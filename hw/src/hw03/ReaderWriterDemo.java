package hw03;

import java.io.*;

public class ReaderWriterDemo {

    public static void main(String[] args) throws IOException {
        // Переход от InputStream к Reader
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("history_login.txt")))) {
            while (in.ready()) {
                System.out.println(in.readLine());
            }
        }

        // Но можно проще, через FileReader, который объединяет InputStreamReader и FileInputStream
        try (BufferedReader reader = new BufferedReader(
                new FileReader("history_login.txt"))) {

            while (reader.ready()) {
                System.out.println(reader.readLine());
            }
        }

        File textFile = new File("history_login.txt");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(textFile))) {
            writer.write("Строка 1\n");
            writer.write("Строка 2\n");
            writer.write("Строка 3\n");
        }

        // У конструктора класса FileWriter есть второй параметр, который указывает
        // нужно ли создать новый файл или дописывать данные в конец существующего файла
        File printTextFile = new File("history_login.txt");
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(printTextFile, true)))) {
            writer.println("Строка 1");
            writer.println("Строка 2");
            writer.println("Строка 3");
        }

                try (RandomAccessFile raf = new RandomAccessFile("history_ivan.txt", "r")) {
                    raf.seek(5);
                    System.out.println((char) raf.read());
                } catch (IOException e) {
                    e.printStackTrace();
                }

        }

}