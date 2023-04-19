package pl.polsl.projekt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projekt.model.Subject;
import pl.polsl.projekt.repository.SubjectRepository;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectRepository subjectRepository;


    // http://localhost:8081/subjects/get/?name=Physic
    @GetMapping("/get")
    Subject getSubjectByName(@RequestParam String name) {
        return subjectRepository.findByName(name);
    }

    // http://localhost:8081/subjects/getPage/?name=algebra
    @GetMapping("/getPage")
    Page<Subject> getSubjectByNameSortedAndPaginated(@RequestParam String name,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "1") int size,
                                   @RequestParam(defaultValue = "desc") String sortDirection,
                                   @RequestParam(defaultValue = "name") String sortColumn) {
        Sort.Order order = new Sort.Order(Sort.Direction.fromString(sortDirection), sortColumn);
        Pageable pagingSort = PageRequest.of(page, size, Sort.by(order));
        return subjectRepository.findAllByName(name, pagingSort);

    }

    // http://localhost:8081/subjects/getLike/?name=aLg
    @GetMapping("/getLike")
    List<Subject> getSubjectByNameLike(@RequestParam String name){
        return subjectRepository.findAllByNameContainingIgnoreCase(name);
    }

    // http://localhost:8081/subjects/getDistinct/?id=1&name=algebra
    @GetMapping("/getDistinct")
    List<Subject> getDistinctTestByIdOrName(@RequestParam int id, String name) {
        return subjectRepository.findDistinctByIdOrName(id, name);
    }
//
    //http://localhost:8081/subjects/getQuery/?name=Sociology
    @GetMapping("/getQuery")
    List<Subject> getAllSubjectByName(@RequestParam String name) {
        return subjectRepository.findAllByName(name);
    }

    //http://localhost:8081/subjects/delete/1
    @GetMapping(value = "/delete/{id}")
    void deleteSubject(@PathVariable Integer id) {
        subjectRepository.deleteById(id);
    }
}
