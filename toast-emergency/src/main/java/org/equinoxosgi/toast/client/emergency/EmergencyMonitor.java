package org.equinoxosgi.toast.client.emergency;

import lombok.Setter;
import org.equinoxosgi.toast.dev.airbag.IAirbag;
import org.equinoxosgi.toast.dev.airbag.IAirbagListener;
import org.equinoxosgi.toast.dev.gps.IGps;

/**
 * @author kongyong
 * @date 2020/4/2
 */
@Setter
public class EmergencyMonitor implements IAirbagListener {

    private IAirbag airbag;
    private IGps gps;

    @Override
    public void deployed() {
        System.out.println(airbag + "," + gps);
        System.out.println(String.format("Emergency occurred at lat=%s lon=%s heading=%s speed=%s",
                gps.getLatitude(), gps.getLongitude(), gps.getHeading(), gps.getSpeed()));
    }

    public void startup() {
        airbag.addListener(this);
    }

    public void shutdown() {
        airbag.removeListener(this);
    }
}
