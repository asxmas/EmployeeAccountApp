package empaccapp.employees;

import empaccapp.employees.enums.Position;
import empaccapp.employees.enums.Rate;

public class TopManager extends EmployeeImpl {

    public TopManager(){
        setPosition(Position.MANAGER);
        setSalary(Rate.TOP_MANAGER_FIX_SALARY.getValue() + (int)(Rate.TOP_MANAGER_FIX_SALARY_FORK.getValue() * Math.random()));
    }

    @Override
    public int getMonthSalary() {
        return getOrganization().getIncome() > Rate.ORGANIZATION_INCOME_PROFIT_FOR_BONUS.getValue()
                ? (int)((getSalary() * Rate.TOP_MANAGER_BONUS_PERCENT.getValue()) / 100.0)
                : getSalary();
    }
}
