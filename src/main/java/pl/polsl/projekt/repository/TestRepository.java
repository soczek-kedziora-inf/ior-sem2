package pl.polsl.projekt.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.polsl.projekt.model.Test;

import java.time.LocalDate;
import java.util.List;

public interface TestRepository extends JpaRepository<Test, Integer> {
    Test findByNameAndDate(String name, LocalDate date);

    Page<Test> findAllByNameAndDate(String name, LocalDate date, Pageable pageable);

    List<Test> findAllByNameContainingIgnoreCase(String name);

    List<Test> findDistinctByNameOrGrade(String name, Double grade);

    @Query("select t from Test t where t.grade = :grade")
    List<Test> findAllByGrade(Double grade);

}
