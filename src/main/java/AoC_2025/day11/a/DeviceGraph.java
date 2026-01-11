package AoC_2025.day11.a;

import java.util.*;

public class DeviceGraph {
        private final Map<String, Device> devices = new HashMap<>();

        protected void addLink(String from, Set<String> targets) {
            devices.put(from, new Device(from, targets));
            targets.forEach(target -> devices.putIfAbsent(target, new Device(target, Set.of())));
        }

        public Device findDevice(String name) {
            return devices.get(name);
        }

}
