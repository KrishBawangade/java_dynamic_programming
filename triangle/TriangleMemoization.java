package triangle;

import java.util.*;

public class TriangleMemoization {

    public static int minimumTotal(List<List<Integer>> triangle){

        int size = triangle.size();

        int[][] dp = new int[size][];

        for (int i = 0; i < size; i++) {
            dp[i] = new int[triangle.get(i).size()];
            Arrays.fill(dp[i], -1);
        }

        int min = Integer.MAX_VALUE;

        for(int j=0; j<size; j++){
            int pathSum = minimum(triangle, dp, size-1, j);
            min = Math.min(min, pathSum);
        }

        return min;
    }

    private static int minimum(List<List<Integer>> triangle, int[][] dp, int i, int j) {
        if(i==0){
            return triangle.get(0).get(0);
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int pathSum1 = Integer.MAX_VALUE;
        int pathSum2 = Integer.MAX_VALUE;

        if(j!=i){
            pathSum1 = minimum(triangle, dp, i-1, j);
        }

        if(j!=0){
            pathSum2 = minimum(triangle, dp, i-1, j-1);
        }

        int min = triangle.get(i).get(j) + Math.min(pathSum1, pathSum2);

        return dp[i][j] = min;
    }

    public static void main(String[] args){
        List<List<Integer>> triangle = new ArrayList<>(
            List.of(
                new ArrayList<>(List.of(2)),
                new ArrayList<>(List.of(3, 4)),
                new ArrayList<>(List.of(6, 5, 7)),
                new ArrayList<>(List.of(4, 1, 8, 3))
            )
        );

        System.out.println(minimumTotal(triangle));
    }
}
