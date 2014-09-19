public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0){
            return 0;
        }
        int[] profit = new int[len];
        int[] min = new int[len];
        min[0] = prices[0];
        for (int i = 1; i < len; i++){
            min[i] = min[i-1]<prices[i]?min[i-1]:prices[i];
        }
        profit[0] = 0;
        for (int i = 1; i < len; i++){
            profit[i] = (prices[i]-min[i])>profit[i-1]?(prices[i]-min[i]):profit[i-1];
        }
        return profit[len-1];
    }
}
