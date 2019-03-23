package com.kamalova.record;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int wordsOnPage = sc.nextInt();

        int pageNumber = sc.nextInt();
        int totalPages = N / wordsOnPage;
        int remainingLastPage = N % wordsOnPage;
        if (remainingLastPage != 0) {
            totalPages += 1;
        }
        // how many words before pageNumber:
        int skip = wordsOnPage * (pageNumber - 1);


        for (int i = 0; i < skip; i++) {
            sc.next();
        }


        int last;
        if (pageNumber == totalPages && remainingLastPage != 0) {
            last = remainingLastPage;
        } else {
            last = wordsOnPage;
        }

        for (int i = 0; i < last; i++) {
            System.out.println(sc.next());
        }
    }
}
