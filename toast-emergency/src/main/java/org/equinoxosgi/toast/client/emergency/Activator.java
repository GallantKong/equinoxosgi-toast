package org.equinoxosgi.toast.client.emergency;

import org.equinoxosgi.toast.dev.airbag.IAirbag;
import org.equinoxosgi.toast.dev.gps.IGps;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * @author kongyong
 * @date 2020/4/3
 */
public class Activator implements BundleActivator {

    private IAirbag airbag;
    private ServiceReference<?> airbagRef;
    private IGps gps;
    private ServiceReference<?> gpsRef;
    private EmergencyMonitor emergencyMonitor;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Launching...");
        emergencyMonitor = new EmergencyMonitor();
        gpsRef = bundleContext.getServiceReference(IGps.class.getName());
        airbagRef = bundleContext.getServiceReference(IAirbag.class.getName());
        if (gpsRef == null || airbagRef == null) {
            System.out.println(String.format("gpsRef=%s, airbagRef=%s", gpsRef, airbagRef));
            System.err.println("Unable to acquire GPS ref or airbag ref!");
            return;
        }
        gps = (IGps) bundleContext.getService(gpsRef);
        airbag = (IAirbag) bundleContext.getService(airbagRef);
        if (gps == null || airbag == null) {
            System.out.println(String.format("gps=%s, airbag=%s", gps, airbag));
            System.err.println("Unable to acquire GPS or airbag!");
            return;
        }
        emergencyMonitor.setGps(gps);
        emergencyMonitor.setAirbag(airbag);
        emergencyMonitor.startup();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        emergencyMonitor.shutdown();
        if (gpsRef != null) {
            bundleContext.ungetService(gpsRef);
        }
        if (airbagRef != null) {
            bundleContext.ungetService(airbagRef);
        }
        System.out.println("Terminating...");
    }
}
