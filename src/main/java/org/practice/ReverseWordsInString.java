package org.practice;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        String[] wordsList = s.split("\\s+");
        int end = wordsList.length - 1;
        int mid = wordsList.length / 2;
        for (int i = 0; i < mid; i++) {
            String temp = wordsList[end - i];
            wordsList[end - i] =  wordsList[i];
            wordsList[i] = temp;
        }
        return  Arrays.stream(wordsList).collect(Collectors.joining(" "));


    }
    public static void main(String[] args){
        String str =  reverseWords(" Hello world of int");
        System.out.println(str);
    }
}
