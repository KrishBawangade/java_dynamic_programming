package longest_increasing_subsequence;

import java.util.*;

public class LISOptimal {

    public static int lengthOfLIS(int[] nums){
        ArrayList<Integer> longestArr = new ArrayList<>();

        longestArr.add(nums[0]);

        for(int i=1; i<nums.length; i++){
            int index = lowerBound(longestArr, nums[i]);

            if(index == longestArr.size()){
                longestArr.add(nums[i]);
            }else{
                longestArr.set(index, nums[i]);
            }
        }

        return longestArr.size();
    }

    public static int lowerBound(ArrayList<Integer> longestArr, int ele){
        int low = 0;
        int high = longestArr.size()-1;

        while(low<=high){
            int mid = (high-low)/2 + low;

            if(longestArr.get(mid)>=ele){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return low;
    }

    public static void main(String[] args){
        int[] nums = {10,9,2,5,3,7,101,18};

        System.out.println(lengthOfLIS(nums));
    }
}
