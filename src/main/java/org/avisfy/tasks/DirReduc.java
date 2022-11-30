package org.avisfy.tasks;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * Directions Reduction
 */
public class DirReduc {
    public static String[] dirReduc(String[] arr) {
        LinkedList<Dirs> dirs = Arrays.stream(arr).map(Dirs::valueOf).collect(Collectors.toCollection(LinkedList::new));
        for (int i = 1; i < dirs.size(); i++) {
            if ((dirs.get(i).getValue() + dirs.get(i - 1).getValue()) == 0) {
                dirs.remove(i);
                dirs.remove(i - 1);
                i--;
                if (i > 0) i--;
            }
        }
        String[] result = Arrays.stream(dirs.toArray(new Dirs[0])).map(Dirs::toString).toArray(String[]::new);
        return result;
    }

    enum Dirs {
        NORTH(-1),
        SOUTH(1),
        EAST(2),
        WEST(-2);

        private final int value;

        Dirs(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
