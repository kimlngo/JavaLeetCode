package com.kimlngo.leetcode;

public class MergeTwoStrings {
    public static void main(String[] arg) {
        String word1 = "abcd", word2 = "pq";
        System.out.println(mergeString(word1, word2));
    }

    private static String mergeString(String word1, String word2) {
        int i = 0, j = 0;
        int length1 = word1.length();
        int length2 = word2.length();

        StringBuilder sb = new StringBuilder();

        while (i < length1 && j < length2) {
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(j));

            i++;
            j++;
        }

        if (length1 == length2) return sb.toString();
        else if (length1 < length2)
            return sb.append(word2.substring(j))
                     .toString();
        else
            return sb.append(word1.substring(i))
                     .toString();
    }
}
