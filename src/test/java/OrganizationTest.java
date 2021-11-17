import empaccapp.employees.EmployeeImpl;
import empaccapp.employees.enums.Position;
import empaccapp.organization.EmployeesFactory;
import empaccapp.organization.Organization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//hire
//hireAll
//dismisal
//getIncome
//sortEmployeesBySalary
//getLowestSalaryEmployees
//getTopSalaryEmployees


public class OrganizationTest {

    private Organization organization;
    private List<EmployeeImpl> employeeList;

    @BeforeEach
    public void setUp(){
        organization = new Organization();
        employeeList = new ArrayList<>();

        employeeList.addAll(EmployeesFactory.createEmployeeList(Position.OPERATOR, 180));
        employeeList.addAll(EmployeesFactory.createEmployeeList(Position.MANAGER, 80));
        employeeList.addAll(EmployeesFactory.createEmployeeList(Position.TOPMANAGER, 10));
    }

    @Test
    @DisplayName("Test of method hire")
    void hireEmployee(){
        organization.hireAll(employeeList);
        int employeesCountBeforeTest = organization.getEmployees().size();

        EmployeeImpl operator = EmployeesFactory.createEmployee(Position.OPERATOR);
        organization.hire(operator);
        assertEquals(employeesCountBeforeTest + 1
                , organization.getEmployees().size()
                , String.format("Size of organization isn't equal to %d.", employeesCountBeforeTest + 1));
        assertTrue(organization.getEmployees().contains(operator)
                , operator.toString().concat(" - not found on the staff of the organization."));
        assertTrue(operator.getId() != 0, "Employee have no id.");
        assertNotNull(operator.getOrganization(), "Organization not defined.");

    }
}
