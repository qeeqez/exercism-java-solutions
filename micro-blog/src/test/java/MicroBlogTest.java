import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;

public class MicroBlogTest {

    private final MicroBlog microBlog = new MicroBlog();
    
    @Test
    public void englishLanguageShort() {
        String expected = "Hi";
        Assertions.assertEquals(expected, microBlog.truncate("Hi"));
    }

    @Test
    public void englishLanguageLong() {
        String expected = "Hello";
        Assertions.assertEquals(expected, microBlog.truncate("Hello there"));
    }
    
    @Test
    public void germanLanguageShort_broth() {
        String expected = "brühe";
        Assertions.assertEquals(expected, microBlog.truncate("brühe"));
    }

    @Test
    public void germanLanguageLong_bearCarpet_to_beards() {
        String expected = "Bärte";
        Assertions.assertEquals(expected, microBlog.truncate("Bärteppich"));
    }
    
    @Test
    public void bulgarianLanguageShort_good() {
        String expected = "Добър";
        Assertions.assertEquals(expected, microBlog.truncate("Добър"));
    }

    @Test
    public void greekLanguageShort_health() {
        String expected = "υγειά";
        Assertions.assertEquals(expected, microBlog.truncate("υγειά"));
    }
    
    @Test
    public void mathsShort() {
        String expected = "a=πr²";
        Assertions.assertEquals(expected, microBlog.truncate("a=πr²"));
    }

    @Test
    public void mathsLong() {
        String expected = "∅⊊ℕ⊊ℤ";
        Assertions.assertEquals(expected, microBlog.truncate("∅⊊ℕ⊊ℤ⊊ℚ⊊ℝ⊊ℂ"));
    }
    
    @Test
    public void englishAndEmojiShort() {
        String expected = "Fly 🛫";
        Assertions.assertEquals(expected, microBlog.truncate("Fly 🛫"));
    }
    
    @Test
    public void emojiShort() {
        String expected = "💇";
        Assertions.assertEquals(expected, microBlog.truncate("💇"));
    }
    
    @Test
    public void emojiLong() {
        String expected = "❄🌡🤧🤒🏥";
        Assertions.assertEquals(expected, microBlog.truncate("❄🌡🤧🤒🏥🕰😀"));
    }
    
    @Test
    public void royalFlush() {
        String expected = "🃎🂸🃅🃋🃍";
        Assertions.assertEquals(expected, microBlog.truncate("🃎🂸🃅🃋🃍🃁🃊"));
    }
}
