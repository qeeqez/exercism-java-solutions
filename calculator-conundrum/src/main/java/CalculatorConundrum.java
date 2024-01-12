class CalculatorConundrum {

    private int processOperation(int operand1, int operand2, String operation) {
        return switch (operation) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> handleDivision(operand1, operand2);
            case null -> throw new IllegalArgumentException("Operation cannot be null");
            case "" -> throw new IllegalArgumentException("Operation cannot be empty");
            default -> throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        };
    }

    private int handleDivision(int operand1, int operand2) {
        try {
            return operand1 / operand2;
        } catch (ArithmeticException exception) {
            throw new IllegalOperationException("Division by zero is not allowed", exception);
        }
    }

    public String calculate(int operand1, int operand2, String operation) {
        return operand1 + " " + operation + " " + operand2 + " = " + processOperation(operand1, operand2, operation);
    }
}
