package dynamicProgramming;

/*\
Find if a subarray sums up to a target.
 */

public class SubarraySum {

    public boolean subArraySumRec(int[] arr, int target, int n) {
        if (target == 0)
            return true;
        if(target<0 || n== 0)
            return false;
        return subArraySumRec(arr,target-arr[n-1],n-1) || subArraySumRec(arr,target,n-1);
    }

    public boolean subArraySumMemo(int[] arr, int target,int n, boolean[] memo) {
        if (memo[n])
            return true;
        if (target == 0)
            return true;
        if(target<0 || n== 0)
            return false;
        memo[n] = subArraySumMemo(arr,target-arr[n-1],n-1,memo) || subArraySumMemo(arr,target,n-1,memo);
        return memo[n];

    }

    public boolean subArraySumDP(int [] arr, int sum, int n){
        boolean cache [] = new boolean[n+1];
        cache[0] = true;
        for(int i=1;i<n;i++){
            //cache[i] = cache[];
        }
        return false;
    }





    public static void main(String[] args) {
        int arr[]= new int[]{2,3};
        int target =7;
        SubarraySum sum = new SubarraySum();
        System.out.println(sum.subArraySumRec(arr, target,arr.length));
        System.out.println(sum.subArraySumRec(new int[]{2, 3, 1, 0, 1}, 7,5));
        System.out.println(sum.subArraySumMemo(arr, target,arr.length,new boolean[arr.length+1]));
        System.out.println(sum.subArraySumMemo(new int[]{2, 3, 1, 0, 1}, 7,5,new boolean[6]));
    }

}
