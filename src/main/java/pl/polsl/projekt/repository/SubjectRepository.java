package pl.polsl.projekt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.polsl.projekt.model.Subject;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Subject findByName(String name);

    Page<Subject> findAllByName(String name,  Pageable pageable);

    List<Subject> findAllByNameContainingIgnoreCase(String name);

    List<Subject> findDistinctByIdOrName(int id, String name);
    @Query("select s from Subject s where s.name = :name")
    List<Subject> findAllByName(String name);

}
