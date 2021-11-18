package empaccapp.employees.impl;

import empaccapp.employees.enums.Position;
import empaccapp.employees.enums.Rate;
import lombok.Getter;

import java.util.Random;

@Getter
public class Manager extends EmployeeImpl {

    public Manager(){
        setPosition(Position.MANAGER);
        setSales(Rate.MANAGER_SALES.getValue() + new Random().nextInt(Rate.MANAGER_SALES.getValue()));
        setSalary(Rate.MANAGER_FIX_SALARY.getValue()
                + new Random().nextInt(Rate.OPERATOR_FIX_SALARY_FORK.getValue())
                + (getSales() * Rate.MANAGER_BONUS_PERCENT.getValue() / 100));
    }

    @Override
    public int getMonthSalary() {
        return getSalary();
    }
}
