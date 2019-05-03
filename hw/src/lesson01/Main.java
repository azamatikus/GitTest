package lesson01;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String nums[] = {"1", "2"};

        swap(nums, 0, 1);
        System.out.println("nums:"+ Arrays.toString(nums));

        toList(nums);
        System.out.println("nums:"+ Arrays.toString(nums));

        //Большая задача:

        Box <Integer> appleBox = new Box<>(1.0f);
        Box <String> orangeBox = new Box<>(1.5f);

        Apple <Integer>  apple1 = new Apple<>();

        Orange <String> orange1 = new Orange<>();
        Orange <String> orange2 = new Orange<>();

        appleBox.addFruit(apple1);
        orangeBox.addFruit(orange1);
        orangeBox.addFruit(orange2);

        System.out.println(appleBox.compare(orangeBox));
    }

    public static <T> void swap (T[] array, int i, int j) {
        T t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    //Написать метод, который преобразует массив в ArrayList

    public static <T> void toList (T [] array) {
        List <T> list = Arrays.asList(array);
    }
 }