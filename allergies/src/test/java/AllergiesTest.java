import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class AllergiesTest {


    // Testing for eggs allergy

    @Test
    public void eggsNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.EGGS)).isFalse();
    }

    @Test
    public void eggsAllergicOnlyToEggs() {
        Allergies allergies = new Allergies(1);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.EGGS)).isTrue();
    }

    @Test
    public void eggsAllergicToEggsAndSomethingElse() {
        Allergies allergies = new Allergies(3);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.EGGS)).isTrue();
    }

    @Test
    public void eggsAllergicToSomethingButNotEggs() {
        Allergies allergies = new Allergies(2);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.EGGS)).isFalse();
    }

    @Test
    public void eggsAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.EGGS)).isTrue();
    }


    // Testing for peanuts allergy

    @Test
    public void peanutsNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isFalse();
    }

    @Test
    public void peanutsAllergicOnlyToPeanuts() {
        Allergies allergies = new Allergies(2);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isTrue();
    }

    @Test
    public void peanutsAllergicToPeanutsAndSomethingElse() {
        Allergies allergies = new Allergies(7);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isTrue();
    }

    @Test
    public void peanutsAllergicToSomethingButNotPeanuts() {
        Allergies allergies = new Allergies(5);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isFalse();
    }

    @Test
    public void peanutsAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.PEANUTS)).isTrue();
    }


    // Testing for shellfish allergy

    @Test
    public void shellfishNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isFalse();
    }

    @Test
    public void shellfishAllergicOnlyToShellfish() {
        Allergies allergies = new Allergies(4);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isTrue();
    }

    @Test
    public void shellfishAllergicToShellfishAndSomethingElse() {
        Allergies allergies = new Allergies(14);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isTrue();
    }

    @Test
    public void shellfishAllergicToSomethingButNotShellfish() {
        Allergies allergies = new Allergies(10);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isFalse();
    }

    @Test
    public void shellfishAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.SHELLFISH)).isTrue();
    }


    // Testing for strawberries allergy

    @Test
    public void strawberriesNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isFalse();
    }

    @Test
    public void strawberriesAllergicOnlyToStrawberries() {
        Allergies allergies = new Allergies(8);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isTrue();
    }

    @Test
    public void strawberriesAllergicToStrawberriesAndSomethingElse() {
        Allergies allergies = new Allergies(28);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isTrue();
    }

    @Test
    public void strawberriesAllergicToSomethingButNotStrawberries() {
        Allergies allergies = new Allergies(20);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isFalse();
    }

    @Test
    public void strawberriesAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.STRAWBERRIES)).isTrue();
    }


    // Testing for tomatoes allergy

    @Test
    public void tomatoesNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isFalse();
    }

    @Test
    public void tomatoesAllergicOnlyToTomatoes() {
        Allergies allergies = new Allergies(16);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isTrue();
    }

    @Test
    public void tomatoesAllergicToTomatoesAndSomethingElse() {
        Allergies allergies = new Allergies(56);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isTrue();
    }

    @Test
    public void tomatoesAllergicToSomethingButNotTomatoes() {
        Allergies allergies = new Allergies(40);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isFalse();
    }

    @Test
    public void tomatoesAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.TOMATOES)).isTrue();
    }


    // Testing for chocolate allergy

    @Test
    public void chocolateNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isFalse();
    }

    @Test
    public void chocolateAllergicOnlyToChocolate() {
        Allergies allergies = new Allergies(32);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isTrue();
    }

    @Test
    public void chocolateAllergicToChocolateAndSomethingElse() {
        Allergies allergies = new Allergies(112);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isTrue();
    }

    @Test
    public void chocolateAllergicToSomethingButNotChocolate() {
        Allergies allergies = new Allergies(80);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isFalse();
    }

    @Test
    public void chocolateAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.CHOCOLATE)).isTrue();
    }


    // Testing for pollen allergy

    @Test
    public void pollenNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isFalse();
    }

    @Test
    public void pollenAllergicOnlyToPollen() {
        Allergies allergies = new Allergies(64);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isTrue();
    }

    @Test
    public void pollenAllergicToPollenAndSomethingElse() {
        Allergies allergies = new Allergies(224);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isTrue();
    }

    @Test
    public void pollenAllergicToSomethingButNotPollen() {
        Allergies allergies = new Allergies(160);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isFalse();
    }

    @Test
    public void pollenAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.POLLEN)).isTrue();
    }


    // Testing for cats allergy

    @Test
    public void catsNotAllergicToAnything() {
        Allergies allergies = new Allergies(0);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.CATS)).isFalse();
    }

    @Test
    public void catsAllergicOnlyToCats() {
        Allergies allergies = new Allergies(128);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.CATS)).isTrue();
    }

    @Test
    public void catsAllergicToCatsAndSomethingElse() {
        Allergies allergies = new Allergies(192);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.CATS)).isTrue();
    }

    @Test
    public void catsAllergicToSomethingButNotCats() {
        Allergies allergies = new Allergies(64);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.CATS)).isFalse();
    }

    @Test
    public void catsAllergicToEverything() {
        Allergies allergies = new Allergies(255);

        Assertions.assertThat(allergies.isAllergicTo(Allergen.CATS)).isTrue();
    }


    // Testing listing allergies

    @Test
    public void listNoAllergies() {
        Allergies allergies = new Allergies(0);

        Assertions.assertThat(allergies.getList().size()).isEqualTo(0);
    }

    @Test
    public void listJustEggs() {
        Allergies allergies = new Allergies(1);

        Assertions.assertThat(allergies.getList())
                .containsExactly(Allergen.EGGS);
    }

    @Test
    public void listJustPeanuts() {
        Allergies allergies = new Allergies(2);

        Assertions.assertThat(allergies.getList())
                .containsExactly(Allergen.PEANUTS);
    }

    @Test
    public void listJustStrawberries() {
        Allergies allergies = new Allergies(8);

        Assertions.assertThat(allergies.getList())
                .containsExactly(Allergen.STRAWBERRIES);
    }

    @Test
    public void listEggsAndPeanuts() {
        Allergies allergies = new Allergies(3);

        Assertions.assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.PEANUTS);
    }

    @Test
    public void listoMoreThanEggsButNotPeanuts() {
        Allergies allergies = new Allergies(5);

        Assertions.assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.SHELLFISH);
    }

    @Test
    public void listManyAllergies() {
        Allergies allergies = new Allergies(248);

        Assertions.assertThat(allergies.getList())
                .containsExactly(
                        Allergen.STRAWBERRIES,
                        Allergen.TOMATOES,
                        Allergen.CHOCOLATE,
                        Allergen.POLLEN,
                        Allergen.CATS);
    }

    @Test
    public void listEverything() {
        Allergies allergies = new Allergies(255);

        Assertions.assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.PEANUTS,
                        Allergen.SHELLFISH,
                        Allergen.STRAWBERRIES,
                        Allergen.TOMATOES,
                        Allergen.CHOCOLATE,
                        Allergen.POLLEN,
                        Allergen.CATS);
    }

    @Test
    public void listNoAllergenScoreParts() {
        Allergies allergies = new Allergies(509);

        Assertions.assertThat(allergies.getList())
                .containsExactly(
                        Allergen.EGGS,
                        Allergen.SHELLFISH,
                        Allergen.STRAWBERRIES,
                        Allergen.TOMATOES,
                        Allergen.CHOCOLATE,
                        Allergen.POLLEN,
                        Allergen.CATS);
    }
}
