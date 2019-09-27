package MainTask_3;

import java.util.Arrays;
import java.util.Random;

public class Matrix {

    public static double[][] initializeMatrix(int rowCount, int colCount, int minValue, int maxValue) {
        if (rowCount <= 0 || colCount <= 0) {
            throw new IllegalArgumentException("Arguments must be more than 0");
        }
        if (maxValue < minValue) {
            throw new IllegalArgumentException("maxValue must be more than minValue");
        }
        double[][] matrix = new double[rowCount][colCount];
        Random random = new Random();
        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                matrix[row][col] = random.nextInt(maxValue - minValue) + minValue + random.nextDouble();
            }
        }
        return matrix;
    }

    public static double[] extremeValues(double[][] matrix) {
        for (int row = 0; row < matrix.length - 1; row++) {
            if (matrix[row].length != matrix[row + 1].length) {
                throw new IllegalArgumentException("Array must be matrix");
            }
        }
        double[] extreme = new double[2];
        extreme[0] = matrix[0][0];
        extreme[1] = matrix[0][0];
        for (double[] row : matrix) {
            for (double cell : row) {
                if (extreme[0] > cell) {
                    extreme[0] = cell;
                } else {
                    if (extreme[1] < cell) {
                        extreme[1] = cell;
                    }
                }
            }
        }
        return extreme;
    }

    public static double[] averageValues(double[][] matrix) {
        for (int row = 0; row < matrix.length - 1; row++) {
            if (matrix[row].length != matrix[row + 1].length) {
                throw new IllegalArgumentException("Array must be matrix");
            }
        }
        double[] average = new double[2];
        average[0] = 0;
        average[1] = 1;
        for (double[] row : matrix) {
            for (double cell : row) {
                average[0] += cell;
                average[1] *= cell;
            }
        }
        average[0] = average[0] / (matrix.length * matrix[0].length);
        average[1] = Math.pow(average[1], 1d / (matrix.length * matrix[0].length));
        return average;
    }

    public static int[][] localExtremesPosition(double[][] matrix) {
        for (int row = 0; row < matrix.length - 1; row++) {
            if (matrix[row].length != matrix[row + 1].length) {
                throw new IllegalArgumentException("Array must be matrix");
            }
        }
        int[][] position = new int[2][];
        position[0] = new int[2];
        position[0][0] = -1;
        position[0][1] = -1;
        position[1] = new int[2];
        position[1][0] = -1;
        position[1][1] = -1;
        for (int row = 0; row < matrix.length && (Arrays.equals(position[0], new int[]{-1, -1}) || Arrays.equals(position[1], new int[]{-1, -1})); row++) {
            for (int col = 0; col < matrix[row].length && (Arrays.equals(position[0], new int[]{-1, -1}) || Arrays.equals(position[1], new int[]{-1, -1})); col++) {
                boolean isLocalMin = true;
                boolean isLocalMax = true;
                if (row - 1 >= 0 && col - 1 >=0) {
                    if (matrix[row][col] >= matrix[row - 1][col - 1]) {
                        isLocalMin = false;
                        if (matrix[row][col] == matrix[row - 1][col - 1]) {
                            isLocalMax = false;
                        }
                    }
                }
                if (col - 1 >=0) {
                    if (matrix[row][col] >= matrix[row][col - 1]) {
                        isLocalMin = false;
                        if (matrix[row][col] == matrix[row][col - 1]) {
                            isLocalMax = false;
                        }
                    }
                }
                if (row + 1 < matrix.length && col + 1 < matrix[row].length) {
                    if (matrix[row][col] >= matrix[row + 1][col + 1]) {
                        isLocalMin = false;
                        if (matrix[row][col] == matrix[row + 1][col + 1]) {
                            isLocalMax = false;
                        }
                    }
                }
                if (col + 1 < matrix[row].length) {
                    if (matrix[row][col] >= matrix[row][col + 1]) {
                        isLocalMin = false;
                        if (matrix[row][col] == matrix[row][col + 1]) {
                            isLocalMax = false;
                        }
                    }
                }
                if (isLocalMin && Arrays.equals(position[0], new int[]{-1, -1})) {
                    position[0] = new int[]{row, col};
                } else {
                    if (isLocalMax && Arrays.equals(position[1], new int[]{-1, -1})) {
                        position[1] = new int[]{row, col};
                    }
                }
            }
        }
        return position;
    }

    public static double[][] transpose(double[][] matrix) {
        for (int row = 0; row < matrix.length - 1; row++) {
            if (matrix[row].length != matrix[row + 1].length) {
                throw new IllegalArgumentException("Array must be matrix");
            }
        }
        double[][] transposedMatrix = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

}