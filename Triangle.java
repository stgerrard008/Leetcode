public class Solution {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int height = triangle.size();
        int[] sum = new int[height];
        int[] temp = new int[height];
        sum[0] = triangle.get(0).get(0);
        for (int i = 1; i < height; i ++){
            for (int j = 0; j <i+1; j++){
                int k = triangle.get(i).get(j);
                if (j>0 && j<i){
                    temp[j] = (sum[j-1]<sum[j]?sum[j-1]:sum[j]) + k;
                }else if(j == 0){
                    temp[j] = sum[j] + k;
                }else if(j == i){
                    temp[j] = sum[j-1] + k;
                }
            }
            for (int j = 0; j <i+1; j++){
                sum[j] = temp[j];
            }
        }
        int min = 1000000;
        for (int i = 0; i < height; i++){
            if (sum[i]<min)
                min = sum[i];
        }
        return min;
    }
}
