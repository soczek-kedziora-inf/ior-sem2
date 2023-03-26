package pl.polsl.projekt.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Teacher extends Person {

    private String title;

    @ManyToMany
    @JsonIgnoreProperties({"tests","teachers"})
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    @JoinTable(name="TEA_SUB",
            joinColumns = @JoinColumn(name="PER_ID"),
            inverseJoinColumns = @JoinColumn(name="SUB_ID"),
            foreignKey = @javax.persistence.ForeignKey(name="FK_TEA_SUB"),
            inverseForeignKey = @javax.persistence.ForeignKey(name="FK_SUB_TEA"))
    private Set<Subject> subjects = new HashSet<>();
    public Teacher(String firstName, String surname, String email, String title, Set<Subject> subjects) {
        super(firstName, surname, email);
        this.title = title;
        this.subjects.addAll(subjects);
    }
}