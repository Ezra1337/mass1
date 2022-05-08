package net.coderodde.math.linear;

import static net.coderodde.math.linear.Utils.checkNotInfinite;
import static net.coderodde.math.linear.Utils.checkNotNaN;
import static net.coderodde.math.linear.Utils.checkNotNegative;
import static net.coderodde.math.linear.Utils.checkNotNull;

/**
 * Этот класс предоставляет статический метод, выполняющий исключение Гаусса-Жордана
 * для входной матрицы *.
 */
public class GaussJordanElimination {

    /**
     * Определяет эпсилон по умолчанию для сравнения.
     */
    private static final double DEFAULT_EPSILON = 1E-6;

    /**
     * Определяет контрольное значение для любого индекса недопустимой строки.
     */
    private static final int ROW_NOT_FOUND = -1;

    /**
     * Кэширует фактическую матрицу.
     */
    private final double[][] m;

    /**
     * Значение эпсилона для сравнения.
     */
    private final double epsilon;

    /**
     * Выполняет исключение Гаусса-Жордана на входной матрице, используя заданную эпсилон.
     *  *
     *  * @param Параметр, который принимает метод или конструктор.
     *  * @param matrix матрица для устранения.
     *  * @param epsilon значение эпсилона, используемое для сравнения.
     *  * @возвращает ранг результирующей матрицы.
     */
    public static int solve(final Matrix matrix, final double epsilon) {
        return new GaussJordanElimination(matrix.m, epsilon).eliminate();
    }

    /**
     * Выполняет исключение Гаусса-Жордана для входной матрицы, используя значение по умолчанию
     *  * эпсилон.
     *  *
     *  * @param matrix матрица для устранения.
     *  * @возвращает ранг результирующей матрицы.
     */
    public static int solve(final Matrix matrix) {
        return solve(matrix, DEFAULT_EPSILON);
    }

    /**
     * Возвращает <code>true</code>, если определено, что система линейных
     *  * уравнения, представленные входной матрицей, не имеют решений. Если есть
     *  * вероятность осуществимости, возвращает <код>false</code>. Использует значение по умолчанию
     *  * эпсилон.
     *  *
     *  * @param matrix матрица для проверки.
     *  * @возвращает <код>true</code>, если нет решения системы
     *  * представлен матрицей, а в противном случае <код>false</code> равен
     *  * возвращен.
     */
    public static boolean isNotFeasible(final Matrix matrix) {
        return isNotFeasible(matrix, DEFAULT_EPSILON);
    }

