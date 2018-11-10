package com.conhj.po;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "husband", schema = "test", catalog = "")
public class HusbandEntity {
    private String id;
    private String name;
    private WifeEntity wife;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
        HusbandEntity that = (HusbandEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "wid", nullable = false)
    public WifeEntity getWife() {
        return wife;
    }

    public void setWife(WifeEntity wife) {
        this.wife = wife;
    }
}
