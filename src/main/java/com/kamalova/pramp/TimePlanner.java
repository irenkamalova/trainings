package com.kamalova.pramp;

import java.io.*;
import java.util.*;

class TimePlanner {
  
  
  static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    // O(N + M) N - slotA.l M - slotsB
    if (slotsA.length == 0 || slotsB.length == 0) return new int[]{};
    
    int i = 0;
    int j = 0;
    int[] pA = slotsA[i];
    int[] pB = slotsB[j];
    
    while (i < slotsA.length && j < slotsB.length) {
      int start = Math.max(pA[0], pB[0]);
      int end = Math.min(pA[1], pB[1]);
      
      if (end - start >= dur) return new int[]{start, start + dur};
      
      if (pA[1] < pB[1]) {
        i++;
        if (i < slotsA.length) {
          pA = slotsA[i];
        } else return new int[]{};
      } else {
        j++;
       if (j < slotsB.length) {
          pB = slotsB[j];
        } else return new int[]{};
      }
      
    }
    
    return new int[]{};
    
  }
}
