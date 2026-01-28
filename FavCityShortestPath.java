// Given are N cities and M roads that travel between the given pair of cities and time it takes to travel that road. 
// Also we are given a list of favourite cities L and a source city S . we have to tell the favourite city which can be reached from source city the fastest(in minimum time)

import java.util.*;

class FavCityShortestPath {
    public int favCity(int cities, int[][] roads, List<Integer> favcity, int source) 
    {
        List<List<int[]>> adj = new ArrayList<>();
        
        HashSet<Integer> set = new HashSet<>();
        set.addAll(favcity);

        for(int i = 0; i < cities; i++)
            adj.add(new ArrayList<>());

        for(var road : roads)
        {
            int from = road[0];
            int to   = road[1];
            int time = road[2];

            adj.get(from).add(new int[]{to, time});
        }
        
        int[] distance = new int[cities];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[source] = 0;


        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] {source, 0});
        
        while(!pq.isEmpty())
        {
            var current = pq.poll();
            var city = current[0];
            int dist = current[1];
            
            if (dist > distance[city]) 
                continue;

            if(set.contains(city))
                return city;

            for (int[] neighbor : adj.get(city)) 
            {
                int next = neighbor[0];
                int w    = neighbor[1];

                if (dist + w < distance[next]) {
                    distance[next] = dist + w;
                    pq.add(new int[]{next, distance[next]});
                }
            }
        }
        return 0;
    }

}