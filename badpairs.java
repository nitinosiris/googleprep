import java.util.*;
// You’re given a string which may contain "bad pairs".
// A bad pair is defined as a pair of adjacent characters, where they are the same letter in different cases. For example, "xX" is a bad pair, but "xx" or "XX" are not.
// Implement a solution to remove the bad pairs from the string.
// Sample:
// 	• Input: abxXw
// 	• Output: abw
// Additional Case:
// If the input string is empty:
// 	• Input: ""
// 	• Output: ""

public class badpairs {
    public String badPairs(String input)
    {
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < input.length(); i++)
        {
            char ch = input.charAt(i);
            if(str.length() == 0)
            {
                str.append(ch);
                continue;
            }
            char last = str.charAt(str.length() - 1);

            if((((Character.isLowerCase(last) && Character.isUpperCase(ch)) || 
                (Character.isLowerCase(ch) && Character.isUpperCase(last))) && 
                (Character.toLowerCase(last) == Character.toLowerCase(ch))))
            {
                str.deleteCharAt(str.length() - 1);
            }
            else
            {
                str.append(ch);
            }
        }

        if(str.length() == 0)
            return "";
        
        return str.toString();
    }
}
