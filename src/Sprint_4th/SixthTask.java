package Sprint_4th;

import java.util.Arrays;
import java.util.Comparator;

public class SixthTask {
}

class Person{
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age; }

    public String getName() {
        return name; }

    public int getAge() {
        return age; }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}'; }
}

class Employee extends Person{
    private double salary;
    public Employee(String name, int age,double salary) {
        super(name, age);
        this.salary = salary;
    }

    public double getSalary() {
        return salary; }

    @Override
    public String toString() {
        return super.toString() + ", Salary: " + salary;
    }
}

class Developer extends Employee{
    private Level level;

    public Developer(String name, int age, double salary,Level level) {
        super(name, age, salary);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return super.toString() + ", Level: " + level;
    }
}
enum Level{
    JUNIOR,MIDDLE,SENIOR;
}


class PersonComparator <Person> implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        return 0;
    }
}
class EmployeeComparator <Employee>implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return 0; }
}

class DeveloperComparator <Developer> implements Comparator<Developer>{


    @Override
    public int compare(Developer o1, Developer o2) {
        return 0;
    }
}


class Utility {

    public static <T extends Person > void sortPeople(T [] array, Comparator<T> comparator){

    }
}