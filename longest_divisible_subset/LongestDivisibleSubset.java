package longest_divisible_subset;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestDivisibleSubset {
    public static void main(String[] args){
        int[] nums = {3,4,16,8};

        int size = nums.length;

        Arrays.sort(nums);


        int[] dp = new int[size];
        int[] hash = new int[size];

        Arrays.fill(dp, 1);

        int maxi = dp[0];
        int lastIndex=0;

        for(int i=0; i<size; i++){
            hash[i] = i;
            for(int p=0; p<i; p++){
                if(nums[i]%nums[p] == 0){
                    if(1+ dp[p] > dp[i]){
                        dp[i] = 1 + dp[p];
                        hash[i] = p;
                    }
                }
            }

            if(dp[i] > maxi){
                maxi = dp[i];
                lastIndex = i;
            }
        }

        ArrayList<Integer> LDS = new ArrayList<>(); 

        while(hash[lastIndex]!=lastIndex){
            LDS.add(0, nums[lastIndex]);
            lastIndex = hash[lastIndex];
        }

        LDS.add(0, nums[lastIndex]);

        System.out.println(LDS);
    }
}
