import java.util.*;

class BellmanFord {
	static class Edge {
		int from; 
		int to; 
		int cost; 
		public Edge(int from,int to,int cost){
			this.from = from;
			this.to = to;
			this.cost = cost;
		}
	}
	static int[] d; 
	static Edge[] edges;
	static int V; // +
	static int E; // +
    static int sv; // +
	static int INF = Integer.MAX_VALUE / 2; //出力する際に注意
    
    //有向グラフ用
	static boolean bellman_ford() {
		d = new int[V];
		Arrays.fill(d, INF);
		d[sv] = 0;

		for (int count = 0; count < V; count++) {
			for (int i = 0; i < edges.length; i++) {
				int to = edges[i].to;
				int from = edges[i].from;
				int cost = edges[i].cost;
				
                if (d[from] != INF && d[from] + cost < d[to]) {
                    d[to] = d[from] + cost;
                    //負の閉路の検出
					if (count == V - 1) {
						return false;
					}
				}
			}
		}
		return true;
	}
    //入力受取用メソッド
    static void setEdges(){
        Scanner sc = new Scanner(System.in);
        V = Integer.parseInt(sc.next());
        E = Integer.parseInt(sc.next());
        sv = Integer.parseInt(sc.next());
        edges = new Edge[E];
        
        for(int i = 0;i < E; i++){
            int from = Integer.parseInt(sc.next());
            int to = Integer.parseInt(sc.next());
            int cost = Integer.parseInt(sc.next());
            Edge edge = new Edge(from,to,cost);
            edges[i] = edge;
        }
        sc.close();
    }
    
}