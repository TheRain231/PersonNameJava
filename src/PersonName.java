import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PersonName {
    private String lastName;
    private String initials;
    private String gender;
    private int age;
    private String ageSuffix;

    public PersonName(String fullName, String dateOfBirth) {
        String[] nameParts = fullName.split(" ");
        if (nameParts.length != 3) {
            throw new PersonException("Неправильный ввод ФИО");
        }
        lastName = nameParts[0];
        String middleName = nameParts[2];
        initials = nameParts[1].charAt(0) + "." + middleName.charAt(0) + ".";

        if (middleName.endsWith("ич")){
            gender = "мужской";
        } else if (middleName.endsWith("на")){
            gender = "женский";
        } else {
            gender = "боевой вертолёт";
        }

        Period period;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate birthDate = LocalDate.parse(dateOfBirth, formatter);
            period = Period.between(birthDate, LocalDate.now());
            age = period.getYears();
        } catch (Exception e) {
            throw new PersonException("Неправильный ввод даты");
        }

        if (period.getDays() < 0){
            throw new PersonException("Неправильная дата (будущее)");
        }

        if (age % 10 == 1 && age % 100 != 11) {
            ageSuffix = "год";
        } else if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) {
            ageSuffix = "года";
        } else {
            ageSuffix = "лет";
        }
    }

    @Override
    public String toString() {
        return "Фамилия + Инициалы: " + lastName + " " + initials + "\n" +
                "Пол: " + gender + "\n" +
                "Возраст: " + age + " " + ageSuffix;
    }
}
