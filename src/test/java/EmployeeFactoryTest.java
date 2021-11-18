import empaccapp.employees.*;
import empaccapp.employees.enums.Position;
import empaccapp.employees.impl.Manager;
import empaccapp.employees.impl.Operator;
import empaccapp.employees.impl.TopManager;
import empaccapp.organization.EmployeesFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test of class EmployeeFactory")
class EmployeeFactoryTest {

    private static final int count = 10;

    @Test
    @DisplayName("Test of method createEmployee, create Operator")
    void createOperatorTest(){
        Employee employee = EmployeesFactory.createEmployee(Position.OPERATOR);
        assertEquals(employee.getClass().getSimpleName()
                , Operator.class.getSimpleName()
                , "The entity is not object of the Operator.class");
        assertTrue(employee instanceof Operator, "The entity is not object of the Operator.class");
        assertNotNull(employee.getFirstName(), "First Name is not filled");
        assertNotNull(employee.getLastName(), "Last Name is not filled");
        assertNotNull(employee.getPosition(), "Position is not filled");
        assertNull(employee.getOrganization(), "Organization is filled before hire");
        assertNotNull(employee.getGender(), "Gender is not filled");
        assertNotEquals(0, employee.getSalary(), "Salary is not filled");
        assertEquals(0, employee.getSales(), "Sales is filled, but this employee isn't manager");
    }

    @Test
    @DisplayName("Test of method createEmployee, create Manager")
    void createManagerTest(){
        Employee employee = EmployeesFactory.createEmployee(Position.MANAGER);
        assertEquals(employee.getClass().getSimpleName()
                , Manager.class.getSimpleName()
                , "The entity is not object of the Manager.class");
        assertTrue(employee instanceof Manager, "The entity is not object of the Manager.class");
        assertNotNull(employee.getFirstName(), "First Name is not filled");
        assertNotNull(employee.getLastName(), "Last Name is not filled");
        assertNotNull(employee.getPosition(), "Position is not filled");
        assertNull(employee.getOrganization(), "Organization is filled before hire");
        assertNotNull(employee.getGender(), "Gender is not filled");
        assertNotEquals(0, employee.getSalary(), "Salary is not filled");
        assertNotEquals(0, employee.getSales(), "Sales is not filled");
    }

    @Test
    @DisplayName("Test of method createEmployee, create Top Manager")
    void createTopManagerTest(){
        Employee employee = EmployeesFactory.createEmployee(Position.TOPMANAGER);
        assertEquals(employee.getClass().getSimpleName()
                , TopManager.class.getSimpleName()
                , "The entity is not object of the TopManager.class");
        assertTrue(employee instanceof TopManager, "The entity is not object of the TopManager.class");
        assertNotNull(employee.getFirstName(), "First Name is not filled");
        assertNotNull(employee.getLastName(), "Last Name is not filled");
        assertNotNull(employee.getPosition(), "Position is not filled");
        assertNull(employee.getOrganization(), "Organization is filled before hire");
        assertNotNull(employee.getGender(), "Gender is not filled");
        assertNotEquals(0, employee.getSalary(), "Salary is not filled");
        assertEquals(0, employee.getSales(), "Sales is filled, but this employee isn't manager");
    }

    @Test
    @DisplayName("Test of method createEmployeeList, create Operators")
    void createOperatorsListTest(){

        boolean instance = true;
        boolean fieldsFilled = true;
        List<Employee> employees = EmployeesFactory.createEmployeeList(Position.OPERATOR, count);
        for (Employee employee : employees){
            if(!(employee instanceof Operator)){
                instance = false;
                break;
            }

            if(employee.getFirstName() == null
                    || employee.getLastName() == null
                    || employee.getPosition() == null
                    || employee.getGender() == null
                    || employee.getOrganization() != null
                    || employee.getSalary() == 0
                    || employee.getSales() != 0) {
                fieldsFilled = false;
                break;
            }
        }
        assertTrue(instance, "Тot all employees belong to the class operator");
        assertTrue(fieldsFilled, "Not all employees contain the correct content");
        assertEquals(count, employees.size(), String.format("the list does not match the given length - %d", count));
    }

    @Test
    @DisplayName("Test of method createEmployeeList, create Managers")
    void createManagersListTest(){

        boolean instance = true;
        boolean fieldsFilled = true;
        List<Employee> employees = EmployeesFactory.createEmployeeList(Position.MANAGER, count);
        for (Employee employee : employees){
            if(!(employee instanceof Manager)){
                instance = false;
                break;
            }

            if(employee.getFirstName() == null
                    || employee.getLastName() == null
                    || employee.getPosition() == null
                    || employee.getGender() == null
                    || employee.getOrganization() != null
                    || employee.getSalary() == 0
                    || employee.getSales() == 0) {
                fieldsFilled = false;
                break;
            }
        }
        assertTrue(instance, "Тot all employees belong to the class manager");
        assertTrue(fieldsFilled, "Not all employees contain the correct content");
        assertEquals(count, employees.size(), String.format("the list does not match the given length - %d", count));
    }

    @Test
    @DisplayName("Test of method createEmployeeList, create TopManagers")
    void createTopManagersListTest(){

        boolean instance = true;
        boolean fieldsFilled = true;
        List<Employee> employees = EmployeesFactory.createEmployeeList(Position.TOPMANAGER, count);
        for (Employee employee : employees){
            if(!(employee instanceof TopManager)){
                instance = false;
                break;
            }

            if(employee.getFirstName() == null
                    || employee.getLastName() == null
                    || employee.getPosition() == null
                    || employee.getGender() == null
                    || employee.getOrganization() != null
                    || employee.getSalary() == 0
                    || employee.getSales() != 0) {
                fieldsFilled = false;
                break;
            }
        }
        assertTrue(instance, "Тot all employees belong to the class operator");
        assertTrue(fieldsFilled, "Not all employees contain the correct content");
        assertEquals(count, employees.size(), String.format("the list does not match the given length - %d", count));
    }
}
