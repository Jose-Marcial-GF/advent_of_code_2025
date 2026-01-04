package AoC_2025.day03.b;

import java.util.Arrays;
import java.util.stream.IntStream;

class BatteryBuilder {

    private final int length;
    private BatteryBuilder(int length) {
        this.length = length;
    }

    public static BatteryBuilder length(int length) {
        return new BatteryBuilder(length);
    }


    public Long with(String voltages) {
        return Arrays.stream(voltages.split("\n")).map(this::buildBattery).mapToLong(Battery::getVoltage).sum();
    }

    private Battery buildBattery(String voltage) {
        return new Battery(voltage, this.length);
    }


    static class Battery {
        private final String voltage;
        private final int length;
        private int initialIndex;

        Battery(String voltage, int length) {
            this.length = length;
            this.initialIndex = 0;
            this.voltage = extracted(voltage);
        }

        private String extracted(String voltages) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                initialIndex = updateInitialIndex(voltages, i);
                stringBuilder.append(voltages.charAt(initialIndex-1));
            }
            return stringBuilder.toString();
        }

        private int updateInitialIndex(String voltages, int i) {
            return getMaxIndex(voltages, getNumber(voltages, i), initialIndex) + 1;
        }

        private String getNumber(String voltages, int i) {
            return String.valueOf(getMax(initialIndex, voltages.length() - length + 1 + i, voltages));
        }

        private int getMax(int initialIndex, int lastIndex, String voltages) {
            return Character.getNumericValue(getMax(voltages.substring(initialIndex, lastIndex)));
        }

        private int getMaxIndex(String substring, String number, int initialIndex) {

            return substring.indexOf(number, initialIndex);
        }

        private int getMax(String substring) {
            return substring.chars().reduce(0, Math::max);
        }

         public Long getVoltage() {
             return Long.parseLong(voltage);
         }
     }}
