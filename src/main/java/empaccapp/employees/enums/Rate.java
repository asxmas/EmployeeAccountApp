package empaccapp.employees.enums;

public enum Rate {
    MANAGER_FIX_SALARY(120000),
    MANAGER_FIX_SALARY_FOR(40000),
    MANAGER_BONUS_PERCENT(5),
    MANAGER_SALES(115000),
    MANAGER_SALES_RANDOM(30000),
    TOP_MANAGER_FIX_SALARY(220000),
    TOP_MANAGER_FIX_SALARY_FORK(60000),
    TOP_MANAGER_BONUS_PERCENT(150),
    OPERATOR_FIX_SALARY(40000),
    OPERATOR_FIX_SALARY_FORK(20000),
    ORGANIZATION_INCOME_PROFIT_FOR_BONUS(10000000);

    private final int value;

    Rate(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
