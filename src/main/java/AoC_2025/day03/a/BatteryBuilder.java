package AoC_2025.day03.a;

import java.util.Arrays;

class BatteryBuilder {

    private BatteryBuilder() {
    }

    public static int with(String voltages) {
        return Arrays.stream(voltages.split("\n")).map(Battery::new).mapToInt(Battery::getVoltage).sum();
    }


    static class Battery {
        private final String voltage;

        Battery(String voltage) {
            this.voltage = extracted(voltage);
        }

        private String extracted(String voltages) {
            int initialIndex = 0;
            StringBuilder stringBuilder = new StringBuilder();
            int length = 2;
            for (int i = 0; i < length; i++) {
                String number = String.valueOf(getMax(initialIndex, voltages.length()-length+1+i, voltages));
                initialIndex = getMaxIndex(voltages, number) +1;
                stringBuilder.append(number);
            }
            return stringBuilder.toString();
        }

        private int getMax(int initialIndex, int lastIndex, String voltages) {
            return Character.getNumericValue(getMax(voltages.substring(initialIndex, lastIndex)));
        }

        private int getMaxIndex(String substring, String number) {
            return substring.indexOf(number);
        }

        private static int getMax(String substring) {
            return substring.chars().reduce(0, Math::max);
        }

         public int getVoltage() {
             return Integer.parseInt(voltage);
         }
     }}
