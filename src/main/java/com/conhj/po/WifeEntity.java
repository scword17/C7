package com.conhj.po;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "wife", schema = "test", catalog = "")
public class WifeEntity {
    private String wid;
    private String name;
    private HusbandEntity hus;

    @Basic
    @Id
    @Column(name = "wid")
    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WifeEntity that = (WifeEntity) o;
        return Objects.equals(wid, that.wid) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(wid, name);
    }

    @OneToOne(mappedBy = "wife")
    public HusbandEntity getHus() {
        return hus;
    }

    public void setHus(HusbandEntity hus) {
        this.hus = hus;
    }
}
