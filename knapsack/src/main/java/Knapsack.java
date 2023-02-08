import java.util.List;

public class Knapsack {

    Knapsack() {
    }

    public int maximumValue(int maxWeight, List<Item> items) {
        return items.stream()
                .mapToInt(
                        item -> item.getWeight() > maxWeight ? 0 :
                                item.getValue() + maximumValue(
                                        maxWeight - item.getWeight(),
                                        items.subList(items.indexOf(item) + 1, items.size())
                                )
                )
                .max()
                .orElse(0);
    }

}