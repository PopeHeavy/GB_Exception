import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите фамилию, имя и отчество, дату рождения в формате дд.мм.гггг, номер телефона, пол");
        String inputLine = scanner.nextLine().trim();

        String[] data = inputLine.split(" ");

        if (data.length != 6) {
            System.err.println("Неверное количество данных");
            return;
        }

        try {
            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDateStr = data[3];
            long phoneNumber = Long.parseLong(data[4]);
            char gender = data[5].charAt(0);

            Person person = new Person(lastName, firstName, middleName, birthDateStr, phoneNumber, gender);

            String fileName = lastName + ".txt";
            FileWriter fileWriter = new FileWriter(fileName, true);

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
            String formattedDate = dateFormat.format(person.getBirthDate());

            String fileContent = String.format("%s %s %s %s %d %c %n",
                    person.getLastName(), person.getFirstName(), person.getMiddleName(),
                    formattedDate, person.getPhoneNumber(), person.getGender());

            fileWriter.write(fileContent);
            fileWriter.close();

            System.out.println("Данные успешно записаны в файл: " + fileName);
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат номера телефона.");
        } catch (ParseException e) {
            System.err.println("Неверный формат даты рождения.");
        } catch (IOException e) {
            System.err.println("Ошибка при записи в файл.");
        }
    }
}