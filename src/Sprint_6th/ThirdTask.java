package Sprint_6th;

import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;
class Appp {
    public static BinaryOperator <String> greetingOperator = new BinaryOperator<String>() {
        @Override
        public String apply(String s, String s2) {
            return "Hello " + s + " " + s2 + "!!!";
        }
    };

    public static List<String> createGreetings(List<Person1> people,BinaryOperator<String> binaryOperator) {
       List<String> lister = new ArrayList<>();
       for(Person1 person:people){
           lister.add(binaryOperator.apply(person.name, person.surname));
       }
      return lister;
    }
}
class Person1 {
    String name;
    String surname;

    public Person1(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}