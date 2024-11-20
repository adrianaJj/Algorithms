import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class JPMorgan {

    // find all of the subsets of a set
    // [2,3,5] = [2], [3], [5], [2,3] [] -> combinations = 3+ 3+ 1 +1 = 8
    //  nc0 + nc1 + nc2 + ... + nc n


    // 2 3 5 7
    // i = 0 -> n-1


    public static List<String> getAllSubsets(String str){
        List<String> output = new ArrayList<>();
        int start = 0;
        int end = str.length();
         recursion(str, output, 0, "" );
        return output;

    }


    private static void recursion(String str,  List<String> output, int position, String slate){
        if(position == str.length()){
            output.add(slate);
            return;
        }
            recursion(str, output, position + 1, slate);
            recursion(str, output, position + 1, slate + str.charAt(position));

    }


    public static void main(String[] args){
        String str = "abcd";
        List<String> output = new ArrayList<>();
        output.add("");

        for (int j = 0 ; j< str.length(); j++){
           int size = output.size();
           for(int i = 0; i< size; i++) {
               output.add(output.get(i)+str.charAt(j));
            }
        }

        System.out.println("Output: "+ output);

    }





}
