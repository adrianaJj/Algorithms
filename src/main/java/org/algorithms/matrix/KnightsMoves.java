package org.algorithms.matrix;

import java.util.*;

public class KnightsMoves{

    public static class Coordinate {
        int row;
        int col;

        public Coordinate(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    private static List<Coordinate> getNeighbors(Coordinate coord, int nx, int ny) {
        ArrayList<Coordinate> result = new ArrayList<>();
        int[] nRows = {-2, -2, -1, 1, 2, 2, 1, -1};
        int[] nCols = {-1, 1, 2, 2, 1, -1, -2, -2};
        for (int i = 0; i < nRows.length; i++) {
            int row = coord.row + nRows[i];
            int col = coord.col + nCols[i];
            if (row < ny && col < ny && 0 <= row && 0 <= col) {
                result.add(new Coordinate(row, col));
            }
        }
        return result;
    }


    public static int knightMinPath(int xStart, int yStart, int endX, int endY, int nx, int ny) {

        Coordinate startCoord = new Coordinate(yStart, xStart);
        int nrMoves = 0;
        ArrayList<Coordinate> movesDone = new ArrayList<>();
        movesDone.add(startCoord);

        ArrayDeque<Coordinate> queue = new ArrayDeque<>();
        queue.add(startCoord);

        while (queue.size() > 0) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Coordinate c = queue.pop();
                if (c.col == endX && c.row == endY) {
                    return nrMoves;
                }
                List<Coordinate> neighbors = getNeighbors(c, nx, ny);
                for (Coordinate neighbor : neighbors) {
                    if (movesDone.contains(neighbor)) {
                        continue;
                    }
                    queue.add(neighbor);
                    movesDone.add(neighbor);
                }
            }
            nrMoves++;
        }

        return nrMoves;
    }


    // nx,ny = rows and cols
    // kx,ky = starting position row and col
    // cx,cy = end coordinates

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] variables = new String[6];
        int i=0;
        int x=3;
        while (x > 0) {
            String line = scanner.nextLine();
            String[] vals = line.split(" ");
            variables[i++] = vals[0];
            variables[i++] = vals[1];
            x--;
        }
        scanner.close();
        int res = knightMinPath(Integer.parseInt(variables[2]), Integer.parseInt(variables[3]), Integer.parseInt(variables[4]), Integer.parseInt(variables[5]), Integer.parseInt(variables[0]), Integer.parseInt(variables[1]));
        System.out.println(res);
    }
}