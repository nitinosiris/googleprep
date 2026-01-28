// we have a dictionary of words and a function which gives hash of these words and another function which gives score=sum of diff of adjacent 
// characters in a string and implement another function which gives the anagram of the given word with highest score.
// Hash of all anagrams is same.

import java.util.*;

class BestAnagramwithScore {
    String hashWord(String w) {
        // Provided externally
        return "0";
    }

    // Given helper: computes score of a word
    int score(String w) {
        // Provided externally
        return 0;
    }

    /*
     * Implement this function:
     * Given a target word, return the dictionary anagram
     * of that word with the highest score.
     */
    String bestAnagram(String target, List<String> dictionary) {

        HashMap<String, String> map = new HashMap<>();

        for(var word : dictionary)
        {
            String hash = hashWord(word);
            
            if(map.containsKey(hash))
            {
                if(score(map.get(hash)) < score(word))
                    map.put(hash, word);
            }
            else
                map.put(hash, word);
        }

        return map.get(hashWord(target));
    }

}