import static org.junit.jupiter.api.Assertions.assertEquals;
import empaccapp.employees.EmployeeImpl;
import empaccapp.employees.enums.Position;
import empaccapp.organization.EmployeesFactory;
import empaccapp.organization.Organization;
import org.junit.jupiter.api.*;

@DisplayName("Test of class Operator")
public class OperatorTest {

    private EmployeeImpl employee;
    private Organization organization;

    @BeforeEach
    public void setUp(){
        employee = EmployeesFactory.createEmployee(Position.OPERATOR);
        organization = new Organization();
        organization.hire(employee);
    }

    @Test
    @DisplayName("Test of method getMonthSalary")
    void getMonthSalary(){
        int expected = employee.getSalary();
        assertEquals(expected, employee.getMonthSalary());
    }
}
