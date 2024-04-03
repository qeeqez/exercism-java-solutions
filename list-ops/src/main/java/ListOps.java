import java.util.Collection;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

class ListOps {

    static <T> List<T> append(List<T> list1, List<T> list2) {
        return Stream.concat(list1.stream(), list2.stream()).toList();
    }

    static <T> List<T> concat(List<List<T>> listOfLists) {
        return listOfLists.stream().flatMap(Collection::stream).toList();
    }

    static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).toList();
    }

    static <T> int size(List<T> list) {
        return list.size();
    }

    static <T, U> List<U> map(List<T> list, Function<T, U> transform) {
        return list.stream().map(transform).toList();
    }

    static <T> List<T> reverse(List<T> list) {
        return list.stream().toList().reversed();
    }

    static <T, U> U foldLeft(List<T> list, U initial, BiFunction<U, T, U> f) {
        return list.stream().reduce(initial, f, (u1, u2) -> u1);
    }

    static <T, U> U foldRight(List<T> list, U initial, BiFunction<T, U, U> f) {
        return reverse(list).stream().reduce(initial, (u, t) -> f.apply(t, u), (u1, u2) -> u1);
    }

    private ListOps() {
    }

}
