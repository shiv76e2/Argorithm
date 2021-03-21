import java.util.*;

//O(V^3)
public class WarshallFloyd {
	public static class WF{
		long[][] d;
		long INF;

		public WF(long[][] d, long INF) {
			this.d = d;
			this.INF = INF;
		}
		public long[][] getAllDis(){

			for(int k=0; k<d.length; k++) {
				for(int i=0; i<d.length; i++) {
					for(int j=0; j<d.length; j++) {
						if(d[i][k] != INF && d[k][j] != INF) {
							d[i][j] = Math.min(d[i][j], d[i][k]+d[k][j]);
						}
					}
				}
			}

			return d;
		}

		public boolean isNegativeCycle() {
			for(int i=0; i<d.length; i++) {
				if(d[i][i] < 0) {
					return true;
				}
			}

			return false;
		}
	}
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        long[][] d = new long[V][V];
        long INF = Long.MAX_VALUE / 2;
		for(int i=0; i<d.length; i++) {
			Arrays.fill(d[i], INF);
		}
		for(int i=0; i<d.length; i++) {
				d[i][i] = 0;
		}
        for(int i = 0;i < E; i++){
            int s = sc.nextInt();
            int t = sc.nextInt();
            long c = sc.nextLong();
            d[s][t] = c;
        }
        WF wf = new WF(d,INF);
        wf.getAllDis();
        if(wf.isNegativeCycle()){
            System.out.println("NEGATIVE CYCLE");
        }else{
            for(int i = 0;i < V; i++){
                for(int j = 0;j < V; j++){
                    
                    if(d[i][j]==INF){
                        System.out.print("INF"+" ");
                    }else{
                        System.out.print(d[i][j]+ " ");
                    }
                }
                System.out.println();
            }
        }
        
        sc.close();
    }

}