abstract class Fighter {

    boolean vulnerable = false;

    boolean isVulnerable() {
        return vulnerable;
    }

    abstract int damagePoints(Fighter fighter);

    @Override
    public String toString() {
        return "Fighter is a Fighter";
    }
}

