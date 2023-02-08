public class Bob {
    Bob() {
    }

    public String hey(String input) {
        input = input.trim();
        if (input.isEmpty()) return "Fine. Be that way!";

        boolean isQuestion = isQuestion(input);
        boolean isAllCapitals = isAllCapitals(input);

        if (isQuestion && isAllCapitals) return "Calm down, I know what I'm doing!";
        if (isQuestion) return "Sure.";
        if (isAllCapitals) return "Whoa, chill out!";

        return "Whatever.";
    }

    private boolean isQuestion(String input) {
        return input.endsWith("?");
    }

    private boolean isAllCapitals(String input) {
        long letterCount = input.chars().filter(Character::isLetter).count();
        return letterCount > 0 && input.chars().filter(Character::isLetter).allMatch(Character::isUpperCase);
    }
}