package org.algorithms.matrix;

import java.util.*;
import java.util.stream.Collectors;

/**
 * In computer graphics, an uncompressed raster image is presented as a matrix of numbers.
 * Each entry of the matrix represents the color of a pixel. A flood fill algorithm takes
 * a coordinate r, c and a replacement color, and replaces all pixels connected to r, c
 * that have the same color (i.e., the pixels connected to the given coordinate with same
 * color and all the other pixels connected to the those pixels of the same color) with the
 * replacement color. (e.g. MS-Paint's paint bucket tool).
 */

public class FloodFill {
    public static class Coordinates {
        int r;
        int c;

        public Coordinates(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static List<List<Integer>> floodFill(int r, int c, int replacement, List<List<Integer>> image) {
        int numRows = image.size();
        int numCols = image.get(0).size();
        bfs(image, new Coordinates(r, c), replacement, numRows, numCols);
        return image;
    }

    private static void bfs(List<List<Integer>> image, Coordinates c, int replacement, int numRows, int numCols){
        ArrayDeque<Coordinates> queue = new ArrayDeque<>();
        queue.add(c);
        boolean[][] visited = new boolean[numRows][numCols];
        visited[c.r][c.c]=true;
        int rootColor = image.get(c.r).get(c.c);
        image.get(c.r).set(c.c, replacement);
        while(queue.size() >0){
            Coordinates node = queue.pop();
            for(Coordinates cr: getNeighbors(image, node, rootColor, numRows, numCols)){
               if(visited[cr.r][cr.c]) continue;
               image.get(cr.r).set(cr.c, replacement);
               queue.add(cr);
               visited[cr.r][cr.c] = true;
            }
        }
    }

    private static List<Coordinates> getNeighbors(List<List<Integer>> image, Coordinates node, int rootColor, int numRows, int numCols) {
        List<Coordinates> neighbors = new ArrayList<>();
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        for (int i = 0; i < deltaRow.length; i++) {
            int neighborRow = node.r + deltaRow[i];
            int neighborCol = node.c + deltaCol[i];
            if (0 <= neighborRow && neighborRow < numRows && 0 <= neighborCol && neighborCol < numCols) {
                if (image.get(neighborRow).get(neighborCol) == rootColor) {
                    neighbors.add(new Coordinates(neighborRow, neighborCol));
                }
            }
        }
        return neighbors;
    }


    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());
        int replacement = Integer.parseInt(scanner.nextLine());
        int imageLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> image = new ArrayList<>();
        for (int i = 0; i < imageLength; i++) {
            image.add(splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        List<List<Integer>> res = floodFill(r, c, replacement, image);
        for (List<Integer> row : res) {
            System.out.println(row.stream().map(String::valueOf).collect(Collectors.joining(" ")));
        }
    }
}
