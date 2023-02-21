class DoublyLinkedList<T> {
    private Element<T> first;
    private Element<T> last;

    void push(T value) {
        if (last == null) {
            last = new Element<>(value);
            first = last;
        } else {
            last.next = new Element<>(value, last, null);
            last = last.next;
        }
    }

    T pop() {
        if (last == null) return null;

        T value = last.value;
        last = last.prev;
        if (last != null) last.next = null;

        return value;
    }

    void unshift(T value) {
        if (first == null) {
            first = new Element<>(value);
            last = first;
        } else {
            first.prev = new Element<>(value, null, first);
            first = first.prev;
        }
    }

    T shift() {
        if (first == null) return null;

        T value = first.value;
        first = first.next;
        if (first != null) first.prev = null;

        return value;
    }

    private static final class Element<T> {
        private final T value;
        private Element<T> prev;
        private Element<T> next;

        Element(T value) {
            this.value = value;
        }

        Element(T value, Element<T> prev, Element<T> next) {
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
}
