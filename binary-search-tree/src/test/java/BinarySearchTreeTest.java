import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;

public class BinarySearchTreeTest {

    @Test
    public void dataIsRetained() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        int expected = 4;
        binarySearchTree.insert(expected);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();

        Assertions.assertThat(root).isNotNull();
        Assertions.assertThat(root.getData()).isEqualTo(expected);
    }


    @Test
    public void insertsLess() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();

        char expectedRoot = '4';
        char expectedLeft = '2';

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedLeft);

        BinarySearchTree.Node<Character> root = binarySearchTree.getRoot();
        BinarySearchTree.Node<Character> left = root.getLeft();

        Assertions.assertThat(root).isNotNull();
        Assertions.assertThat(left).isNotNull();

        Assertions.assertThat(root.getData()).isEqualTo(expectedRoot);
        Assertions.assertThat(left.getData()).isEqualTo(expectedLeft);
    }

    @Test
    public void insertsSame() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        String expectedRoot = "4";
        String expectedLeft = "4";

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedLeft);

        BinarySearchTree.Node<String> root = binarySearchTree.getRoot();
        BinarySearchTree.Node<String> left = root.getLeft();

        Assertions.assertThat(root).isNotNull();
        Assertions.assertThat(left).isNotNull();

        Assertions.assertThat(root.getData()).isEqualTo(expectedRoot);
        Assertions.assertThat(left.getData()).isEqualTo(expectedLeft);
    }

    @Test
    public void insertsRight() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        int expectedRoot = 4;
        int expectedRight = 5;

        binarySearchTree.insert(expectedRoot);
        binarySearchTree.insert(expectedRight);

        BinarySearchTree.Node<Integer> root = binarySearchTree.getRoot();
        BinarySearchTree.Node<Integer> right = root.getRight();

        Assertions.assertThat(root).isNotNull();
        Assertions.assertThat(right).isNotNull();

        Assertions.assertThat(root.getData()).isEqualTo(expectedRoot);
        Assertions.assertThat(right.getData()).isEqualTo(expectedRight);
    }

    @Test
    public void createsComplexTree() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = List.of('4', '2', '6', '1', '3', '5', '7');

        List<Character> treeData = List.of('4', '2', '6', '1', '3', '5', '7');
        treeData.forEach(binarySearchTree::insert);

        Assertions.assertThat(binarySearchTree.getAsLevelOrderList()).isEqualTo(expected);
    }

    @Test
    public void sortsSingleElement() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        List<String> expected = Collections.singletonList("2");

        binarySearchTree.insert("2");

        Assertions.assertThat(binarySearchTree.getAsSortedList()).isEqualTo(expected);
    }

    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsSmallerThanFirst() {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        List<Integer> expected = List.of(1, 2);

        binarySearchTree.insert(2);
        binarySearchTree.insert(1);

        Assertions.assertThat(binarySearchTree.getAsSortedList()).isEqualTo(expected);
    }

    @Test
    public void sortsCollectionOfTwoIfSecondNumberisSameAsFirst() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = List.of('2', '2');

        binarySearchTree.insert('2');
        binarySearchTree.insert('2');

        Assertions.assertThat(binarySearchTree.getAsSortedList()).isEqualTo(expected);
    }

    @Test
    public void sortsCollectionOfTwoIfSecondInsertedIsBiggerThanFirst() {
        BinarySearchTree<Character> binarySearchTree = new BinarySearchTree<>();
        List<Character> expected = List.of('2', '3');

        binarySearchTree.insert('2');
        binarySearchTree.insert('3');

        Assertions.assertThat(binarySearchTree.getAsSortedList()).isEqualTo(expected);
    }

    @Test
    public void iteratesOverComplexTree() {
        BinarySearchTree<String> binarySearchTree = new BinarySearchTree<>();
        List<String> expected = List.of("1", "2", "3", "5", "6", "7");

        List<String> treeData = List.of("2", "1", "3", "6", "7", "5");
        treeData.forEach(binarySearchTree::insert);

        Assertions.assertThat(binarySearchTree.getAsSortedList()).isEqualTo(expected);
    }
}
