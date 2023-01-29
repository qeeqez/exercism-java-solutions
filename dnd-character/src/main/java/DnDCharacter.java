import java.util.Random;

class DnDCharacter {

    private final int strength;
    private final int dexterity;
    private final int constitution;
    private final int intelligence;
    private final int wisdom;
    private final int charisma;

    DnDCharacter() {
        strength = ability();
        dexterity = ability();
        constitution = ability();
        intelligence = ability();
        wisdom = ability();
        charisma = ability();
    }

    int ability() {
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            int currentValue = rollTheDice();
            sum += currentValue;
            min = Math.min(currentValue, min);
        }
        return sum - min;
    }

    private int rollTheDice() {
        return new Random().nextInt(1, 7);
    }

    int modifier(int input) {
        return Math.floorDiv((input - 10), 2);
    }

    int getStrength() {
        return strength;
    }

    int getDexterity() {
        return dexterity;
    }

    int getConstitution() {
        return constitution;
    }

    int getIntelligence() {
        return intelligence;
    }

    int getWisdom() {
        return wisdom;
    }

    int getCharisma() {
        return charisma;
    }

    int getHitpoints() {
        return 10 + getConstitutionModifier();
    }

    private int getConstitutionModifier() {
        return modifier(constitution);
    }
}
