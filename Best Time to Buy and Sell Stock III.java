public class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int len = prices.length;
        if (len==0)
            return profit;
        int[] fmax =new int[len];
        int[] lmax =new int[len];
        int[] fmin =new int[len];
        int[] lmin =new int[len];
        fmin[0] = prices[0];
        for (int i = 1; i < len; i ++){
            if (fmin[i-1]>prices[i])
                fmin[i] = prices[i];
            else
                fmin[i] = fmin[i-1];
        }
        lmin[len-1] = prices[len-1];
        for (int i = len - 2; i >=0; i--){
            if (lmin[i+1] < prices[i])
                lmin[i] = prices[i];
            else
                lmin[i] = lmin[i+1];
        }
        fmax[0] = 0;
        int temp = 0;
        for (int i = 1; i < len; i++){
            temp = prices[i]-fmin[i-1];
            fmax[i] = fmax[i-1]>temp?fmax[i-1]:temp;
        }
        lmax[len - 1] = 0;
        for (int i = len-2; i >= 0 ; i--){
            temp = lmin[i+1] - prices[i];
            lmax[i] = lmax[i+1]>temp?lmax[i+1]:temp;
        }
        for (int i = 0; i < len ; i++){
            temp = lmax[i] + fmax[i];
            if (temp > profit)
                profit = temp;
        }
        return profit;
    }
}
