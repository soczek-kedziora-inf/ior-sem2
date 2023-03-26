package pl.polsl.projekt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.projekt.model.Subject;
import pl.polsl.projekt.model.Teacher;
import pl.polsl.projekt.repository.SubjectRepository;
import pl.polsl.projekt.repository.TeacherRepository;

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
    Page<Subject> getSubjectByName(@RequestParam String name,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "1") int size,
                                   @RequestParam(defaultValue = "desc") String sortDirection,
                                   @RequestParam(defaultValue = "firstName") String sortColumn) {
        Sort.Order order = new Sort.Order(Sort.Direction.fromString(sortDirection), sortColumn);
        Pageable pagingSort = PageRequest.of(page, size, Sort.by(order));
        return subjectRepository.findAllByName(name, pagingSort);

    }
//
//    // http://localhost:8081/subjects/getLike/?firstName=mAri
//    @GetMapping("/getLike")
//    List<Subject> getTeachersByFirstNameLike(@RequestParam String firstName) {
//        return teacherRepository.findAllByFirstNameContainingIgnoreCase(firstName);
//    }
//
//    // http://localhost:8081/subjects/getOr/?firstName=Mariusz&surname=Kolonko
//    @GetMapping("/getOr")
//    List<Subject> getTeachersByName(@RequestParam String firstName, String surname) {
//        return teacherRepository.findAllByFirstNameOrSurname(firstName, surname);
//    }
//
//    // http://localhost:8081/subjects/getQuery/?title=professor
//    @GetMapping("/getQuery")
//    List<Subject> getTeachersByName(@RequestParam String title) {
//        return teacherRepository.findAllByTitle(title);
//    }
}
