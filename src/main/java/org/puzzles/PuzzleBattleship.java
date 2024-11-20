package org.puzzles;

public class PuzzleBattleship {
    public double getHitProbability(int R, int C, int[][] G) {
        int rows = G.length, cols = G[0].length;
        int sum=0;
        for(int i = 0; i< rows; i++){
            for(int j=0; j< cols; j++){
                sum+=G[i][j];
            }
        }
        return (double)sum/(rows*cols);
    }

    public void run() {
        int[][] G = {
                {0, 0, 1},
                {1, 0, 1}
        };
        double d = getHitProbability(2,3,G);
        System.out.println("Probability "+ d);
    }
    public static void main(String[] args) {
        new PuzzleBattleship().run();
    }

}
