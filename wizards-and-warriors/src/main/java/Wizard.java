class Wizard extends Fighter {

    private boolean isSpellPrepared = false;

    Wizard() {
        vulnerable = true;
    }

    @Override
    int getDamagePoints(Fighter warrior) {
        return isSpellPrepared ? 12 : 3;
    }

    @Override
    boolean isVulnerable() {
        return super.isVulnerable();
    }

    @SuppressWarnings("unused")
    void prepareSpell() {
        isSpellPrepared = true;
        vulnerable = false;
    }

    @Override
    public String toString() {
        return "Fighter is a Wizard";
    }
}
