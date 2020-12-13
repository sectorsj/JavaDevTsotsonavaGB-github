package ru.geekbrains.creatingatest;

public final class ArrayUtils {

    private static final int EMPTY_INDEX = -1;
    private ArrayUtils() {}

    public static int[]findElementAfterDigit(int[]numbers, int digit) {
        if (numbers == null || numbers.length == 0) {
            throw new RuntimeException("Array cannot be null or empty");
        }

        int idx = EMPTY_INDEX;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == digit) {
                idx = i + 1;
            }
        }

        if (idx == EMPTY_INDEX) {
            throw new RuntimeException("Array does not contain any digit like: " + digit);
        }

        int size = numbers.length - idx;
        int[] foundValues = new int[numbers.length - idx];
        System.arraycopy(numbers, idx, foundValues, 0, size);

        return foundValues;
    }
}
