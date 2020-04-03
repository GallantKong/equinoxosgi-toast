package org.equinoxosgi.toast.dev.gps;

/**
 * @author kongyong
 * @date 2020/4/3
 */
public interface IGps {

    /**
     * 前进方向
     * @return int :
     */
    int getHeading();

    /**
     * 纬度
     * @return int :
     */
    int getLatitude();

    /**
     * 经度
     * @return int :
     */
    int getLongitude();

    /**
     * 速度
     * @return int :
     */
    int getSpeed();
}
