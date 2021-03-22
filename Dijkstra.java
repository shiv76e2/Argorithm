import java.util.*;

class Dijkstra {
    static int[] d;
    //隣接リスト
    static Map<Integer,List<Edge>> all_edges = new HashMap<>();
    static int V;
    static int E;
    static int sv;
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
    
    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->(d[a.from]+a.cost)-(d[b.from]+b.cost));
        List<Edge> edges = all_edges.get(sv);
        for(int i=0;i<edges.size();i++) pq.add(edges.get(i));
        while(!pq.isEmpty()){
            Edge nearest_edge = pq.poll();
            if(d[nearest_edge.to]<0) {
                d[nearest_edge.to] = d[nearest_edge.from] + nearest_edge.cost;
                if(all_edges.containsKey(nearest_edge.to)) {
                    //MapからEdgeを取得>>変数edgesを初期化>>PriorityQueueに追加
                    edges = all_edges.get(nearest_edge.to);
                    for(int i=0;i<edges.size();i++) {
                        Edge edge = edges.get(i);
                        if(d[edge.to]<0) pq.add(edge);
                    }
                }
            }
        }
    }
    
     //入力受取用メソッド
     static void setEdges(){
        Scanner sc = new Scanner(System.in);
        V = Integer.parseInt(sc.next());
        E = Integer.parseInt(sc.next());
        sv = Integer.parseInt(sc.next());
        d = new int[V];
        for(int i=0;i<V;i++) d[i] = -1; 
        d[sv] = 0;
        for(int i = 0;i < V; i++){
            List<Edge> init = new ArrayList<>();
            all_edges.put(i,init);
        }
        //有向グラフ
        for(int i = 0;i < E; i++){
            int from = Integer.parseInt(sc.next());
            int to = Integer.parseInt(sc.next());
            int cost = Integer.parseInt(sc.next());
            Edge edge = new Edge(from,to,cost);
            all_edges.get(from).add(edge);
        }
        sc.close();
    }


}
