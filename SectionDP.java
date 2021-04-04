import java.util.*;

public class SectionDP {
    static int[][] dp;
    static int[] ary;
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        ary = new int[N];
        dp = new int[N][N+1];
        for(int i = 0;i < N; i++){
            for(int j = 0;j < N+1; j++){
                dp[i][j] = -1;
            }
        }
        for(int i = 0;i < N; i++){
            ary[i] = Integer.parseInt(sc.next());
        }
        sc.close();
        System.out.println(rec(0,N));
    }
    //再起
    static int rec(int l, int r){
        
        if(dp[l][r] != -1) return dp[l][r];
        if(Math.abs(l-r) <=1) return 0;

        int res = 0;
        //1
        if(rec(l+1,r-1) == r-l-2 && Math.abs(ary[l]-ary[r-1]) <=1){
            res = r-l; //ここでreturnしない理由は、下の区間を求める必要があるから
        }
        //2
        for(int mid = l+1;mid < r; mid++){
            res = Math.max(res,rec(l,mid)+rec(mid,r));
        }

        return dp[l][r] = res;
    }
}