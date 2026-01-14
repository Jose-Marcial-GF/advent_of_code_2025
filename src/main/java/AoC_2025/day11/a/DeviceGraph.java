package AoC_2025.day11.a;

import java.util.*;

public record DeviceGraph(Map<String, Device> devices) {

    public static DeviceGraph with(Map<String, Device> devices) {
        return new DeviceGraph(devices);
    }

    public Device findDevice(String name) {
        return devices.get(name);
    }

}
