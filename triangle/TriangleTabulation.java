package triangle;

import java.util.*;

public class TriangleTabulation {
    public static int minimumTotal(List<List<Integer>> triangle){

        int size = triangle.size();

        int[][] dp = new int[size][];

        dp[0] = new int[] {triangle.get(0).get(0)};

        for(int i=1; i<size; i++){
            dp[i] = new int[triangle.get(i).size()];

            for(int j=0; j<dp[i].length; j++){
                int pathSum1 = Integer.MAX_VALUE;
                int pathSum2 = Integer.MAX_VALUE;

                if(j!=i){
                    pathSum1 = dp[i-1][j];
                }

                if(j!=0){
                    pathSum2 = dp[i-1][j-1];
                }

                int innerMin = triangle.get(i).get(j) + Math.min(pathSum1, pathSum2);

                dp[i][j] = innerMin;
            }
        }

        int min = dp[size-1][0];

        for(int j=1; j<size; j++){
            min = Math.min(min, dp[size-1][j]);
        }


        return min;
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
