package pl.polsl.projekt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projekt.model.Test;
import pl.polsl.projekt.repository.TestRepository;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tests")
@RequiredArgsConstructor
public class TestController {

    private final TestRepository testRepository;

    // http://localhost:8081/tests/get/?name=Kinematic&date=2022-11-20
    @GetMapping("/get")
    Test getTestsByFirstNameAndSurname(@RequestParam String name,
                                       @DateTimeFormat(pattern = "yyyy-MM-dd")@RequestParam("date") LocalDate date){
        return testRepository.findByNameAndDate(name, date);
    }


    // http://localhost:8081/tests/getPage/?name=Kinematic&date=2022-11-20
    @GetMapping("/getPage")
    Page<Test> getTestsByNameAndDateSortedAndPaginated(@RequestParam String name,
                                                       @DateTimeFormat(pattern = "yyyy-MM-dd")@RequestParam("date") LocalDate date,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "1") int size,
                                                       @RequestParam(defaultValue = "desc") String sortDirection,
                                                       @RequestParam(defaultValue = "name") String sortColumn) {
        Sort.Order order = new Sort.Order(Sort.Direction.fromString(sortDirection), sortColumn);
        Pageable pagingSort = PageRequest.of(page, size, Sort.by(order));
        return testRepository.findAllByNameAndDate(name, date, pagingSort);

    }
    // http://localhost:8081/tests/getLike/?name=alG
    @GetMapping("/getLike")
    List<Test> getTestsByFirstNameLike(@RequestParam String name) {
        return testRepository.findAllByNameContainingIgnoreCase(name);
    }

    // http://localhost:8081/tests/getDistinct/?name=Kinematic&grade=5.0
    @GetMapping("/getDistinct")
    List<Test> getDistinctTestsByNameOrGrade(@RequestParam String name, Double grade) {
        return testRepository.findDistinctByNameOrGrade(name, grade);
    }

    // http://localhost:8081/tests/getQuery/?grade=3.0
    @GetMapping("/getQuery")
    List<Test> getTestsByGrade(@RequestParam Double grade) {
        return testRepository.findAllByGrade(grade);
    }

    //http://localhost:8081/tests/delete/4
    @GetMapping(value = "/delete/{id}")
    void deleteTest(@PathVariable Integer id) {
        testRepository.deleteById(id);
    }
}
