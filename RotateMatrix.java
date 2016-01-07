package arrays.strings;

class RotateMatrix
{
  public static void main(String[] args)
  {
    int[][] input = { {3, 5, 0, 4},
                      {2, 1, 9, 7},
                      {3, 2, 1, 0},
                      {8, 5, 0, 4} };
    //solve(input);
    rotateClockWise(input);
    printMatrix(input);
  }

  public static void printMatrix(int[][] matrix)
  {
    for (int i = 0; i < matrix.length; i++)
    {
      for (int j = 0; j < matrix[0].length; j++)
      {
        System.out.print(matrix[i][j] + " ");
      }
      System.out.println();
    }
  }
  
  public static void solve(int[][] matrix)
  {
    for (int layer = 0; layer < matrix.length / 2; layer++)
    {
      int first = layer;
      int last = matrix.length - 1 - layer;
      for (int i = first; i < last; i++)
      {
        int offset = i - first;
        //save top
        int top = matrix[first][i];
        
        //left -> top
        matrix[first][i] = matrix[last-offset][first];
        
        // bottom -> left
        matrix[last-offset][first] = matrix[last][last - offset];
        
        // right -> bottom
        matrix[last][last - offset] = matrix[i][last];
        
        // top -> right
        matrix[i][last] = top;
      }
    }
  }
  
  public static void rotateClockWise(int[][] matrix) {
      int n = matrix.length;
      if (n <= 1) return;

      // transpose the matrix
      for (int i = 0; i < n; i++) {
          for (int j = i; j < n; j++) {
              int temp = matrix[i][j];
              matrix[i][j] = matrix[j][i];
              matrix[j][i] = temp;
          }
      }

      // horizontally flip the matrix
      for (int col = 0; col < n / 2; col++) {
          for (int row = 0; row < n; row++) {
              int temp = matrix[row][col];
              matrix[row][col] = matrix[row][n - col - 1];
              matrix[row][n - col - 1] = temp;
          }
      }
  }
}
