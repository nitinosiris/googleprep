// A ramp in an integer array nums is a pair (i, j) for which i < j and nums[i] <= nums[j]. The width of such a ramp is j - i.

// Given an integer array nums, return the maximum width of a ramp in nums. If there is no ramp in nums, return 0.
import java.util.*;

class maxWidthRamp {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums.length; i++)
        {
            if(stack.isEmpty() || nums[i] < nums[stack.peek()])
            {
                stack.push(i);
            }
        }

        int maxWidth = 0;
        for(int i = nums.length - 1; i >= 0; i--)
        {
            if(!stack.isEmpty() && nums[i] >= nums[stack.peek()])
            {
                maxWidth = Math.max(maxWidth, i - stack.pop());
                i++;
            }
        }
        return maxWidth;
    }
}
