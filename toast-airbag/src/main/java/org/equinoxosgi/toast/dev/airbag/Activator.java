package org.equinoxosgi.toast.dev.airbag;

import org.equinoxosgi.toast.internal.dev.airbag.fake.FakeAirbag;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * @author kongyong
 * @date 2020/4/3
 */
public class Activator implements BundleActivator {

    private FakeAirbag airbag;
    private ServiceRegistration<?> registration;

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        airbag = new FakeAirbag();
        airbag.startup();
        registration = bundleContext.registerService(IAirbag.class.getName(), airbag, null);
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        registration.unregister();
        airbag.shutdown();
    }
}
