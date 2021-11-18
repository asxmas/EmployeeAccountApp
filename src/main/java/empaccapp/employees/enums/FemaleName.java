package empaccapp.employees.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public enum FemaleName {
    NAME_1("Александра"),
    NAME_2("Анна"),
    NAME_3("Екатерина"),
    NAME_4("Анастасия"),
    NAME_5("Евгения"),
    NAME_6("Ольга"),
    NAME_7("Ксения"),
    NAME_8("Алиса"),
    NAME_9("Виктория"),
    NAME_10("Елизавета"),
    NAME_11("Юлия"),
    NAME_12("Ева"),
    NAME_13("Полина"),
    NAME_14("Василиса"),
    NAME_15("Наталья"),
    NAME_16("Наталия"),
    NAME_17("Любовь"),
    NAME_18("Надежда"),
    NAME_19("Яна"),
    NAME_20("София");

    private final String name;

    public static String getRandomName(){
        return values()[new Random().nextInt(values().length)].getName();
    }
}
