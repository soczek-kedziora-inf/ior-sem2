package pl.polsl.projekt.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.polsl.projekt.model.*;
import pl.polsl.projekt.repository.StudentRepository;
import pl.polsl.projekt.repository.SubjectRepository;
import pl.polsl.projekt.repository.TeacherRepository;
import pl.polsl.projekt.repository.TestRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.HashSet;

@Component
@RequiredArgsConstructor
public class DataLoader {
    private final TeacherRepository teacherRepository;
    private final TestRepository testRepository;
    private final SubjectRepository subjectRepository;
    private final StudentRepository studentRepository;

    @PostConstruct
    public void loadData(){

        Subject subject1 = new Subject("Mathematic");
        Subject subject2 = new Subject("Physic");
        Subject subject3 = new Subject("Algebra");
        Subject subject4 = new Subject("Sociology");

        HashSet<Subject> subjectHashSet1 = new HashSet<>();
        HashSet<Subject> subjectHashSet2 = new HashSet<>();
        HashSet<Subject> subjectHashSet3 = new HashSet<>();
        HashSet<Subject> subjectHashSet4 = new HashSet<>();
        subjectHashSet1.add(subject1);
        subjectHashSet1.add(subject3);

        subjectHashSet2.add(subject4);

        subjectHashSet3.add(subject2);
        subjectHashSet3.add(subject3);

        subjectHashSet4.add(subject1);
        subjectHashSet4.add(subject2);
        subjectHashSet4.add(subject3);

        subjectRepository.save(subject1);
        subjectRepository.save(subject2);
        subjectRepository.save(subject3);
        subjectRepository.save(subject4);
//
//        FieldOfStudy fieldOfStudy1 = new FieldOfStudy(1, "Informatics","S1");
//        FieldOfStudy fieldOfStudy2 = new FieldOfStudy(2, "Telecommunications","S1");
//        FieldOfStudy fieldOfStudy3 = new FieldOfStudy(3, "Geology","S1");
//        FieldOfStudy fieldOfStudy4 = new FieldOfStudy(4, "Architecture","S1");
//
//        FieldOfStudy fieldOfStudy5 = new FieldOfStudy(1, "Robotics","S2");
//        FieldOfStudy fieldOfStudy6 = new FieldOfStudy(1,"Informatics","S2");
//
//
//        HashSet<FieldOfStudy> fieldOfStudyHashSet1 = new HashSet<>();
//        HashSet<FieldOfStudy> fieldOfStudyHashSet2 = new HashSet<>();
//        HashSet<FieldOfStudy> fieldOfStudyHashSet3 = new HashSet<>();
//        HashSet<FieldOfStudy> fieldOfStudyHashSet4 = new HashSet<>();
//
//        fieldOfStudyHashSet1.add(fieldOfStudy1);
//        fieldOfStudyHashSet1.add(fieldOfStudy2);
//        fieldOfStudyHashSet2.add(fieldOfStudy4);
//        fieldOfStudyHashSet3.add(fieldOfStudy3);
//        fieldOfStudyHashSet3.add(fieldOfStudy1);
//        fieldOfStudyHashSet4.add(fieldOfStudy6);





        Student student1 = new Student( "Adam","Adamiak","adam@gmail.com");
        Student student2 = new Student( "Jan","Kowalski","kowalski@email.com");
        Student student3 = new Student( "Lukasz","Olkowicz","olkiewicz@gmail.com");
        Student student4 = new Student("Piotr","Napierala","asdas@email.com");


        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);
        studentRepository.save(student4);


        Teacher teacher1 = new Teacher("Jacek","Bartosiak","bartosiak@mail.com","doctor",subjectHashSet1);
        Teacher teacher2 = new Teacher("Mariusz","Pudzianowski","pudzian@mail.com","professor",subjectHashSet4);
        teacherRepository.save(teacher1);
        teacherRepository.save(teacher2);

        HashSet<Teacher> teacherHashSet1 = new HashSet<>();
        teacherHashSet1.add(teacher2);
        teacherHashSet1.add(teacher1);

        HashSet<Student> studentHashSet1 = new HashSet<>();
        studentHashSet1.add(student1);
        studentHashSet1.add(student2);
        studentHashSet1.add(student3);
        studentHashSet1.add(student4);

        HashSet<Test> testHashSet1 = new HashSet<>();

        Test test1 = new Test(1, LocalDate.parse("2022-11-20"),5.0,"Linear algebra",subject1,student1);
        Test test2 = new Test(2, LocalDate.parse("2022-11-20"),3.0,"Linear algebra",subject1,student2);
        Test test3 = new Test(3, LocalDate.parse("2022-11-20"),5.0,"Linear algebra",subject1,student3);
        Test test4 = new Test(4, LocalDate.parse("2022-11-20"),5.0,"Kinematic",subject2,student4);
        testRepository.save(test1);
        testRepository.save(test2);
        testRepository.save(test3);
        testRepository.save(test4);

    }
}
