package ee;

public class Person {
    String Full_name;
    int age;
    String password;

    //  constructor  for setting name and age
    public Person(String full_name, int age) {
        Full_name = full_name;
        this.age = age;
    }

    public void setFull_name(String full_name) {
        Full_name = full_name;
    }

    public void setAge(int age) {

        if (age >= 0) {

            this.age = age;
        } else {
            System.out.println("Вік не може бути  від'ємний");
        }
    }

    public String getFull_name() {
        return Full_name;
    }

    public int getAge() {
        return age;
    }

    // overload of constructor
    Person(String password, String full_name) {
        this.password = password;
        Full_name = full_name;
    }


}
