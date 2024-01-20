import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private long phoneNumber;
    private char gender;

    public Person(String lastName, String firstName, String middleName, String birthDateStr, long phoneNumber, char gender) throws ParseException {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        this.birthDate = dateFormat.parse(birthDateStr);

        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }
    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }
}