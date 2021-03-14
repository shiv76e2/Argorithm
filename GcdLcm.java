public class GcdLcm{
    //最大公約数
    public static int gcd(int a,int b){
       int A = Math.max(a,b);
       int B = Math.min(a,b);

       if(B == 0){
           return A;
       }else{
           return gcd(B, A % B);
       }
   }
   //最小高倍数
   public static int lcm(int a,int b){
        return (a * b) / gcd(a,b);
   }
}
