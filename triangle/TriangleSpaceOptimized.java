package triangle;

import java.util.*;

public class TriangleSpaceOptimized {
    public static int minimumTotal(List<List<Integer>> triangle){

        int size = triangle.size();

        int[] prev = new int[1];

        prev[0] = triangle.get(0).get(0);

        for(int i=1; i<size; i++){

            int[] curr = new int[triangle.get(i).size()];

            for(int j=0; j<curr.length; j++){
                int pathSum1 = Integer.MAX_VALUE;
                int pathSum2 = Integer.MAX_VALUE;

                if(j!=i){
                    pathSum1 = prev[j];
                }

                if(j!=0){
                    pathSum2 = prev[j-1];
                }

                int innerMin = triangle.get(i).get(j) + Math.min(pathSum1, pathSum2);

                curr[j] = innerMin;
            }

            prev = curr;
        }

        int min = prev[0];

        for(int i=1; i<prev.length; i++){
            min = Math.min(min, prev[i]);
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
