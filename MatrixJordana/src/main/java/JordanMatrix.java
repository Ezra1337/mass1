
class JordanMatrix {
    String JordanMatrix = String.format("%s%d%s", "%", 8, ".1f");

    double[][] matrix;
    double[] answers;
    boolean[] lines;

    JordanMatrix(int[][] matrix, int[] answers) {
        checkArguments(matrix, answers);
        this.matrix = parceMatrixIntToDouble(matrix);
        this.answers = parseIntToDouble(answers);
        this.lines = new boolean[answers.length];
    }

    private void checkArguments(int[][] matrix, int[] answers) {
        if (matrix == null || matrix.length == 0) {
            throw new IllegalArgumentException("Matrix not may be null or empty.");
        }
        if (answers == null || answers.length == 0) {
            throw new IllegalArgumentException("Answers not may be null or empty.");
        }
        if (matrix.length != answers.length) {
            throw new IllegalArgumentException("Amount answer not equal height matrix.");
        }
        if (!checkSquareMatrix(matrix)) {
            throw new IllegalArgumentException("Matrix not may be not square.");
        }
    }

    private boolean checkSquareMatrix(int[][] matrix) {
        boolean result = true;
        int size = matrix.length;
        for (int[] line : matrix) {
            if (line.length != size) {
                result = false;
                break;
            }
        }
        return result;
    }

    private double[][] parceMatrixIntToDouble(int[][] matrix) {
        double[][] result = new double[matrix.length][];
        int count = 0;
        for (int[] line : matrix) {
            result[count++] = parseIntToDouble(line);
        }
        return result;
    }

    private double[] parseIntToDouble(int[] line) {
        double[] result = new double[line.length];
        for (int i = 0; i < line.length; i++) {
            result[i] = line[i];
        }
        return result;
    }


    double[] start() {
        System.out.println("Дана СЛАУ:");
        printSLAU(this.matrix, this.answers);

        double element;
        int index;
        int row = 0;

        while (!isEnd(this.lines)) {
            System.out.println("####################### СТОЛБЕЦ №" + (row + 1) + " #######################\n");

            System.out.println("Ищем разрешающий элемент в столбце #" + (row + 1) + ":");
            index = getIndexMin(this.matrix, this.lines, row);
            element = matrix[index][row];
            System.out.printf("элемент = %.1f;\n", element);

            System.out.println("\nДелим строку #" + (index + 1) + " на " + element + ":");
            divToElement(this.matrix[index], element);
            this.answers[index] /= element;
            printSLAU(this.matrix, this.answers);

            System.out.println("Обнулим в столбце #" + (row + 1) + " все элементы, кроме разрешающего:");
            toNullifyElements(this.matrix, this.answers, index, row);
            printSLAU(this.matrix, this.answers);

            this.lines[index] = true;
            row++;
        }

        System.out.println("###########################################################\n");
        return getAnswer(this.matrix, this.answers);
    }

    private double[] getAnswer(double[][] matrix, double[] answers) {
        double[] result = new double[answers.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1.) {
                    result[j] = answers[i];
                }
            }
        }
        return result;
    }

    private boolean isEnd(boolean[] lines) {
        boolean result = true;
        for (boolean index : lines) {
            if (!index) {
                result = false;
                break;
            }
        }
        return result;
    }

    private void toNullifyElements(double[][] matrix, double[] answers, int exceptLine, int row) {
        for (int i = 0; i < matrix.length; i++) {
            if (i == exceptLine) {
                continue;
            }
            double first = matrix[i][row];
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0.) {
                    matrix[i][j] -= first * matrix[exceptLine][j];
                }
            }
            if (answers[i] != 0.) {
                answers[i] -= first * answers[exceptLine];
            }
        }
    }

    private void divToElement(double[] line, double div) {
        for (int index = 0; index < line.length; index++) {
            if (line[index] != 0.) {
                line[index] /= div;
            }
        }
    }

    private void printSLAU(double[][] matrix, double[] answers) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answers.length; i++) {
            sb.append("|");
            for (int j = 0; j < matrix[i].length; j++) {
                sb.append(" ").append(String.format(JordanMatrix, matrix[i][j]));
            }
            sb.append(" | ").append(String.format(JordanMatrix, answers[i])).append(" |\n");
        }
        System.out.println(sb);
    }

    private int getIndexMin(double[][] matrix, boolean[] lines, int index) {
        int res = -1;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (!lines[i] && Math.abs(matrix[i][index]) < Math.abs(min) && matrix[i][index] != 0) {
                res = i;
                min = matrix[i][index];
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}

