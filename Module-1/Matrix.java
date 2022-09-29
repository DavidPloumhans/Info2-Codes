import java.io.*;
import java.util.*;

public class Matrix {

    /**
     * Create a matrix from a String.
     *
     * The string if formatted as follow:
     *  - Each row of the matrix is separated by a newline
     *    character \n
     *  - Each element of the rows are separated by a space
     *  For example, the String "0 1\n2 3" represent the
     *  matrix:
     *      [0 1]
     *      [2 3]
     *
     *  @param s The input String
     *  @return The matrix represented by the String
     */
    public static int[][] buildFrom(String s) {
        String[] lines = s.split("\n");
        int amountLines = lines.length;
        String[] copyOfLines = lines.clone();  // not necessary
        int amountColumns = copyOfLines[0].split(" ").length;
        int[][] matrix = new int[amountLines][amountColumns];
        for (int i = 0; i < amountLines; i++) {
            String[] columns = lines[i].split(" ");
            for (int j = 0; j < amountColumns; j++) {
                matrix[i][j] = Integer.parseInt(columns[j]);
            }
        }

        return matrix;
    }

    /**
     * Compute the sum of the element in a matrix
     *
     * @param matrix The input matrix
     * @return The sum of the element in matrix
     */
    public static int sum(int[][] matrix) {
        int sum = 0;
        for(int[] line : matrix) {
            for(int column : line) {
                sum += column;
            }
        }
        return sum;
    }

    /**
     * Compute the transpose of a matrix
     *
     * @param matrix The input rectangular matrix
     * @return A new matrix that is the transpose of matrix
     */
    public static int[][] transpose(int[][] matrix) {
        int[][] transposed = new int[matrix[0].length][matrix.length];  // the dimension of the matrix get inverted during a transpose
        for(int i = 0; i < matrix.length;  i++) {
            for(int j =0; j < matrix[0].length; j++) {
                transposed[j][i] = matrix[i][j];  // invert the indices
            }
        }
        return transposed;
    }

    /**
     * Compute the product of two matrix
     *
     * @param matrix1 A n x m matrix
     * @param matrix2 A m x k matrix
     * @return The n x k matrix product of matrix1 and matrix2
     */
    public static int[][] product(int[][] matrix1, int[][] matrix2) {
        int n = matrix1.length;
        int k = matrix2[0].length;
        int m = matrix2.length;
        int[][] result = new int[n][k];
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                // let's calculate the value for each element of result
                // lines of matrix1 * column of matrix2
                int localResult = 0;
                for (int f = 0; f < m; f++) {
                    localResult += matrix1[i][f] * matrix2[f][j];
                }
                result[i][j] = localResult;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] myMatrix = buildFrom("1 2 3\n4 5 6");
        print2D(myMatrix);  // works fine
        System.out.println(sum(myMatrix));  // works fine
        int[][] transpose = transpose(myMatrix);
        print2D(transpose);
        print2D(product(myMatrix, transpose));
        print2D(buildFrom("0 1 3 4 5\n2 3 9 6 8"));
    }
    public static void print2D(int[][] matrix)  // to print the matrix like in Python, used to verify your code
    {
        for (int[] line : matrix)
            System.out.println(Arrays.toString(line));
    }

}