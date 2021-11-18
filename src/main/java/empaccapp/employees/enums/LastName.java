package empaccapp.employees.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public enum LastName {
    NAME_1("Иванов"),
    NAME_2("Петров"),
    NAME_3("Сидоров"),
    NAME_4("Путин"),
    NAME_5("Ельцин"),
    NAME_6("Левашов"),
    NAME_7("Удальцов"),
    NAME_8("Самсонов"),
    NAME_9("Анофриев"),
    NAME_10("Бунин"),
    NAME_11("Пушкин"),
    NAME_12("Лермонтов"),
    NAME_13("Бутусов"),
    NAME_14("Ельчин"),
    NAME_15("Колобков"),
    NAME_16("Пушков"),
    NAME_17("Савельев"),
    NAME_18("Ложкарев"),
    NAME_19("Ленин"),
    NAME_20("Сталин");

    private final String name;

    public static String getRandomName(){
        return values()[new Random().nextInt(values().length)].getName();
    }
}
