// You are given multiple axis-aligned squares on an **x–y Cartesian plane**, where each square has its sides parallel to the coordinate axes. 
// For every square, you are provided with the coordinates of its **top-left corner** ((x, y)) and its **edge length** (a). 
// All squares may overlap, and their combined area is considered as the total area covered by all squares. 
// Your task is to determine the equation (i.e., the (y)-value) of a **horizontal line** parallel to the x-axis 
// that divides the total area of all given squares into **two equal halves** — such that the area above the line is equal to the area below the line.


class separateSquares {
    public double separateSquares(int[][] squares) {
        double left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        
        for (int[] square : squares) {
            int y = square[1], l = square[2];
            left = Math.min(left, y);
            right = Math.max(right, y + l);
        }

        double epsilon = 1e-5;
        
        while (right - left > epsilon) {
            double mid = (left + right) / 2.0;
            double topArea = 0, bottomArea = 0;

            for (int[] square : squares) {
                int y = square[1], l = square[2];
                double topY = y + l;
                double bottomY = y;

                if (mid >= topY) {
                    bottomArea += (double) l * l;
                } else if (mid <= bottomY) {
                    topArea += (double) l * l;
                } else {
                    double topPart = l * (topY - mid);
                    double bottomPart = l * (mid - bottomY);
                    topArea += topPart;
                    bottomArea += bottomPart;
                }
            }

            if (topArea > bottomArea) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return left;
    }
}