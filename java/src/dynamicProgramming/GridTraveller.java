package dynamicProgramming;

/**
 * Number of ways to travel in a m*n grid from (0,0) to (m,n)
 * Only allowed to move downwards or right,No diagonal or left movements.
 */


public class GridTraveller {

    public int gridTravellerRecursive(int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        return gridTravellerRecursive(m - 1, n) + gridTravellerRecursive(m, n - 1);
    }

    public long gridTravellerMemo(long[][] memo, int m, int n) {
        if (memo[m][n] != 0)
            return memo[m][n];
        if (m == 0 || n == 0)
            return 0;
        if (m == 1 && n == 1)
            return 1;
        memo[m][n] = gridTravellerMemo(memo, m - 1, n) + gridTravellerMemo(memo,m, n - 1);
        return memo[m][n];

    }

    public int gridTravellerDP(int m, int n) {
        int[][] cache = new int[m + 1][n + 1];
        cache[1][1] =1;
        for(int i =2;i<=m;i++){
            for(int j = 2;j<=n ; j ++){
                cache[i][j] = cache[i-1][j] + cache[i][j-1];
            }
        }
        return cache[m][n];
    }


    public static void main(String[] args) {
        GridTraveller traveller = new GridTraveller();
        int m = 18,n=18;
        //System.out.println(traveller.gridTravellerRecursive(m,n));
        System.out.println(traveller.gridTravellerMemo(new long[m+1][n+1],m,n));
        System.out.println(traveller.gridTravellerDP(m,n));
    }

}
