package org.practice;

import java.util.*;
import java.util.function.Function;

import java.util.Arrays;

class Solution {

        public static int solution(int N, String S) {
            // Implement your solution here
            String[] seatsTaken = S.split("\\s+");

            int[][] seatMapping = new int[N+1][10];
            if(S.isEmpty()){
                return N*2;
            }
            for(int i=0; i< seatsTaken.length; i++){
                if(seatsTaken[i].length() > 1){
                    int row = Integer.parseInt(seatsTaken[i].substring(0, seatsTaken[i].length()-1));
                    int col = seatsTaken[i].charAt(seatsTaken[i].length()-1)-'A'+1;
                    seatMapping[row][col] = col;
                }
            }
            int sum = 0;
            for(int i = 0; i< seatMapping.length; i++){
                if(seatMapping[i].length <=1){
                    sum += 2;
                } else {
                    int colSum = 10;
                    for(int j = 1; j< seatMapping[i].length; j++){
                        colSum -= seatMapping[i][j];
                    }
                    if(colSum > 4){
                        sum += colSum / 4;
                    }

                }
            }


            return sum;

        }


    public static void main(String[] args) {
        int[] arr = new int[2];
        int x = solution(2, "1A 2F 1");
        System.out.println(x);
    }
}