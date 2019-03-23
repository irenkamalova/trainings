package com.kamalova.pramp;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WordCountEngineBrute {

    static String[][] wordCountEngine(String document) {

        // TODO: here is O(N⋅log(N)) solution
        // TODO: find O(N) solution

        String processedDoc = document.toLowerCase().replaceAll("[^(a-z )]", "");
        String[] strings = processedDoc.split(" ");

        Map<String, Integer> map = new LinkedHashMap<>();
        for(String s : strings) {
                map.put(s, map.getOrDefault(s, 0) + 1);
        }

        Comparator<Integer> customComparator = (o1, o2) -> - o1.compareTo(o2);

        Map<Integer, List<String>> treeMap = new TreeMap<>(customComparator);

        for (Map.Entry<String, Integer> wordOccurrence : map.entrySet()) {
            int occurrence = wordOccurrence.getValue();
            String word = wordOccurrence.getKey();
            if(treeMap.containsKey(occurrence)) {
                treeMap.get(occurrence).add(word);
            } else {
                List<String> list = new LinkedList<>();
                list.add(word);
                treeMap.put(occurrence, list);
            }
        }
        int j = 0;
        String[][] stringsRes = new String[map.size()][2];

        for (Map.Entry<Integer, List<String>> entry : treeMap.entrySet()) {
            for (String s : entry.getValue()) {
                stringsRes[j][0] = s;
                stringsRes[j][1] = entry.getKey().toString();
                j++;
            }
        }

        return stringsRes;

        // your code goes here
        /*
        [[and, 4], [every, 3], [is, 3], [a, 3], [quotation, 3], [all, 2], [book, 1], [house, 1], [out, 1], [of, 1],
        [forests, 1], [mines, 1], [stone, 1], [quarries, 1], [man, 1], [from, 1], [his, 1], [ancestors, 1]]
         */
    }

    public static void main(String[] args) {
        String result = Arrays.deepToString(wordCountEngine("Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. "));
        System.out.println(result);
    }

}