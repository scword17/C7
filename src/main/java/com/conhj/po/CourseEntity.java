package com.conhj.po;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "course", schema = "test", catalog = "")
public class CourseEntity {
    private String cno;
    private String cname;
    private Short ccredit;
    private Set<StudentEntity> stus=new HashSet<>();

    @Id
    @Column(name = "Cno")
    public String getCno() {
        return cno;
    }

    public void setCno(String cno) {
        this.cno = cno;
    }

    @Basic
    @Column(name = "Cname")
    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Basic
    @Column(name = "Ccredit")
    public Short getCcredit() {
        return ccredit;
    }

    public void setCcredit(Short ccredit) {
        this.ccredit = ccredit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseEntity that = (CourseEntity) o;
        return Objects.equals(cno, that.cno) &&
                Objects.equals(cname, that.cname) &&
                Objects.equals(ccredit, that.ccredit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cno, cname, ccredit);
    }

    @ManyToMany(mappedBy = "courses")
    public Set<StudentEntity> getStus() {
        return stus;
    }

    public void setStus(Set<StudentEntity> stus) {
        this.stus = stus;
    }
}
