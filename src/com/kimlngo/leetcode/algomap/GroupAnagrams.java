package com.kimlngo.leetcode.algomap;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"nozzle","punjabi","waterlogged","imprison","crux","numismatists","sultans","rambles","deprecating","aware","outfield","marlborough","guardrooms","roast","wattage","shortcuts","confidential","reprint","foxtrot","dispossession","floodgate","unfriendliest","semimonthlies","dwellers","walkways","wastrels","dippers","engrossing","undertakings","unforeseen","oscilloscopes","pioneers","geller","neglects","cultivates","mantegna","elicit","couriered","shielded","shrew","heartening","lucks","teammates","jewishness","documentaries","subliming","sultan","redo","recopy","flippancy","rothko","conductor","e","carolingian","outmanoeuvres","gewgaw","saki","sarah","snooping","hakka","highness","mewling","spender","blockhead","detonated","cognac","congaing","prissy","loathes","bluebell","involuntary","aping","sadly","jiving","buffalo","chided","instalment","boon","ashikaga","enigmas","recommenced","snell","parsley","buns","abracadabra","forewomen","persecuted","carsick","janitorial","neonate","expeditiously","porterhouse","bussed","charm","tinseled","pencils","inherits","crew","estimate","blacktop","mythologists","essequibo","dusky","fends","pithily","positively","participants","brew","tows","pentathlon","misdiagnoses","paraphrase","telephoning","engining","anglo","duisburg","shorthorns","physical","enquiries","grudging","floodlit","safflower","asphalts","representing","airbrush","bedevilling","fulminations","peacefuller","hurl","unequalled","wiser","vinson","paglia","doggones","optimist","rulering","katmandu","flutists","sterling","oregonians","boosts","slaver","straightedges","stendhal","defaulters","stylize","chucking","adulterate","partaking","omelettes","monochrome","bitched","foxhound","tapir","vocalizing","manifolding","northerner","ineptly","dunce","matchbook","locutions","docudrama","sinkers","paralegal","sip","maliced","lechers","zippy","tillman","penknives","olympias","designates","mossiest","leanne","lavishing","understate","underwriting","showered","belittle"}));
    }

    private static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if(strs.length == 0) return result;
        else if(strs.length == 1) {
            result.add(Collections.singletonList(strs[0]));
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        for(String s : strs) {
            if(map.isEmpty()) {
                map.put(s, new ArrayList<>());
                continue;
            }

            boolean anagramFound = false;
            for(String key : map.keySet()) {
                if(isAnagram(key, s)) {
                    map.get(key).add(s);
                    anagramFound = true;
                    break;
                }
            }
            if(!anagramFound) {
                map.put(s, new ArrayList<>());
            }
        }

        for (var entry : map.entrySet()) {
            entry.getValue()
                 .add(entry.getKey());
            result.add(entry.getValue());
        }
        return result;
    }

    private static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) return false;

        var map1 = buildFrequencyMap(s1);
        var map2 = buildFrequencyMap(s2);

        for (var c : map1.keySet()) {
            if (map2.get(c) == null || !map2.get(c)
                                            .equals(map1.get(c)))
                return false;
        }

        for (var c : map2.keySet()) {
            if (map1.get(c) == null || !map1.get(c)
                                            .equals(map2.get(c)))
                return false;
        }

        return true;
    }

    private static Map<Character, Long> buildFrequencyMap(String s) {
        return s.chars()
                .mapToObj(a -> (char) a)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
