package com.example.linkgenerator;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@CrossOrigin
@RequestMapping("/api/access-links")
public class AccessLinkController {

    private static final Logger logger = LoggerFactory.getLogger(AccessLinkController.class);

    @Autowired
    private AccessLinkService accessLinkService;

    /**
     * Generates a new time-limited access link.
     * 
     * Request JSON:
     * {
     *   "targetResource": "https://example.com",
     *   "expiryMinutes": 120
     * }
     */
    @PostMapping
    public ResponseEntity<?> generateAccessLink(@RequestBody AccessLinkRequest request) {
        try {
            logger.info("Generating access link for target resource: {} with expiry minutes: {}", 
                request.getTargetResource(), request.getExpiryMinutes());

            LocalDateTime expiryTime = LocalDateTime.now().plusMinutes(request.getExpiryMinutes());
            AccessLink accessLink = accessLinkService.generateAccessLink(request.getTargetResource(), expiryTime);
            String formattedExpiryTime = accessLinkService.formatExpiryTime(expiryTime);
            
            AccessLinkResponse response = new AccessLinkResponse(accessLink.getUrl(), formattedExpiryTime);
            logger.info("Generated access link: {} with expiry time: {}", accessLink.getUrl(), formattedExpiryTime);
            
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            logger.error("Failed to generate access link: {}", e.getMessage());
            return ResponseEntity.badRequest().body("Invalid request: " + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error while generating access link", e);
            return ResponseEntity.internalServerError().body("Failed to generate access link");
        }
    }

    /**
     * Redirects to the original URL if the token is valid and not expired or used.
     * Example URL: /api/access-links/abc123
     */    @GetMapping("/{id}")


    public ResponseEntity<?> redirectToTargetResource(@PathVariable String id,
    HttpServletResponse response) {

        try {
            logger.info("Processing redirect request for access link ID: {}", id);
            Optional<AccessLink> accessLink = accessLinkService.validateAccessLink(id);

            if (accessLink.isPresent()) {
                AccessLink link = accessLink.get();
                String targetResource = link.getTargetResource();
                
                if (targetResource == null || targetResource.isEmpty()) {
                    logger.error("Invalid target resource for access link ID: {}", id);
                    return ResponseEntity.badRequest().body("Invalid target resource");
                }

                // Mark link as used before redirecting
                accessLinkService.markAsUsed(id);

                logger.info("Redirecting to target resource: {} for access link ID: {}", targetResource, id);

                logger.info("Redirecting to target resource: {} for access link ID: {}",
                targetResource, id);

                response.sendRedirect(targetResource);
                return ResponseEntity.ok().build();
            } else {
                logger.warn("Invalid or expired access link ID: {}", id);
                return ResponseEntity.status(HttpServletResponse.SC_FORBIDDEN)
                    .body("This link is either expired, already used, or invalid.");
            }
    } catch (IOException e) {
            logger.error("Failed to process redirect for access link ID: {}", id, e);
            return ResponseEntity.internalServerError().body("Failed to process redirect");
        }
    }
}
