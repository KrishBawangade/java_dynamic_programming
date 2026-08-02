package print_longest_increasing_subsequence;

import java.util.*;

public class PrintLIS{
    public static void main(String[] args){
        int[] nums = {10,9,-1,5,3,7,101,18};

        int size = nums.length;

        int[] dp = new int[size];
        int[] hash = new int[size];

        Arrays.fill(dp, 1);

        int maxi = 1;
        int lastIndex=0;

        for(int i=0; i<size; i++){
            for(int p=0; p<i; p++){
                if(nums[i]>nums[p]){
                    if(1+ dp[p] > dp[i]){
                        dp[i] = 1 + dp[p];
                        hash[i] = p;
                    }
                }
            }

            if(dp[i] > dp[maxi]){
                maxi = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> LIS = new ArrayList<>(); 

        while(hash[lastIndex]!=lastIndex){
            LIS.add(0, nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }

        System.out.println(LIS);
    }
}