package chaincodemachinelearning;

import java.util.*;
import java.sql.*;

class QArray {
    private int[][] array;
    private int quadrantSize;

    public QArray(int[][] array) {
        this.array = array;
        this.quadrantSize = array.length / 3;
    }

    public int[][] getQuadrant(int quadrant) {
        int[][] quadrantArray;

        switch (quadrant) {
        case 1:
            quadrantArray = getQuadrant(0, 0);
            break;
        case 2:
            quadrantArray = getQuadrant(0, 10);
            break;
        case 3:
            quadrantArray = getQuadrant(0, 20);
            break;
        case 4:
            quadrantArray = getQuadrant(10, 0);
            break;
        case 5:
            quadrantArray = getQuadrant(10, 10);
            break;
        case 6:
            quadrantArray = getQuadrant(10, 20);
            break;
        case 7:
            quadrantArray = getQuadrant(20, 0);
            break;
        case 8:
            quadrantArray = getQuadrant(20, 10);
            break;
        case 9:         
            quadrantArray = getQuadrant(20, 20);
            break;
        default:
            throw new IllegalArgumentException("Invalid quadrant: " + quadrant);
        }
        return quadrantArray;
    }

    public int[][] getQuadrant(int startRow, int startCol) {
        int[][] quadrantArray = new int[quadrantSize][];
        for (int r = 0; r < quadrantSize; r++) {
            quadrantArray[r] = Arrays.copyOfRange(array[startRow + r], startCol, startCol + quadrantSize);
        }

        return quadrantArray;
    }
}