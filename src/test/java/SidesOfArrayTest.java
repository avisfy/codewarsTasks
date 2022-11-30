import org.avisfy.tasks.SidesOfArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SidesOfArrayTest {
    @Test
    public void test3() {
        assertEquals(3, SidesOfArray.findEvenIndex(new int[] {1,2,3,4,3,2,1}));
    }

    @Test
    public void test1() {
        assertEquals(1,SidesOfArray.findEvenIndex(new int[] {1,100,50,-51,1,1}));
    }

    @Test
    public void testNoSuchIndex() {
        assertEquals(-1,SidesOfArray.findEvenIndex(new int[] {1,2,3,4,5,6}));
    }

    @Test
    public void test0() {
        assertEquals(0,SidesOfArray.findEvenIndex(new int[] {20,10,-80,10,10,15,35}));
    }
    @Test
    public void test6() {
        assertEquals(6,SidesOfArray.findEvenIndex(new int[] {4, 5, 6, 7, 8, 9, 10, 9, 8, 7, 6, 5, 4}));
    }
}
