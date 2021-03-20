import java.util.Arrays;

//O(|V|*|E|)
public class BellmanFord {
	static class Edge {
		int from; 
		int to; 
		int cost; 
	}

	static int V; 
	static int E; 
	static Edge[] edges;
	static int[] d; //頂点毎の暫定的な最短の距離

	static int INF = Integer.MAX_VALUE / 2; 

	static boolean bellman_ford(int sv) {
		// 最短距離を初期化
		d = new int[V];
		Arrays.fill(d, INF);
		d[sv] = 0;

		for (int count = 0; count < V; count++) {
			for (int i = 0; i < edges.length; i++) {
				int v = edges[i].to;
				int u = edges[i].from;
				int c = edges[i].cost;

				if (d[u] + c < d[v]) {
					d[v] = d[u] + c;
					if (count == V - 1) {
						return false;
					}
				}
			}
		}
		return true;
	}
}
