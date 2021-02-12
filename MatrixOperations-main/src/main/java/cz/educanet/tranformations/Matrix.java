package cz.educanet.tranformations;

import kotlin.NotImplementedError;

import java.util.Arrays;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        double[][] vysledek = new double[getRows()][getColumns()];
        if (matrix.getColumns() == getColumns() && matrix.getRows() == getRows()) {
            for (int i = 0; i < getRows(); i++) {
                for (int j = 0; j < getColumns(); j++) {
                    vysledek[i][j] = 0;
                    for (int y = 0; y < 3; y++) {
                        vysledek[i][j] += get(i,y) * matrix.get(y,j);
                    }
                }
            }
        }
        return MatrixFactory.create(vysledek);
    }


    @Override
    public IMatrix times(Number scalar) {
     double[][] vysledek = new double[getRows()][getColumns()];
        for (int i = 0; i <getRows() ; i++) {
            for (int j = 0; j <getColumns() ; j++) {
                double a  = get(i , j);
                 vysledek[i][j] =  (a * (double)scalar);
            }
        }

        return MatrixFactory.create(vysledek); 
    }


    @Override
    public IMatrix add(IMatrix matrix) {  // TODO:
        double[][] vysledek = new double[getRows()][getColumns()];
        for (int i = 0; i < getRows(); i++) {
            for (int j = 0; j < getColumns(); j++) {
                double a =  get(i, j);
                double b =  matrix.get(i, j);
                vysledek[i][j] = a + b;
            }
        }


        return MatrixFactory.create(vysledek);
    }

    @Override
    public double get(int n, int m) {
        return rawArray[n][m];
    }

    //region Optional
    @Override
    public IMatrix transpose() {
        return null;
    }

    @Override
    public double determinant() {
        return 0;
    }

    //endregion
    //region Generated
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;

        for (int i = 0; i < rawArray.length; i++) {
            if (!Arrays.equals(rawArray[i], matrix.rawArray[i]))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rawArray);
    }
    //endregion
}
