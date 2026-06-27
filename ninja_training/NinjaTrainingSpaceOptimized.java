package ninja_training;


public class NinjaTrainingSpaceOptimized{

    public static int ninjaTraining(int[][] points){

        int n = points.length;

        int[] prev = new int[3];
        
        for(int j=0; j<3; j++){
           prev[j] = points[0][j];
        }

        for(int i=1; i<n; i++){
            
            int[] curr = new int[3];
            
            for(int j=0; j<3; j++){
                
                int innerMax = Integer.MIN_VALUE;


                for(int k = 0; k<3; k++){
                    if(k==j){
                        continue;
                    }
    
                    int meritPoints = points[i][j] + prev[k];
                    innerMax = Math.max(innerMax, meritPoints);
                }

                curr[j] = innerMax;
            }

            prev = curr;
        }

        int lastMax = prev[0];

        for(int i=1; i<3; i++){
            lastMax = Math.max(lastMax, prev[i]);
        }

        return lastMax;
    }

    public static void main(String[] args){
        int[][] points = {{1,2,5}, {3,1,1}, {3,3,3}};

        System.out.println(ninjaTraining(points));
    }
}