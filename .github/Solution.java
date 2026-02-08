import java.util.*;
// Problem: Write a function to determine if it's possible to make a single vertical cut through a rectangular cake with non-overlapping toppings such that:

// The cut does not intersect or destroy any of the toppings.
// After the cut, both resulting pieces of the cake each contain at least one topping.

// List of toppings with their positions [topping (start_x, end_x, start_y, end_y) ]

public class Solution{
    class Topping 
    {
        int startX;
        int endX;
        int startY;
        int endY;

        Topping(int startX, int endX, int startY, int endY) {
            this.startX = startX;
            this.endX = endX;
            this.startY = startY;
            this.endY = endY;
        }
    }
    

    public boolean horizontalCut(List<Topping> toppings)
    {
        if(toppings == null || toppings.size() < 2)
            return false;

        Collections.sort(toppings, (a, b) -> Integer.compare(a.startX, b.startX));

        int[] maxEnd = new int[toppings.size()];

        maxEnd[0] = toppings.get(0).endX;

        for(int i = 1; i < toppings.size(); i++)
        {
            maxEnd[i] = Math.max(maxEnd[i - 1], toppings.get(i).endX);
        }

        for(int i = 0; i < toppings.size() - 1; i++)
        {
            int leftEndMax = maxEnd[i];
            int rightStartMin = toppings.get(i + 1).startX;

            if(leftEndMax <= rightStartMin)
                return true;
        }
        return false;
    }
}