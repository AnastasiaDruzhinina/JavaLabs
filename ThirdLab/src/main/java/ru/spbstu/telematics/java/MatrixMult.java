package ru.spbstu.telematics.java;

public class MatrixMult
{
    public static double[][] Mult(double[][] matrix1, double[][] matrix2)
    {
        if (matrix1[0].length != matrix2.length)
            return null;

        double[][] result = new double[matrix1.length][matrix2[0].length];
        Thread[] threads = new Thread[matrix1.length];
        for (int i = 0; i < matrix1.length; i++)
        {
            threads[i] = new multThread(matrix1[i], matrix2, result[i]);
            threads[i].start();
        }

        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted");
        }

        return result;
    }

    static class multThread extends Thread
    {
        final double[] _row;
        final double[][] _matrix;
        double[] _result;

        multThread(double[] row, double[][] matrix, double[] result)
        {
            _row=row;
            _matrix=matrix;
            _result=result;
        }

        @Override
        public void run()
        {
            for (int i = 0; i < _matrix[0].length; i++)
            {
                _result[i] = 0;
                for (int j = 0; j < _row.length; j++)
                {
                    _result[i] += _row[j]*_matrix[j][i];
                }
            }
        }
    }
}
