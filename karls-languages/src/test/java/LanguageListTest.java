import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.Test;

public class LanguageListTest {

    LanguageList languageList = new LanguageList();

    @Test
    public void empty() {
        Assertions.assertThat(languageList.isEmpty()).isTrue();
    }

    @Test
    public void nonEmpty() {
        languageList.addLanguage("Java");

        Assertions.assertThat(languageList.isEmpty()).isFalse();
    }

    @Test
    public void addOneLanguage() {
        languageList.addLanguage("Java");

        Assertions.assertThat(languageList.containsLanguage("Java")).isTrue();
        Assertions.assertThat(languageList.containsLanguage("Python")).isFalse();
    }

    @Test
    public void addMultipleLanguages() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Ruby");
        languageList.addLanguage("C++");

        Assertions.assertThat(languageList.containsLanguage("Java")).isTrue();
        Assertions.assertThat(languageList.containsLanguage("Ruby")).isTrue();
        Assertions.assertThat(languageList.containsLanguage("C++")).isTrue();
        Assertions.assertThat(languageList.containsLanguage("Python")).isFalse();
    }

    @Test
    public void removeLanguage() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        languageList.removeLanguage("Python");

        Assertions.assertThat(languageList.containsLanguage("Java")).isTrue();
        Assertions.assertThat(languageList.containsLanguage("Python")).isFalse();
        Assertions.assertThat(languageList.containsLanguage("Ruby")).isTrue();
    }

    @Test
    public void firstLanguage() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        Assertions.assertThat(languageList.firstLanguage()).isEqualTo("Java");
    }

    @Test
    public void countThree() {
        languageList.addLanguage("Java");
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");

        Assertions.assertThat(languageList.count()).isEqualTo(3);
    }

    @Test
    public void countEmpty() {
        Assertions.assertThat(languageList.count()).isEqualTo(0);
    }

    @Test
    public void excitingLanguageListWithJava() {
        languageList.addLanguage("Java");

        Assertions.assertThat(languageList.isExciting()).isTrue();
    }

    @Test
    public void excitingLanguageListWithKotlin() {
        languageList.addLanguage("Python");
        languageList.addLanguage("Kotlin");

        Assertions.assertThat(languageList.isExciting()).isTrue();
    }

    @Test
    public void boringLanguageList() {
        languageList.addLanguage("Python");
        languageList.addLanguage("Ruby");
        languageList.addLanguage("C++");

        Assertions.assertThat(languageList.isExciting()).isFalse();
    }
}
