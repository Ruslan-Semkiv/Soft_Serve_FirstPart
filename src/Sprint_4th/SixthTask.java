package Sprint_4th;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Double.compare(employee.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Developer developer = (Developer) o;
        return level == developer.level;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), level);
    }
}
enum Level{
    JUNIOR,MIDDLE,SENIOR;
}

////////////////////////////////////////////////////////////////////////////////////////

class PersonComparator implements Comparator<Person> {


    @Override
    public int compare(Person o1, Person o2) {
        int index = String.CASE_INSENSITIVE_ORDER.compare(o1.name, o2.name);
        if(index==0){
            index = Integer.compare(o1.age,o2.age);
        }
        return index;
    }
}
class EmployeeComparator implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        int index = String.CASE_INSENSITIVE_ORDER.compare(o1.name, o2.name);
        if(index==0){
            index = Integer.compare(o1.age, o2.age);
            if(index==0){
                index = Double.compare(o1.getSalary(),o2.getSalary());
            }
        }
        return  index;
         }
}

class DeveloperComparator implements Comparator<Developer>{

    @Override
    public int compare(Developer o1, Developer o2) {
        int index = String.CASE_INSENSITIVE_ORDER.compare(o1.name,o2.name);
        if(index==0){
            index = Integer.compare(o1.age, o2.age);
            if(index==0){
                index = Double.compare(o1.getSalary(), o2.getSalary());
                if(index==0){
                    index = o1.getLevel().compareTo(o2.getLevel());
                }
            }
        }
        return index;
    }
}


class Utility {

    public static <T> void sortPeople(T [] array, Comparator<T> comparator){
        Arrays.sort(array,comparator);
    }
}