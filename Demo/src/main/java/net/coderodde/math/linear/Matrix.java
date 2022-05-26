package net.coderodde.math.linear;

/**
 * Этот класс реализует матрицу из <code>двойных</code> записей.
 */
public class Matrix implements Cloneable {

    /**
     * Минимально допустимая ширина матрицы.
     */
    private static final int MINIMUM_WIDTH = 1;

    /**
     *
     * Минимально допустимая высота матрицы.
     */
    private static final int MINIMUM_HEIGHT = 1;

    /**
     * Фактическое хранение записей. Это поле объявляется закрытым для пакета как
     * *, чтобы ускорить фактические операции с матрицей.
     */
    final double[][] m;

    /**
     * Создает новую матрицу с шириной <код>ширина</код> и высотой
     *  * <код>высота</код>.
     *  *
     *  * @param width - ширина матрицы.
     *  * @param height - высота матрицы.
     */
    public Matrix(final int width, final int height) {
        checkWidth(width);
        checkHeight(height);
        m = new double[height][width];
    }

    /**
     * Создает новую матрицу, используя указанные записи.
     *  *
     *  * @param data матрица данных, содержащая записи.
     */
    public Matrix(final double[][] data) {
        int h = data.length;
        int w = 0;

        for (final double[] row : data) {
            w = Math.max(w, row.length);
        }

        m = new double[h][w];

        for (int r = 0; r != data.length; ++r) {
            for (int c = 0; c != data[r].length; ++c) {
                m[r][c] = data[r][c];
            }
        }
    }

    /**
     * Возвращает высоту этой матрицы.
     *  *
     *  * @возвращает высоту.
     */
    public int getHeight() {
        return m.length;
    }

    /**
     * Возвращает ширину этой матрицы.
     *  *
     *  * @возвращает ширину.
     */
    public int getWidth() {
        return m[0].length;
    }

    /**
     * Возвращает запись в строке <код>y</код> столбец <код>x</код>. (Оба
     *  * индексы начинаются с нуля.)
     *  *
     *  * @param x индекс столбца записи.
     *  * @param - y индекс строки записи.
     *  * @возвращает запись матрицы.
     */
    public double get(final int x, final int y) {
        checkColumnIndex(x);
        checkRowIndex(y);
        return m[y][x];
    }

    /**
     * Задает значение для записи в строке <код>y</код> столбец <код>x</код>.
     *  * (Оба индекса начинаются с нуля.)
     *  *
     *  * @param x индекс столбца.
     *  * @param y индекс строки.
     *  * @param value новое значение для установки.
     *  * @возвращает старое значение.
     */
    public double set(final int x, final int y, final double value) {
        checkColumnIndex(x);
        checkRowIndex(y);
        final double old = m[y][x];
        m[y][x] = value;
        return old;
    }

    /**
     * Возвращает другую матрицу с точно таким же содержимым, что и эта матрица.
     *  *
     *  * @возвращает матрицу клонирования.
     */
    @Override
    public Matrix clone() {
        final Matrix clone = new Matrix(getWidth(), getHeight());

        for (int row = 0; row < getHeight(); ++row) {
            for (int column = 0; column < getWidth(); ++column) {
                clone.set(column, row, get(column, row));
            }
        }

        return clone;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final String formatString = "%+f ";

        for (int r = 0; r < getHeight(); ++r) {
            for (int c = 0; c < getWidth(); ++c) {
                sb.append(String.format(formatString, get(c, r)));
            }

            sb.append('\n');
        }

        return sb.toString();
    }

    /**
     * Проверяет ширину.
     * @param , параметр который принимает метод или конструктор.
     * @param width ширина для проверки.
     * выдает исключение IllegalArgumentException, если ширина слишком мала.
     */
    private void checkWidth(final int width) {
        if (width < MINIMUM_WIDTH) {
            throw new IllegalArgumentException(
                    "The matrix width is too small. " +
                            "Requested width: " + width + ", " +
                            "mimimum allowed: " + MINIMUM_WIDTH);
        }
    }

    /**
     * Проверяет высоту.
     *  *
     *  * @param height высота, которую нужно проверить.
     *  * @выдает исключение IllegalArgumentException, если высота слишком мала.
     */
    private void checkHeight(final int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(
                    "The matrix width is too small. " +
                            "Requested width: " + height + ", " +
                            "mimimum allowed: " + MINIMUM_HEIGHT);
        }
    }

    /**
     * Проверяет, является ли данный индекс строки действительным.
     *  *
     *  * @param RowIndex - индекс строки для проверки.
     *  * @выдает исключение IllegalArgumenException, если индекс находится за пределами допустимых значений.
     */
    private void checkRowIndex(final int rowIndex) {
        if (rowIndex < 0) {
            throw new IllegalArgumentException(
                    "Row index is negative: " + rowIndex);
        }

        if (rowIndex >= m.length) {
            throw new IllegalArgumentException(
                    "Row index is too large. " +
                            "Received: " + rowIndex + ", the height of the matrix: " +
                            m.length);
        }
    }

    /**
     * Проверяет, является ли данный индекс столбца действительным.
     *  *
     *  * @param ColumnIndex - индекс столбца для проверки.
     *  * @выдает исключение IllegalArgumentException, если индекс находится за пределами допустимых значений.
     */
    private void checkColumnIndex(final int columnIndex) {
        if (columnIndex < 0) {
            throw new IllegalArgumentException(
                    "Column index is negative: " + columnIndex);
        }

        if (columnIndex >= m[0].length) {
            throw new IllegalArgumentException(
                    "Column index is too large. " +
                            "Received: " + columnIndex + ", the width of the matrix: " +
                            m[0].length);
        }
    }
}