package mainTask_3;

import java.util.Random;

public class Matrix {

    protected Matrix() {

    }

    public void a() {}

    public static double[][] initializeMatrix(int rowCount, int colCount, int minValue, int maxValue) {
        if (rowCount <= 0 || colCount <= 0) {
            throw new IllegalArgumentException("Arguments must be more than 0");
        }
        if (maxValue < minValue) {
            throw new IllegalArgumentException("maxValue must be more than minValue");
        }
        double[][] matrix = new double[rowCount][colCount];
        Random random = new Random();
        if (minValue != maxValue) {
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < colCount; col++) {
                    matrix[row][col] = random.nextInt(maxValue - minValue) + minValue + random.nextDouble();
                }
            }
        } else {
            for (int row = 0; row < rowCount; row++) {
                for (int col = 0; col < colCount; col++) {
                    matrix[row][col] = minValue;
                }
            }
        }
        return matrix;
    }

    public static double minValue(double[][] matrix) throws Exception {
        if (matrix == null) {
            throw new NullPointerException("Matrix can`t be null");
        }
        for (double[] row : matrix) {
            if (row == null) {
                throw new NullPointerException("Row of matrix can`t be null");
            }
        }
        if (!isMatrix(matrix)) {
            throw new IllegalArgumentException("Array must be matrix");
        }
        if (isOneValue(matrix)) {
            throw new Exception("Matrix hasn't min value");
        }
        double minValue = matrix[0][0];
        for (double[] row : matrix) {
            for (double cell : row) {
                if (cell < minValue) {
                    minValue = cell;
                }
            }
        }
        return minValue;
    }

    public static double maxValue(double[][] matrix) throws Exception {
        if (matrix == null) {
            throw new NullPointerException("Matrix can`t be null");
        }
        for (double[] row : matrix) {
            if (row == null) {
                throw new NullPointerException("Row of matrix can`t be null");
            }
        }
        if (!isMatrix(matrix)) {
            throw new IllegalArgumentException("Array must be matrix");
        }
        if (isOneValue(matrix)) {
            throw new Exception("Matrix hasn't max value");
        }

        double maxValue = matrix[0][0];
        for (double[] row : matrix) {
            for (double cell : row) {
                if (cell > maxValue) {
                    maxValue = cell;
                }
            }
        }
        return maxValue;
    }

    public static double arithmeticAverageValue(double[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("Matrix can`t be null");
        }
        for (double[] row : matrix) {
            if (row == null) {
                throw new NullPointerException("Row of matrix can`t be null");
            }
        }
        if (!isMatrix(matrix)) {
            throw new IllegalArgumentException("Array must be matrix");
        }

        int average = 0;
        for (double[] row : matrix) {
            for (double cell : row) {
                average += cell;
            }
        }
        return average / matrix.length * matrix[0].length;
    }

    public static double geometricAverageValue(double[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("Matrix can`t be null");
        }
        for (double[] row : matrix) {
            if (row == null) {
                throw new NullPointerException("Row of matrix can`t be null");
            }
        }
        if (!isMatrix(matrix)) {
            throw new IllegalArgumentException("Array must be matrix");
        }

        int average = 1;
        for (double[] row : matrix) {
            for (double cell : row) {
                average *= cell;
            }
        }
        return Math.pow(average, 1d / (matrix.length * matrix[0].length));
    }

    public static int[] firstLocalMinPosition(double[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("Matrix can`t be null");
        }
        for (double[] row : matrix) {
            if (row == null) {
                throw new NullPointerException("Row of matrix can`t be null");
            }
        }
        if (!isMatrix(matrix)) {
            throw new IllegalArgumentException("Array must be matrix");
        }

        if (isOneValue(matrix)) {
            return new int[]{-1, -1};
        }

        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length -  1; i++) {
                if (matrix[0][i] < matrix[0][i + 1]) {
                    return new int[]{0, i};
                }
            }
            return new int[]{0, matrix[0].length - 1};
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length -  1; i++) {
                if (matrix[0][i] < matrix[i + 1][0]) {
                    return new int[]{i, 0};
                }
            }
            return new int[]{matrix.length - 1, 0};
        }

        if ((matrix[0][0] < matrix[1][0]) &&
                (matrix[0][0] < matrix[0][1])) {
            return new int[]{0, 0};
        }
        for (int i = 1; i < matrix[0].length - 1; i++) {
            if ((matrix[0][i] < matrix[0][i - 1]) &&
                    (matrix[0][i] < matrix[1][i]) &&
                    (matrix[0][i] < matrix[0][i + 1])) {
                return new int[]{0, i};
            }
        }
        if ((matrix[0][matrix[0].length - 1] < matrix[1][matrix[0].length - 1]) &&
                (matrix[0][matrix[0].length - 1] < matrix[0][matrix[0].length - 2])) {
            return new int[]{0, matrix[0].length - 1};
        }

        for (int i = 1; i < matrix.length - 1; i++) {
            if ((matrix[i][0] < matrix[i - 1][0]) &&
                    (matrix[i][0] < matrix[i][1]) &&
                    (matrix[i][0] < matrix[i + 1][0])) {
                return new int[]{i, 0};
            }
            for (int j = 1; j < matrix[0].length - 1; j++) {
                if ((matrix[i][j] < matrix[i][j - 1]) &&
                        (matrix[i][j] < matrix[i + 1][j]) &&
                        (matrix[i][j] < matrix[i][j + 1]) &&
                        (matrix[i][j] < matrix[i + 1][j])) {
                    return new int[]{i, j};
                }
            }
            if ((matrix[i][matrix[0].length - 1] < matrix[i + 1][matrix[0].length - 1]) &&
                    (matrix[i][matrix[0].length - 1] < matrix[i][matrix[0].length - 2]) &&
                    (matrix[i][matrix[0].length - 1] < matrix[i - 1][matrix[0].length - 1])) {
                return new int[]{i, matrix[0].length - 1};
            }
        }

        if ((matrix[matrix.length - 1][0] < matrix[matrix.length - 2][0]) &&
                (matrix[matrix.length - 1][0] < matrix[matrix.length - 1][1])) {
            return new int[]{matrix.length - 1, 0};
        }
        for (int i = 1; i < matrix[0].length - 1; i++) {
            if ((matrix[matrix.length - 1][i] < matrix[0][i - 1]) &&
                    (matrix[matrix.length - 1][i] < matrix[matrix.length - 2][i]) &&
                    (matrix[matrix.length - 1][i] < matrix[matrix.length - 1][i + 1])) {
                return new int[]{matrix.length - 1, i};
            }
        }
        if ((matrix[matrix.length - 1][matrix[0].length - 1] < matrix[matrix.length - 1][matrix[0].length - 2]) &&
                (matrix[matrix.length - 1][matrix[0].length - 1] < matrix[matrix.length - 2][matrix[0].length - 1])) {
            return new int[]{matrix.length - 1, matrix[0].length - 1};
        }
        return new int[]{-1, -1};
    }

    public static int[] firstLocalMaxPosition(double[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("Matrix can`t be null");
        }
        for (double[] row : matrix) {
            if (row == null) {
                throw new NullPointerException("Row of matrix can`t be null");
            }
        }
        if (!isMatrix(matrix)) {
            throw new IllegalArgumentException("Array must be matrix");
        }

        if (isOneValue(matrix)) {
            return new int[]{-1, -1};
        }

        if (matrix.length == 1) {
            for (int i = 0; i < matrix[0].length -  1; i++) {
                if (matrix[0][i] > matrix[0][i + 1]) {
                    return new int[]{0, i};
                }
            }
            return new int[]{0, matrix[0].length - 1};
        }
        if (matrix[0].length == 1) {
            for (int i = 0; i < matrix.length -  1; i++) {
                if (matrix[0][i] > matrix[i + 1][0]) {
                    return new int[]{i, 0};
                }
            }
            return new int[]{matrix.length - 1, 0};
        }

        if ((matrix[0][0] < matrix[1][0]) &&
                (matrix[0][0] < matrix[0][1])) {
            return new int[]{0, 0};
        }
        for (int i = 1; i < matrix[0].length - 1; i++) {
            if ((matrix[0][i] > matrix[0][i - 1]) &&
                    (matrix[0][i] > matrix[1][i]) &&
                    (matrix[0][i] > matrix[0][i + 1])) {
                return new int[]{0, i};
            }
        }
        if ((matrix[0][matrix[0].length - 1] > matrix[1][matrix[0].length - 1]) &&
                (matrix[0][matrix[0].length - 1] > matrix[0][matrix[0].length - 2])) {
            return new int[]{0, matrix[0].length - 1};
        }

        for (int i = 1; i < matrix.length - 1; i++) {
            if ((matrix[i][0] > matrix[i - 1][0]) &&
                    (matrix[i][0] > matrix[i][1]) &&
                    (matrix[i][0] > matrix[i + 1][0])) {
                return new int[]{i, 0};
            }
            for (int j = 1; j < matrix[0].length - 1; j++) {
                if ((matrix[i][j] > matrix[i][j - 1]) &&
                        (matrix[i][j] > matrix[i + 1][j]) &&
                        (matrix[i][j] > matrix[i][j + 1]) &&
                        (matrix[i][j] > matrix[i + 1][j])) {
                    return new int[]{i, j};
                }
            }
            if ((matrix[i][matrix[0].length - 1] > matrix[i + 1][matrix[0].length - 1]) &&
                    (matrix[i][matrix[0].length - 1] > matrix[i][matrix[0].length - 2]) &&
                    (matrix[i][matrix[0].length - 1] > matrix[i - 1][matrix[0].length - 1])) {
                return new int[]{i, matrix[0].length - 1};
            }
        }

        if ((matrix[matrix.length - 1][0] > matrix[matrix.length - 2][0]) &&
                (matrix[matrix.length - 1][0] > matrix[matrix.length - 1][1])) {
            return new int[]{matrix.length - 1, 0};
        }
        for (int i = 1; i < matrix[0].length - 1; i++) {
            if ((matrix[matrix.length - 1][i] > matrix[0][i - 1]) &&
                    (matrix[matrix.length - 1][i] > matrix[matrix.length - 2][i]) &&
                    (matrix[matrix.length - 1][i] > matrix[matrix.length - 1][i + 1])) {
                return new int[]{matrix.length - 1, i};
            }
        }
        if ((matrix[matrix.length - 1][matrix[0].length - 1] > matrix[matrix.length - 1][matrix[0].length - 2]) &&
                (matrix[matrix.length - 1][matrix[0].length - 1] > matrix[matrix.length - 2][matrix[0].length - 1])) {
            return new int[]{matrix.length - 1, matrix[0].length - 1};
        }
        return new int[]{-1, -1};
    }

//    if user wants get transposed matrix and save initial matrix
//    then this function should not change the argument and we are
//    forced to use additional memory
    public static double[][] transpose(double[][] matrix) {
        if (matrix == null) {
            throw new NullPointerException("Matrix can`t be null");
        }
        for (double[] row : matrix) {
            if (row == null) {
                throw new NullPointerException("Row of matrix can`t be null");
            }
        }
        if (!isMatrix(matrix)) {
            throw new IllegalArgumentException("Array must be matrix");
        }

        double[][] transposedMatrix = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                transposedMatrix[j][i] = matrix[i][j];
            }
        }
        return transposedMatrix;
    }

    private static boolean isMatrix(double[][] array) {
        for (int row = 0; row < array.length - 1; row++) {
            if (array[row].length != array[row + 1].length) {
                return false;
            }
        }
        return true;
    }

    private static boolean isOneValue(double[][] matrix) {
        for (double[] row : matrix) {
            for (double cell : row) {
                if (cell != matrix[0][0]) {
                    return true;
                }
            }
        }
        return false;
    }

}