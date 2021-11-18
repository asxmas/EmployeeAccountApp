# EmployeeAccountApp
A program that implements the functionality for accounting for employees:

    -hiring one employee - hire(Employee employee)
    -hiring a list of employees - hireAll(List<Employee> list)
    -dismissing an employee - dismissal(Employee employee)
    -getting the value of the company's income - getIncome()
    -get a list of the highest salaries - getTopSalaryEmployees(int count)
    -get a list of the lowest salaries - getLowestSalaryEmployees(int count)
    -print list of employees - printEmployeeList(List<Employee> listOfEmployees)

Employees classes:

    -Manager - the salary consists of a fixed part and a bonus in the form of 5% of earnings for the company,
    the salary is randomly generated from 120,000 to 160,000 rubles.
    the amount of earnings for the company is randomly generated from 115,000 to 140,000 rubles.
    -TopManager - the salary consists of a fixed part (from 220,000 to 280,000 rubles) and a bonus in the form of 150% of the salary if the company's income is more than 10 million rubles.
    -Operator - the salary consists of a fixed part only (from 40,000 to 60,000 rubles).

To demonstrate how the code works, run the Main class.