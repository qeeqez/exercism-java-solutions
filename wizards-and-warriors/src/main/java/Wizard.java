class Wizard extends Fighter {

    private boolean isSpellPrepared = false;

    Wizard() {
        vulnerable = true;
    }

    @Override
    int damagePoints(Fighter warrior) {
        return isSpellPrepared ? 12 : 3;
    }

    void prepareSpell() {
        isSpellPrepared = true;
        vulnerable = false;
    }

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }
}
