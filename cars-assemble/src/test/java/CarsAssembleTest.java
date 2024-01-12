import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;


public class CarsAssembleTest {

    private CarsAssemble carsAssemble;
    private final double epsilon = 0.0000001d;

    @BeforeEach
    public void setUp() {
        carsAssemble = new CarsAssemble();
    }

    @Test
    public void productionRatePerHourForSpeedZero() {
        Assertions.assertThat(Math.abs(carsAssemble.productionRatePerHour(0) - 0.0) < epsilon).isTrue();
    }

    @Test
    public void productionRatePerHourForSpeedOne() {
        Assertions.assertThat(Math.abs(carsAssemble.productionRatePerHour(1) - 221.0) < epsilon).isTrue();
    }

    @Test
    public void productionRatePerHourForSpeedFour() {
        Assertions.assertThat(Math.abs(carsAssemble.productionRatePerHour(4) - 884.0) < epsilon).isTrue();
    }
    @Test
    public void productionRatePerHourForSpeedSeven() {
        Assertions.assertThat(Math.abs(carsAssemble.productionRatePerHour(7) - 1392.3) < epsilon).isTrue();
    }

    @Test
    public void productionRatePerHourForSpeedNine() {
        Assertions.assertThat(Math.abs(carsAssemble.productionRatePerHour(9) - 1591.2) < epsilon).isTrue();
    }

    @Test
    public void productionRatePerHourForSpeedTen() {
        Assertions.assertThat(Math.abs(carsAssemble.productionRatePerHour(10) - 1701.7) < epsilon).isTrue();
    }

    @Test
    public void workingItemsPerMinuteForSpeedZero() {
        Assertions.assertThat(carsAssemble.workingItemsPerMinute(0)).isEqualTo(0);
    }

    @Test
    public void workingItemsPerMinuteForSpeedOne() {
        Assertions.assertThat(carsAssemble.workingItemsPerMinute(1)).isEqualTo(3);
    }

    @Test
    public void workingItemsPerMinuteForSpeedFive() {
        Assertions.assertThat(carsAssemble.workingItemsPerMinute(5)).isEqualTo(16);
    }

    @Test
    public void workingItemsPerMinuteForSpeedEight() {
        Assertions.assertThat(carsAssemble.workingItemsPerMinute(8)).isEqualTo(26);
    }

    @Test
    public void workingItemsPerMinuteForSpeedNine() {
        Assertions.assertThat(carsAssemble.workingItemsPerMinute(9)).isEqualTo(26);
    }

    @Test
    public void workingItemsPerMinuteForSpeedTen() {
        Assertions.assertThat(carsAssemble.workingItemsPerMinute(10)).isEqualTo(28);
    }
}
