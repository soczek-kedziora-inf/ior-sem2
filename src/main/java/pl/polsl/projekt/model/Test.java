package pl.polsl.projekt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Test implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TES_ID")
    private int id;

    private LocalDate date;

    private Double grade;

    private String name;


    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JsonIgnoreProperties("tests")
    @JoinColumn(name="SUB_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_SUB_TES"))
    private Subject subject;

    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JsonIgnoreProperties("tests")
    @JoinColumn(name="STU_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_STU_TES"))
    private Student student;
}
