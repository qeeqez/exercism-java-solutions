import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class DoublyLinkedListTest {

    @Test
    public void testPushPop() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.push(10);
        list.push(20);
        list.push(30);

        Assertions.assertThat(list.pop()).isEqualTo(30);
        Assertions.assertThat(list.pop()).isEqualTo(20);
        Assertions.assertThat(list.pop()).isEqualTo(10);
    }

    @Test
    public void testPushShift() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.push("10");
        list.push("20");
        list.push("30");

        Assertions.assertThat(list.shift()).isEqualTo("10");
        Assertions.assertThat(list.shift()).isEqualTo("20");
        Assertions.assertThat(list.shift()).isEqualTo("30");
    }

    @Test
    public void testUnshiftShift() {
        DoublyLinkedList<Character> list = new DoublyLinkedList<>();

        list.unshift('1');
        list.unshift('2');
        list.unshift('3');

        Assertions.assertThat(list.shift()).isEqualTo('3');
        Assertions.assertThat(list.shift()).isEqualTo('2');
        Assertions.assertThat(list.shift()).isEqualTo('1');
    }

    @Test
    public void testUnshiftPop() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        list.unshift(10);
        list.unshift(20);
        list.unshift(30);

        Assertions.assertThat(list.pop()).isEqualTo(10);
        Assertions.assertThat(list.pop()).isEqualTo(20);
        Assertions.assertThat(list.pop()).isEqualTo(30);
    }

    @Test
    public void testExample() {
        DoublyLinkedList<String> list = new DoublyLinkedList<>();

        list.push("ten");
        list.push("twenty");

        Assertions.assertThat(list.pop()).isEqualTo("twenty");

        list.push("thirty");

        Assertions.assertThat(list.shift()).isEqualTo("ten");

        list.unshift("forty");
        list.push("fifty");

        Assertions.assertThat(list.shift()).isEqualTo("forty");
        Assertions.assertThat(list.pop()).isEqualTo("fifty");
        Assertions.assertThat(list.shift()).isEqualTo("thirty");
    }

}
