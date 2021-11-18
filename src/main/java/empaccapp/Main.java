package empaccapp;

import empaccapp.employees.*;
import empaccapp.employees.enums.Position;
import empaccapp.organization.EmployeesFactory;
import empaccapp.organization.Organization;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Organization organization = new Organization();
        ArrayList<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.addAll(EmployeesFactory.createEmployeeList(Position.OPERATOR, 180));
        listOfEmployees.addAll(EmployeesFactory.createEmployeeList(Position.MANAGER, 80));
        listOfEmployees.addAll(EmployeesFactory.createEmployeeList(Position.TOPMANAGER, 10));
        organization.hireAll(listOfEmployees);

        System.out.println("Top 15 salary");
        organization.printEmployeeList(organization.getTopSalaryEmployees(15));
        System.out.println("\nLowest 15 salary");
        organization.printEmployeeList(organization.getLowestSalaryEmployees(15));
    }
}
