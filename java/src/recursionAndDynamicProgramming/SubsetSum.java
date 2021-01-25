package recursionAndDynamicProgramming;
/*Problem Statement:Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
        Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
        Output: True
        There is a subset (4, 5) with sum 9.

        Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
        Output: False
        There is no subset that add up to 30.

 */
public class SubsetSum {

    public boolean subsetSumRecursive(int arr[], int n , int sum){
        if(sum == 0)
            return true;
        if(n<0 || sum < 0)return false;
        return subsetSumRecursive(arr,n-1,sum-arr[n]) || subsetSumRecursive(arr,n-1,sum);
    }

    public boolean subsetSumDP(int [] ar, int n, int sum){
        return false;
    }

}
