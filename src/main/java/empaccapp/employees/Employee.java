package empaccapp.employees;

import empaccapp.employees.enums.Gender;
import empaccapp.employees.enums.Position;
import empaccapp.organization.Organization;

public interface Employee extends Comparable<Employee> {

    int getMonthSalary();


    default int compareTo(Employee employee){
        return Integer.compare(getMonthSalary(), employee.getMonthSalary());
    }

    void setId(int employeeId);

    void setOrganization(Organization organization);

    int getSales();
    int getSalary();
    int getId();
    Organization getOrganization();
    String getFirstName();
    String getLastName();
    Position getPosition();
    Gender getGender();
}
