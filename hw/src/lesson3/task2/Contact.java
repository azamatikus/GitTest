package lesson3.task2;

public class Contact {
    String phone;
    String phone2;
    String name;

    public Contact(String _name, String _phone){
        this.phone = _phone;
        this.name = _name;
    }

    public Contact(String _name, String _phone, String _phone2){
        this.phone = _phone;
        this.phone2 = _phone2;
        this.name = _name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }
}
