package lesson01;

public class Apple <T> extends Fruit{

    private Float weight = 1.0f;
    T [] apples;

    public Apple(T...apples) {
        this.apples = apples;
    }

    @Override
    public Float getWeight() {
        return weight;
    }
}
