import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class canShipPackage {
    public class Flight {
        String from;
        String to;
        int depart;
        int arrive;

        Flight(String from, String to, int depart, int arrive) {
            this.from = from;
            this.to = to;
            this.depart = depart;
            this.arrive = arrive;
        }
    }

    class Node{
        String curr;
        int time;

        Node(String cur, int t)
        {
            curr = cur;
            time = t;
        }
    }

    public boolean canShipPackage(String origin, String destination, List<Flight> flights) {
        HashMap<String, List<Flight>> graph = new HashMap<>();
        
        for(Flight flight : flights)
        {
            graph.computeIfAbsent(flight.from, k -> new ArrayList<>()).add(flight);
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(origin, 0));

        while(!queue.isEmpty())
        {
            Node node = queue.poll();

            if(node.curr.equals(destination))
                return true;

            for(Flight next : graph.getOrDefault(node.curr, new ArrayList<>()))
            {
                if(node.time <= next.depart)
                {
                    queue.offer(new Node(next.to, next.arrive));
                }
            }

        }
        return false;
    }
}
