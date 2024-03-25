import java.util.*;

class BracketChecker {

    private final String expression;

    private final Map<Character, Character> brackets = Map.of(
            '[', ']',
            '{', '}',
            '(', ')'
    );

    BracketChecker(String expression) {
        this.expression = expression;
    }

    boolean areBracketsMatchedAndNestedCorrectly() {
        Stack<Character> closingBrackets = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (brackets.containsKey(c)) {
                closingBrackets.push(brackets.get(c));
            } else if (brackets.containsValue(c)) {
                if (closingBrackets.isEmpty() || closingBrackets.pop() != c) {
                    return false;
                }
            }
        }
        return closingBrackets.isEmpty();
    }

}