package org.equinoxosgi.toast.client.emergency;

import org.equinoxosgi.toast.dev.airbag.Airbag;
import org.equinoxosgi.toast.dev.gps.Gps;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * @author kongyong
 * @date 2020/4/2
 */
public class Activator implements BundleActivator {

    private Gps gps;
    private Airbag airbag;
    private EmergencyMonitor emergencyMonitor;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Launching");
        gps = new Gps();
        airbag = new Airbag();
        emergencyMonitor = new EmergencyMonitor();
        emergencyMonitor.setAirbag(airbag);
        emergencyMonitor.setGps(gps);
        emergencyMonitor.startup();
        airbag.deployed();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        emergencyMonitor.shutdown();
        System.out.println("Terminating");
    }
}
