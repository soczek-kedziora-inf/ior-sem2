package pl.polsl.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.projekt.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
