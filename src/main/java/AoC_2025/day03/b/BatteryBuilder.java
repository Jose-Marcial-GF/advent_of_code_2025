package AoC_2025.day03.b;

import java.util.Arrays;

class BatteryBuilder {

    private BatteryBuilder() {
    }

    public static Long with(String voltages) {
        return Arrays.stream(voltages.split("\n")).map(Battery::new).mapToLong(Battery::getVoltage).sum();
    }


    static class Battery {
        private final String voltage;

        Battery(String voltage) {
            this.voltage = extracted(voltage);
        }

        private String extracted(String voltages) {
            int initialIndex = 0;
            StringBuilder stringBuilder = new StringBuilder();
            int length = 12;
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

        private static int getMax(String substring) {
            return substring.chars().reduce(0, Math::max);
        }

         public Long getVoltage() {
             return Long.parseLong(voltage);
         }
     }}
