package com.kamalova.image;

import java.util.*;
import java.math.*;

/*
Took idea from discussions
Success
Details 
Runtime: 36 ms, faster than 16.80% of Java online submissions for Max Points on a Line.
Memory Usage: 36.3 MB, less than 86.63% of Java online submissions for Max Points on a Line.
    */
class MaxPointsOnALine {

    public int maxPoints(int[][] points) {
        if (points.length < 3) return points.length;
        int result = 0;

        //int result = 0;
        for(int i = 0; i < points.length; i++){
            HashMap<BigDecimal, Integer> hm = new HashMap<>();
            int p0x = points[i][0];
            int p0y = points[i][1];
            int samex = 1;
            int samep = 0;
            for(int j = 0; j < points.length; j++){
                if(j != i) {
                    int p1x = points[j][0];
                    int p1y = points[j][1];
                    if((p1x == p0x) && (p1y == p0y)){
                        samep++;
                    }
                    if(p1x == p0x){
                        samex++;
                        continue;
                    }
                    BigDecimal ky = BigDecimal.valueOf(p1y - p0y);
                    BigDecimal kx = BigDecimal.valueOf(p1x - p0x);
                    BigDecimal k = ky.divide(kx,34, RoundingMode.HALF_EVEN);

                    if(hm.containsKey(k)){
                        hm.put(k,hm.get(k) + 1);
                    }else{
                        hm.put(k, 2);
                    }
                    result = Math.max(result, hm.get(k) + samep);
                }
            }
            result = Math.max(result, samex);
        }
        return result;
    }
}
