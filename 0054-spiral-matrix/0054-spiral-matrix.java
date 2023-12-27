class Solution {
    static List<Integer> traverse(int[][] arr, int i, int j, List<Integer> list){
        if(arr[i][j] != Integer.MIN_VALUE){
            list.add(arr[i][j]);
            arr[i][j] = Integer.MIN_VALUE;  
        }
        //traversing in right direction →
        if(j < arr[i].length-1 && arr[i][j+1] != Integer.MIN_VALUE){
            traverse(arr, i, j+1, list);
        }
        //traversing in right direction ↓
        else if(i < arr.length-1 && arr[i+1][j] != Integer.MIN_VALUE){
            traverse(arr, i+1, j, list);
        }
        //traversing in right direction ←
        else if(j > 0 && arr[i][j-1] != Integer.MIN_VALUE){
            traverse(arr, i, j-1, list);
        }
        //traversing all the way up to finish one spiral ↑
        if(i > 0 && arr[i-1][j] != Integer.MIN_VALUE){
            while(arr[i-1][j] != Integer.MIN_VALUE){
                i--;
                list.add(arr[i][j]);
                arr[i][j] = Integer.MIN_VALUE;
            }
            traverse(arr, i, j+1, list);
        }
        return list;
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<Integer>();
        return traverse(matrix,0,0,spiral);
    }
}