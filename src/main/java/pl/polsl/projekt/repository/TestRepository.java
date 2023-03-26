package pl.polsl.projekt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.polsl.projekt.model.Test;

public interface TestRepository extends JpaRepository<Test, Integer> {
}
