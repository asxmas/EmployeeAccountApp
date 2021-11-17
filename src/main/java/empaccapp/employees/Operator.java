package empaccapp.employees;

import empaccapp.employees.enums.Position;
import empaccapp.employees.enums.Rate;

public class Operator extends EmployeeImpl {

    int salary;
    public Operator(){
        setPosition(Position.OPERATOR);
        setSalary(Rate.OPERATOR_FIX_SALARY.getValue() + (int)(Rate.OPERATOR_FIX_SALARY_FORK.getValue() * Math.random()));
    }

    @Override
    public int getMonthSalary() {
        return getSalary();
    }
}
