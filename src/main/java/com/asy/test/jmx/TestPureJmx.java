package com.asy.test.jmx;

import com.asy.test.jmx.pure.AppStatsPure;

import javax.management.*;
import java.lang.management.ManagementFactory;

/**
 * Created by asy
 */
public class TestPureJmx {

    private MBeanServer mbs = null;

    public TestPureJmx() throws NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, MalformedObjectNameException {
        System.out.println("Starting jmx server");
        mbs = ManagementFactory.getPlatformMBeanServer();
        AppStatsPure appStatsPureBean = new AppStatsPure();
        appStatsPureBean.updateApplicationDescription("Pure Jmx Server");
        appStatsPureBean.updateMaxAllowedConnections(5);

        ObjectName appStatsName = new ObjectName("com.asy.test.jmx.pure.mbean:name=AppStatsPure");
        mbs.registerMBean(appStatsPureBean, appStatsName);
        System.out.println("Jmx bean registered");

    }

    public static void main(String[] args) throws MBeanRegistrationException, InstanceAlreadyExistsException, NotCompliantMBeanException, MalformedObjectNameException {
        TestPureJmx jmsAgent = new TestPureJmx();
        for(;;) {

        }
    }

}
