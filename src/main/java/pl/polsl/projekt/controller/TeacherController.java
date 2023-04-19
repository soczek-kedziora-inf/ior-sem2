package pl.polsl.projekt.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.polsl.projekt.model.Teacher;
import pl.polsl.projekt.repository.TeacherRepository;

import java.util.List;

@RestController
@RequestMapping("/teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherRepository teacherRepository;

    // http://localhost:8081/teachers/get/?firstName=Mariusz&surname=Pudzianowski
    @GetMapping("/get")
    Teacher getTeachersByFirstNameAndSurname(@RequestParam String firstName, @RequestParam String surname) {
        return teacherRepository.findByFirstNameAndSurname(firstName, surname);
    }

    // http://localhost:8081/teachers/getPage/?firstName=Mariusz&surname=Pudzianowski
    @GetMapping("/getPage")
    Page<Teacher> getTeachersByFirstNameAndSurnameSortedAndPaginated(@RequestParam String firstName,
                                                                     @RequestParam String surname,
                                                                     @RequestParam(defaultValue = "0") int page,
                                                                     @RequestParam(defaultValue = "1") int size,
                                                                     @RequestParam(defaultValue = "desc") String sortDirection,
                                                                     @RequestParam(defaultValue = "firstName") String sortColumn) {
        Sort.Order order = new Sort.Order(Sort.Direction.fromString(sortDirection), sortColumn);
        Pageable pagingSort = PageRequest.of(page, size, Sort.by(order));
        return teacherRepository.findAllByFirstNameAndSurname(firstName, surname, pagingSort);

    }

    // http://localhost:8081/teachers/getLike/?firstName=mAri
    @GetMapping("/getLike")
    List<Teacher> getTeachersByFirstNameLike(@RequestParam String firstName) {
        return teacherRepository.findAllByFirstNameContainingIgnoreCase(firstName);
    }

    //http://localhost:8081/teachers/getOr/?firstName=Mariusz&surname=Bartosiak
    @GetMapping("/getOr")
    List<Teacher> getTeachersByName(@RequestParam String firstName, String surname) {
        return teacherRepository.findAllByFirstNameOrSurname(firstName, surname);
    }

    // http://localhost:8081/teachers/getQuery/?title=professor
    @GetMapping("/getQuery")
    List<Teacher> getTeachersByName(@RequestParam String title) {
        return teacherRepository.findAllByTitle(title);
    }

    //http://localhost:8081/teachers/delete/6
    @GetMapping(value = "/delete/{id}")
    void deleteTeacher(@PathVariable Integer id) {
        teacherRepository.deleteById(id);
    }
}
