package sn.modelsis.gestion_clinique.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "medicament")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Medicament implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    @ManyToMany(mappedBy = "medicaments")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "medicaments", "medecin", "patient" }, allowSetters = true)
    private Set<Consultation> consultations = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Medicament id(Long id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return this.code;
    }

    public Medicament code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return this.libelle;
    }

    public Medicament libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Set<Consultation> getConsultations() {
        return this.consultations;
    }

    public Medicament consultations(Set<Consultation> consultations) {
        this.setConsultations(consultations);
        return this;
    }

    public Medicament addConsultation(Consultation consultation) {
        this.consultations.add(consultation);
        consultation.getMedicaments().add(this);
        return this;
    }

    public Medicament removeConsultation(Consultation consultation) {
        this.consultations.remove(consultation);
        consultation.getMedicaments().remove(this);
        return this;
    }

    public void setConsultations(Set<Consultation> consultations) {
        if (this.consultations != null) {
            this.consultations.forEach(i -> i.removeMedicament(this));
        }
        if (consultations != null) {
            consultations.forEach(i -> i.addMedicament(this));
        }
        this.consultations = consultations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Medicament)) {
            return false;
        }
        return id != null && id.equals(((Medicament) o).id);
    }

    @Override
    public int hashCode() {

        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "Medicament{" + "id=" + getId() + ", code='" + getCode() + "'" + ", libelle='" + getLibelle() + "'"
                + "}";
    }
}
