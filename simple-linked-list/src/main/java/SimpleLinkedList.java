import java.util.NoSuchElementException;

class SimpleLinkedList<T> {

    private Node<T> lastNode;
    private int size = 0;

    SimpleLinkedList() {
    }

    SimpleLinkedList(T[] values) {
        for (T value : values) {
            push(value);
        }
    }

    void push(T value) {
        Node<T> newNode = new Node<>(value);
        if (lastNode == null) {
            lastNode = newNode;
        } else {
            lastNode.setNext(newNode);
            newNode.setPrev(lastNode);
            lastNode = lastNode.getNext();
        }

        size++;
    }

    T pop() {
        if(lastNode == null) throw new NoSuchElementException();

        T value = lastNode.getValue();
        lastNode.setNext(null);
        lastNode = lastNode.getPrev();

        size--;

        return value;
    }

    void reverse() {
        throw new UnsupportedOperationException("Please implement the SimpleLinkedList.reverse() method.");
    }

    T[] asArray(Class<T> clazz) {
        throw new UnsupportedOperationException("Please implement the SimpleLinkedList.asArray() method.");
    }

    int size() {
        return size;
    }
}
