import java.util.Scanner;

public class PersonProgram {
    private String fullName;
    private String birthDateString;

    void run(){
        input();

        PersonName prog;
        try {
            prog = new PersonName(fullName, birthDateString);
        } catch (PersonException e) {
            System.out.println(e.getMessage());
            run();
            return;
        }

        System.out.println(prog);
    }

    private void input(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите ФИО (например: Иванов Иван Иванович): ");
        fullName = scanner.nextLine();

        System.out.print("Введите дату рождения (дд.мм.гггг): ");
        birthDateString = scanner.nextLine();
    }
}
