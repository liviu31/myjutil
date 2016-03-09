package com.myjutil.util;

import java.util.function.BiFunction;
import java.util.function.DoubleFunction;


/**
 * This class will flood you gc
 *
 * User: liviu
 * Date: 2/27/16
 * Time: 9:55 PM
 */
public class DoubleMatrix {

    public static double[][] merge(double[][] x, double[][] y, BiFunction<Double, Double, Double> function) {
        if (x.length != y.length) {
            throw new IllegalArgumentException("nonconformant arguments");
        }
        int length = x.length;
        double result[][] = new double[length][];
        for (int i = 0; i < length; i++) {
            result[i] = DoubleArray.merge(x[i], y[i], function);
        }
        return result;
    }


    public static double[][] operation(double[][] matrix, DoubleFunction<Double> function) {
        double result[][] = new double[matrix.length][];
        for (int i = 0; i < matrix.length; i++) {
            result[i] = DoubleArray.operation(matrix[i], function);
        }
        return result;
    }

    public static double[][] multiply(double[][] firstMatrix, double[][] secondMatrix) {

        int firstLineLength = firstMatrix[0].length;
        if (firstLineLength != secondMatrix.length) {
            throw new IllegalArgumentException("The number of columns of firstMatrix must agree with the number of rows of secondMatrix");
        }

        int secondLineLength = secondMatrix[0].length;
        double[][] result = new double[firstMatrix.length][secondLineLength];

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < secondLineLength; j++) {
                for (int k = 0; k < firstLineLength; k++) {
                    result[i][j] += firstMatrix[i][k] * secondMatrix[k][j];
                }
            }
        }

        return result;
    }

    /**
     * You are given a 2D matrix, a, of dimension MxN and a positive integer R. You have to rotate the matrix R times
     * and print the resultant matrix. Rotation should be in anti-clockwise direction.
     * @param matrix
     * @param rotate
     */

    private static void rotate(int[][] matrix, int rotate) {
        int level = 0;

        int n = matrix.length;
        int m = matrix[0].length;
        while (true) {
            int tmpR = rotate % (2 * (m + n - 4*level  - 2));
            for (int r = 0; r < tmpR; r++) {
                int carry = matrix[level][level];
                for (int i = level; i < m - level - 1; i++) {
                    matrix[level][i] = matrix[level][i + 1];
                }
                for (int i = level; i < n - level - 1; i++) {
                    matrix[i][m - level - 1] = matrix[i + 1][m - level - 1];
                }
                for (int i = m - level - 1; i > level; i--) {
                    matrix[n - level - 1][i] = matrix[n - level - 1][i - 1];
                }
                for (int i = n - level - 1; i > level; i--) {
                    matrix[i][level] = matrix[i - 1][level];
                }
                matrix[level + 1][level] = carry;
            }
            level++;
            if (level >= Math.min(n, m) / 2) {
                break;
            }
        }
        //System.out.println("done");
    }

}
