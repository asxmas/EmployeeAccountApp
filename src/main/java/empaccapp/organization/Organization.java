package empaccapp.organization;

import empaccapp.employees.Employee;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Getter
@RequiredArgsConstructor
public class Organization {

    private int employeeId = 0;
    private Set<Employee> employees = new HashSet<>();

}
