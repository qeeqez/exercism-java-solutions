import java.io.IOException;
import java.util.Optional;

@SuppressWarnings("SameParameterValue")
class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException(message);
    }

    void handleErrorByThrowingAnyCheckedException() throws IOException {
        throw new IOException();
    }

    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String message) throws IOException {
        throw new IOException(message);
    }

    void handleErrorByThrowingAnyUncheckedException() {
        throw new ArithmeticException();
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String message) {
        throw new ArithmeticException(message);
    }

    void handleErrorByThrowingCustomCheckedException() throws Exception {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String message) throws Exception {
        throw new CustomCheckedException(message);
    }

    void handleErrorByThrowingCustomUncheckedException() {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String message) {
        throw new CustomUncheckedException(message);
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        try {
            return Integer.valueOf(integer).describeConstable();
        } catch (NumberFormatException exception) {
            return Optional.empty();
        }
    }

}
