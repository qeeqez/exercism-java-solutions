import java.lang.reflect.Array;
import java.util.NoSuchElementException;

class SimpleLinkedList<T> {

    private Node<T> firstNode;
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
        if (firstNode == null) {
            firstNode = newNode;
        } else {
            lastNode.setNext(newNode);
            newNode.setPrev(lastNode);
        }

        lastNode = newNode;
        size++;
    }

    T pop() {
        if (lastNode == null) throw new NoSuchElementException();

        T value = lastNode.getValue();
        lastNode.setNext(null);
        lastNode = lastNode.getPrev();

        size--;

        return value;
    }

    void reverse() {
        Node<T> current = firstNode;
        while (current != null) {
            current = reverseNode(current);
        }
        Node<T> tempNode = firstNode;
        firstNode = lastNode;
        lastNode = tempNode;
    }

    private Node<T> reverseNode(Node<T> current) {
        Node<T> tempNode = current.getPrev();
        current.setPrev(current.getNext());
        current.setNext(tempNode);
        return current.getPrev();
    }

    @SuppressWarnings("unchecked")
    T[] asArray(Class<T> clazz) {
        T[] array = (T[]) Array.newInstance(clazz, size);

        Node<T> current = lastNode;
        for (int i = 0; i < size; i++) {
            array[i] = current.getValue();
            current = current.getPrev();
        }

        return array;
    }

    int size() {
        return size;
    }
}
