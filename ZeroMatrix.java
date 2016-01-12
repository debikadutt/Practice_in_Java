package arrays.strings;

public class ZeroMatrix1 {

	public static void main(String[] args) {
		int[][] input = { { 4, 9, 0, 2 }, { 2, 1, 3, 7 }, { 3, 8, 1, 0 }, { 6, 4, 2, 0 } };
		solution(input);
	}

	static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.println(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void solution(int[][] matrix) {
		boolean rowHasZero = false;
		boolean colHasZero = false;
		
		//check if first row has a zero
		for (int i = 0; i < matrix[0].length; i++) {
			if (matrix[0][i] == 0) {
				rowHasZero = true;
				break;
			}
		}

		//check if first column has a zero
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				colHasZero = true;
				break;
			}
		}
		
		//check if remaining matrix has a zero
		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		
		//nullify rows based on first column
		for (int i = 1; i < matrix.length; i++) {
			if (matrix[i][0] == 0) {
				nullifyRow(matrix, i);
			}
		}

		//nullify columns based on first row
		for (int j = 1; j < matrix[0].length; j++) {
			if (matrix[0][j] == 0) {
				nullifyColumn(matrix, j);
			}
		}
		
		if (rowHasZero) {
			nullifyRow(matrix, 0);
		}
		if (colHasZero) {
			nullifyColumn(matrix, 0);
		}
		printMatrix(matrix);
	}

	static void nullifyRow(int[][] matrix, int row) {
		for (int j = 0; j < matrix[0].length; j++) {
			matrix[row][j] = 0;
		}
	}

	static void nullifyColumn(int[][] matrix, int col) {
		for (int i = 0; i < matrix.length; i++) {
			matrix[i][col] = 0;
		}
	}
}
