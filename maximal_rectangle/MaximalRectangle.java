package maximal_rectangle;

import java.util.Stack;

public class MaximalRectangle {

    public static int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;

        stack.push(0);

        for(int i=1; i<heights.length; i++){
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()] ){
                maxArea = getMax(heights, stack, maxArea, i);
            }
            
            stack.push(i);
        }

        int i = heights.length;

        while(!stack.isEmpty()){
            maxArea = getMax(heights, stack, maxArea, i);
        }

        return maxArea;
    }

    public static int getMax(int[] arr, Stack<Integer> stack, int maxArea, int i){

        int area;

        int popped = stack.pop();

        if(stack.isEmpty()){
            area = arr[popped] * i;
        }else{
            area = arr[popped]* (i-1-stack.peek());
        }

        return Math.max(maxArea, area);
    }

    public static void main(String[] args){
        char[][] matrix = {
            {'1','0','1','0','0'},
            {'1','0','1','1','1'},
            {'1','1','1','1','1'},
            {'1','0','0','1','0'},
        };

        int n = matrix.length;
        int m = matrix[0].length;

        int[] heights = new int[m];

        int maxArea=0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j] == '1'){
                    heights[j]++;
                }else{
                    heights[j] = 0;
                }
            }
            int area = largestRectangleArea(heights);

            maxArea = Math.max(maxArea, area);
        }

        System.out.println(maxArea);
    }
}
