class Warrior extends Fighter {

    @Override
    public String toString() {
        return "Fighter is a Warrior";
    }

    @Override
    int getDamagePoints(Fighter wizard) {
        return wizard.isVulnerable() ? 10 : 6;
    }

    @Override
    boolean isVulnerable() {
        return false;
    }
}
