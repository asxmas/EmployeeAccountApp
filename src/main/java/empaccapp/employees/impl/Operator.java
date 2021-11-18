package empaccapp.employees.impl;

import empaccapp.employees.enums.Position;
import empaccapp.employees.enums.Rate;

import java.util.Random;

public class Operator extends EmployeeImpl {

    public Operator(){
        setPosition(Position.OPERATOR);
        setSalary(Rate.OPERATOR_FIX_SALARY.getValue() + new Random().nextInt(Rate.OPERATOR_FIX_SALARY_FORK.getValue()));
    }

    @Override
    public int getMonthSalary() {
        return getSalary();
    }
}
