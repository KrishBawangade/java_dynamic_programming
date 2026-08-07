package no_of_longest_increasing_subsequences;

import java.util.Arrays;

public class NoOfLIS {
    public static void main(String[] args){
        int[] nums = {1,2,4,3,5,4,7,2};

        int size = nums.length;

        int[] len = new int[size];
        int[] count = new int[size];
    
        Arrays.fill(len, 1);
        Arrays.fill(count, 1);

        int max = 1;

        for(int i=0; i<size; i++){
            for(int p=0; p<i; p++){
                if(nums[i]>nums[p]){
                    if(1+ len[p] > len[i]){
                        len[i] = 1 + len[p];
                        count[i] = count[p];
                    }else if(1+len[p] == len[i]){
                        count[i] += count[p];
                    }
                }
            }

            max = Math.max(max, len[i]);
        }

        int noOfLIS = 0;

        for(int i=0; i<size; i++){
            if(len[i] == max){
                noOfLIS += count[i];
            }
        }

        System.out.println(noOfLIS);
    }
}
