package com.myjutil.regression; // LinearRegressionOneVariable

        import com.myjutil.util.DoubleMatrix;

        import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

/**
 *  Java implementation of linear regression with multiple variables based on gradient descent.
 *
 * H theta (x) = theta[0] +thetha[1] x
 * theta[i] - parameter
 *
 * User: liviu
 * Date: 2/29/16
 * Time: 1:12 PM
 */
public class LinearRegressionOneVariable {

    public final double xInput[][];

    public final double yOutput[];

    public LinearRegressionOneVariable(double[][] xInput, double[] yOutput) {
        this.xInput = xInput;
        this.yOutput = yOutput;
    }

    //J (theta)
    public double squaredErrorCostFunction(double[][] theta) {
        double h[][] = hypothesis(xInput, theta);

        double sum = 0;
        for (int i = 0; i < h.length; i++) {
            double diff = h[i][0] - yOutput[i];
            sum += Math.pow(diff, 2);
        }
        double upperJ = sum / (2 * h.length);
        return upperJ;
    }

    public double[][] hypothesis(double[][] xInput, double[][] theta) {
        return DoubleMatrix.multiply(xInput, theta);
    }

    public void regression(double learningRate, int numberOfIterations) {
        double theta[][] = zeros(2, 1);
        double alpha = learningRate;
        for (int i = 0; i < numberOfIterations; i++) {
            double[][] tmpMatrix = DoubleMatrix.multiply(xInput, theta);
            double[][] diff = diff(tmpMatrix);
            double[][] tmp = DoubleMatrix.multiply(transpose(xInput), diff);

            double tmpTheta[][] = scalarMultiplyMatrix(tmp, alpha / xInput.length);
            theta = minus(theta, tmpTheta);

            double j = squaredErrorCostFunction(theta);
            System.out.println(j+ " "+ Arrays.toString(theta[0])+" "+ Arrays.toString(theta[1]));
        }
    }

    private double[][] scalarMultiplyMatrix(double[][] matrix, double v) {
        double[][] result = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i][j] = v * matrix[i][j];

            }
        }
        return result;
    }

    private double[][] minus(double[][] first, double[][] second) {
        double[][] result = new double[first.length][first[0].length];
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[i].length; j++) {
                result[i][j] = first[i][j] - second[i][j];

            }
        }
        return result;
    }

    private double[][] diff(double[][] tmpMatrix) {
        double[][] diff = new double[tmpMatrix.length][1];
        for (int index = 0; index < tmpMatrix.length; index++) {
            diff[index][0] = tmpMatrix[index][0] - yOutput[index];
        }
        return diff;
    }

    public static void main(String... args) throws IOException {
        double[][] matrix = inputs();
        double[][] xInput = getInputs(matrix);
        double[] yOutput = getOutputs(matrix);
        LinearRegressionOneVariable lr = new LinearRegressionOneVariable(xInput, yOutput);
        double theta[][] = zeros(2, 1);
        System.out.println(lr.squaredErrorCostFunction(theta));
        lr.regression(.01d, 1500);

    }

    private static double[] getOutputs(double[][] matrix) {
        double[] outputs = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            outputs[i] = matrix[i][1];
        }
        return outputs;
    }

    private static double[][] getInputs(double[][] matrix) {
        double[][] inputs = new double[matrix.length][2];
        for (int i = 0; i < matrix.length; i++) {
            inputs[i][0] = 1;
            inputs[i][1] = matrix[i][0];
        }
        return inputs;
    }

    private static double[][] inputs() throws IOException {
        String input = "/home/liviu/ex1data1.txt";
        Path file = Paths.get(input);

        Scanner sc = new Scanner(file);

        int lineCount = 97;
        int columnsCount = 2;
        double[][] matrix = new double[lineCount][columnsCount];

        for (int i = 0; i < lineCount; i++) {
            String line = sc.nextLine();
            String aux[] = line.split("[,]");
            for (int j = 0; j < columnsCount; j++) {
                matrix[i][j] = Double.parseDouble(aux[j]);
                System.out.print(" " + matrix[i][j]);
                //sc.nex();
            }
            System.out.println();
        }
        return matrix;
    }

    public static double[][] zeros(int lines, int columns) {
        return new double[lines][columns];
    }

    public static double[][] transpose(double[][] matrix) {
        double[][] transpose = new double[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }


}
