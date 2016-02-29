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

}
