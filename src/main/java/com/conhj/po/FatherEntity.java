package com.conhj.po;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "father", schema = "test", catalog = "")
public class FatherEntity {
    private String fid;
    private String fname;
    private Set<SonEntity> sons=new HashSet<SonEntity>();

    @Id
    @Column(name = "fid")
    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    @Basic
    @Column(name = "fname")
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FatherEntity that = (FatherEntity) o;
        return Objects.equals(fid, that.fid) &&
                Objects.equals(fname, that.fname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fid, fname);
    }

    @OneToMany(mappedBy = "father",cascade=CascadeType.ALL)
    public Set<SonEntity> getSons() {
        return sons;
    }

    public void setSons(Set<SonEntity> sons) {
        this.sons = sons;
    }
}
