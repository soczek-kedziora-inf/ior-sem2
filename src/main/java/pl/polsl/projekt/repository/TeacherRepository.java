package pl.polsl.projekt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.polsl.projekt.model.Teacher;

import java.util.List;


public interface TeacherRepository extends JpaRepository<Teacher, Integer> {


    Teacher findByFirstNameAndSurname(String firstName, String surname);

    Page<Teacher> findAllByFirstNameAndSurname(String firstName, String surname, Pageable pageable);

    List<Teacher> findAllByFirstNameContainingIgnoreCase(String firstName);

    List<Teacher> findAllByFirstNameOrSurname(String firstName, String surname);

    @Query("select u from Teacher u where u.title = :title")
    List<Teacher> findAllByTitle(String title);
}

