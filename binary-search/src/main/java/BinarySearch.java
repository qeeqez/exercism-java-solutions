/*

Since this exercise has a difficulty of > 4 it doesn't come
with any starter implementation.
This is so that you get to practice creating classes and methods
which is an important part of programming in Java.

Please remove this comment when submitting your solution.

*/

import java.util.List;

class BinarySearch {

    List<Integer> listToSearch;

    BinarySearch(List<Integer> input) {
        listToSearch = input;
    }

    public int indexOf(int value) throws ValueNotFoundException {
        int left = 0;
        int right = listToSearch.size() - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (listToSearch.get(middle) == value) return middle;
            else if (listToSearch.get(middle) < value) left = middle + 1;
            else right = middle - 1;
        }

        throw new ValueNotFoundException("Value not in array");
    }


}
