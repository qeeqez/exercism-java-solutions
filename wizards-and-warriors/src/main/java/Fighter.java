class Fighter {

    boolean vulnerable = false;

    boolean isVulnerable() {
        return vulnerable;
    }

    @SuppressWarnings("unused")
    int getDamagePoints(Fighter fighter) {
        return 1;
    }

    @Override
    public String toString() {
        return "Fighter is a Fighter";
    }
}

