//O(logN)
class UnionFind {
    static int[] par;
    
    static int root(int x){
        if(par[x] == x){
            return x;
        }else{
            return par[x] = root(par[x]);//経路圧縮
        }
    }
    static void unite(int x, int y){
        x = root(x);
        y = root(y);
        if(x == y){
            return;
        }else{
            par[x] = y;
        }
    }
    static boolean same(int x, int y){
        return root(x) == root(y);
    }
}