    /**
     * Возвращает <code>true</code>, если определено, что система линейных
     *  * уравнения, представленные входной матрицей, не имеют решений. Если есть
     *  * вероятность осуществимости, возвращает <код>false</code>.
     *  *
     *  * @param matrix матрица для проверки.
     *  * @param epsilon - эпсилон сравнения.
     *  * @возвращает <код>true</code>, если нет решения системы
     *  * представлен матрицей, а в противном случае <код>false</code> равен
     *  * возвращен.
     */
    public static boolean isNotFeasible(final Matrix matrix,
                                        final double epsilon) {
        checkNotNaN(epsilon, "The input epsilon is NaN.");
        checkNotInfinite(epsilon, "The input epsilon is infinite: " + epsilon);
        checkNotNegative(epsilon, "The input epsilon is negative: " + epsilon);

        outer:
        for (int r = 0; r < matrix.getHeight(); ++r) {
            for (int c = 0; c < matrix.getWidth() - 1; ++c) {
                if (!epsilonEquals(0.0, matrix.get(c, r), epsilon)) {
                    continue outer;
                }
            }

            if (!epsilonEquals(0.0,
                    matrix.get(matrix.getWidth() - 1, r),
                    epsilon)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Создает этот элиминатор.
     *  *
     *  * @param m матрица для устранения.
     *  * @param epsilon значение эпсилона для сравнения.
     */
    private GaussJordanElimination(final double[][] m, final double epsilon) {
        checkNotNull(m, "The input matrix is null.");
        checkNotNaN(epsilon, "The input epsilon is NaN.");
        checkNotInfinite(epsilon, "The input epsilon is infinite: " + epsilon);
        checkNotNegative(epsilon, "The input epsilon is negative: " + epsilon);

        this.m = m;
        this.epsilon = epsilon;
    }

    /**
     * Выполняет фактическое устранение.
     *  *
     *  * @возвращает ранг результирующей матрицы.
     */
    private int eliminate() {
        int rowsProcessed = 0;

        for (int k = 0; k != m[0].length; ++k) {
            int ur = findUpmostRowWithPivotAtColumn(k, rowsProcessed);

            if (ur == ROW_NOT_FOUND) {
                continue;
            }

            swapRows(ur, rowsProcessed);
            scaleRow(rowsProcessed, 1.0 / m[rowsProcessed][k]);

            for (int r = 0; r != m.length; ++r) {
                if (r != rowsProcessed) {
                    addToRowMultipleOfAnotherRow(
                            r,
                            rowsProcessed,
                            -m[r][k] / m[rowsProcessed][k]);
                }
            }

            ++rowsProcessed;
        }

        return rowsProcessed;
    }

    /**
     * Возвращает <code>true</code>, если <code>a</code> и <code>b</code> находятся в пределах
     *  * <код>эпсилон</код> друг от друга.
     *  *
     *  * @param - первое значение.
     *  * @param - второе значение.
     *  * @param epsilon - максимально допустимое расстояние.
     *  * @возвращает <code>true</code>, если <code>a</code> и <code>b</code> являются
     *  * в пределах <код>эпсилон</код> друг от друга.
     */
    public static boolean epsilonEquals(final double a,
                                        final double b,
                                        final double epsilon) {
        return Math.abs(a - b) <= epsilon;
    }

    /**
     * Проверяет коэффициент умножения.
     *  *
     *  * @param factor - значение коэффициента для проверки.
     *  * @выдает исключение IllegalArgumentException, если коэффициент равен <code>NaN</code> или равен
     * * infinite.
     */
    private static void checkFactor(final double factor) {
        checkNotNaN(factor, "The factor is NaN.");
        checkNotInfinite(factor, "The factor is infinite: " + factor);
    }

    /**
     * Реализует элементарную матричную операцию сложения, кратную одной строке
     *  * к другому.
     *  *
     *  * @param targetRowIndex - индекс строки, в которую нужно добавить.
     *  * @param sourceRowIndex - индекс добавляемой строки.
     *  * @param factor коэффициент, на который умножается каждая запись
     * исходной строки *.
     */
    private void addToRowMultipleOfAnotherRow(final int targetRowIndex,
                                              final int sourceRowIndex,
                                              final double factor) {
        checkFactor(factor);
        for (int i = 0; i != m[0].length; ++i) {
            m[targetRowIndex][i] += m[sourceRowIndex][i] * factor;
        }
    }

    /**
     * Переключается на строки с заданными индексами.
     *  *
     *  * @param rowIndex1 - индекс строки.
     *  * @param rowIndex2 - индекс другой строки.
     */
    private void swapRows(final int rowIndex1, final int rowIndex2) {
        final double[] tmp = m[rowIndex1];
        m[rowIndex1] = m[rowIndex2];
        m[rowIndex2] = tmp;
    }

    /**
     * Пропускает первые строки <code>skipRows</code> в матрице и возвращает
     *  * индекс строки, содержащей ненулевое значение в столбце
     *  * <код>Индекс столбца</код>.
     *  *
     *  * @param ColumnIndex - индекс целевого столбца.
     *  * @param skipRows - количество самых верхних строк, которые нужно пропустить.
     *  * @возвращает индекс строки.
     */
    private int findUpmostRowWithPivotAtColumn(final int columnIndex,
                                               final int skipRows) {
        for (int i = skipRows; i < m.length; ++i) {
            if (!epsilonEquals(m[i][columnIndex], 0.0, epsilon)) {
                return i;
            }
        }

        return ROW_NOT_FOUND;
    }

    /**
     * Умножает каждую запись указанной строки матрицы на заданный коэффициент.
     *  *
     *  * @param RowIndex - индекс строки.
     *  * @param - коэффициент умножения.
     */
    private void scaleRow(final int rowIndex, final double factor) {
        checkFactor(factor);
        final double[] row = m[rowIndex];
        for (int i = 0; i != row.length; ++i) {
            row[i] *= factor;
        }
    }
}