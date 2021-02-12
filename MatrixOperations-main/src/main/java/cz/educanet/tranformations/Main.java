package cz.educanet.tranformations;

public class Main {

    public static void main(String[] args) {

        double[][] a = {

                {2, 3 , 1},
                {4, 3 , 3},
                {5, 8 , 7},
        };

        double[][] b = {
                {8, 5, 3},
                {2, 5, 7},
                {3, 4, 8},
        };


        IMatrix matrixA = MatrixFactory.create(a);
        IMatrix matrixB = MatrixFactory.create(b);

       double vypis =  matrixA.get(0,0);
       double vypis2 =  matrixB.get(0,0);



    }
}
