import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoteControlCarTest {
    @Test
    public void race() {
        ProductionRemoteControlCar productionCar = new ProductionRemoteControlCar();
        ExperimentalRemoteControlCar experimentalCar = new ExperimentalRemoteControlCar();
        TestTrack.race(productionCar);
        TestTrack.race(productionCar);
        TestTrack.race(experimentalCar);
        TestTrack.race(experimentalCar);
        assertThat(experimentalCar.getDistanceTravelled() - productionCar.getDistanceTravelled()).isEqualTo(20);
    }

    @Test
    public void rankCars() {
        ProductionRemoteControlCar prc1 = new ProductionRemoteControlCar();
        ProductionRemoteControlCar prc2 = new ProductionRemoteControlCar();

        prc1.setNumberOfVictories(3);
        prc2.setNumberOfVictories(2);

        assertThat(prc1.getNumberOfVictories()).isEqualTo(3);
        assertThat(prc2.getNumberOfVictories()).isEqualTo(2);

        List<ProductionRemoteControlCar> rankings = TestTrack.getRankedCars(prc1, prc2);
        assertThat(rankings.get(1)).isEqualTo(prc1);
    }

    @Test
    public void ensureCarsAreComparable() {
        assertThat(RemoteControlCar.class).isAssignableFrom(ProductionRemoteControlCar.class);
    }
}
