import static org.junit.jupiter.api.Assertions.assertEquals;

import empaccapp.employees.Employee;
import empaccapp.employees.enums.Position;
import empaccapp.organization.EmployeesFactory;
import empaccapp.organization.Organization;
import org.junit.jupiter.api.*;

@DisplayName("Test of class Operator")
class OperatorTest {

    private Employee employee;

    @BeforeEach
    public void setUp(){
        employee = EmployeesFactory.createEmployee(Position.OPERATOR);
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
