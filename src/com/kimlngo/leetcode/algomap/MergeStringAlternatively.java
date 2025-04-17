package com.kimlngo.leetcode.algomap;

public class MergeStringAlternatively {

    public static void main(String[] args) {
        System.out.println(mergeStringAlternatively("abc", "pqr"));
        System.out.println(mergeStringAlternatively("ab", "pqrs"));
        System.out.println(mergeStringAlternatively("abcd", "pq"));

        System.out.println(mergeStringAlternatively("a", "pr"));
    }

    private static String mergeStringAlternatively(String word1, String word2) {
        int index1 = 0, index2 = 0;
        StringBuilder sb = new StringBuilder();

        //merging
        while (index1 < word1.length() && index2 < word2.length()) {
            sb.append(word1.charAt(index1));
            sb.append(word2.charAt(index2));

            index1++;
            index2++;
        }

        //process the remaining chars (if any)
        if (index1 < word1.length()) {
            sb.append(word1.substring(index1));
        } else if(index2 < word2.length()) {
            sb.append(word2.substring(index2));
        }

        return sb.toString();
    }
}
