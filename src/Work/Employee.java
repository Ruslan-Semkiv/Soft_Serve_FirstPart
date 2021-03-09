package Work;





import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private final String name;
    private final int experience;
    private final BigDecimal basePayment;

    public Employee(String name, int experience, BigDecimal payment) {
        this.name = name;
        this.experience = experience;
        basePayment = payment;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return experience == employee.experience && Objects.equals(basePayment, employee.basePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experience, basePayment);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", basePayment=" + basePayment +
                '}';
    }
}


class Manager extends Employee {
    private double coefficient;

    public Manager(String name, int experience, BigDecimal payment, double coefficient) {
        super(name, experience, payment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }


    @Override
    public BigDecimal getPayment() {
        BigDecimal a = super.getPayment();
        return a.multiply(BigDecimal.valueOf(getCoefficient()));
    }


    @Override
    public String toString() {
        return "Manager{" +
                "coefficient=" + coefficient +
                '}';
    }

}


class MyUtils {
    public List<Employee> largestEmployees(List<Employee> workers) {
        List<Employee> generalEmployees = new ArrayList<>();
        List<Manager> generalManagers = new ArrayList<>();
        // Тут я поділив їх на два табори
        double maxEmployeePay = 0;
        double maxManagerPay = 0;
        int maxEmployeeExp = 0;
        int maxManagerExp = 0;
        List<Employee> largestEmployees = new ArrayList<>();
        if(!workers.isEmpty()){
            Set<Employee> uniqueEmployees= new HashSet<>(workers);
            for(Employee employee: uniqueEmployees){
                if(employee == null){ return workers;}
                if(employee instanceof Manager){
                    maxManagerExp = Math.max(maxManagerExp,employee.getExperience());
                    maxManagerPay = Math.max(maxManagerPay,employee.getPayment().doubleValue());
                }
                else {
                    maxEmployeeExp = Math.max(maxEmployeeExp,employee.getExperience());
                    maxEmployeePay = Math.max(maxEmployeePay,employee.getPayment().doubleValue());
                }
            }
            for(Employee employee: uniqueEmployees){
                if(employee instanceof Manager){
                    if(employee.getExperience()==maxManagerExp || employee.getPayment().doubleValue()==maxManagerPay){
                        largestEmployees.add(employee);
                    }
                }
                else {
                    if(employee.getExperience()==maxEmployeeExp || employee.getPayment().doubleValue()==maxEmployeePay){
                        largestEmployees.add(employee);
                    }
                }
            }
        }

        return largestEmployees;
    }
}

