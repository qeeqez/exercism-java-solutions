class SimpleLinkedList<T> {

    Node<T> lastNode;

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
    }

    T pop() {
        throw new UnsupportedOperationException("Please implement the SimpleLinkedList.pop() method.");
    }

    void reverse() {
        throw new UnsupportedOperationException("Please implement the SimpleLinkedList.reverse() method.");
    }

    T[] asArray(Class<T> clazz) {
        throw new UnsupportedOperationException("Please implement the SimpleLinkedList.asArray() method.");
    }

    int size() {
        int size = 0;

        Node<T> current = lastNode;
        while (current != null) {
            current = current.getPrev();
            size++;
        }

        return size;
    }
}
