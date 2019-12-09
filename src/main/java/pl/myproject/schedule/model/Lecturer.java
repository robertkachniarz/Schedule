package pl.myproject.schedule.model;

import javax.persistence.*;

@Entity
@Table(name="lecturer")
public class Lecturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private long id;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    private String lastname;

    @Column(name="academic_title")
    private String academicTitle;

    public Lecturer(String firstname, String lastname, String academicTitle) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.academicTitle = academicTitle;
    }

    public Lecturer() {
    }

    public long getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    @Override
    public String toString() {
        return "Lecturer{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", academicTitle='" + academicTitle + '\'' +
                '}';
    }
}
