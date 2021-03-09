package Work;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(new Employee ("Ivan", 10,new BigDecimal("3000.00")),
                new Manager ("Petro",9,new BigDecimal("3000.00"),1.5),
                new Employee ("Stepan",8,new BigDecimal("4000.00")),
                new Employee ("Andriy",7, new BigDecimal("3500.00")),
                new Employee ("Ihor",5, new BigDecimal("4500.00")),
                new Manager ("Vasyl",8,new BigDecimal("2000.00"),2.0));
        MyUtils myUtils = new MyUtils();
        System.out.println(myUtils.largestEmployees(employees));
    }
}