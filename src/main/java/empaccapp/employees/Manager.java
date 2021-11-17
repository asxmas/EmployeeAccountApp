package empaccapp.employees;

import empaccapp.employees.enums.Position;
import empaccapp.employees.enums.Rate;

public class Manager extends EmployeeImpl {

    public Manager(){
        setPosition(Position.MANAGER);
        setSales(Rate.MANAGER_SALES.getValue() + (int)(Rate.MANAGER_SALES.getValue() * Math.random()));
        setSalary(Rate.MANAGER_FIX_SALARY.getValue()
                + (int)(Rate.OPERATOR_FIX_SALARY_FORK.getValue() * Math.random())
                + (getSales() * Rate.MANAGER_BONUS_PERCENT.getValue() / 100));
    }

    @Override
    public int getMonthSalary() {
        return getSalary();
    }
}
