package org.equinoxosgi.toast.dev.gps;

import org.equinoxosgi.toast.internal.dev.gps.fake.FakeGps;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @author kongyong
 * @date 2020/4/3
 */
public class Activator implements BundleActivator {

    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        FakeGps gps = new FakeGps();
        registration = bundleContext.registerService(IGps.class.getName(), gps, null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        registration.unregister();
    }
}
