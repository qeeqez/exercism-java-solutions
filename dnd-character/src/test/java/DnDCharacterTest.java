import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;
import static org.junit.Assert.assertTrue;

public class DnDCharacterTest {

    private final DnDCharacter dndCharacter = new DnDCharacter();

    @Test
    public void testAbilityModifierForScore3IsNegative4() {
        Assertions.assertEquals(-4, dndCharacter.modifier(3));
    }

    @Test
    public void testAbilityModifierForScore4IsNegative3() {
        Assertions.assertEquals(-3, dndCharacter.modifier(4));
    }

    @Test
    public void testAbilityModifierForScore5IsNegative3() {
        Assertions.assertEquals(-3, dndCharacter.modifier(5));
    }

    @Test
    public void testAbilityModifierForScore6IsNegative2() {
        Assertions.assertEquals(-2, dndCharacter.modifier(6));
    }

    @Test
    public void testAbilityModifierForScore7IsNegative2() {
        Assertions.assertEquals(-2, dndCharacter.modifier(7));
    }

    @Test
    public void testAbilityModifierForScore8IsNegative1() {
        Assertions.assertEquals(-1, dndCharacter.modifier(8));
    }

    @Test
    public void testAbilityModifierForScore9IsNegative1() {
        Assertions.assertEquals(-1, dndCharacter.modifier(9));
    }

    @Test
    public void testAbilityModifierForScore10Is0() {
        Assertions.assertEquals(0, dndCharacter.modifier(10));
    }

    @Test
    public void testAbilityModifierForScore11Is0() {
        Assertions.assertEquals(0, dndCharacter.modifier(11));
    }

    @Test
    public void testAbilityModifierForScore12Is1() {
        Assertions.assertEquals(1, dndCharacter.modifier(12));
    }

    @Test
    public void testAbilityModifierForScore13Is1() {
        Assertions.assertEquals(1, dndCharacter.modifier(13));
    }

    @Test
    public void testAbilityModifierForScore14Is2() {
        Assertions.assertEquals(2, dndCharacter.modifier(14));
    }

    @Test
    public void testAbilityModifierForScore15Is2() {
        Assertions.assertEquals(2, dndCharacter.modifier(15));
    }

    @Test
    public void testAbilityModifierForScore16Is3() {
        Assertions.assertEquals(3, dndCharacter.modifier(16));
    }

    @Test
    public void testAbilityModifierForScore17Is3() {
        Assertions.assertEquals(3, dndCharacter.modifier(17));
    }

    @Test
    public void testAbilityModifierForScore18Is4() {
        Assertions.assertEquals(4, dndCharacter.modifier(18));
    }

    @Test
    public void testRandomAbilityIsWithinRange() {
        int score = dndCharacter.ability();
        assertTrue(score > 2 && score < 19);
    }

    @Test
    public void testRandomCharacterIsValid() {
        for (int i = 0; i < 1000; i++) {
            DnDCharacter character = new DnDCharacter();
            assertTrue(character.getStrength() > 2 && character.getStrength() < 19);
            assertTrue(character.getDexterity() > 2 && character.getDexterity() < 19);
            assertTrue(character.getConstitution() > 2 && character.getConstitution() < 19);
            assertTrue(character.getIntelligence() > 2 && character.getIntelligence() < 19);
            assertTrue(character.getWisdom() > 2 && character.getWisdom() < 19);
            assertTrue(character.getCharisma() > 2 && character.getCharisma() < 19);
            Assertions.assertEquals(character.getHitpoints(),
                    10 + character.modifier(character.getConstitution()));
        }
    }

    @Test
    public void testEachAbilityIsOnlyCalculatedOnce() {
        int first = dndCharacter.getStrength();
        int second = dndCharacter.getStrength();
        Assertions.assertEquals(first, second);
    }

}
