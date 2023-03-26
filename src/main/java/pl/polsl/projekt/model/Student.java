package pl.polsl.projekt.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Students")
@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student extends Person implements Serializable {


//    @ManyToMany
//    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
//    @JoinTable(name="STU_FIE",
//            joinColumns=@JoinColumn(name="PER_ID"),
//            inverseJoinColumns=@JoinColumn(name="FIE_ID"),
//            foreignKey = @javax.persistence.ForeignKey(name="FK_STU_FIE"),
//            inverseForeignKey = @javax.persistence.ForeignKey(name="FK_FIE_STU"))
//    private Set<FieldOfStudy> fieldsOfStudy = new HashSet<>();

    @JsonIgnoreProperties("student")
    @OneToMany(mappedBy = "student", orphanRemoval = true)
    private Set<Test> tests = new HashSet<>();

    public Student(String firstName, String surname, String email) {
        super(firstName, surname, email);
    }
}
