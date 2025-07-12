package com.amit.learning.sliding_window;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Anagram {
    public static boolean isAnagram(String source, String tgt) {
        if (Objects.isNull(source) || Objects.isNull(tgt) || source.length() != tgt.length()) return false;
        source = source.toLowerCase();
        tgt = tgt.toLowerCase();
        char[] sChars = source.toCharArray();
        char[] tChars = tgt.toCharArray();
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

    public static List<Integer> findAllAnagramsInAString(String targetString, String findStr) {
        if(Objects.isNull(targetString) || Objects.isNull(findStr) || targetString.length() < findStr.length()){
            return null;
        }
        int[] findStrChars = new int[26];
        int[] strChars = new int[26];
        List<Integer> indexes = new ArrayList<>();
        for(char character: findStr.toCharArray()){//findStr = "aab"
            findStrChars[character -'a']++;//it will be like for a it will 0, for b 1 and so on, [2,1,0,0,0,0,0,0.....]
        }
        for (int rightIndex = 0; rightIndex < targetString.length(); rightIndex++) {
            strChars[targetString.charAt(rightIndex)-'a']++;
            if (rightIndex >= findStr.length()) {
                strChars[targetString.charAt(rightIndex - findStr.length()) - 'a']--;
            }
            if (Arrays.equals(findStrChars, strChars)) {
                indexes.add(rightIndex - findStr.length() + 1);
            }
        }
        return indexes;
    }
}
