package org.algorithms.matrix;
// definition x= var name y =int[-1000, 1000]
// if one variable is defined twice, later will rewrite the first
// x = 30 lowercase char [a,z]
// if line[0] == calculation
// clear -> delete the var value

// method for definition => void
// method for calc => int

import java.util.*;

public class Solution {
    private static Map<String, Integer> exMap = new HashMap<>();

    public static void commands(String line) {

        String[] words = line.split(" ");
        String instruction = words[0];
        if (instruction.equals("def")) {
            definition(words[1], Integer.parseInt(words[2]));
        } else if (instruction.equals("calc")) {
            int result = calculate(words);
            String outResult = getKeyByValue(exMap, result);
            if(result == Integer.MIN_VALUE || outResult == null){
                outResult = "unknown";
            }

            System.out.println(  line.substring(5, line.length()) + " " +  outResult);
        } else if (instruction.equals("clear")) {
            clearDefinition();
        }
    }
    public static <K, V> K getKeyByValue(Map<K, V> map, V value) {
        Optional<K> optionalKey = map.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(value))
                .map(Map.Entry::getKey)
                .findFirst();
        return optionalKey.orElse(null);
    }


    private static void definition(String key, Integer value) {
        exMap.put(key, value);
    }

    private static int calculate(String[] operations) {
        int result = 0;
        boolean isAdition = true;
        int opSize = operations.length;

        for(int i=1; i< opSize-1; i++){
            if(operations[i].equals("+")){
                isAdition = true;
            } else if(operations[i].equals("-")){
                isAdition = false;
            } else{
                int val = exMap.getOrDefault(operations[i], Integer.MIN_VALUE);
                result = isAdition ? result + val : result - val;
            }
        }
        return result;
    }

    private static void clearDefinition() {
        exMap.clear();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            commands(line);
        }
        scanner.close();
    }

}
