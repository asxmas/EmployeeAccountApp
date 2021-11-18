import empaccapp.employees.Employee;
import empaccapp.employees.enums.Position;
import empaccapp.employees.enums.Rate;
import empaccapp.organization.EmployeesFactory;
import empaccapp.organization.Organization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Test of class TopManager")
class TopManagerTest {

    private Employee employee;
    private Organization organization;

    @BeforeEach
    public void setUp(){
        employee = EmployeesFactory.createEmployee(Position.TOPMANAGER);
        organization = new Organization();
        organization.hire(employee);
    }

    @Test
    @DisplayName("Test of method getMonthSalary")
    void getMonthSalary(){
        int expected = employee.getSalary();
        assertEquals(0, organization.getIncome(), "Organization income not equals to 0");
        assertEquals(expected, employee.getMonthSalary(), "MonthSalary not equals to fix salary");
    }

    @Test
    @DisplayName("Test of method getMonthSalary when income less than KPI")
    void getMonthSalaryIncomeLessKPI(){

        int expectedSalary = employee.getSalary();
        organization.hireAll(EmployeesFactory.createEmployeeList(Position.MANAGER, 50));
        assertTrue(organization.getIncome() > 0, "Organization income greater than 0");
        assertTrue(organization.getIncome() < Rate.ORGANIZATION_INCOME_PROFIT_FOR_BONUS.getValue()
                , "Organization income less than income for bonus");
        assertEquals(expectedSalary, employee.getMonthSalary(), "TopManager month salary not equal to salary");
    }

    @Test
    @DisplayName("Test of method getMonthSalary when income greater than KPI")
    void getMonthSalaryIncomeGreaterKPI(){
        int expectedSalary = employee.getSalary() * Rate.TOP_MANAGER_BONUS_PERCENT.getValue() / 100;
        organization.hireAll(EmployeesFactory.createEmployeeList(Position.MANAGER, 100));
        assertTrue(organization.getIncome() > 0, "Organization income greater than 0");
        assertTrue(organization.getIncome() > Rate.ORGANIZATION_INCOME_PROFIT_FOR_BONUS.getValue()
                , "Organization income less than income for bonus");
        assertEquals(expectedSalary, employee.getMonthSalary(), "TopManager month salary not equal to salary with bonus");
    }
}
