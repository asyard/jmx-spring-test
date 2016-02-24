package com.asy.test.jmx.spring.mbean;

/**
 * Created by asy
 */
public class AppStats {

    private String appDescription;
    private int maxAllowedConnections;
    private int currentConnectionCount;

    public int getCurrentConnectionCount() {
        return currentConnectionCount;
    }

    public void setAppDescription(String desc) {
        appDescription = desc;
    }

    public String getAppDescription() {
        return appDescription;
    }

    public int getMaxAllowedConnections() {
        return maxAllowedConnections;
    }

    public void setMaxAllowedConnections(int maxAllowedConnections) {
        if (maxAllowedConnections < 1) {
            throw new RuntimeException("Max allowed connections cannot be less than 1");
        }
        this.maxAllowedConnections = maxAllowedConnections;
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