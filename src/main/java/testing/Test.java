package testing;

import java.util.*;

public class Test {

    // Find the single number who is not doubled in the list
    public int singleNumber(int[] nums) {
        int xor = 0;
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }
        return xor;
    }

    // Happy number
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = squareSum(n);
        }
        return n == 1;
    }

    private int squareSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }

    // isomorphic strings
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        if (s.length() != t.length()) return false;
        for (int i = 0; i < s.length(); i++) {
            mapS.put(s.charAt(i), i);
            mapT.put(t.charAt(i), i);
            if (!Objects.equals(mapS.get(s.charAt(i)), mapT.get(t.charAt(i)))) return false;
        }
        return true;
    }

    //Minimum Index Sum of Two Lists
    public static String[] findRestaurant(String[] list1, String[] list2) {
        HashMap<String, Integer> map = new HashMap<>();
        int list1S = list1.length;
        int list2S = list2.length;
        for (int i = 0; i < list1S; i++) {
            map.put(list1[i], i);
        }
        List<String> out = new ArrayList<>();
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < list2S; j++) {
            if (map.containsKey(list2[j])) {
                int indexSum = map.get(list2[j]) + j;
                if (indexSum < min) {
                    out = new ArrayList<>();
                    out.add(list2[j]);
                    min = indexSum;
                } else if (indexSum == min) {
                    out.add(list2[j]);
                }
            }
        }
        return out.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] n1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] n2 = new String[]{"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};

        String[] i = findRestaurant(n1, n2);
        System.out.println("output:  " + Arrays.toString(i));
    }

}

