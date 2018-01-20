package ru.spbstu.telematics.java;

import org.apache.commons.math3.linear.MatrixUtils;
import org.apache.commons.math3.linear.RealMatrix;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MultTest
{
    final Random random = new Random();
    /*Тестирование умножения матриц*/
    @Test
    public void multTest()
    {
        double[][] matrix1;
        double[][] matrix2;

        /*Квадратные матрицы*/
        int n = 5;
        matrix1 = randMatrix(n,n);
        matrix2 = randMatrix(n,n);

        RealMatrix m1 = MatrixUtils.createRealMatrix(matrix1);
        RealMatrix m2 = MatrixUtils.createRealMatrix(matrix2);

        double[][] TrustedResult = m1.multiply(m2).getData();
        double[][] CustomResult = MatrixMult.Mult(matrix1,matrix2);

        assertArrayEquals("Square test failed", TrustedResult,CustomResult);

        /*Прямоугольные матрицы*/
        n = 3;
        int m = 5;
        matrix1 = randMatrix(m,n);
        matrix2 = randMatrix(n,m);

        m1 = MatrixUtils.createRealMatrix(matrix1);
        m2 = MatrixUtils.createRealMatrix(matrix2);

        TrustedResult = m1.multiply(m2).getData();
        CustomResult = MatrixMult.Mult(matrix1,matrix2);

        assertArrayEquals("Rectangle test failed", TrustedResult,CustomResult);
    }

    double[][] randMatrix(int m, int n)
    {
        double[][] matrix = new double[m][n];
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                matrix[i][j] = random.nextInt(10);
            }
        }

        return matrix;
    }

}
