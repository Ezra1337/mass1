public class hw1 {
    public static void main(String[] args) {
        double[][] matrixD4 = {
                {1.0, 1.0, -1.0, -1.0},
                {2.0, 1.0, 2.0, 3.0},
                {3.0, 4.0, 5.0, 6.0},
                {5.0, 7.0, 8.0, 9.0}
        };
        double[][] matrixD3 = {
                {1.0, 2.0, 3.0},
                {4.0, 5.0, 6.0},
                {7.0, 8.0, 9.0}
        };
        double[][] matrixD2 = {
                {1, 2},
                {3, 4},
        };
        Determinant D4 = new Determinant(matrixD4);
        D4.getValue();
        Determinant D3 = new Determinant(matrixD2);
        D3.getValue();
        Determinant D2 = new Determinant(matrixD3);
        D2.getValue();
    }
}

class Determinant {
    public double summ;

    public Determinant(double[][] matrix) {
        getReduction(matrix, 1);
    }


    public void getValue() {
        System.out.printf("%.2f", this.summ);
        System.out.println("");
    }


    private void getReduction(double[][] subMinor, double elemParentMinor) {
        if (subMinor.length > 1) {
            double[][] tmpMinor = new double[subMinor.length - 1][subMinor[0].length - 1];
            for (int c = 0; c < subMinor[0].length; c++) {
                for (int i = 1; i < subMinor.length; i++) {
                    for (int j = 0; j < subMinor[0].length; j++) {
                        if (j < c)
                            tmpMinor[i - 1][j] = subMinor[i][j];
                        else if (j > c)
                            tmpMinor[i - 1][j - 1] = subMinor[i][j];
                    }
                }
                double paramForSub = Math.pow(-1, c + 2) * subMinor[0][c] * elemParentMinor;
                getReduction(tmpMinor, paramForSub);
            }
        } else
            this.summ += elemParentMinor * subMinor[0][0];
    }
}