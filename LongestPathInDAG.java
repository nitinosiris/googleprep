// Given a Directed Acyclic Graph (DAG) with N nodes and weighted/unweighted directed edges, determine the maximum path distance possible in the graph.

// In other words, among all possible directed paths from any node to any other reachable node, find the maximum length (distance) of such a path.

import java.util.*;

class LongestPathInDAG{
    public int longestPath(int n, List<List<Integer>> graph) {
        int size = graph.size();
        int[] indegree = new int[size];

        for(int i = 0; i < size; i++)
        {
            for(var dest : graph.get(i))
            {
                indegree[dest]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < size; i++)
            if(indegree[i] == 0)
                queue.add(i);

        int ans = 0;
        int[] dist = new int[n];

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int nei : graph.get(node)) {

                dist[nei] = Math.max(dist[nei], dist[node] + 1);
                ans = Math.max(ans, dist[nei]);

                indegree[nei]--;
                if (indegree[nei] == 0) {
                    queue.add(nei);
                }
            }
        }
        return ans;
    }
}