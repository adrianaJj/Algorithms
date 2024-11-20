package org.algorithms.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromeSubsets {
    public static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l<r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }

    public static void dfs(List<List<String>> ans, ArrayList<String> part, String s, int start) {
        if (start == s.length()) {
            List<String> li = new ArrayList<>(part);
            ans.add(li);
        }
        for (int end = start; end<s.length(); end++) {
            if (isPalindrome(s.substring(start, end + 1))) {
                part.add(s.substring(start, end + 1));
                dfs(ans, part, s, end + 1);
                part.remove(part.size() - 1);
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<String>(), s, 0);
        return ans;
    }

    public static void main(String[] args) {
        //ex aabgb
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        scanner.close();
        List<List<String>> res = partition(s);
        for (List<String> row : res) {
            System.out.println(String.join(" ", row));
        }
    }
}
