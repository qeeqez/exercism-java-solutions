import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnnalynsInfiltrationTest {
    @Test
    public void cannot_execute_fast_attack_if_knight_is_awake() {
        boolean knightIsAwake = true;
        Assertions.assertThat(AnnalynsInfiltration.canFastAttack(knightIsAwake)).isFalse();
    }

    @Test
    public void can_execute_fast_attack_if_knight_is_sleeping() {
        boolean knightIsAwake = false;
        Assertions.assertThat(AnnalynsInfiltration.canFastAttack(knightIsAwake)).isTrue();
    }

    @Test
    public void cannot_spy_if_everyone_is_sleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        Assertions.assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isFalse();
    }

    @Test
    public void can_spy_if_everyone_but_knight_is_sleeping() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        Assertions.assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    public void can_spy_if_everyone_but_archer_is_sleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        Assertions.assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    public void can_spy_if_everyone_but_prisoner_is_sleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        Assertions.assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    public void can_spy_if_only_knight_is_sleeping() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        Assertions.assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    public void can_spy_if_only_archer_is_sleeping() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        Assertions.assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    public void can_spy_if_only_prisoner_is_sleeping() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        Assertions.assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    public void can_spy_if_everyone_is_awake() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        Assertions.assertThat(AnnalynsInfiltration.canSpy(knightIsAwake, archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    public void can_signal_prisoner_if_archer_is_sleeping_and_prisoner_is_awake() {
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        Assertions.assertThat(AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake)).isTrue();
    }

    @Test
    public void cannot_signal_prisoner_if_archer_is_awake_and_prisoner_is_sleeping() {
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        Assertions.assertThat(AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake)).isFalse();
    }

    @Test
    public void cannot_signal_prisoner_if_archer_and_prisoner_are_both_sleeping() {
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        Assertions.assertThat(AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake)).isFalse();
    }

    @Test
    public void cannot_signal_prisoner_if_archer_and_prisoner_are_both_awake() {
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        Assertions.assertThat(AnnalynsInfiltration.canSignalPrisoner(archerIsAwake, prisonerIsAwake)).isFalse();
    }

    @Test
    public void cannot_release_prisoner_if_everyone_is_awake_and_pet_dog_is_present() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    public void cannot_release_prisoner_if_everyone_is_awake_and_pet_dog_is_absent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = false;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    public void can_release_prisoner_if_everyone_is_asleep_and_pet_dog_is_present() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = true;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isTrue();
    }

    @Test
    public void cannot_release_prisoner_if_everyone_is_asleep_and_pet_dog_is_absent() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    public void can_release_prisoner_if_only_prisoner_is_awake_and_pet_dog_is_present() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isTrue();
    }

    @Test
    public void can_release_prisoner_if_only_prisoner_is_awake_and_pet_dog_is_absent() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = false;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isTrue();
    }

    @Test
    public void cannot_release_prisoner_if_only_archer_is_awake_and_pet_dog_is_present() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = true;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    public void cannot_release_prisoner_if_only_archer_is_awake_and_pet_dog_is_absent() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    public void can_release_prisoner_if_only_knight_is_awake_and_pet_dog_is_present() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = true;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isTrue();
    }

    @Test
    public void cannot_release_prisoner_if_only_knight_is_awake_and_pet_dog_is_absent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    public void cannot_release_prisoner_if_only_knight_is_asleep_and_pet_dog_is_present() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    public void cannot_release_prisoner_if_only_knight_is_asleep_and_pet_dog_is_absent() {
        boolean knightIsAwake = false;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = false;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    public void can_release_prisoner_if_only_archer_is_asleep_and_pet_dog_is_present() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = true;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isTrue();
    }

    @Test
    public void cannot_release_prisoner_if_only_archer_is_asleep_and_pet_dog_is_absent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = false;
        boolean prisonerIsAwake = true;
        boolean petDogIsPresent = false;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    public void cannot_release_prisoner_if_only_prisoner_is_asleep_and_pet_dog_is_present() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = true;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }

    @Test
    public void cannot_release_prisoner_if_only_prisoner_is_asleep_and_pet_dog_is_absent() {
        boolean knightIsAwake = true;
        boolean archerIsAwake = true;
        boolean prisonerIsAwake = false;
        boolean petDogIsPresent = false;
        Assertions.assertThat(AnnalynsInfiltration.canFreePrisoner(knightIsAwake, archerIsAwake,
                   prisonerIsAwake, petDogIsPresent)).isFalse();
    }
}
