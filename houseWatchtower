import java.util.*;


// A town is building a watchtower. The watchtower is located at (0, 0). 
// Each unit height of the watchtower has a cost H. There are N houses located at (x, y) coordinates. 
// Each house will pay cost C if it comes under the surveillance of the watchtower. 
// The horizontal distance covered by the watchtower is the same as it's height. Find out the max profit you can make.

class houseWatchtower {
    public long maxProfit(int n, int[][] houses, int H, int C) {

        long[] dist = new long[n];
        int i = 0;

        for (var house : houses) {
            long x = house[0];
            long y = house[1];
            dist[i++] = x * x + y * y;
        }

        Arrays.sort(dist);

        long profit = 0;
        long revenue = 0;

        for (i = 0; i < n; i++) {
            long height = (long) Math.ceil(Math.sqrt(dist[i]));
            revenue += C;
            profit = Math.max(profit, revenue - height * H);
        }

        return profit;
    }
}
