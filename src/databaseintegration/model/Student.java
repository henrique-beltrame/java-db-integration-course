package databaseintegration.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Henrique
 */
@Entity
@Table(name = "STUDENT")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
})
public class Student implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "REGISTRATION")
    private String registration;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ENTRY_YEAR")
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
