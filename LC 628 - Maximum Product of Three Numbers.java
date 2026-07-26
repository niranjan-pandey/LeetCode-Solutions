class Solution {
    public int maximumProduct(int[] A) {

        //TC = O(n*log(n))
        //SC = O(n*log(n))

        Arrays.sort(A);
        int n = A.length;

        int way1 = A[0] * A[1] * A[2];
        int way2 = A[n-1] * A[n-2] * A[n-3];
        int way3 = A[0] * A[1] * A[n-1];

        return Math.max(way1, Math.max(way2, way3));
    }
}