import java.util.Scanner;
public class GaussJordanElimination {
    private static final double EPSILON = 1e-8;

    private final int N;      // N-by-N system
    private double[][] a;     // N-by-N+1 augmented matrix

    // исключение Гаусса-Джордана с частичным поворотом
    public GaussJordanElimination(double[][] A, double[] b) {
        N = b.length;

        // построить дополненную матрицу
        a = new double[N][N + N + 1];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                a[i][j] = A[i][j];

        // нужно только в том случае, если вы хотите найти сертификат неосуществимости (или вычислить обратное)
        for (int i = 0; i < N; i++)
            a[i][N + i] = 1.0;

        for (int i = 0; i < N; i++)
            a[i][N + N] = b[i];

        solve();

        assert check(A, b);
    }

    private void solve() {
        // исключение Гаусса-Джордана
        for (int p = 0; p < N; p++) {
            int max = p;
            for (int i = p + 1; i < N; i++) {
                if (Math.abs(a[i][p]) > Math.abs(a[max][p])) {
                    max = i;
                }
            }

            // заменить строку p на строку max
            swap(p, max);

            // единственное или почти единственное число
            if (Math.abs(a[p][p]) <= EPSILON) {
                continue;
                // выдать новое исключение RuntimeException("Матрица является сингулярной или почти сингулярной");
            }

            // точка
            pivot(p, p);
        }
        // димонстрация();
    }

    // поменять местами строку 1 и строку 2
    private void swap(int row1, int row2) {
        double[] temp = a[row1];
        a[row1] = a[row2];
        a[row2] = temp;
    }


    // разворот на входе (p, q) с использованием исключения Гаусса-Жордана
    private void pivot(int p, int q) {   // все, кроме строки p и столбца q
        for (int i = 0; i < N; i++) {
            double alpha = a[i][q] / a[p][q];
            for (int j = 0; j <= N + N; j++) {
                if (i != p && j != q) a[i][j] -= alpha * a[p][j];
            }
        }

        // обнуление столбца q
        for (int i = 0; i < N; i++)
            if (i != p) a[i][q] = 0.0;

        // масштабируем строку p (перейдём от q + 1 к N, но сделаем это согласованно с simplex pivot)
        for (int j = 0; j <= N + N; j++)
            if (j != q) a[p][j] /= a[p][q];
        a[p][q] = 1.0;
    }

    // вычисляем решение Ax = b
    public double[] primal() {
        double[] x = new double[N];
        for (int i = 0; i < N; i++) {
            if (Math.abs(a[i][i]) > EPSILON)
                x[i] = a[i][N + N] / a[i][i];
            else if (Math.abs(a[i][N + N]) > EPSILON)
                return null;
        }
        return x;
    }

    // вычисляем решение yA = 0, yb != 0
    public double[] dual() {
        double[] y = new double[N];
        for (int i = 0; i < N; i++) {
            if ((Math.abs(a[i][i]) <= EPSILON) && (Math.abs(a[i][N + N]) > EPSILON)) {
                for (int j = 0; j < N; j++)
                    y[j] = a[i][N + j];
                return y;
            }
        }
        return null;
    }

    // есть ли у системы решение?
    public boolean isFeasible() {
        return primal() != null;
    }

    // печатаем таблицы
    private void show() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(" " + a[i][j]);
            }
            System.out.print("| ");
            for (int j = N; j < N + N; j++) {
                System.out.print(" " + a[i][j]);
            }
            System.out.print("| \n" + a[i][N + N]);
        }
        System.out.println();
    }


    // проверяем это Ax = b or yA = 0, yb != 0
    private boolean check(double[][] A, double[] b) {

        // проверяем это Ax = b
        if (isFeasible()) {
            double[] x = primal();
            for (int i = 0; i < N; i++) {
                double sum = 0.0;
                for (int j = 0; j < N; j++) {
                    sum += A[i][j] * x[j];
                }
                if (Math.abs(sum - b[i]) > EPSILON) {
                    System.out.println("неосуществимо");
                    System.out.println(i + " = " + b[i] + ", sum = " + sum + "\n");
                    return false;
                }
            }
            return true;
        }

        // проверяем это yA = 0, yb != 0
        else {
            double[] y = dual();
            for (int j = 0; j < N; j++) {
                double sum = 0.0;
                for (int i = 0; i < N; i++) {
                    sum += A[i][j] * y[i];
                }
                if (Math.abs(sum) > EPSILON) {
                    System.out.println("Юзер дурак введи новые значения!");
                    System.out.println("sum = " + sum + "\n");
                    return false;
                }
            }
            double sum = 0.0;
            for (int i = 0; i < N; i++) {
                sum += y[i] * b[i];
            }
            if (Math.abs(sum) < EPSILON) {
                System.out.println("Юзер дурак введи новые значения!");
                System.out.println("yb  = " + sum + "\n");

                return false;
            }
            return true;
        }
    }


    public static void test(double[][] A, double[] b) {
        GaussJordanElimination gaussian = new GaussJordanElimination(A, b);
        if (gaussian.isFeasible()) {
            System.out.println("Решение Ax = b");
            double[] x = gaussian.primal();
            for (int i = 0; i < x.length; i++) {
                System.out.println(" " + x[i] + "\n");
            }
        } else {
            System.out.println("Неосущесвует");
            double[] y = gaussian.dual();
            for (int j = 0; j < y.length; j++) {
                System.out.println(" " + y[j] + "\n");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество переменных в уравнениях: ");
        int n = input.nextInt();
        System.out.println("Введите коэффициенты каждой переменной для каждого уравнения: ");
        System.out.println("ax + by + cz + ... = d");
        double[][] mat = new double[n][n];
        double[] constants = new double[n];
        //input
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = input.nextDouble();
            }
            constants[i] = input.nextDouble();
        }
        test(mat, constants);
    }
}
