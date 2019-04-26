package lesson2;

import lesson2.exeptions.MyArrayDataException;
import lesson2.exeptions.MyArraySizeException;

public class ExeptionsHW {

    private final static int SIZE = 4;

    public static void main(String[] args) {
        String testArr[][] = {
                {"1", "2", "3", "4"},
                {"-1", "2", "-3", "4"},
                {"1", "20", "3", "4"},
                {"1", "22", "-3", "4"}};

        try {
            System.out.println("Сумма массива " + mysuperCorrectArrayMethod(testArr));
        } catch (MyArraySizeException | MyArrayDataException e) {
            System.out.println(e);
        }
    }

    public static int mysuperCorrectArrayMethod(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int res = 0;

        if (arr.length != SIZE) {
            throw new MyArraySizeException();
        }

        for (int i=0; i<arr.length; i++) {
            if (arr[i].length != SIZE) {
                throw new MyArraySizeException();
            }

            for (int j=0; j<arr[i].length; j++) {
                try {
                    res += Integer.valueOf(arr[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j, arr[i][j], e);
                }
            }
        }

        return res;
    }
}
