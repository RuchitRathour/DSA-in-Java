class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
       int totalrow = matrix.length;
       int totalcol = matrix[0].length;
       int rowIndex = 0;
       int colIndex = totalcol-1;
       while(rowIndex<totalrow && colIndex>=0){
        if(matrix[rowIndex][colIndex] == target){
            return true;
        } else if (matrix[rowIndex][colIndex]>target){
            colIndex--;
        } else {
            rowIndex++;
        }
       } 
       return false;
    }
}