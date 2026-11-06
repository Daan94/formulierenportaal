package nl.oefening.formulierenportaal.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "formulieren")
public class FormulierenEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;
    private String title;
    @Enumerated(EnumType.STRING)
    private FormulierenStatus formulierenStatus;

    public FormulierenEntity(Long id, String title, FormulierenStatus status) {
        this.id = id;
        this.title = title;
        this.formulierenStatus = status;
    }

    public FormulierenEntity() {
    }

    public FormulierenEntity(String titel, FormulierenStatus formulierenStatus) {
        this.title=titel;
        this.formulierenStatus=formulierenStatus;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public FormulierenStatus getFormulierenStatus() {
        return formulierenStatus;
    }

    public void setFormulierenStatus(FormulierenStatus formulierenStatus) {
        this.formulierenStatus = formulierenStatus;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
