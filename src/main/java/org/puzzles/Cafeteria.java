package org.puzzles;

/**
 * A cafeteria table consists of a row of N seats, numbered from 1 to N from left to right. Social distancing guidelines require that every diner be seated such that  K seats to their left and  K seats to their right (or all the remaining seats to that side if there are fewer than  K) remain empty.
 * There are currently  M diners seated at the table, the  ith of whom is in seat Si
 * No two diners are sitting in the same seat, and the social distancing guidelines are satisfied.
 * Determine the maximum number of additional diners who can potentially sit at the table without social distancing guidelines being violated for any new or existing diners, assuming that the existing diners cannot move and that the additional diners will cooperate to maximize how many of them can sit down.
 * Please take care to write a solution which runs within the time limit.
 */
public class Cafeteria {

    /*public long getMaxAdditionalDinersCount(long N, long K, int M, long[] S) {

    }*/

    public void run() {
        int[] s = {11,6,14};
        int d = getMaxAdditionalDiners(15,2,3,s);
        System.out.println("Probability "+ d);
    }
    public static void main(String[] args) {
        new Cafeteria().run();
    }


        static int getMaxAdditionalDiners(int N, int K, int M, int[] seatedDiners) {
            int maxAdditionalDiners = 0;

            // Check the space between diners and at the ends of the table
            for (int i = 1; i < M; i++) {
                int distance = (seatedDiners[i] - seatedDiners[i - 1]) / 2 - 1;
                maxAdditionalDiners = Math.max(maxAdditionalDiners, distance);
            }

            // Check the space on the left and right ends of the table
            maxAdditionalDiners = Math.max(maxAdditionalDiners, seatedDiners[0] - 1);
            maxAdditionalDiners = Math.max(maxAdditionalDiners, N - seatedDiners[M - 1]);

            // Return the maximum additional diners
            return maxAdditionalDiners;
        }


}
