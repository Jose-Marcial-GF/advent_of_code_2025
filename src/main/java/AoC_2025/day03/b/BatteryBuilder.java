package AoC_2025.day03.b;

import java.util.Arrays;

class BatteryBuilder {

    private final int length;
    private BatteryBuilder(int length) {
        this.length = length;
    }

    public static BatteryBuilder length(int length) {
        return new BatteryBuilder(12);
    }


    public Long with(String voltages) {
        return Arrays.stream(voltages.split("\n")).map(this::buildBattery).mapToLong(Battery::getVoltage).sum();
    }

    private Battery buildBattery(String voltage) {
        return new Battery(voltage, this.length);
    }


    static class Battery {
        private final String voltage;
        private int length;

        Battery(String voltage, int length) {
            this.length = length;
            this.voltage = extracted(voltage);
        }

        private String extracted(String voltages) {
            int initialIndex = 0;
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < length; i++) {
                String number = String.valueOf(getMax(initialIndex, voltages.length()-length+1+i, voltages));
                initialIndex = getMaxIndex(voltages, number, initialIndex) +1;
                stringBuilder.append(number);
            }
            return stringBuilder.toString();
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
