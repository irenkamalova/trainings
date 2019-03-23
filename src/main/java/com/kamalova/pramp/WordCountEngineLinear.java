package com.kamalova.pramp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WordCountEngineLinear {

    static String[][] wordCountEngine(String document) {

        // TODO: here is O(N⋅log(N)) solution
        // TODO: find O(N) solution

        // ? should be sorted according to their order in the original sentence.

        String processedDoc = document.toLowerCase().replaceAll("[^(a-z )]", "");

        String[] strings = processedDoc.split(" ");

        Map<String, Integer> map = new LinkedHashMap<>();
        int maxValue = 0;
        for(String s : strings) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            if (map.get(s) > maxValue) {
                maxValue = map.get(s);
            }
        }
        // O(N) solution:
        List<LinkedList<String>> list = new ArrayList<LinkedList<String>>(maxValue + 1);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (list.get(entry.getValue()) == null) {
                list.set(entry.getValue(), new LinkedList<String>());
            }
            list.get(entry.getValue()).add(entry.getKey());
        }

        int i = 0;
        int j = 0;
        String[][][] stringsRes = new String[maxValue][map.size()][2];
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            i = entry.getValue();

        }


            for (i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) != null) {
                List<String> words = list.get(i);
                for (String word : words) {
                    stringsRes[i][j][0] = String.valueOf(i);
                    stringsRes[i][j][1] = word;
                    j++;
                }
            }
        }

        return stringsRes[0];
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
