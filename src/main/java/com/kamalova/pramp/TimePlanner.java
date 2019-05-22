package com.kamalova.pramp;

import java.io.*;
import java.util.*;

class TimePlanner {
  
  public int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
    // O(N + M) N - slotA.l M - slotsB    
    int i = 0, j = 0;    
    while (i < slotsA.length && j < slotsB.length) {
      int start = Math.max(slotsA[i][0], slotsB[j][0]);
      int end = Math.min(slotsA[i][1], slotsB[j][1]);
      
      if (end - start >= dur) return new int[]{start, start + dur};
            
      if (slotsA[i][1] < slotsB[j][1]) {
        i++;
      } else {
        j++;
      }
    }
    return new int[]{};   
  } 
}
