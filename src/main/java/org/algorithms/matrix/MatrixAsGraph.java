package org.algorithms.matrix;

import java.util.ArrayList;
import java.util.List;

public class MatrixAsGraph {

    public class Coordinate{
        int row;
        int col;
        public Coordinate(int row, int col){
            this.row = row;
            this.col = col;
        }

    }

    public List<Coordinate> getNeighbors(Coordinate coord, int numRows, int numCols) {
        int row = coord.row;
        int col = coord.col;
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        List<Coordinate> res = new ArrayList<>();
        for (int i = 0; i < deltaRow.length; i++) {
            int neighborRow = row + deltaRow[i];
            int neighborCol = col + deltaCol[i];
            if (0 <= neighborRow && neighborRow < numRows &&
                    0 <= neighborCol && neighborCol < numCols) {
                res.add(new Coordinate(neighborRow, neighborCol));
            }
        }
        return res;
    }



}
