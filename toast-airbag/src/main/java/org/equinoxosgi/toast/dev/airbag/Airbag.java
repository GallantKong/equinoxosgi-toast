package org.equinoxosgi.toast.dev.airbag;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kongyong
 * @date 2020/4/2
 */
public class Airbag {

    private List<IAirbagListener> listeners;

    public Airbag() {
        super();
        listeners = new LinkedList<>();
    }

    public synchronized void addListener(IAirbagListener listener) {
        listeners.add(listener);
    }

    public synchronized void deployed() {
        for (IAirbagListener listener : listeners) {
            listener.deployed();
        }
    }

    public synchronized void removeListener(IAirbagListener listener) {
        listeners.remove(listener);
    }
}
