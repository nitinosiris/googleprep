import java.util.*;

// You are given an integer array nums of fixed size and an integer S representing a storage limit.
// You may choose an integer value x (not necessarily present in the array).
// For every element nums[i], truncate it as follows:
// If nums[i] > x, replace it with x
// Otherwise, keep it unchanged
// After truncation, the sum of the modified array must be less than or equal to S.
// Your task is to find the integer x such that:
// The truncated array sum is ≤ S
// The value of x is as large as possible (optimal truncation)

class truncateArray {
    public int findOptimalTruncationValue(int[] nums, long S) {
        int max = Integer.MIN_VALUE;

        for(int num : nums)
            max = Math.max(max, num);
        

        int low = 0;
        int high = max;
        int ans = 0;

        while(low <= high)
        {
            int mid = (low + high) / 2;

            long sum = getSum(nums, mid);

            if(sum <= S)
            {
                ans = mid;
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return ans;
    }

    private long getSum(int[] arr, int num)
    {
        long sum = 0;
        for(int val : arr)
        {
            sum += Math.max(num, val);
        }
        return sum;
    }
}
