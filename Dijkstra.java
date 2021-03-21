import java.util.*;

public class Dijkstra {
    //隣接リスト
    static Map<Integer,List<Edge>> all_edges = new HashMap<>();
    static int V;
    static int E;
    static int[] d;

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
    
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        int start = sc.nextInt();

        for(int i = 0;i < V; i++){
            List<Edge> edges = new ArrayList<>();
            all_edges.put(i,edges);
        }
        
        for(int i = 0;i < E; i++){
            int s = sc.nextInt();
            int t = sc.nextInt();
            int d = sc.nextInt();
            Edge e = new Edge(s,t,d);
            all_edges.get(s).add(e);    
        }
        //各nodeへの暫定コスト
        d = new int[V];
        //コストを初期化
        for(int i=0;i<d.length;i++) d[i] = -1; 
        d[start] = 0;
        //Edgeが存在場合にdijkstra処理
        dijkstra(start);
        //出力
        for(int i = 0;i < V; i++){
            if(d[i]<0){
                System.out.println("INF");
            }else{
                System.out.println(d[i]);
            }
        }
        
        sc.close();
    }
    //有向グラフ
    public static void dijkstra(int start) {
        //近いところから配るPriorityQueue
        PriorityQueue<Edge> pq = new PriorityQueue<>((a,b)->(d[a.from]+a.cost)-(d[b.from]+b.cost));
        //スタート地点からのEdgeを取る
        List<Edge> edges = all_edges.get(start);
        //上記の各EdgeをPriorityQueueにadd
        for(int i=0;i<edges.size();i++) pq.add(edges.get(i));
        //終了条件
        while(!pq.isEmpty()){
         //次に配るedgeを取る
            Edge nearest_edge = pq.poll();
            //まだ配っていないNodeなら処理
            if(d[nearest_edge.to]<0) {
                //コストの決定
                d[nearest_edge.to] = d[nearest_edge.from] + nearest_edge.cost;
                //配るEdgeがあるなら処理
                if(all_edges.containsKey(nearest_edge.to)) {
                    //MapからEdgeを取得>>edgesを初期化>>PriorityQueueに追加
                    edges = all_edges.get(nearest_edge.to);
                    for(int i=0;i<edges.size();i++) {
                        Edge edge = edges.get(i);
                        if(d[edge.to]<0) pq.add(edge);
                    }
                }
            }
        }
    }
}