public class Solution {
    public int singleNumber(int[] A) {
        int x=A[0];
        for (int i = 1;i<A.length;i++){
            x ^= A[i];
        }
        return x;
    }
}
