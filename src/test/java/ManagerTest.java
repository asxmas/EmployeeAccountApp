import empaccapp.employees.Employee;
import empaccapp.employees.enums.Position;
import empaccapp.organization.EmployeesFactory;
import empaccapp.organization.Organization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test of class Manager")
class ManagerTest {

    private Employee employee;

    @BeforeEach
    public void setUp(){
        employee = EmployeesFactory.createEmployee(Position.MANAGER);
        Organization organization = new Organization();
        organization.hire(employee);
    }

    @Test
    @DisplayName("Test of method getMonthSalary")
    void getMonthSalary(){
        int expected = employee.getSalary();
        assertEquals(expected, employee.getMonthSalary(), "MonthSalary not equals to fix salary");
    }
}
