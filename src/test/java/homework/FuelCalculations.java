package homework;

import org.junit.jupiter.api.Test;

public class FuelCalculations {

    public int fuelNeeded(int distance, int fuel) {
        int fuelRequired = fuel + (distance - 100) / fuel;
        return fuelRequired;
    }

    @Test
    public void test() {
        int a = fuelNeeded(120, 7);
        System.out.println(a);
    }
}
