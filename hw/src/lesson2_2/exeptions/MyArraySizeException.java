package lesson2_2.exeptions;

public class MyArraySizeException extends Exception {

    public MyArraySizeException() {
        super("Некорректный размер массива");
    }
}