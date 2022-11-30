import org.avisfy.tasks.Diamond;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiamondTest {
    @Test
    public void testDiamond3() {
        StringBuilder expected = new StringBuilder();
        expected.append(" *\n");
        expected.append("***\n");
        expected.append(" *\n");

        assertEquals(expected.toString(), Diamond.print(3));
    }

    @Test
    public void testDiamond5() {
        StringBuilder expected = new StringBuilder();
        expected.append("  *\n");
        expected.append(" ***\n");
        expected.append("*****\n");
        expected.append(" ***\n");
        expected.append("  *\n");

        assertEquals(expected.toString(), Diamond.print(5));
    }

    @Test
    public void testDiamond1() {
        StringBuilder expected = new StringBuilder();
        expected.append("*\n");
        assertEquals(expected.toString(), Diamond.print(1));
    }

    @Test
    public void testDiamond0() {
        assertEquals(null, Diamond.print(0));
    }

    @Test
    public void testDiamondMinus2() {
        assertEquals(null, Diamond.print(-2));
    }

    @Test
    public void testDiamond2() {
        assertEquals(null, Diamond.print(2));
    }
}
