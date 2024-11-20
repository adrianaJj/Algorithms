package org.datastructures.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Sol_Testingpurposes {
    public static List<Integer> getOneBits(int n) {
        char[] str = Integer.toBinaryString(n).toCharArray();
        List<Integer> out = new ArrayList<>();
        int sum =0;
        out.add(sum);
        for(int i=0; i<str.length; i++){
            if(str[i] == '1'){
                sum++;
                out.set(0,sum);
                out.add(i+1);
            }
        }
        return out;

    }

    public static List<String> romanizer(List<Integer> numbers) {
        String[] romanNr = {"M","CM", "D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int[] arabicNr = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        List<String> out = new ArrayList<>();
        for(int i =0; i< numbers.size(); i++){
            StringBuilder str = new StringBuilder();
            int nr = numbers.get(i);
            for(int j=0; j< arabicNr.length; j++){
                while(nr >= arabicNr[j]){
                    nr -=arabicNr[j];
                    str.append(romanNr[j]);
                }
            }
            out.add(str.toString());
        }
        return out;
    }

    public static List<String> getJSONDiff(String json1, String json2) {
        List<String> out = new ArrayList<>();

        HashMap<String, String> map1 = stringToMap(json1);
        HashMap<String, String> map2 = stringToMap(json2);
        for(String key1: map1.keySet()){
            if(map2.get(key1)!= null && !map1.get(key1).equals(map2.get(key1))){
                out.add(key1);
            }
        }

        return out;

    }

    private static HashMap<String, String> stringToMap(String json){
        HashMap<String, String> map = new HashMap<>();
        String[] pairs = json.split(",");
        for(String str: pairs){
            String[] keyVal = str.split(":");
            map.put(keyVal[0],keyVal[1]);
        }
        return map;
    }


    public static void main(String[] args) {
       // List<Integer> out = getOneBits(161);
        List<Integer> list = new ArrayList<>();
        list.add(5); list.add(1); list.add(2); list.add(3); list.add(4); list.add(5);
        List<String> romanizer = romanizer(list);
        System.out.println(romanizer.toString());
    }
}
