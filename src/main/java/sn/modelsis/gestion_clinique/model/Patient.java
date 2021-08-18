package sn.modelsis.gestion_clinique.model;

import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Patient.
 */
@Entity
@Table(name = "patient")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Patient implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "noss")
    private String noss;

    @Column(name = "nom")
    private String nom;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient id(Long id) {
        this.id = id;
        return this;
    }

    public String getNoss() {
        return this.noss;
    }

    public Patient noss(String noss) {
        this.noss = noss;
        return this;
    }

    public void setNoss(String noss) {
        this.noss = noss;
    }

    public String getNom() {
        return this.nom;
    }

    public Patient nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Patient)) {
            return false;
        }
        return id != null && id.equals(((Patient) o).id);
    }

    @Override
    public int hashCode() {

        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Patient{" + "id=" + getId() + ", noss='" + getNoss() + "'" + ", nom='" + getNom() + "'" + "}";
    }
}