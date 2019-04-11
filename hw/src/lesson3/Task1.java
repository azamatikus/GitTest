package lesson3;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {

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

        //второй менее эффективный вариант

        Map<String, Integer> myMap2 = new HashMap<>();

        for (String myWord : myArray) {
            Integer counter = 0;
//            Collections.frequency();
            for (String myWord2 : myArray) {
                if (myWord.equals(myWord2)){
                    counter ++;
                }
            }

                myMap2.put(myWord, counter);
        }

        System.out.println(myMap2.toString());

        //{дедушка=1, сын=2, попугай=1, мама=1, бабушка=1, собачка=1, дочка=2, папа=1}

        //способ преподователя

        Map<String, Integer> myMap3 = new HashMap<>();
        for (String myWord : myArray) {
            myMap3.putIfAbsent(myWord, 0);
//            myMap3.computeIfPresent(myWord, (key, val) -> val +1);
            int cnt = myMap3.get(myWord);
            myMap3.put(myWord, (cnt+1));

        }

        System.out.println(myMap3.toString());

    }
}
