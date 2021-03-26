public class Mod {
    public static long pow(long a,long b) {
        long res = 1;
        while(b>0) {
            if((b&1)==1) res = (res * a);
            a = (a * a);
            b = b>>1;
        }
        return res;
    }
    public static long pow(long a,long b,long mod) {
        long res = 1;
        while(b>0) {
            if((b&1)==1) res = (res * a) % mod;
            a = (a * a) % mod;
            b = b>>1;
        }
        return res;
    }
}
