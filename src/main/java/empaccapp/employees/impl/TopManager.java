package empaccapp.employees.impl;

import empaccapp.employees.enums.Position;
import empaccapp.employees.enums.Rate;

import java.util.Random;

public class TopManager extends EmployeeImpl {

    public TopManager(){
        setPosition(Position.TOPMANAGER);
        setSalary(Rate.TOP_MANAGER_FIX_SALARY.getValue() + new Random().nextInt(Rate.TOP_MANAGER_FIX_SALARY_FORK.getValue()));
    }

    @Override
    public int getMonthSalary() {
        return getOrganization().getIncome() > Rate.ORGANIZATION_INCOME_PROFIT_FOR_BONUS.getValue()
                ? (int)((getSalary() * Rate.TOP_MANAGER_BONUS_PERCENT.getValue()) / 100.0)
                : getSalary();
    }
}
