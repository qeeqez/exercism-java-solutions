import java.util.Optional;

class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException(message);
    }

    void handleErrorByThrowingAnyCheckedException() throws Exception {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String message) throws Exception {
        throw new CustomCheckedException(message);
    }

    void handleErrorByThrowingAnyUncheckedException() {
        // Delete this statement and write your own implementation.
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String message) {
        // Delete this statement and write your own implementation.
    }

    void handleErrorByThrowingCustomCheckedException() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String message) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    void handleErrorByThrowingCustomUncheckedException() {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String message) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
    }

}
