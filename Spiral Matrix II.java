public class Solution {
    int[][] moves={{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] generateMatrix(int n) {
        int x=0,y=0,d=0;
        int[][] matrix = new int[n][n];
        if (n==0)
            return matrix;
        matrix[x][y]=1;
        for (int i =1; i < n*n; i++){
            x=x+moves[d][0];
            y=y+moves[d][1];
            matrix[x][y] = i+1;
            if ((x+moves[d][0])==n || (y+moves[d][1])==n || (y+moves[d][1])==-1 || matrix[x+moves[d][0]][y+moves[d][1]]!=0){
                d++;
                d%=4;
            }
        }
        return matrix;
    }
}
