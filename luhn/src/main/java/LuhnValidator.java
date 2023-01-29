class LuhnValidator {

    boolean isValid(String candidate) {
        candidate = candidate.replace(" ", "");

        if (!candidate.matches("[0-9]+") || candidate.length() == 1) return false;

        int sum = 0;
        for (int i = 0; i < candidate.length(); i++) {
            int value = Character.getNumericValue(candidate.charAt(i));
            if ((candidate.length() - i) % 2 == 0)
                sum += doubleValue(value);
            else sum += value;
        }
        return sum % 10 == 0;
    }

    private int doubleValue(int value) {
        value += value;
        if (value > 9) value -= 9;
        return value;
    }

}
