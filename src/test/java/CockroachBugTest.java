import org.avisfy.tasks.CockroachBug;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class CockroachBugTest {

    @Test
    public void room1() {
        final String[] s = new String[]{
                "+----------------0---------------+",
                "|                                |",
                "|                                |",
                "|          U        D            |",
                "|     L                          |",
                "|              R                 |",
                "|           L                    |",
                "|  U                             1",
                "3        U    D                  |",
                "|         L              R       |",
                "|                                |",
                "+----------------2---------------+"
        };
        final char[][] room = arrayFromRoom(s);
        final int[] expected = new int[]{1, 2, 2, 5, 0, 0, 0, 0, 0, 0};
        assertArrayEquals(expected, CockroachBug.cockroaches(room));
    }

    @Test
    public void cornerHoles() {
        final String[] s = new String[]{
                "2-----------4",
                "|           |",
                "|    UD     |",
                "|    RL     |",
                "|           |",
                "6-----------8"
        };
        final char[][] room = arrayFromRoom(s);
        final int[] expected = new int[]{0, 0, 1, 0, 1, 0, 1, 0, 1, 0};
        assertArrayEquals(expected, CockroachBug.cockroaches(room));
    }

    @Test
    public void downHoles() {
        final String[] s = new String[]{
                "+-----------+",
                "|           |",
                "|           |",
                "|    DDDD   |",
                "|           |",
                "+----456----+"
        };
        final char[][] room = arrayFromRoom(s);
        final int[] expected = new int[]{0, 0, 0, 0, 2, 1, 1, 0, 0, 0};
        assertArrayEquals(expected, CockroachBug.cockroaches(room));
    }

    @Test
    public void inOneHole() {
        final String[] s = new String[]{
                "+-----------+",
                "|           |",
                "|    D D    |",
                "|    DDDD   |",
                "|           |",
                "+----456----+"
        };
        final char[][] room = arrayFromRoom(s);
        final int[] expected = new int[]{0, 0, 0, 0, 3, 1, 2, 0, 0, 0};
        assertArrayEquals(expected, CockroachBug.cockroaches(room));
    }

    private char[][] arrayFromRoom(String[] room) {
        int width = room[0].length();
        int height = room.length;
        char[][] roomArray = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                roomArray[i][j] = room[i].charAt(j);
            }
        }
        return roomArray;
    }


}
