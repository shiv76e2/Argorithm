import java.util.*;
public class Kruskal {
    static int[] par;
    static class Edge{
        int from;
        int to;
        int cost;
        public Edge(int from,int to,int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
    public static int root(int x){
        if(par[x] == x){
            return x;
        }else{
            return par[x] = root(par[x]);//経路圧縮
        }
    }
    public static void unite(int x, int y){
        x = root(x);
        y = root(y);
        if(x == y){
            return;
        }else{
            par[x] = y;
        }
    }
    public static boolean same(int x, int y){
        return root(x) == root(y);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        int V = sc.nextInt();
        int E = sc.nextInt();
        par = new int[V];
        for(int i = 0;i < V; i++){
            par[i] = i;
        }
        for(int i = 0;i < E; i++){
            int s = sc.nextInt();
            int t = sc.nextInt();
            int d = sc.nextInt();
            Edge e = new Edge(s,t,d);
            pq.add(e);
        }
        int ans = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(!same(par[e.from],par[e.to])){
                unite(e.from,e.to);
                ans += e.cost;
            }
        }
        System.out.println(ans);
        sc.close();
    }
}
