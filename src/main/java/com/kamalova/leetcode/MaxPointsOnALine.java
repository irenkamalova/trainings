package com.kamalova.image;

import java.util.*;

// can't pass
class MaxPointsOnALine {


    public int maxPoints(int[][] points) {
        if (points.length == 1) return 1;


        Map<Line, Set<int[]>> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            int p0x = points[i][0];
            int p0y = points[i][1];
            for (int j = 1; j < points.length; j++) {
                int p1x = points[j][0];
                int p1y = points[j][1];
                if ((p0x == p1x) && (p0y == p1y) && !map.isEmpty()) {
                    for (Map.Entry<Line, Set<int[]>> entry : map.entrySet()) {
                        Line l = entry.getKey();
                        Set<int[]> set = entry.getValue();
                        if (p0y == (int) (l.a * p0x + l.b)) {
                            set.add(points[j]);
                        } else if (l.x != 0 && p0x == l.x) {
                            set.add(points[j]);
                        }
                    }
                } else {
                    Line line = getLine(p0x, p0y, p1x, p1y);
                    map.computeIfAbsent(line, l -> new HashSet<int[]>());
                    map.get(line).add(points[i]);
                    map.get(line).add(points[j]);
                }
            }
        }
        int max = 0;
        for (Map.Entry<Line, Set<int[]>> entry : map.entrySet()) {
            if (entry.getValue().size() > max) {
                max = entry.getValue().size();
            }
        }
        return max;
    }

    private Line getLine(int x0, int y0, int x1, int y1) {
        if (x1 - x0 == 0) {
            return new Line(x1);
        }
        double a = (double) (((long) (y1 - y0)) / (double) ((long) (x1 - x0)));
        double b = y1 - a * x1;
        return new Line(a, b);
    }

    private class Line {
        double a, b;
        int x;

        Line(double a, double b) {
            this.a = a;
            this.b = b;
            this.x = 0;
        }

        Line(int x) {
            this.a = 0;
            this.b = 0;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (o == null) return false;
            if (o instanceof Line) {
                Line l = (Line) o;
                return (this.a == l.a) && (this.b == l.b) && (this.x == l.x);
            } else return false;
        }

        @Override
        public int hashCode() {
            return (int) a + (int) b;
        }
    }
}
