import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import org.assertj.core.api.Assertions;

public class RobotTest {

    private static final String EXPECTED_ROBOT_NAME_PATTERN = "[A-Z]{2}\\d{3}";
    private Robot robot;

    @BeforeEach
    public void setUp() {
        robot = new Robot();
    }

    @Test
    public void hasName() {
        assertIsValidName(robot.getName());
    }

    @Test
    public void differentRobotsHaveDifferentNames() {
        Assertions.assertThat(robot.getName()).isNotEqualTo(new Robot().getName());
    }

    @Test
    public void resetName() {
        final String name = robot.getName();
        robot.reset();
        final String name2 = robot.getName();
        Assertions.assertThat(name).isNotEqualTo(name2);
        assertIsValidName(name2);
    }
    
    @Test
    public void robotNamesAreUnique() {
        Set<String> robotNames = new HashSet<>();
        int sampleSize = 5000;
        for (int i = 0; i < sampleSize; i++) {
            robotNames.add(new Robot().getName());
        }
        Assertions.assertThat(robotNames).hasSize(sampleSize);
    }

    private static void assertIsValidName(String name) {
        Assertions.assertThat(name).matches(EXPECTED_ROBOT_NAME_PATTERN);
    }
}
