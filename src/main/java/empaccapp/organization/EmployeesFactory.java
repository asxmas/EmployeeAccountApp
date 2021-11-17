package empaccapp.organization;

import empaccapp.employees.EmployeeImpl;
import empaccapp.employees.Manager;
import empaccapp.employees.Operator;
import empaccapp.employees.TopManager;
import empaccapp.employees.enums.Position;

import java.util.ArrayList;
import java.util.List;

public class EmployeesFactory {

    public static EmployeeImpl createEmployee(Position position){

        return
        switch (position){
            case MANAGER -> new Manager();
            case OPERATOR -> new Operator();
            case TOPMANAGER -> new TopManager();
        };
    }

    public static List<EmployeeImpl> createEmployeeList(Position position, int employeeNums){
        List<EmployeeImpl> listOfEmployees = new ArrayList<>();
        for(int i = 0; i < employeeNums; i++){
            listOfEmployees.add(createEmployee(position));
        }
        return listOfEmployees;
    }
}
