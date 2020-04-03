package org.equinoxosgi.toast.dev.airbag;

/**
 * @author kongyong
 * @date 2020/4/3
 */
public interface IAirbag {

    void addListener(IAirbagListener listener);

    void deploy();

    void removeListener(IAirbagListener listener);
}
