class Solution {
    public int[] validSequence(String A, String B) {

        int n = A.length();
        int m = B.length();
        int[] suffix = new int[n]; //right side match length

        int indexA = n-1;
        int indexB = m-1;
        int matchedCnt = 0;
        while(indexA >= 0) {
            if(indexB >= 0 && A.charAt(indexA) == B.charAt(indexB)) {
                matchedCnt++;
                indexB--;
            }
            suffix[indexA] = matchedCnt;
            indexA--;
        }

        int rIdx = 0;
        int[] result = new int[m];

        indexA = 0;
        indexB = 0;
        boolean ok = true; //Can change power Flg
        while(indexA < n && indexB < m) {
            if(A.charAt(indexA) == B.charAt(indexB)) {
                result[rIdx++] = indexA;
                indexB++;
            }
            else if(ok && indexA + 1 < n && suffix[indexA+1] >= m-indexB-1) {
                result[rIdx++] = indexA;
                indexB++;
                ok = false;
            }        
            indexA++;
        }    
        return indexB == m ? result : new int[]{};    
    }
}