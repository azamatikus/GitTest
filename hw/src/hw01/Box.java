package hw01;

import java.util.ArrayList;

public class Box <T extends Fruit>{

    private ArrayList<T> list = new ArrayList<>();


    public void addFruit (T fruit){

        list.add(fruit);
    }

    public Float getWeight(){

        float sum = 0;

        for (Fruit fr: list){
            sum += fr.getWeight();
        }
        return sum;
    }

    public boolean compare (Box<?> box) {

        return this.getWeight().equals(box.getWeight());
    }

    public void moveFromBox (Box<T> box) {

        list.addAll(box.list);
        box.list.clear();
    }
}
