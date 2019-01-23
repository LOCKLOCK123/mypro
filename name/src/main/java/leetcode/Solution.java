package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linlang
 * @date 2019/1/17
 */

public class Solution {

    /*  给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
      你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。*/
    public int[] towNum(int nums[], int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];
            if (map.containsKey(left)) {
                return new int[]{map.get(left), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }

    public static int removeElement(int[] nums, int val) {
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    nums[j - 1] = nums[j];
                    nums[j] = val;
                }
            }
        }
        return nums.length-flag;
    }

    public static int searchInsert(int[] nums, int target) {
        int i = 0;
        for(i = 0; i<nums.length;i++){
            if(nums[i] >= target){
                  break;
            }
        }
        return i;
    }
    public int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        return climbStairs(n-1)+climbStairs(n-2);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m + n - 1;
        for(;i >= 0; i--){
            if((n - 1) < 0){
                return;
            }else if((m - 1) < 0){
                nums1[i] = nums2[n - 1];
                n--;
            }else{
                if(nums1[m-1] > nums2[n-1]){
                    nums1[i] = nums1[m-1];
                    m--;
                }else{
                    nums1[i] = nums2[n-1];
                    n--;
                }
            }
        }
    }
    public static int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length-1;
        while (i<=j){
            if(A[i] % 2 ==0){
                i++;
            }else if(A[i] % 2 ==1){
                if(A[j] % 2 == 1){
                    j--;
                }else if(A[j]%2 == 0){
                    int temp = 0;
                    temp = A[i];
                    A[i] = A[j];
                    A[j] = temp;
                    j--;
                }
            }

        }
        return A;

    }

    public static int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0;i<prices.length;i++){
            for(int j=i;j<prices.length;j++){
                if(prices[j]>prices[i] ){
                    int profit = prices[j] - prices[i];
                    if (profit > max){
                        max = profit;
                    }
                }
            }
        }
        System.out.print(max);
        return max;
    }

    public static boolean validMountainArray(int[] A) {
        if(A.length <= 2){
            return  false;
        }
        for(int i = 1;i<A.length-1;i++){
            if(A[i] <= A[i-1]){
                return  false;
            }
            int j = 0;
            for( j = i;j<A.length-1;j++){
                if(A[j] <= A[j+1]){
                    break;
                }
            }
            if(j == A.length-1){
                return true;
            }
        }
        return  false;
    }
    public static int missingNumber(int[] nums) {
        int shouledBeLength = nums.length + 1;
        int result = 0;
        for(int i=0;i<nums.length;i++){
            result +=nums[i];
        }
        int firstPlusend = (0+shouledBeLength-1)*shouledBeLength/2;
        return  firstPlusend - result;
    }

    public static int maxSubArray(int[] nums) {

        solve(nums, 0, nums.length - 1);


    }
    private static int solve(int[] nums, int left,  int right){
        if(left == right){
            return nums[left];
        }
        int mid = (left + right) >>1;
        int lans = solve(nums, left, mid);
        int rans = solve(nums, mid+1, right);

        //横跨分割点的情况
        int sum = 0, lmax = nums[mid], rmax = nums[mid + 1];
        for (int i=mid+1; i<=right;i++){
            sum += nums[i];
                if(sum > rmax){
                    rmax = sum;
            }
        }
        sum = 0;
        for(int i = mid; i >=left; i--){
            sum += nums[i];
            if(sum > lmax){
                lmax = sum;
            }
        }
        int ans = lmax + rmax;
        if(lans > ans)
        {ans = lans;}
        if(rans > ans)
        {ans = rans;}
        return  ans;

    }
    public static void main(String[] args) {
        int nums1[] = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.print(maxSubArray(nums1));
    }

}
