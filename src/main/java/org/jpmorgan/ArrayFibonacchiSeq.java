package org.jpmorgan;

import java.util.ArrayList;
import java.util.List;

public class ArrayFibonacchiSeq {
    public List<Integer> splitIntoFibonacci(String num) {
        List<Integer> result = new ArrayList<>();
        helper(num, result, 0);
        return result;
    }

    private boolean helper(String num, List<Integer> result, int pos) {
        if (pos == num.length()) {
            return result.size() > 2 ? true : false;
        }
        int m = num.length();
        int cur = 0;
        for (int i = pos; i < m; i++) {
            cur = cur * 10 + (num.charAt(i) - '0');
            if (cur < 0) {
                return false;
            }
            if (result.size() < 2 || (result.get(result.size() - 1) + result.get(result.size() - 2) == cur)) {
                result.add(cur);
                if (helper(num, result, i + 1)) {
                    return true;
                }
                result.remove(result.size() - 1);
            }
            if (i == pos && num.charAt(i) == '0') {
                return false;
            }
        }
        return false;
    }

}
