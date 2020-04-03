package org.equinoxosgi.toast.internal.dev.gps.fake;

import org.equinoxosgi.toast.dev.gps.IGps;

/**
 * @author kongyong
 * @date 2020/4/2
 */
public class FakeGps implements IGps {

    @Override
    public int getHeading() {
        // 90度（东）
        return 90;
    }

    @Override
    public int getLatitude() {
        // 37.76999 N
        return 3776999;
    }

    @Override
    public int getLongitude() {
        // -122.44694 W
        return -12244694;
    }

    @Override
    public int getSpeed() {
        // 50 km/h
        return 50;
    }
}
