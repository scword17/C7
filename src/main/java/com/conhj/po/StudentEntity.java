package com.conhj.po;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student", schema = "test", catalog = "")
public class StudentEntity {
    private String sno;
    private String sname;
    private String sex;
    private Short sage;
    private String sdept;
    private Set<CourseEntity> courses=new HashSet<>();

    @Id
    @Column(name = "Sno")
    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    @Basic
    @Column(name = "Sname")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Basic
    @Column(name = "Sex")
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "Sage")
    public Short getSage() {
        return sage;
    }

    public void setSage(Short sage) {
        this.sage = sage;
    }

    @Basic
    @Column(name = "Sdept")
    public String getSdept() {
        return sdept;
    }

    public void setSdept(String sdept) {
        this.sdept = sdept;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentEntity that = (StudentEntity) o;
        return Objects.equals(sno, that.sno) &&
                Objects.equals(sname, that.sname) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(sage, that.sage) &&
                Objects.equals(sdept, that.sdept);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sno, sname, sex, sage, sdept);
    }

    @ManyToMany
    @Cascade(value=org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "sc", catalog = "", schema = "test", joinColumns = @JoinColumn(name = "Sno", referencedColumnName = "Sno", nullable = false), inverseJoinColumns = @JoinColumn(name = "Cno", referencedColumnName = "Cno", nullable = false))
    public Set<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(Set<CourseEntity> courses) {
        this.courses = courses;
    }
}
