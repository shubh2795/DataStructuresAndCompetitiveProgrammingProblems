package backtracking;

//program that prints all the permutations of a given string
//Below are the permutations of string ABC.
//        ABC ACB BAC BCA CBA CAB

import java.util.*;

public class PrintPermutations {

    public static void backTrack(List<String> list, String str, String temp) {
        if (temp.length() == str.length())
            list.add(temp);
        for (int i = 0; i < str.length(); i++) {
            temp = temp + str.charAt(i);
            backTrack(list, str, temp);
            temp = temp.substring(0, temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        String str = "ABC";
        List<String> permutations = new ArrayList<>();
        backTrack(permutations, str, "");
        System.out.println(permutations);
    }
}
