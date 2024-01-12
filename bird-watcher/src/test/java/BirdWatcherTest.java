import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import org.assertj.core.api.Assertions;

public class BirdWatcherTest {

    private static final int DAY1 = 0;
    private static final int DAY2 = 2;
    private static final int DAY3 = 5;
    private static final int DAY4 = 3;
    private static final int DAY5 = 7;
    private static final int DAY6 = 8;
    private static final int TODAY = 4;

    private BirdWatcher birdWatcher;
    private final int[] lastWeek = {DAY1, DAY2, DAY3, DAY4, DAY5, DAY6, TODAY};

    @BeforeEach
    public void setUp() {
        birdWatcher = new BirdWatcher(lastWeek);
    }

    @Test
    public void itTestGetLastWeek() {
        Assertions.assertThat(birdWatcher.getLastWeek())
            .containsExactly(DAY1, DAY2, DAY3, DAY4, DAY5, DAY6, TODAY);
    }

    @Test
    public void itTestGetToday() {
        Assertions.assertThat(birdWatcher.getToday()).isEqualTo(TODAY);
    }

    @Test
    public void itShouldReturnZeroIfBirdWatcherLastWeekIsEmpty() {
        int[] lastWeekEmpty = new int[0];
        birdWatcher = new BirdWatcher(lastWeekEmpty);
        Assertions.assertThat(birdWatcher.getToday()).isEqualTo(0);
    }

    @Test
    public void itIncrementTodaysCount() {
        birdWatcher.incrementTodaysCount();
        Assertions.assertThat(birdWatcher.getToday()).isEqualTo(TODAY + 1);
    }

    @Test
    public void itHasDayWithoutBirds() {
        Assertions.assertThat(birdWatcher.hasDayWithoutBirds()).isTrue();
    }

    @Test
    public void itShouldNotHaveDaysWithoutBirds() {
        birdWatcher = new BirdWatcher(new int[]{1, 2, 5, 3, 7, 8, 4});
        Assertions.assertThat(birdWatcher.hasDayWithoutBirds()).isFalse();
    }


    @Test
    public void itTestGetCountForFirstDays() {
        Assertions.assertThat(birdWatcher.getCountForFirstDays(4)).isEqualTo(DAY1 + DAY2 + DAY3 + DAY4);
    }

    @Test
    public void itTestGetCountForMoreDaysThanTheArraySize() {
        Assertions.assertThat(birdWatcher.getCountForFirstDays(10))
            .isEqualTo(DAY1 + DAY2 + DAY3 + DAY4 + DAY5 + DAY6 + TODAY);
    }

    @Test
    public void itTestGetCountForBusyDays() {
        // DAY3, DAY5 and DAY6 are all >= 5 birds
        Assertions.assertThat(birdWatcher.getBusyDays()).isEqualTo(3);
    }

    @Test
    public void itShouldNotHaveBusyDays() {
        birdWatcher = new BirdWatcher(new int[]{1, 2, 3, 3, 2, 1, 4});
        Assertions.assertThat(birdWatcher.getBusyDays()).isEqualTo(0);
    }
}
