import org.avisfy.tasks.DirReduc;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class DirReducTest {

    @Test
    public void reduceToWest() {
        assertArrayEquals(new String[]{"WEST"},
                DirReduc.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"}));
    }

    @Test
    public void reduceToEmpty() {
        assertArrayEquals(new String[]{},
                DirReduc.dirReduc(new String[]{"NORTH","SOUTH","SOUTH","EAST","WEST","NORTH"}));
    }
}
