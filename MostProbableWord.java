import java.util.*;

class MostProbableWord{
    public String nextWord(String word, List<List<String>> sentences) {
        HashMap<String, HashMap<String, Integer>> dictionary = new HashMap<>();

        for(var sentence : sentences)
        {
            for(int i = 0; i < sentence.size() - 1; i++)
            {
                dictionary.computeIfAbsent(sentence.get(i), k -> new HashMap<>())
                .put(sentence.get(i + 1),
                    dictionary.get(sentence.get(i)).getOrDefault(sentence.get(i + 1), 0) + 1
                );
            }    
        }
        String ans = "";
        int count = 0;
        for(var entry : dictionary.get(word).entrySet())
        {
            if(entry.getValue() >= count)
            {
                ans = entry.getKey();
                count = entry.getValue();
            }
        }
        return ans;
    }
}