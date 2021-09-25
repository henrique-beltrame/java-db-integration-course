package databaseintegration.model;

/**
 *
 * @author Henrique
 */
public class Student {

    private String registration;
    private String name;
    private Integer entryYear;

    public Student() {
    }

    public Student(String registration, String name, Integer entryYear) {
        this.registration = registration;
        this.name = name;
        this.entryYear = entryYear;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEntryYear() {
        return entryYear;
    }

    public void setEntryYear(Integer entryYear) {
        this.entryYear = entryYear;
    }
}
