package hw05;

public enum Parties {

    CARS_COUNT (4);

    private int number;

    Parties(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
