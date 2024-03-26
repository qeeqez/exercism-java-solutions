import static java.util.Collections.unmodifiableList;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO representing a User in the database.
 */
public class User {
    private final String name;
    private final List<Iou> owes;
    private final List<Iou> owedBy;

    private User(String name, List<Iou> owes, List<Iou> owedBy) {
        this.name = name;
        this.owes = new ArrayList<>(owes);
        this.owedBy = new ArrayList<>(owedBy);
    }

    public String name() {
        return name;
    }

    /**
     * IOUs this user owes to other users.
     */
    public List<Iou> owes() {
        return unmodifiableList(owes);
    }

    /**
     * IOUs other users owe to this user.
     */
    public List<Iou> owedBy() {
        return unmodifiableList(owedBy);
    }

    public void updateOwes(Iou iou) {
        updateOwe(iou, owedBy, owes);
    }

    public void updateOwedBy(Iou iou) {
        updateOwe(iou, owes, owedBy);
    }

    private void updateOwe(Iou updated, List<Iou> owedBy, List<Iou> owes) {
        for (Iou iou : owedBy) {
            if (iou.name.equals(updated.name)) {
                double totalAmount = iou.amount - updated.amount;
                if (totalAmount <= 0) owedBy.remove(iou);
                if (totalAmount > 0) owedBy.set(owedBy.indexOf(iou), new Iou(updated.name, totalAmount));
                else if (totalAmount < 0) owes.add(new Iou(updated.name, totalAmount * -1));
                return;
            }
        }
        owes.add(updated);
    }

    public double getBalance() {
        Double owes = owes().stream().mapToDouble(iou -> iou.amount).sum();
        Double owedBy = owedBy().stream().mapToDouble(iou -> iou.amount).sum();
        return owedBy - owes;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String name;
        private final List<Iou> owes = new ArrayList<>();
        private final List<Iou> owedBy = new ArrayList<>();

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder owes(String name, double amount) {
            owes.add(new Iou(name, amount));
            return this;
        }

        public Builder owedBy(String name, double amount) {
            owedBy.add(new Iou(name, amount));
            return this;
        }

        public User build() {
            return new User(name, owes, owedBy);
        }
    }
}
