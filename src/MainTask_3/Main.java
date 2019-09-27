package MainTask_3;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        double[][] matrix = Matrix.initializeMatrix(3, 4, -1, 5);
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3.3f ", matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("Extreme values in format [min, max]:");
        System.out.println(Arrays.toString(Matrix.extremeValues(matrix)));
        System.out.println("Average values in format [arithmetic, geometric]:");
        System.out.println(Arrays.toString(Matrix.averageValues(matrix)));
        System.out.println("First local extreme positions in format [local min: [row index, col index], local max: [row index, col index]]:");
        int[][] localExtremesPosition = Matrix.localExtremesPosition(matrix);
        System.out.printf("[local min: %s, local max: %s]", Arrays.toString(localExtremesPosition[0]), Arrays.toString(localExtremesPosition[1]));
        matrix = Matrix.transpose(matrix);
        System.out.println("Transpose matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%3.3f ", matrix[i][j]);
            }
            System.out.println();
        }
    }

}
