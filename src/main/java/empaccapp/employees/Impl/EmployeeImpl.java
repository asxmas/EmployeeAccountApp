package empaccapp.employees.Impl;

import empaccapp.employees.Employee;
import empaccapp.employees.enums.Gender;
import empaccapp.employees.enums.Position;
import empaccapp.organization.Organization;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class EmployeeImpl implements Employee {

    private int id;
    private String FirstName;
    private String LastName;
    private Gender gender;
    private Organization organization;
    private Position position;

    private int fixedSalary;
    private int managerBonus;
    private double bonus;
    private int bonusAmount;
    private int salary;

}
