// Given an array of positive elements, you can start at any element, at every element you have a choice to take it or skip it.
// If you take it the score will be increased by arr[i] and your next position will be i + arr[i], we have to find the max score that we can get

class StandTakeNoTake {
    public int maxProfit(int[] arr)
    {
        return rec(arr, 0);
    }

    private int rec(int[] arr, int i)
    {
        if(i >= arr.length)
            return 0;

        int notake = rec(arr, i + 1);

        int take = arr[i] + rec(arr, i + arr[i]);
        
        return Math.max(take, notake);
    }
}
