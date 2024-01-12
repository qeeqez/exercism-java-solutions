import org.junit.jupiter.api.Test;

import org.assertj.core.api.Assertions;

public class SqueakyCleanTest {

    @Test
    public void empty() {
        Assertions.assertThat(SqueakyClean.clean("")).isEmpty();
    }

    @Test
    public void single_letter() {
        Assertions.assertThat(SqueakyClean.clean("A")).isEqualTo("A");
    }

    @Test
    public void string() {
        Assertions.assertThat(SqueakyClean.clean("àḃç")).isEqualTo("àḃç");
    }

    @Test
    public void spaces() {
        Assertions.assertThat(SqueakyClean.clean("my   Id")).isEqualTo("my___Id");
    }

    @Test
    public void leading_and_trailing_spaces() {
        Assertions.assertThat(SqueakyClean.clean(" myId ")).isEqualTo("_myId_");
    }

    @Test
    public void ctrl() {
        Assertions.assertThat(SqueakyClean.clean("my\0\r\u007FId")).isEqualTo("myCTRLCTRLCTRLId");
    }

    @Test
    public void string_with_no_letters() {
        Assertions.assertThat(SqueakyClean.clean("\uD83D\uDE00\uD83D\uDE00\uD83D\uDE00")).isEmpty();
    }

    @Test
    public void keep_only_letters() {
        Assertions.assertThat(SqueakyClean.clean("a1\uD83D\uDE002\uD83D\uDE003\uD83D\uDE00b")).isEqualTo("ab");
    }

    @Test
    public void kebab_to_camel_case() {
        Assertions.assertThat(SqueakyClean.clean("à-ḃç")).isEqualTo("àḂç");
    }

    @Test
    public void kebab_to_camel_case_no_letter() {
        Assertions.assertThat(SqueakyClean.clean("a-1C")).isEqualTo("aC");
    }

    @Test
    public void omit_lower_case_greek_letters() {
        Assertions.assertThat(SqueakyClean.clean("MyΟβιεγτFinder")).isEqualTo("MyΟFinder");
    }

    @Test
    public void combine_conversions() {
        Assertions.assertThat(SqueakyClean.clean("9 -abcĐ\uD83D\uDE00ω\0")).isEqualTo("_AbcĐCTRL");
    }
}
