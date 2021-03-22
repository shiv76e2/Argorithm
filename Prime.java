import java.util.*;

class Prime {
    static List<Integer> list = new ArrayList<>(); //素因数分解した値を格納するリスト
    
    //素数判定
    static boolean isPrime(int n){
        if(n < 2)   return false;
		
        if(n == 2) return true;

        if(n % 2 == 0) return false;

		for(int i=2; i<=Math.sqrt(n); i++) if(n % i == 0) return false;
		
		return true;
    }

    //素因数分解
    static void factorization(int n){
        if(n < 2){
            if(list.isEmpty()){
                list.add(n);
                factorization(n);
                return;
            }
            //出力 
            for(int i = 0; i<list.size(); i++){
                System.out.print(list.get(i)+" ");
            }
            return;
        }    

		for(int i=2; i<=Math.sqrt(n); i++){
            if(n % i == 0){
                n /= i;
                list.add(i);
                factorization(n);
                return;
            }
        } 
        list.add(n);
        factorization(0);
    }
}
