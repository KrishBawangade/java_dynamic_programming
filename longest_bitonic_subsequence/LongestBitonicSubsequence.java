package longest_bitonic_subsequence;

import java.util.Arrays;

public class LongestBitonicSubsequence {

    public static void main(String[] args){
        int[] nums = {1,11,2,10,4,5,2,1};

        int size = nums.length;

        int[] dp1 = new int[size];
        int[] dp2 = new int[size];

        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);


        // for increasing
        for(int i=0; i<size; i++){
            for(int p=0; p<i; p++){
                if(nums[i]>nums[p]){
                    if(1+ dp1[p] > dp1[i]){
                        dp1[i] = 1 + dp1[p];
                    }
                }
            }
        }

        // for decreasing
        for(int i=size-1; i>=0; i--){
            for(int p=size-1; p>i; p--){
                if(nums[i]>nums[p]){
                    if(1+ dp2[p] > dp2[i]){
                        dp2[i] = 1 + dp2[p];
                    }
                }
            }
        }

        int max = 1;

        // find maximum bitonic length
        for(int i=0; i<size; i++){
            max = Math.max(dp1[i]+dp2[i]-1, max);
        }


        System.out.println(max);
    }
}
