public class Person {
    private String name;
    private int birthYear;
    private boolean isFemale;

    public Person(String name, int birthYear, boolean isFemale) {
        this.name = name;
        this.birthYear = birthYear;
        this.isFemale = isFemale;
    }

    @Override
    public String toString() {
        return "Name='" + name + '\'' +
                ", Birth Year=" + birthYear +
                ", Gender" + isFemale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public void setFemale(boolean female) {
        isFemale = female;
    }
}
