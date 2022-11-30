import org.avisfy.tasks.ValidParentheses;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidParenthesesTest {
    @Test
    public void easyValidTest() {
        assertEquals(true, ValidParentheses.validParentheses( "()" ));
    }

    @Test
    public void easyInvalidTest() {
        assertEquals(false,ValidParentheses.validParentheses( "())" ));
    }

    @Test
    public void validWithLettersTest() {
        assertEquals(true,ValidParentheses.validParentheses( "32423(sgsdg)" ));
    }

    @Test
    public void invalidWithLettersTest() {
        assertEquals(false,ValidParentheses.validParentheses( "(dsgdsg))2432" ));
    }

    @Test
    public void validWithoutParenthesesTest() {
        assertEquals(true,ValidParentheses.validParentheses( "adasdasfa" ));
    }
}
