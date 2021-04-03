import java.util.*;

class BitDP {
    static void tsp(String[] args) throws Exception {
        //入力
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        double[] x = new double[N];
        double[] y = new double[N];
        for(int i = 0; i<N; i++){
            x[i] = sc.nextDouble();
            y[i] = sc.nextDouble();
        }
        
        double[][] dist = new double[N][N];
        for(int i =0;i<N;i++){
            for(int j=0; j<N; j++){
                dist[i][j] = Math.hypot(x[i]-x[j],y[i]-y[j]);
            }
        }
        sc.close();
        //初期化。全ての状態にINFを格納。
        double INF = 1e100;
        double[][] dp = new double[1<<N][N];
        for(int i = 0;i < (i<<N); i++){
            for(int j = 0;j < N; j++){
                dp[i][j] = INF;
            }
        }
        //初期状態。0に訪れていて、それ以外にはまだ訪れていない。
        dp[1][0] = 0;

        //配るdp
        for(int i = 0;i < (1<<N); i++){
            for(int j = 0;j < N; j++){
                //次の状態について探索する。
                for(int k = 0;k < N; k++){
                    //既に訪れた街なら次へ
                    if((i>>k)%2==1) continue; 
                    //次の集合にkbit目を立てる
                    int nexti = i | (i<<k);
                    //今までの分に距離を足す
                    double nextd = dp[i][j] + dist[j][k];
                    //次の場所はk
                    //今まで調べたものより短くなっていれば、更新する
                    dp[nexti][k] = Math.min(dp[nexti][k],nextd);
                }
            }
        }
        //出力: 全て回ったパターンに対し全探索
        int all = (1<<N) -1;
        double ret = INF;
        for(int i = 0;i<N;i++){
            if(dp[all][i] == INF) continue;
            //0に帰って来るまでの経路を足す
            double temp = dp[all][i] + dist[i][0];
            ret = Math.min(ret,temp);
        }
        System.out.println(ret);

    }
}
