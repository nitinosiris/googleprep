
// You are given a set of distinct points in a 2D Cartesian plane, each represented by integer coordinates ((x, y)). 
// A rectangle is said to be valid if all four of its vertices are present in the given set of points and its sides are parallel to the x-axis and y-axis (i.e., the rectangle is axis-aligned). 
// Your task is to determine four points that form such a rectangle with the maximum possible area among all valid rectangles that can be formed from the given set. 
// If no rectangle can be formed, return an appropriate result indicating that it is not possible.


import java.util.*;

class maxArearectangle {

    public int maxAreaRect(int[][] points) {

        int area = 0;

        HashSet<String> set = new HashSet<>();
        for (int[] pt : points) {
            set.add(pt[0] + "," + pt[1]);
        }

        for (int i = 0; i < points.length; i++) {

            int x1 = points[i][0];
            int y1 = points[i][1];

            for (int j = i + 1; j < points.length; j++) {

                int x3 = points[j][0];
                int y3 = points[j][1];

                if (x1 == x3 || y1 == y3)
                    continue;

                String rightBottom = x3 + "," + y1;
                String topLeft     = x1 + "," + y3;

                if (set.contains(rightBottom) && set.contains(topLeft)) {
                    int currArea = Math.abs(x3 - x1) * Math.abs(y3 - y1);
                    area = Math.max(area, currArea);
                }
            }
        }
        return area;
    }
}
