package hw01;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        String nums[] = {"1", "2"};

        swap(nums, 0, 1);
        System.out.println("nums:"+ Arrays.toString(nums));

        toList(nums);
        System.out.println("nums:"+ Arrays.toString(nums));

        //Большая задача:

        Box <Fruit> appleBox = new Box<>();
        Box <Fruit> orangeBox = new Box<>();

        Apple apple1 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

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

    public static <T> List<T> toList (T [] array) {
//        List <T> list = Arrays.asList(array);
        List <T> list = new ArrayList<>();
        Collections.addAll(list, array);

        return list;
    }
 }