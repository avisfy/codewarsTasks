package org.avisfy.tasks;

import java.util.ArrayList;

public class Metro {
    public static int countPassengers(ArrayList<int[]> stops) {
        int sumLeft = stops.stream().mapToInt(s->s[0]-s[1]).sum();
        return sumLeft;
    }
}
