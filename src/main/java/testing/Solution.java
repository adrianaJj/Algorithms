package testing;


import java.util.*;

// Find first non repetitive character in “teeter”
public class Solution {


      /*  // [t, e, e, t,e,r , x, y]
        int left = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        // list that contains how many time a char is in the list
        for(int i = 0; i< arr.length; i++){
            if(map.containsKey(arr[i])){
                map.put(map.getOrDefault(arr.charAt(i)));
            }
        }

        // t: 2
        // e: 3
        // r: 1
       // x: 1
       // y:1
        int size = map.size();
       for(int i = 0 ; i< arr.length ; i++){
           if(map.getValue() == 1)
               return map.get(i);
       }



        return null;*/
    // }

    // array of integers , find the second largest number
    // not sorted [ 2, 4, 6, 78, 65 ,23 ]  result: 65;

    //  2

    public static int alg(int[] arr) {
        int maxNumber = 0;
        int secondBiggest = 0;
        //

        for (int i = 0; i < arr.length; i++) {
            System.out.println(" Nr: " + arr[i]);
            if (arr[i] > maxNumber) {
                secondBiggest = maxNumber;
                maxNumber = arr[i];
            } else if (arr[i] > secondBiggest && arr[i] < maxNumber) {
                secondBiggest = arr[i];
            }
        }
        System.out.println("Max " + maxNumber + " and secondBiggest " + secondBiggest);
        return maxNumber;
    }


    public static void main(String[] args) {
        int[] arr = new int[7];
        arr = new int[]{2, 4, 6, 78, 65, 65, 78, 23};
        alg(arr);
    }
    //Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    //An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
    //Input: strs = ["eat","tea","tan","ate","nat","bat"]
    //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]


    public static List<List<String>> anagram(List<String> arr) {
        return null;
        // eat and tea
      /*  HashMap<String, List<String>> map = new HashMap<>();
        [ key: sum , value : [ eat, tea, ate]  ]
        [  key: abt , value [bat]]

     //  Characters [26] : arr.charAt(i) -'a' = [1]
        String str = " “1+5+17” ";
        aet = 1+ 5 + 17 = aet,
        arr.charAt()*/


        // slinding window
        // dynamic programing


        // eat : e -> 1, a -> 1, t -> 1  a e t
        // tea :  t -> e ->1 a -> 1


        // for each word [letters, how many times that letter appears in the word]  HashMap
        //

        //Arrays.sort(a);
    }


    //e  -> 1 a -> 1 tttttt -> 6
    //
    private static void word(String str) {
       /* HashMap<Character, Integer> word = new HashMap<>();
        char[] ch = str.toCharArray();
        for( int i = 0; i< ch.length ; i++){
            if(word.containsKey(ch[i])){
                word.getOrDefault()
            }
        }*/
    }

}
