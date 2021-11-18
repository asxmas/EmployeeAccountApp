package empaccapp.organization;

import empaccapp.employees.*;
import empaccapp.employees.enums.Position;
import empaccapp.employees.impl.*;

import java.util.ArrayList;
import java.util.List;

public class EmployeesFactory {

    private EmployeesFactory(){
        throw new IllegalStateException("Utility class");
    }
    public static Employee createEmployee(Position position){

        return
        switch (position){
            case MANAGER -> new Manager();
            case OPERATOR -> new Operator();
            case TOPMANAGER -> new TopManager();
        };
    }

    public static List<Employee> createEmployeeList(Position position, int employeeNums){
        List<Employee> listOfEmployees = new ArrayList<>();
        for(int i = 0; i < employeeNums; i++){
            listOfEmployees.add(createEmployee(position));
        }
        return listOfEmployees;
    }
}
