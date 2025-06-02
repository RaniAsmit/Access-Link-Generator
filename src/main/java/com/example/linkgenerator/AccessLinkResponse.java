package com.example.linkgenerator;

public class AccessLinkResponse {
    private String url;
    private String expiryTime;

    public AccessLinkResponse(String url, String expiryTime) {
        this.url = url;
        this.expiryTime = expiryTime;
    }

    // Getters and Setters
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }
}