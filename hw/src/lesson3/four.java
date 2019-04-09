package lesson3;

import java.util.*;

public class four {
    public static void main(String[] args) {

        //Задание 1
        //создаем массив с повторяющимися строками

        List<String> myArray = Arrays.asList("мама",
                "папа",
                "сын",
                "дочка",
                "бабушка",
                "дедушка",
                "сын", // повтор
                "собачка",
                "дочка", // повтор
                "попугай");
        System.out.println(myArray);

        //результат
        //[мама, папа, сын, дочка, бабушка, дедушка, сын, собачка, дочка, попугай]

        //----------------------------------------------------------------------------------------
        //выводим только уникальные строки:

        Set<String> set = new HashSet<>(myArray);

        System.out.println("Set values .....");
        for (String temp : set){
            System.out.println(temp);
        }

        //результат без повторов:

        /*Set values .....
          дедушка
          сын
          попугай
          мама
          бабушка
          собачка
          дочка
          папа*/

        //Посчитать, сколько раз встречается каждое слово
        Map<String, Integer> myMap = new HashMap<>();


        for (String myWord : myArray) {
            Integer counter = myMap.get(myWord);
            if(counter == null) {
                counter = 0;
            }
            myMap.put(myWord, (counter +1));
        }

        System.out.println(myMap.toString());

        //{дедушка=1, сын=2, попугай=1, мама=1, бабушка=1, собачка=1, дочка=2, папа=1}

        //задание 2

        Map<String, List<String>> contacts = new HashMap<>();

    }
}
