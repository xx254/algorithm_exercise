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
//        System.out.println("now " + a + "`s father is " + find(a));
//        System.out.println("now " + b + "`s father is " + find(b));
    }
    public String find(String a){
        while(h.get(a) != a){
            a = h.get(a);
        }
        return a;
    }
    public boolean connected(String a, String b){
        String fa = find(a);
        String fb = find(b);
        return fa.equals(fb);
    }

    public List<Connection> lowestCost(List<Connection> connections) {

        List<Connection> res = new ArrayList<Connection>();
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection o1, Connection o2) {
                int diff = o1.cost - o2.cost;
                if (diff == 0) {
                    diff = o1.city1.compareTo(o2.city1);
                }
                if (diff == 0) {
                    diff = o1.city2.compareTo(o2.city2);
                }
                return diff;
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
        }
        for(int i=0; i<connections.size(); i++){
            Connection cur = connections.get(i);
            if(connected(cur.city1, cur.city2)){
                continue;
            } else {
//                System.out.println("Before connecting, their fathers are "+ find(cur.city1) + " and " + find(cur.city2));
//                System.out.println("connecting "+ cur.city1 + " and " + cur.city2);
                union(cur.city1, cur.city2);
                res.add(cur);
            }
        }
        String commonFather = find(res.get(0).city1);
        String curFather = null;
        for(Connection cur : res){
            curFather = find(cur.city1);
            if(!curFather.equals(commonFather)){
                System.out.println("over");
                return new ArrayList<Connection>();

            }
            curFather = find(cur.city2);
            if(!curFather.equals(commonFather)){
                System.out.println("over");
                return new ArrayList<Connection>();
            }
        }
        return res;
    }

    public static void main(String args[]) {
        Demo d = new Demo();
        List<Connection> connections = new ArrayList<>();
        String[] a = {"A", "A", "B", "C", "E", "E", "F", "C"};
        String[] b = {"B", "C", "C", "D", "F", "G", "G", "E"};
        int[] cost = {1, 3, 2, 2, 1, 1, 2, 5};
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
