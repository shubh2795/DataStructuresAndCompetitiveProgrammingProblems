package dynamicProgramming;

/*
 * SOlving the nth fibonacci problem with recursion DP and memoization
 * */


public class Fibonacci {

    public int fibRecursive(int n) {
        if (n <= 2)
            return 1;
        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    public long fibMemo(int n, long [] memo){
        if(memo[n]!=0)
            return memo[n];
        if(n<=2)
            return 1;
        memo[n] =  fibMemo(n-1,memo) + fibMemo(n-2,memo);
        return memo[n];
    }

    public long fibDP(int n){
        long cache [] = new long[n+1];
        cache[1] = cache[2] = 1;
        for(int i = 3;i<=n ;i++){
            cache[i] =  cache[i-1] +cache[i-2];
        }
        for(long x:cache){
            System.out.print(x+" ");
        }
        System.out.println("");

        return cache[n];
    }



    public static void main(String[] args) {

        Fibonacci fib = new Fibonacci();
        int n = 50;
        long memo [] = new long[n+1];
        //System.out.println("Fibonacci of "+n+"= "+fib.fibRecursive(n));
        System.out.println("Fibonacci Memo of "+n+"= "+fib.fibMemo(n,memo));
        for (long x:memo) {
            System.out.print(x+" ");
        }
        System.out.println("Fibonacci DP of "+n+"= "+fib.fibDP(n));


    }

}
