package com.asy.test.jmx.pure;

/**
 * Created by asy
 */
public interface AppStatsPureMBean {

    int getCurrentConnectionCount();      // get method values are shown in MBean Attributes rather than MBean Operations

    void updateApplicationDescription(String desc);

    String showApplicationDescription();

    int showMaxAllowedConnections();

    void updateMaxAllowedConnections(int maxAllowedConnections);

    void connect();

    void disconnect();

    void releaseAllConnections();

}
