package empaccapp.employees.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public enum MaleName {
    NAME_1("Александр"),
    NAME_2("Кирилл"),
    NAME_3("Сергей"),
    NAME_4("Иван"),
    NAME_5("Евгений"),
    NAME_6("Петр"),
    NAME_7("Сидор"),
    NAME_8("Пафнутий"),
    NAME_9("Виктор"),
    NAME_10("Дмитрий"),
    NAME_11("Андрей"),
    NAME_12("Егор"),
    NAME_13("Роман"),
    NAME_14("Василий"),
    NAME_15("Владимир"),
    NAME_16("Владлен"),
    NAME_17("Константин"),
    NAME_18("Марк"),
    NAME_19("Ян"),
    NAME_20("Семен");

    private final String name;

    public static String getRandomName(){
        return values()[new Random().nextInt(values().length)].getName();

    }
}
