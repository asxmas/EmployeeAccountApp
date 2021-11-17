package empaccapp.employees;

import empaccapp.employees.enums.*;
import empaccapp.organization.Organization;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@Getter
@Setter
public abstract class EmployeeImpl implements Employee {

    private int id;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Organization organization;
    private Position position;

    private int sales;
    private int salary;

    protected EmployeeImpl(){
        this.gender = new Random().nextBoolean() ? Gender.MALE : Gender.FEMALE;
        this.firstName = this.gender == Gender.MALE ? MaleName.getRandomName() : FemaleName.getRandomName();
        this.lastName = LastName.getRandomName() + (this.gender == Gender.MALE ? "" : "а");
    }



}
