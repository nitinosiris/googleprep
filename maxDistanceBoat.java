// You are given an integer K (𝐾 < 1000) representing the initial energy of a boatman and an array A of length N, 
// where A[i] denotes the distance the boatman can travel on the i-th day if he chooses to move. 
// The boatman is stuck on a boat for N days, and each day he must either travel or stay idle: if he travels on day i, he moves forward by A[i] units but his energy decreases by 1, 
// while if he stays idle, his energy increases by 1. 
// The boatman’s energy must never drop below 0 at any point during the N days. 
// Your task is to determine the maximum total distance the boatman can travel over the N days while maintaining a non-negative energy level throughout.

class maxDistanceBoat {
    Integer[][] dp;

    int maxDistance(int k, int[] arr) {
        int n = arr.length;
        dp = new Integer[n + 1][k + n + 1];

        return rec(0, k, arr);
    }

    private int rec(int i, int e, int[] arr) {
        if (i == arr.length)
            return 0;

        if (dp[i][e] != null)
            return dp[i][e];

        int move = Integer.MIN_VALUE;

        if (e > 0)
            move = rec(i + 1, e - 1, arr) + arr[i];

        int stay = rec(i + 1, e + 1, arr);

        return dp[i][e] = Math.max(move, stay);
    }
}
