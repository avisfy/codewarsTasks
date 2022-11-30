import org.avisfy.tasks.WhoLikesIt;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WhoLikesItTest {
    @Test
    public void noOneLikesTests() {
        assertEquals("no one likes this", WhoLikesIt.whoLikesIt());
    }

    @Test
    public void oneLikeTests() {
        assertEquals("Peter likes this", WhoLikesIt.whoLikesIt("Peter"));
    }

    @Test
    public void twoLikesTests() {
        assertEquals("Jacob and Alex like this", WhoLikesIt.whoLikesIt("Jacob", "Alex"));
    }

    @Test
    public void threeLikesTests() {
        assertEquals("Max, John and Mark like this", WhoLikesIt.whoLikesIt("Max", "John", "Mark"));
    }

    @Test
    public void moreThanThreeLikesTests() {
        assertEquals("Alex, Jacob and 2 others like this", WhoLikesIt.whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }
}
