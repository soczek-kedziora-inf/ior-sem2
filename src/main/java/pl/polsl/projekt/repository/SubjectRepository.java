package pl.polsl.projekt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.projekt.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Subject findByName(String name);

    Page<Subject> findAllByName(String name,  Pageable pageable);

}
