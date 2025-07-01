package com.amit.learning.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Anagram {
    public static boolean isAnagram(String s, String t) {
        if (Objects.isNull(s) || Objects.isNull(t) || s.length() != t.length()) return false;
        s = s.toLowerCase();
        t = t.toLowerCase();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(findAllAnagramsInAString(s, t));
        System.out.println(findAllAnagramsInAString("ababacbterabc", "aab"));

    }

    public static List<Integer> findAllAnagramsInAString(String str, String findStr) {
        if(Objects.isNull(str) || Objects.isNull(findStr) || str.length() < findStr.length()){
            return null;
        }
        int[] findStrChars = new int[26];
        int[] strChars = new int[26];
        List<Integer> indexes = new ArrayList<>();
        for(char c: findStr.toCharArray()){
            findStrChars[c-'a']++;
        }
        for (int right = 0; right < str.length(); right++) {
            int count = 0;
            strChars[str.charAt(right)-'a']++;
            if (right >= findStr.length()) {
                strChars[str.charAt(right - findStr.length()) - 'a']--;
            }
            if (Arrays.equals(findStrChars, strChars)) {
                indexes.add(right - findStr.length() + 1);
            }
            /* Arrays.equals(findStrChars, strChars) OR
            for (int i = 0; i < 26; i++) {
                if(findStrChars[i] != strChars[i]){
                    count = 0;
                    break;
                }
                count++;
            }
            if (count == findStrChars.length) {
                indexes.add(right - findStr.length() + 1);
            }*/

        }
        return indexes;
    }
}
