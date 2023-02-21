import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

class Flattener {

    Flattener() {
    }

    public List<Object> flatten(List<Object> input) {
        return input.stream()
                .flatMap(this::flatten)
                .filter(Objects::nonNull)
                .toList();
    }

    private Stream<Object> flatten(Object o) {
        return o instanceof List ? ((List<?>) o).stream().flatMap(this::flatten) : Stream.of(o);
    }
}
