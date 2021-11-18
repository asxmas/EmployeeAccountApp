package empaccapp.organization;

import empaccapp.employees.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;

@Getter
@RequiredArgsConstructor
public class Organization {

    private int employeeId = 0;
    private final Set<Employee> employees = new HashSet<>();

    public void hire(Employee employee){

        employeeId++;
        employee.setId(employeeId);
        employee.setOrganization(this);
        employees.add(employee);
    }

    public void hireAll(List<Employee> employeeList){
        employeeList.forEach(this::hire);
    }

    public void dismissal(Employee employee){
        if(employees.isEmpty()){
            throw new IllegalArgumentException("The organization has no employees");
        }
        if(!employees.contains(employee)){
            throw new IllegalArgumentException("This employee is not on the staff");
        }
        employees.remove(employee);
    }

    public int getIncome(){
        return employees.stream().filter(e -> e.getSales() > 0).mapToInt(Employee::getSales).sum();
    }

    public List<Employee> sortEmployeesBySalary(){
        return employees.stream()
                .sorted(Comparator.comparing(Employee::getSalary))
                .toList();
    }
    public List<Employee> getLowestSalaryEmployees(int numOfEmployees){
        if(numOfEmployees < 0){
            throw new IllegalArgumentException("numOfEmployees must be greater than 0");
        }
        else {
            return sortEmployeesBySalary().stream().limit(numOfEmployees).toList();
        }
    }

    public List<Employee> getTopSalaryEmployees(int numOfEmployees){
        if(numOfEmployees <= 0){
            throw new IllegalArgumentException("numOfEmployees must be greater than 0");
        }
        else {
            if(numOfEmployees > employees.size()){
                numOfEmployees = employees.size();
            }
            ArrayList<Employee> topSalary = new ArrayList<>();
            for(int i = employees.size() - 1; i > employees.size() - numOfEmployees - 1; i--){
                topSalary.add(sortEmployeesBySalary().get(i));
            }
            return topSalary;
        }
    }

    public void printEmployeeList(List<Employee> listOfEmployees){
        listOfEmployees.forEach(e -> System.out.println(e.getFirstName()
                + " "
                + e.getLastName()
                + " ("
                + e.getPosition()
                + ") "
                + " - " + e.getMonthSalary()));
    }
}
