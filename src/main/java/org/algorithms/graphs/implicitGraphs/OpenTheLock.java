package org.algorithms.graphs.implicitGraphs;

import java.util.*;
import java.util.stream.Collectors;

public class OpenTheLock {
    public static Map<Character, Character> nextDigit = Map.of(
            '0', '1',
            '1', '2',
            '2', '3',
            '3', '4',
            '4', '5',
            '5', '6',
            '6', '7',
            '7', '8',
            '8', '9',
            '9', '0'
    );

    public static Map<Character, Character> prevDigit = nextDigit.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

    public static int numSteps(String targetCombo, List<String> trappedCombos) {
        if (targetCombo.equals("0000")) {
            return 0;
        }
        // combinations to avoid
        HashSet<String> trappedComboSet = new HashSet<>(trappedCombos);
        // adds the amount of steps for each combination
        HashMap<String, Integer> steps = new HashMap<>();
        steps.put("0000", 0);
        ArrayDeque<String> bfsQueue = new ArrayDeque<>();
        //add the first combination into the queue
        bfsQueue.offer("0000");
        while (!bfsQueue.isEmpty()) {
            String top = bfsQueue.poll();
            for (int i = 0; i < 4; i++) {
                // the string will be "0000", top.substring(0,i) concatenated with
                String newCombo = top.substring(0, i).concat(String.valueOf(nextDigit.get(top.charAt(i)))).concat(top.substring(i + 1));

                if (!trappedComboSet.contains(newCombo) && !steps.containsKey(newCombo)) {
                    bfsQueue.offer(newCombo);
                    steps.put(newCombo, steps.get(top) + 1);
                    if (newCombo.equals(targetCombo)) {
                        System.out.println("Exit "+ steps.get(newCombo));
                        return steps.get(newCombo);
                    }
                }
                System.out.println("Steps at i= "+i+ " newCombo: "+newCombo+ " with getTop "+steps.get(top).toString());
                newCombo = top.substring(0, i).concat(String.valueOf(prevDigit.get(top.charAt(i)))).concat(top.substring(i + 1));
                if (!trappedComboSet.contains(newCombo) && !steps.containsKey(newCombo)) {
                    bfsQueue.offer(newCombo);
                    steps.put(newCombo, steps.get(top) + 1);
                    if (newCombo.equals(targetCombo)) {
                        System.out.println("Exit "+ steps.get(newCombo));
                        return steps.get(newCombo);
                    }
                }
                System.out.println("Steps at i= "+i+ " newCombo: "+newCombo+ " with getTop "+steps.get(top).toString());

            } System.out.println("Steps "+steps.toString());
        }

        return -1;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String targetCombo = scanner.nextLine();
        List<String> trappedCombos = splitWords(scanner.nextLine());
        scanner.close();
        int res = numSteps(targetCombo, trappedCombos);
        System.out.println(res);
    }
}
