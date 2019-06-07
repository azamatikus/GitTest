package hw06;

import java.util.Arrays;

public class Main {


    public static void main(String[] args) {

        int[] arr = {1, 2, 4, 4, 5, 6, 4, 7, 8};
        int[] arr2 = {1, 3};

        int target = 4;

        System.out.println(Arrays.toString(find(arr, target)));


        System.out.println(find2(arr2));

    }

    public static int[] find(int[] array, int target) {

        int counter = array.length;

        for (int i = array.length - 1; i > 0; i--) {

            if (array[i] == target) {

                int[] newArr = Arrays.copyOfRange(array, counter, array.length);

                return newArr;

            }

            counter--;
        }

        throw new RuntimeException("Этого числа нет в массиве!");

    }

    public static boolean find2(int[] array) {

        for (int s : array) {
            if (s == 1 || s == 4) {
               return true;
            }
        }

        return false;
    }
}
