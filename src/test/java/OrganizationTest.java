import empaccapp.employees.Employee;
import empaccapp.employees.enums.Position;
import empaccapp.organization.EmployeesFactory;
import empaccapp.organization.Organization;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class OrganizationTest {

    private Organization organization;
    private List<Employee> employeeList;

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

        Employee operator = EmployeesFactory.createEmployee(Position.OPERATOR);
        organization.hire(operator);
        assertEquals(employeesCountBeforeTest + 1
                , organization.getEmployees().size()
                , String.format("Size of organization isn't equal to %d.", employeesCountBeforeTest + 1));
        assertTrue(organization.getEmployees().contains(operator)
                , operator.toString().concat(" - not found on the staff of the organization."));
        assertNotEquals(0, operator.getId(), "Employee have no id.");
        assertNotNull(operator.getOrganization(), "Organization not defined.");

    }

    @Test
    @DisplayName("Test of method hireAll")
    void hireEmployees(){
        organization.hireAll(employeeList);
        assertEquals(employeeList.size()
                , organization.getEmployees().size()
                , "employees isn't equal hired employees");
        employeeList.forEach(employee -> {
            assertTrue(organization.getEmployees().contains(employee)
                    , employee.toString().concat(" - not found on the staff of the organization."));
            assertNotEquals(0, employee.getId(), "Employee have no id.");
            assertNotNull(employee.getOrganization(), "Organization not defined.");
        });
    }

    @Test
    @DisplayName("Test of method dismissal")
    void dismissalEmployee(){
        organization.hireAll(employeeList);
        int hiredEmployeesCountBeforeDismissal = organization.getEmployees().size();
        Employee employee = employeeList.get(new Random().nextInt(employeeList.size()));
        organization.dismissal(employee);
        assertEquals(hiredEmployeesCountBeforeDismissal - 1
                , organization.getEmployees().size()
                , String.format("Size of organization isn't equal to %d.", hiredEmployeesCountBeforeDismissal - 1));
        assertFalse(organization.getEmployees().contains(employee), "Employee isn't dismissed");
    }

    @Test
    @DisplayName("Test of method dismissal if employee don't be hire")
    void dismissalNotHiredEmployee(){
        organization.hireAll(employeeList);
        int hiredEmployeesCountBeforeTest = organization.getEmployees().size();
        Employee employee = EmployeesFactory.createEmployee(Position.TOPMANAGER);
        assertEquals(hiredEmployeesCountBeforeTest
                , organization.getEmployees().size()
                , "Size of employees changed after incorrect dismissal");
        assertThrows(IllegalArgumentException.class
                , () -> organization.dismissal(employee)
                , "This employee is not on the staff");
    }

    @Test
    @DisplayName("Test of method dismissal if organization is empty")
    void dismissalOfEmptyOrganization(){
        Employee employee = EmployeesFactory.createEmployee(Position.OPERATOR);
        assertThrows(IllegalArgumentException.class
                , () -> organization.dismissal(employee)
                , "Employee has been dismissal from empty organization");
    }

    @Test
    @DisplayName("Test of method getIncome without managers")
    void getIncomeTestWithoutManagers() {
        int salesWithoutManagers = 0;
        assertEquals(salesWithoutManagers
                , organization.getIncome()
                , "Sales without managers isn't equal to 0");
    }

    @Test
    @DisplayName("Test of method getIncome with managers")
    void getIncomeTestWithManagers() {
        int sales = employeeList.stream().mapToInt(Employee::getSales).sum();
        organization.hireAll(employeeList);
        assertEquals(sales
                , organization.getIncome()
                , "Income of organization not equal to sales of Managers");

    }

    @Test
    @DisplayName("Test of method getIncome with manager")
    void getIncomeTestWithManager() {

        Employee employee = EmployeesFactory.createEmployee(Position.MANAGER);
        organization.hire(employee);
        int salesAfterHireNewManager = employee.getSales();
        assertEquals(salesAfterHireNewManager
                , organization.getIncome()
                , "Income of organization not equal to sales of Managers after hire new Manager");
    }

    @Test
    @DisplayName("Test of method getIncome after dismissal manager")
    void getIncomeTestAfterDismissalManager() {

        organization.hireAll(employeeList);
        Optional<Employee> optionalEmployee = organization.getEmployees().stream().filter(e -> e.getPosition().equals(Position.MANAGER)).findFirst();
        Employee manager = optionalEmployee.orElseThrow();
        int salesAfterDismissalManager = employeeList.stream().mapToInt(Employee::getSales).sum() - manager.getSales();
        organization.dismissal(manager);
        assertEquals(salesAfterDismissalManager
                , organization.getIncome()
                , "Income of organization not equal to sales of Managers after dismissal Manager");
    }

    @Test
    @DisplayName("Test of method getIncome after hire and dismissal Operators and Top Managers")
    void getIncomeTestAfterHireOperatorsAndTopManagers() {
        organization.hireAll(employeeList);
        int salesBeforeHireManagersAndOperators = employeeList.stream().mapToInt(Employee::getSales).sum();

        //hire operator
        Employee operator = EmployeesFactory.createEmployee(Position.OPERATOR);
        organization.hire(operator);
        assertEquals(salesBeforeHireManagersAndOperators
                , organization.getIncome()
                , "Income of organization changed after hiring of Operator");

        //hire manager
        Employee topManager = EmployeesFactory.createEmployee(Position.TOPMANAGER);
        organization.hire(topManager);
        assertEquals(salesBeforeHireManagersAndOperators
                , organization.getIncome()
                , "Income of organization changed after hiring of Top Manager");
    }

    @Test
    @DisplayName("Test of method getIncome after dismissal Operators and Top Managers")
    void getIncomeTestAfterDismissalOperatorsAndTopManagers() {

        organization.hireAll(employeeList);
        int salesBeforeDismissalManagersAndOperators = employeeList.stream().mapToInt(Employee::getSales).sum();

        //dismissal operator
        Optional<Employee> optionalOperator = organization.getEmployees()
                .stream()
                .filter(e -> e.getPosition().equals(Position.OPERATOR))
                .findFirst();
        Employee operatorToDismissal = optionalOperator.orElseThrow();
        organization.dismissal(operatorToDismissal);
        assertEquals(salesBeforeDismissalManagersAndOperators
                , organization.getIncome()
                , "Income of organization changed after dismissal of Operator");

        //dismissal top manager
        Optional<Employee> optionalTopManager = organization.getEmployees()
                .stream()
                .filter(e -> e.getPosition().equals(Position.TOPMANAGER))
                .findFirst();
        Employee topManagerToDismissal = optionalTopManager.orElseThrow();
        organization.dismissal(topManagerToDismissal);
        assertEquals(salesBeforeDismissalManagersAndOperators
                , organization.getIncome()
                , "Income of organization changed after dismissal of Top Manager");
    }

    @Test
    @DisplayName("Test of method sortEmployeesBySalary")
    void sortEmployeesBySalaryTest(){

        assertTrue(organization.sortEmployeesBySalary().isEmpty(), "List of employees not empty in empty organization");

        organization.hireAll(employeeList);
        List<Employee> sortedListOfEmployees = organization.sortEmployeesBySalary();
        boolean isListSorted = true;
        for (int i = 0; i < sortedListOfEmployees.size() - 1; i++){
            isListSorted = sortedListOfEmployees.get(i).getMonthSalary() <= sortedListOfEmployees.get(i + 1).getMonthSalary();
            if(!isListSorted) break;
        }
        assertTrue(isListSorted, "Employees not sorted by salary");
    }

    @Test
    @DisplayName("Test of method get getLowestSalaryEmployees")
    void getLowestSalaryEmployeesTest(){
        organization.hireAll(employeeList);
        int count = 20;
        List<Employee> lowestSalaryList = organization.getLowestSalaryEmployees(count);
        assertEquals(count, lowestSalaryList.size());

        int countGreaterThanOrganizationSize = organization.getEmployees().size() + 100;
        List<Employee> lowestSalaryListGreaterThanOrganizationSize = organization.getLowestSalaryEmployees(countGreaterThanOrganizationSize);
        int countOfOrganization = organization.getEmployees().size();
        List<Employee> topSalaryListForCountGreaterThanOrganizationSize = organization.getLowestSalaryEmployees(countGreaterThanOrganizationSize);
        assertNotEquals(countGreaterThanOrganizationSize
                , lowestSalaryListGreaterThanOrganizationSize.size()
                , "Count of Lowest salary list greater than count of organization employees");
        assertEquals(countOfOrganization
                , lowestSalaryListGreaterThanOrganizationSize.size()
                , "Count of Lowest salary list not equals to count of organization employees");

        boolean isListSorted = true;
        for (int i = 0; i < lowestSalaryList.size() - 1; i++){
            isListSorted = lowestSalaryList.get(i).getMonthSalary() <= topSalaryListForCountGreaterThanOrganizationSize.get(i + 1).getMonthSalary();
            if(!isListSorted) break;
        }
        assertTrue(isListSorted, "Employees with lowest salary is not sorted by salary");

        Optional<Employee> optionalEmployee = lowestSalaryList.stream().max((Employee::compareTo));
        int topSalaryInLowest = optionalEmployee.orElseThrow().getMonthSalary();
        List<Employee> employeesWithoutLowestList = organization.getEmployees()
                .stream()
                .filter(employee -> !lowestSalaryList.contains(employee))
                .collect(Collectors.toList());
        List<Employee> listOfEmployeesWithSalaryLowerThanLowestSalaryList = employeesWithoutLowestList
                .stream()
                .filter(employee -> employee.getMonthSalary() < topSalaryInLowest).collect(Collectors.toList());
        assertTrue(listOfEmployeesWithSalaryLowerThanLowestSalaryList.isEmpty()
                , "Employees were found with salaries less than those presented in the list with the lowest salaries");
    }

    @Test
    @DisplayName("Test of method get getTopSalaryEmployees")
    void getTopSalaryEmployeesTest(){
        organization.hireAll(employeeList);
        int count = 20;
        List<Employee> topSalaryList = organization.getTopSalaryEmployees(count);
        assertEquals(count, topSalaryList.size());

        int countGreaterThanOrganizationSize = organization.getEmployees().size() + 100;
        List<Employee> topSalaryListForCountGreaterThanOrganizationSize = organization.getTopSalaryEmployees(countGreaterThanOrganizationSize);
        assertNotEquals(countGreaterThanOrganizationSize
                , topSalaryList.size()
                , "Count of Top salary list greater than count of organization employees");
        assertEquals(count
                , topSalaryList.size()
                , "Count of Top salary list not equals to count of organization employees");

        boolean isListSorted = true;
        for (int i = 0; i < topSalaryList.size() - 1; i++){
            isListSorted = topSalaryList.get(i).getMonthSalary() >= topSalaryListForCountGreaterThanOrganizationSize.get(i + 1).getMonthSalary();
            if(!isListSorted) break;
        }
        assertTrue(isListSorted, "Employees with lowest salary is not sorted by salary");

        Optional<Employee> optionalEmployee = topSalaryList.stream().min((Employee::compareTo));
        int lowestSalaryInTop = optionalEmployee.orElseThrow().getMonthSalary();
        Set<Employee> employeesWithoutTopList = organization.getEmployees();
        List<Employee> listOfEmployeesWithSalaryLowerThanLowestSalaryList = employeesWithoutTopList
                .stream()
                .filter(employee -> !topSalaryList.contains(employee))
                .filter(employee -> employee.getMonthSalary() >= lowestSalaryInTop).collect(Collectors.toList());
        assertTrue(listOfEmployeesWithSalaryLowerThanLowestSalaryList.isEmpty()
                , "Employees were found with salaries greater than those presented in the list with the top salaries");
    }
}
