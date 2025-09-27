class Solution {
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int [][] a = new int[r][c];
        
        int i,j;
        //converting char aray to int array
        for(i=0;i<r;i++){
            for(j=0;j<c;j++){
                a[i][j] = (int)(matrix[i][j] - '0');
            }
        }
        
        //forming multiple inputs of largest rectange in a histogram
        for(i=0;i<r;i++){
            for(j=0;j<c;j++){
                if(i!=0 && a[i][j]!=0){
                    a[i][j] += a[i-1][j];
                }
                    
            }
        }

        int maxArea = 0;
        int val;
        int width;
        int area;
        for(i=0;i<r;i++){
            Stack<Integer> st = new Stack<>();
            area = 0;
            for(j=0;j<c;j++){
                while(!st.isEmpty() && a[i][st.peek()]>=a[i][j]){
                    val = a[i][st.pop()];
                    if(st.isEmpty()){
                       width = j; 
                    }
                    else{
                        width = j - st.peek() - 1;
                    }
                    area = val * width;
                    if(area>maxArea)
                        maxArea = area;
                }
                st.push(j);
            }
            while(!st.isEmpty()){
                val = a[i][st.pop()];
                if (st.isEmpty()) {
                    width = c;
                } else {
                    width = c - st.peek() - 1;
                }
                maxArea = Math.max(maxArea, val * width);
            }
        }
        return maxArea;
    }
}
