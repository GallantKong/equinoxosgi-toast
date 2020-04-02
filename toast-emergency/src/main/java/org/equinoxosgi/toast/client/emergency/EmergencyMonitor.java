package org.equinoxosgi.toast.client.emergency;

import org.equinoxosgi.toast.dev.airbag.Airbag;
import org.equinoxosgi.toast.dev.airbag.IAirbagListener;
import org.equinoxosgi.toast.dev.gps.Gps;

/**
 * @author kongyong
 * @date 2020/4/2
 */
public class EmergencyMonitor implements IAirbagListener {

    private Airbag airbag;
    private Gps gps;

    @Override
    public void deployed() {
        System.out.println(String.format("Emergency occurred at lat=%s lon=%s heading=%s speed=%s",
                gps.getLatitude(), gps.getLongitude(), gps.getHeading(), gps.getSpeed()));
    }

    public void setAirbag(Airbag airbag) {
        this.airbag = airbag;
    }

    public void setGps(Gps gps) {
        this.gps = gps;
    }

    public void startup() {
        airbag.addListener(this);
    }

    public void shutdown() {
        airbag.removeListener(this);
    }
}
