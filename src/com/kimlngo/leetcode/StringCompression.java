package com.kimlngo.leetcode;

public class StringCompression {

    public static void main(String[] args) {
        char[] chars = {'a','b','b','b','b','b','b','b','b','b','b','b','b'};
        System.out.println(compress(chars));
        System.out.println(chars);
    }

    private static int compress(char[] chars) {
        int length = chars.length;
        int groupCount = 1;

        for (int i = 0; i < length && chars[i] != ' '; i++) {
            char cur = chars[i];
            int groupStartIdx = i + 1;

            while (i + 1 < length && cur == chars[i + 1]) {
                groupCount++;
                i++;
            }

            if(groupCount > 1) {
                String groupCountStr = String.valueOf(groupCount);

                //set group count
                for(int j = 0; j < groupCountStr.length(); j++)
                    chars[groupStartIdx + j] = groupCountStr.charAt(j);

                //copy down all the remaining
                int count = 0;
                for(int j = i + 1; j < length; j++, count++) {
                    chars[groupStartIdx + groupCountStr.length() + count] = chars[j];
                }

                for(int k = groupStartIdx + groupCountStr.length() + count; k < length; k++)
                    chars[k] = ' ';

                i = groupStartIdx + groupCountStr.length() - 1;
            }

            groupCount = 1;
        }

        String result = new String(chars).trim();
        return result.length();
    }
}
