package net.coderodde.math.linear;

/**
 * Этот класс определяет некоторые общие служебные методы.
 */
public class Utils {

    /**
     * Проверяет, что входное число не бесконечно, и если это так, выдает
     * исключение с указанным сообщением.
     *
     * @param value значение для проверки.
     * @param errmsg сообщение для передачи исключению при сбое.
     */
    public static void checkNotInfinite(final double value,
                                        final String errmsg) {
        if (Double.isInfinite(value)) {
            throw new IllegalArgumentException(errmsg);
        }
    }

    /**
     * Проверяет, что введенный номер не является <code>NaN</code>, и если это так,
     * выдает исключение с указанным сообщением.
     *
     * @param value значение для проверки.
     * @param errmsg сообщение для передачи исключению при сбое.
     */
    public static void checkNotNaN(final double value, final String errmsg) {
        if (Double.isNaN(value)) {
            throw new IllegalArgumentException("The value is NaN.");
        }
    }

    /**
     * Проверяет, что входное число не является отрицательным, и если это так, выдает
     * исключение с указанным сообщением.
     *
     * @param value значение для проверки.
     * @param errmsg сообщение для передачи исключению при сбое.
     */
    public static void checkNotNegative(final double value,
                                        final String errmsg) {
        if (value < 0.0) {
            throw new IllegalArgumentException(errmsg);
        }
    }

    /**
     проверяет, что входная ссылка не является <code>null</code>, и если это так,
     * выдает исключение с предоставленным сообщением об ошибке.
     *
     * @param o ссылка для проверки.
     * @param errmsg сообщение для передачи исключению при сбое.
     */
    public static void checkNotNull(final Object o, final String errmsg) {
        if (o == null) {
            throw new IllegalArgumentException(errmsg);
        }
    }
}