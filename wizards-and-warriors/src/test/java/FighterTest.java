import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class FighterTest {

    @Test
    public void testWarriorToString() {
        Fighter warrior = new Warrior();
        Assertions.assertThat(warrior.toString()).isEqualTo("Fighter is a Warrior");
    }

    @Test
    public void testWizardToString() {
        Wizard wizard = new Wizard();
        Assertions.assertThat(wizard.toString()).isEqualTo("Fighter is a Wizard");
    }

    @Test
    public void testFighterVulnerableByDefault() {
        Fighter warrior = new Warrior();
        Assertions.assertThat(warrior.isVulnerable()).isFalse();
    }

    @Test
    public void testWizardVulnerable() {
        Wizard wizard = new Wizard();
        Assertions.assertThat(wizard.isVulnerable()).isTrue();
        wizard.prepareSpell();
        Assertions.assertThat(wizard.isVulnerable()).isFalse();
    }

    @Test
    public void testWizardsDamagePoints() {
        Wizard wizard = new Wizard();
        Warrior warrior = new Warrior();
        Assertions.assertThat(wizard.damagePoints(warrior)).isEqualTo(3);
        wizard.prepareSpell();
        Assertions.assertThat(wizard.damagePoints(warrior)).isEqualTo(12);
    }

    @Test
    public void testWarriorsDamagePoints() {
        Warrior warrior = new Warrior();
        Wizard wizard = new Wizard();
        Assertions.assertThat(warrior.damagePoints(wizard)).isEqualTo(10);
        wizard.prepareSpell();
        Assertions.assertThat(warrior.damagePoints(wizard)).isEqualTo(6);
    }
}
