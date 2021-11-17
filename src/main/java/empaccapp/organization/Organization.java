package empaccapp.organization;

import empaccapp.employees.Employee;
import empaccapp.employees.EmployeeImpl;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class Organization {

    private int employeeId = 0;
    private Set<EmployeeImpl> employees = new HashSet<>();

    public void hire(EmployeeImpl employee){

        employeeId++;
        employee.setOrganization(this);
        employees.add(employee);
    }

    public void hireAll(List<EmployeeImpl> employeeList){
        employeeList.forEach(this::hire);
    }

    public void dismissal(EmployeeImpl employee){
        if(employees.isEmpty()){
            System.out.println("The organization has no employees");
        }
        if(!employees.contains(employee)){
            System.out.println("This employee is not on the staff");
        }
        employees.remove(employee);
    }

    public int getIncome(){
        return employees.stream().filter(e -> e.getSales() > 0).mapToInt(EmployeeImpl::getSales).sum();
    }

    private List<EmployeeImpl> sortEmployeesBySalary(){
        return employees.stream()
                .sorted(Comparator.comparing(EmployeeImpl::getSalary))
                .collect(Collectors.toList());
    }
    public List<EmployeeImpl> getLowestSalaryEmployees(int numOfEmployees){
        if(numOfEmployees < 0){
            throw new IllegalArgumentException("numOfEmployees must be greater than 0");
        }
        else {
            return sortEmployeesBySalary().stream().limit(numOfEmployees).collect(Collectors.toList());
        }
    }

    public List<EmployeeImpl> getTopSalaryEmployees(int numOfEmployees){
        if(numOfEmployees < 0){
            throw new IllegalArgumentException("numOfEmployees must be greater than 0");
        }
        else {
            List<EmployeeImpl> list = sortEmployeesBySalary();
            Collections.reverse(list);
            return list.stream().limit(numOfEmployees).collect(Collectors.toList());
        }
    }

    public void printEmployeeList(List<EmployeeImpl> listOfEmployees){
        listOfEmployees.forEach(e -> System.out.println(e.getFirstName()
                + " "
                + e.getLastName()
                + " ("
                + e.getPosition()
                + ") "
                + " - " + e.getMonthSalary()));
    }
}
