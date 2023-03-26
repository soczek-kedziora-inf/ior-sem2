package pl.polsl.projekt.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
//@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Subject implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUB_ID")
    private int id;

    private String name;

    @JsonIgnoreProperties("subjects")
    @ManyToMany(mappedBy = "subjects")
    private Set<Teacher> teachers = new HashSet<>();

    @JsonIgnoreProperties("subject")
    @OneToMany(mappedBy = "subject", orphanRemoval = true)
    private Set<Test> tests = new HashSet<>();

    public Subject(String name) {
        this.name = name;
    }
}
