package org.algorithms.matrix;

import java.util.*;
import java.util.stream.Collectors;

public class NumberOfIslands {
    public static class Coordinates {
        int r;
        int c;

        public Coordinates(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int countNumberOfIslands(List<List<Integer>> grid) {
        int nrRows = grid.size();
        int nrCols = grid.get(0).size();
        int nrIslands = 0;
        for (int r = 0; r < nrRows; r++) {
            for (int c = 0; c < nrCols; c++) {
                bfs(grid, new Coordinates(r, c), nrRows, nrCols);
                nrIslands++;
            }
        }
        return nrIslands;
    }

    private static void bfs(List<List<Integer>> grid, Coordinates root, int nrRows, int nrCols) {
        ArrayDeque<Coordinates> queue = new ArrayDeque<>();
        Coordinates node = new Coordinates(0, 0);
        queue.add(node);
        grid.get(root.r).set(root.c, 0);
        while (!queue.isEmpty()) {
            Coordinates coordinate = queue.pop();
            for (Coordinates neighbor : getNeighbors(grid, nrRows, nrCols, coordinate)) {
                if (grid.get(neighbor.r).get(neighbor.c) == 0) continue;
                queue.add(coordinate);
                grid.get(coordinate.r).set(coordinate.c, 0);
            }
        }
    }

    private static List<Coordinates> getNeighbors(List<List<Integer>> grid, int nrRows, int nrCols, Coordinates node) {
        List<Coordinates> res = new ArrayList<>();
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {1, 0, -1, 0};
        for (int i = 0; i < deltaRow.length; i++) {
            int neighborRow = node.r + deltaRow[i];
            int neighborCol = node.c + deltaCol[i];
            if (neighborRow >= 0 && neighborRow < nrRows && neighborCol >= 0 && neighborCol < nrCols) {
                res.add(new Coordinates(neighborRow, neighborCol));
            }
        }
        return res;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int gridLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> grid = new ArrayList<>();
        for (int i = 0; i < gridLength; i++) {
            grid.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        int res = countNumberOfIslands(grid);
        System.out.println(res);
    }
}
