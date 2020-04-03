package org.equinoxosgi.toast.dev.airbag;

import java.util.LinkedList;
import java.util.List;

/**
 * @author kongyong
 * @date 2020/4/2
 */
public class Airbag implements IAirbag {

    private List<IAirbagListener> listeners;

    public Airbag() {
        super();
        listeners = new LinkedList<>();
    }

    @Override
    public synchronized void addListener(IAirbagListener listener) {
        listeners.add(listener);
    }

    @Override
    public synchronized void deploy() {
        for (IAirbagListener listener : listeners) {
            listener.deployed();
        }
    }

    @Override
    public synchronized void removeListener(IAirbagListener listener) {
        listeners.remove(listener);
    }
}
