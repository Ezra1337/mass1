
/**
 * This class implements a matrix of <code>double</code> entries.
 */
public class Matrix implements Cloneable {

    /**
     * The minimum allowed width of a matrix.
     */
    private static final int MINIMUM_WIDTH = 1;

    /**
     * The minimum allowed height of a matrix.
     */
    private static final int MINIMUM_HEIGHT = 1;

    /**
     * The actual storage of entries. This field is declared package private as
     * to speed up the actual matrix operations.
     */
    final double[][] m;

    /**
     * Constructs a new matrix with width <code>width</code> and height
     * <code>height</code>.
     *
     * @param width  the width of the matrix.
     * @param height the height of the matrix.
     */
    public Matrix(final int width, final int height) {
        checkWidth(width);
        checkHeight(height);
        m = new double[height][width];
    }

    /**
     * Constructs a new matrix using the specified entries.
     *
     * @param data the data matrix containing the entries.
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
     * Returns the height of this matrix.
     *
     * @return the height.
     */
    public int getHeight() {
        return m.length;
    }

    /**
     * Returns the width of this matrix.
     *
     * @return the width.
     */
    public int getWidth() {
        return m[0].length;
    }

    /**
     * Returns the entry at row <code>y</code> column <code>x</code>. (Both
     * indices start at zero.)
     *
     * @param x the column index of the entry.
     * @param y the row index of the entry.
     * @return a matrix entry.
     */
    public double get(final int x, final int y) {
        checkColumnIndex(x);
        checkRowIndex(y);
        return m[y][x];
    }

    /**
     * Sets the value for the entry at row <code>y</code> column <code>x</code>.
     * (Both indices start at zero.)
     *
     * @param x     the column index.
     * @param y     the row index.
     * @param value the new value to set.
     * @return      the old value.
     */
    public double set(final int x, final int y, final double value) {
        checkColumnIndex(x);
        checkRowIndex(y);
        final double old = m[y][x];
        m[y][x] = value;
        return old;
    }

    /**
     * Returns another matrix with exactly same contents as this matrix.
     *
     * @return the clone matrix.
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
     * Checks the width.
     *
     * @param width the width to check.
     * @throws IllegalArgumentException if the width is too small.
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
     * Checks the height.
     *
     * @param height the height to check.
     * @throws IllegalArgumentException if the height is too small.
     */
    private void checkHeight(final int height) {
        if (height < MINIMUM_HEIGHT) {
            throw new IllegalArgumentException(
                    "The matrix width is too small. " +
                            "Requested width: " + height + ", " +
                            "mimimum allowed: " + MINIMUM_HEIGHT);
        }
    }
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
     * Checks that the given column index is valid.
     *
     * @param columnIndex the index of a column to check.
     * @throws IllegalArgumentException if the index is out of bounds.
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