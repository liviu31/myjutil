package com.myjutil.patterns;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * User: liviu
 * Date: 11/30/15
 * Time: 11:57 PM
 */
public class MultitionBroker {

    private static Map<String, Broker> values = new ConcurrentHashMap<>();

    public static Broker valueOf(String brokerName) {
        Broker broker = values.get(brokerName);
        if (broker != null) {
            return broker;
        }

        broker = new Broker(brokerName);
        values.put(brokerName, broker);
        return broker;
    }

    public static final class Broker {

        private final String name;

        private Broker(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Broker broker = (Broker) o;

            if (name != null ? !name.equals(broker.name) : broker.name != null) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }
    }

}
