package com.conhj.po;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "son", schema = "test", catalog = "")
public class SonEntity {
    private String id;
    private String sname;
    private FatherEntity father;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "sname")
    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SonEntity sonEntity = (SonEntity) o;
        return Objects.equals(id, sonEntity.id) &&
                Objects.equals(sname, sonEntity.sname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sname);
    }

    @ManyToOne
    @JoinColumn(name = "fid", referencedColumnName = "fid")
    public FatherEntity getFather() {
        return father;
    }

    public void setFather(FatherEntity father) {
        this.father = father;
    }
}
