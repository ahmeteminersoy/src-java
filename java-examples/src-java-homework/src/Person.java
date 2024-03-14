package src;

import java.util.Calendar;
import java.util.Objects;

public class Person
{
    private int id;
    private String firstName;
    private String lastName;
    private byte gender;
    private Calendar birthDate;
    private byte maritalStatus;
    private boolean hasDriverLicence;

    public Person(int id, String firstName, String lastName, byte gender, Calendar birthDate, byte maritalStatus, boolean hasDriverLicence) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthDate = birthDate;
        this.maritalStatus = maritalStatus;
        this.hasDriverLicence = hasDriverLicence;
    }
    public Person(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        setGender(gender);
        this.birthDate = birthDate;
        if (maritalStatus.equals("Single"))
            this.maritalStatus = 1;
        else if (maritalStatus.equals("Married"))
            this.maritalStatus = 2;
        if (hasDriverLicence.equals("Yes"))
            this.hasDriverLicence = true;
        if (hasDriverLicence.equals("No"))
            this.hasDriverLicence = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        if (gender == 1)
            return "Woman";
        if (gender == 2)
            return "Man";
        return null;
    }

    public void setGender(byte gender) {
        this.gender = gender;
    }
    public void setGender(String gender) {
        if(gender.equals("Woman"))
            this.gender = 1;
        if(gender.equals("Man"))
            this.gender = 2;

    }

    public Calendar getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getMaritalStatus() {
        if (maritalStatus == 1)
            return "Single";
        if (maritalStatus == 2)
            return "Married";
        return null;
    }

    public void setMaritalStatus(byte maritalStatus) {
        this.maritalStatus = maritalStatus;
    }
    public void setMaritalStatus(String maritalStatus) {
        if (maritalStatus.equals("Single"))
            this.maritalStatus = 1;
        if (maritalStatus.equals("Married"))
            this.maritalStatus = 2;
    }

    public String isHasDriverLicence() {
        if (hasDriverLicence)
            return "Yes";
        else
            return "No";
    }

    public void setHasDriverLicence(boolean hasDriverLicence) {
        this.hasDriverLicence = hasDriverLicence;
    }
    public void setHasDriverLicence(String hasDriverLicence) {
        if (hasDriverLicence.equals("Yes"))
            this.hasDriverLicence = true;
        if (hasDriverLicence.equals("No"))
            this.hasDriverLicence = false;
    }
    public String getHasDriverLicense()
    {
        if (hasDriverLicence)
            return "Yes";
        else
            return "No";
    }

    @Override
    public String toString() {
        return "Person [" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + getGender() +
                ", birthDate=" + getBirthDate(birthDate) +
                ", maritalStatus=" + getMaritalStatus() +
                ", hasDriverLicence=" + getHasDriverLicense() +
                ']';
    }
    public String getBirthDate(Calendar cal)
    {
        String result = "";
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1;
        int year = cal.get(Calendar.YEAR);
        String dayStr = String.format("%02d", day);
        String monthStr = String.format("%02d", month);

        return dayStr + "/" + monthStr + "/" + year;
    }
}