class Solution {
    public int minCut(String s) {
        
        int len = s.length();
        
        // Memo will contain minimun number of cuts required for string at given index.
        // End index stays constant so no need of 2D grid.
        int memo[] = new int[len+1];
        
        // start building result from bottom-up, from last 1,2,3... chars to whole string. 
        for(int start = len-1; start >= 0 ; start--) {
            // if string (start, len-1) is palindrom, it requires 0 cuts.
            if(!isPalindrom(s, start, len-1)) {
                
                //as string (start, end-1) is not palindrom, at least 1 cut is required.
                int minCuts = len;
                // From given start index, consider substrings of size 1, 2, 3... so on.
                // if string start,end is palindrom, required cut is 1 + cuts required for remaining string.
                // we are taking min of all possible solutions and storing in memo.
                for(int end = start; end < len ; end++) {
                    if(isPalindrom(s, start, end)) {
                        minCuts = Math.min(minCuts, memo[end+1]);
                    }
                }
                memo[start] = 1 + minCuts;
            }
            // Else min cuts at start index is zero
        }
        
        return memo[0];
    }
    
    private boolean isPalindrom(String s, int low, int high) {
        while(low < high) {
            if(s.charAt(low++) != s.charAt(high--))
                return false;
        }
        return true;
    }
}
