class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        List<List<Integer>> dp = new ArrayList<>();
        for(int i = 0 ; i < m ; i++)
            dp.add(new ArrayList<>());
        
        for(int i = 0 ; i < m ; i++)
            for(int j = 0 ; j < i+1 ; j++)
                dp.get(i).add(-1);
        
        return minPath(triangle , m , 0 , 0 , dp);
    }
    
    public int minPath(List<List<Integer>> triangle , int m , int r , int c , List<List<Integer>> dp){
        if(r>=m || c>r)
            return Integer.MAX_VALUE-1000000;
        
        if(dp.get(r).get(c) != -1)
            return dp.get(r).get(c);
        
        if(r == m-1)
            return triangle.get(r).get(c);
        
        int downL = triangle.get(r).get(c) + minPath(triangle , m , r+1 , c , dp);
        int downR = triangle.get(r).get(c) + minPath(triangle , m , r+1 , c+1 , dp);
        
        dp.get(r).set(c , Math.min(downL , downR));
        return dp.get(r).get(c);
    }
}