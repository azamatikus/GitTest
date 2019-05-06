package hw01;

import java.util.ArrayList;


public class Box <T>{

    private ArrayList<T> list = new ArrayList<>();
    private Float fruitWeight;

    public Box(Float weight){
        this.fruitWeight = weight;
    }

    public void addFruit (T fruit){

        list.add(fruit);
    }

    public Float getWeight(){

        float sum = 0;

        for (int i=0; i<list.size(); i++){
            sum += list[i].floatValue();
        }
        return sum * fruitWeight;
    }

    public boolean compare (Box<?> box) {

        return this.getWeight().equals(box.getWeight());
    }
}
