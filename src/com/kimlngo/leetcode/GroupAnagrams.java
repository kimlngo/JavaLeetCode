package com.kimlngo.leetcode;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagrams {

    public static void main(String[] args) throws IOException {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{"nozzle","punjabi","waterlogged","imprison","crux","numismatists","sultans","rambles","deprecating","aware","outfield","marlborough","guardrooms","roast","wattage","shortcuts","confidential","reprint","foxtrot","dispossession","floodgate","unfriendliest","semimonthlies","dwellers","walkways","wastrels","dippers","engrossing","undertakings","unforeseen","oscilloscopes","pioneers","geller","neglects","cultivates","mantegna","elicit","couriered","shielded","shrew","heartening","lucks","teammates","jewishness","documentaries","subliming","sultan","redo","recopy","flippancy","rothko","conductor","e","carolingian","outmanoeuvres","gewgaw","saki","sarah","snooping","hakka","highness","mewling","spender","blockhead","detonated","cognac","congaing","prissy","loathes","bluebell","involuntary","aping","sadly","jiving","buffalo","chided","instalment","boon","ashikaga","enigmas","recommenced","snell","parsley","buns","abracadabra","forewomen","persecuted","carsick","janitorial","neonate","expeditiously","porterhouse","bussed","charm","tinseled","pencils","inherits","crew","estimate","blacktop","mythologists","essequibo","dusky","fends","pithily","positively","participants","brew","tows","pentathlon","misdiagnoses","paraphrase","telephoning","engining","anglo","duisburg","shorthorns","physical","enquiries","grudging","floodlit","safflower","asphalts","representing","airbrush","bedevilling","fulminations","peacefuller","hurl","unequalled","wiser","vinson","paglia","doggones","optimist","rulering","katmandu","flutists","sterling","oregonians","boosts","slaver","straightedges","stendhal","defaulters","stylize","chucking","adulterate","partaking","omelettes","monochrome","bitched","foxhound","tapir","vocalizing","manifolding","northerner","ineptly","dunce","matchbook","locutions","docudrama","sinkers","paralegal","sip","maliced","lechers","zippy","tillman","penknives","olympias","designates","mossiest","leanne","lavishing","understate","underwriting","showered","belittle"}));
//        System.out.println(groupAnagrams(new String[]{"a"}));

        long start = System.currentTimeMillis();
        System.out.println(groupAnagrams(Util.readAnagrams()));
        long end = System.currentTimeMillis();
        System.out.println("Execution time = " + (end - start));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        String key;

        for (String s : strs) {
            key = sortStr(s);
            if (map.get(key) == null)
                map.put(key, new ArrayList<>());

            map.get(key)
               .add(s);
        }

        List<List<String>> result = new ArrayList<>();
        result.addAll(map.values());
        return result;
    }

    private static String sortStr(String input) {
        String collect = input.chars()
                              .mapToObj(a -> (char) a)
                              .sorted()
                              .map(c -> c.toString())
                              .collect(Collectors.joining());

        return collect;
    }
}
