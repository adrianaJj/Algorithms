package org.algorithms.twopointers.slidingWindow;

import java.util.*;
import java.util.stream.Collectors;

/**
 * A bunch of cards is laid out in front of you in a line, where the value of each card ranges from 0 to 10^6.
 * A pair of cards are matching if they have the same number value.
 * Given a list of integer cards, your goal is to match a pair of cards, but you can only pick up cards in a
 * consecutive manner. What's the minimum number of cards that you need to pick up to make a pair? If there is
 * no matching pairs, return -1.
 * For example, given cards = [3, 4, 2, 3, 4, 7], then picking up [3, 4, 2, 3] makes a pair of 3s and picking
 * up [4, 2, 3, 4] matches two 4s. We need 4 consecutive cards to match a pair of 3s and 4 consecutive cards to
 * match 4s, so you need to pick up at least 4 cards to make a match.
 */
public class LeastConsecutiveCardstoMatch {
    public static int leastConsecutiveCardsToMatch(List<Integer> cards) {
        int leastConsecutiveSubarray = cards.size() + 1;
        int left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.size(); i++) {
            map.put(cards.get(i), map.getOrDefault(cards.get(i), 0) + 1);
            while (map.get(cards.get(i)) == 2) {
                leastConsecutiveSubarray = Math.min(leastConsecutiveSubarray, i - left + 1);
                map.put(cards.get(left), map.get(cards.get(left)) - 1);
                left++;
            }
        }
        return (leastConsecutiveSubarray != cards.size() + 1) ? leastConsecutiveSubarray : -1;
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> cards = splitWords(scanner.nextLine()).stream().map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        int res = leastConsecutiveCardsToMatch(cards);
        System.out.println(res);
    }


}
