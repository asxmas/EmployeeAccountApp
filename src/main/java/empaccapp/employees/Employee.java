package empaccapp.employees;

public interface Employee extends Comparable<Employee> {

    int getMonthSalary();

    default int compareTo(Employee employee){
        if (getMonthSalary() > employee.getMonthSalary()) {
            return -1;
        }
        if (getMonthSalary() < employee.getMonthSalary()) {
            return 1;
        }
        return 0;
    }
}
