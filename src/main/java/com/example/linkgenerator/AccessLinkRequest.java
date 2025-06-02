package com.example.linkgenerator;

public class AccessLinkRequest {
    private String targetResource;
    private int expiryMinutes;

    // Getters and Setters
    public String getTargetResource() {
        return targetResource;
    }

    public void setTargetResource(String targetResource) {
        this.targetResource = targetResource;
    }

    public int getExpiryMinutes() {
        return expiryMinutes;
    }

    public void setExpiryMinutes(int expiryMinutes) {
        this.expiryMinutes = expiryMinutes;
    }
}