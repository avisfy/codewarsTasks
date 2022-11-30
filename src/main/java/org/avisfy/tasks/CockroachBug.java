package org.avisfy.tasks;

/**
 * Cockroach Bug Scatter
 */
public class CockroachBug {

    public static int[] cockroaches(final char[][] room) {
        int height = room.length;
        int width = room[0].length;
        int[] result = new int[10];

        /**
         *     top      left      bot     right
         *  |-------|----------|-------|----------|
         *  0       w         w+h    2w+h       2w+2h
         *   (revers)                    (revers)
         */
        int[] roomWalls = new int[2 * width + 2 * height];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int element = room[i][j];

                if (Character.isDigit(element)) {
                    //hole
                    int holeNumber = Character.digit(element, 10);
                    int newIndex = -1;
                    if (j == 0) {
                        //left wall
                        newIndex = width + i + 1;
                    } else if (j == (width - 1)) {
                        //right wall
                        newIndex = 2 * (width + height) - i - 1;
                    } else if (i == 0) {
                        //top wall
                        newIndex = width - j - 1;
                    } else if (i == (height - 1)) {
                        //bottom wall
                        newIndex = width + height + j + 1;
                    }

                    if (newIndex != -1) {
                        if (roomWalls[newIndex] > 0)
                            result[holeNumber] += roomWalls[newIndex];
                        //make hole numbers negative from -1 to -10 to make them different from cockroaches
                        roomWalls[newIndex] = -holeNumber - 1;
                    }

                } else if (Character.isLetter(element)) {
                    //cockroach
                    int newIndex = -1;
                    switch (element) {
                        case 'U':
                            newIndex = width - j - 1;
                            break;
                        case 'D':
                            newIndex = width + height + j + 1;
                            break;
                        case 'L':
                            newIndex = width + i + 1;
                            break;
                        case 'R':
                            newIndex = 2 * (width + height) - i - 1;
                    }
                    if (newIndex != -1) {
                        if (roomWalls[newIndex] < 0)
                            result[-roomWalls[newIndex] - 1] += 1;
                        else
                            roomWalls[newIndex] += 1;
                    }
                }
            }
        }

        //count cockroaches
        int firstHole = -1;
        int sum = 0;
        for (int i = 0; i < 2 * (width + height); i++) {
            int element = roomWalls[i];
            if (element > 0) {
                //cockroach
                sum += element;
            } else if (element < 0) {
                int holeNumber = -element - 1;
                result[holeNumber] += sum;
                sum = 0;
                if (firstHole == -1) {
                    firstHole = holeNumber;
                }
            }
        }

//        System.out.println();
//        for(int i = 0; i < 2 * (width + height); i++) {
//            System.out.print(roomWalls[i] + " ");
//        }
//        System.out.println();

        result[firstHole] += sum;
        return result;
    }
}
