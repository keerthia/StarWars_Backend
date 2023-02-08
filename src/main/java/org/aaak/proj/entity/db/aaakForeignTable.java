package org.aaak.proj.entity.db;

import javax.persistence.*;

@Entity
@Table(name = "aaak_foreign_table")
public class aaakForeignTable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;
    @ManyToOne
    @JoinColumn(name = "aaak_id")
    private aaak aaakObj;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public aaak getAaakObj() {
        return aaakObj;
    }

    public void setAaakObj(aaak aaakObj) {
        System.out.println("Setting the aaakForeignTable");
        this.aaakObj = aaakObj;
    }
}
