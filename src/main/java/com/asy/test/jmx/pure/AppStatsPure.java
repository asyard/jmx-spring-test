package com.asy.test.jmx.pure;

/**
 * Created by asy
 */
public class AppStatsPure implements AppStatsPureMBean {

    private String appDescription;
    private int maxAllowedConnections;
    private int currentConnectionCount = 0;

    public String showApplicationDescription() {
        return appDescription;
    }

    public void updateApplicationDescription(String appDescription) {
        this.appDescription = appDescription;
    }

    public int showMaxAllowedConnections() {
        return maxAllowedConnections;
    }

    public void updateMaxAllowedConnections(int maxAllowedConnections) {
        if (maxAllowedConnections < 1) {
            throw new RuntimeException("Max allowed connections cannot be less than 1");
        }
        this.maxAllowedConnections = maxAllowedConnections;
    }

    public int getCurrentConnectionCount() {
        return currentConnectionCount;
    }

    public void connect() {
        if (currentConnectionCount >= maxAllowedConnections) {
            throw new RuntimeException("Max allowed connections exceeded");
        }
        currentConnectionCount++;
    }

    public void disconnect() {
        if (currentConnectionCount == 0) {
            throw new RuntimeException("There is no connection to be released");
        }
        currentConnectionCount--;
    }

    public void releaseAllConnections() {
        currentConnectionCount = 0;
    }

}