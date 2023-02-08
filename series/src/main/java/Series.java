import java.util.ArrayList;
import java.util.List;

class Series {

    private final String series;

    Series(String string) {
        series = string;
    }

    List<String> slices(int num) {
        if (num <= 0) throw new IllegalArgumentException("Slice size is too small.");
        if (num > series.length()) throw new IllegalArgumentException("Slice size is too big.");

        int sliceCount = series.length() - num + 1;

        List<String> slices = new ArrayList<>();
        for (int i = 0; i < sliceCount; i++) {
            slices.add(series.substring(i, i + num));
        }
        return slices;
    }
}
