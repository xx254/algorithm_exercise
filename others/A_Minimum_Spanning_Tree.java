// 除了用PriorityQueue来给collection排序之外，还可以用Collecitons.sort(list, new Comparator<..>{...}); 详见82-84行

import java.util.*;

public class Demo {

    public Demo(){

    }

    HashMap<String, String> h = new HashMap<>();

    public static class Connection {
        public String city1, city2;
        public int cost;
        public Connection(String city1, String city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
    }

    public void union(String a, String b){
        String fa = find(a);
        String fb = find(b);
        if(!fa.equals(fb)){
            h.put(fa, fb);
        }
    }
    public String find(String a){
        while(h.get(a) != a){
            a = h.get(a);
        }
        return a;
    }
    public boolean connected(String a, String b){
        return h.get(a).equals(h.get(b));
    }

    public List<Connection> lowestCost(List<Connection> connections) {

        List<Connection> res = new ArrayList<Connection>();
        PriorityQueue<Connection> pq = new PriorityQueue<Connection>(new Comparator<Connection>(){
            @Override
            public int compare(Connection o1, Connection o2){
                return o1.cost - o2.cost;
            }
        });
        for(Connection c : connections){
            // Union-find 初始化 HashMap
            if(!h.containsKey(c.city1)){
                h.put(c.city1, c.city1);
            }
            if(!h.containsKey(c.city2)){
                h.put(c.city2, c.city2);
            }
            pq.offer(c);
        }
        while(!pq.isEmpty()){
            Connection cur = pq.poll();
            if(connected(cur.city1, cur.city2)){
                continue;
            } else {
                //System.out.println("about to connect " + cur.city1 + "and " + cur.city2);
                union(cur.city1, cur.city2);
                res.add(cur);
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Demo d = new Demo();
        List<Connection> connections = new ArrayList<>();
        String[] a = {"A", "A", "B", "B", "D", "E"};
        String[] b = {"B", "C", "C", "D", "E", "F"};
        int[] cost = {1, 2, 3, 2, 5, 2};
        for(int i=0; i<a.length; i++){
            Connection c = new Connection(a[i], b[i], cost[i]);
            connections.add(c);
        }
//      for(int i=0; i<connections.size(); i++){
//          System.out.println(connections.get(i).cost);
//      }
        List<Connection> res = d.lowestCost(connections);
        for(int i=0; i<res.size(); i++){
            System.out.println(res.get(i).city1 + res.get(i).city2 + res.get(i).cost);
        }

    }
}
