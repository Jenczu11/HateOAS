package com.atos.rest.controller;

import com.atos.rest.manager.RestManager;
import com.atos.rest.model.Student;
import com.atos.rest.model.Subject;
import com.atos.rest.model.Year;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v2")
public class HateoasStudentController {
    RestManager rm = new RestManager();

    @RequestMapping(method = RequestMethod.GET, value = "/year",
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Year>> getYear() {
        Collection<Year> yearCollection = rm.getYear().values();
        List<Year> aaa = new ArrayList<>(yearCollection);
        for (Year y : aaa) {
            y.removeLinks();
            y.add(linkTo(methodOn
                    (HateoasStudentController.class)
                    .getYearNumber(Integer.toString(y.getYear())))
                    .withRel(y.getDescription()
                    )
            );
        }
        return new ResponseEntity<List<Year>>(aaa, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/year/{yearID}",
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<Year> getYearNumber(@PathVariable String yearID) {
        Year year = rm.getYear().get(yearID);
        year.removeLinks();

        Map<String, Student> mapStudent = rm.getYearStudent().get(yearID);
        for (Map.Entry<String, Student> entry : mapStudent.entrySet()) {
            Student stud = mapStudent.get(entry.getKey());
            year.add(linkTo(methodOn(HateoasStudentController.class).getStudent(yearID, entry.getKey())).withRel(stud.getLastName()));
        }
        //self
        year.add(linkTo(methodOn(HateoasStudentController.class).getYearNumber(yearID)).withSelfRel());
        return new ResponseEntity<Year>(year, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/year/{yearID}/student/{studentID}",
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<Student> getStudent(@PathVariable String yearID, @PathVariable String studentID) {
        Map<String, Student> mapStudent = rm.getYearStudent().get(yearID);
        Student stud = mapStudent.get(studentID);
        stud.removeLinks();
        List<Subject> listSubject = rm.getStudentsSubjects().get(studentID);

        for (Subject S : listSubject) {
            stud.add(linkTo(methodOn(HateoasStudentController.class).getSubjects(yearID, studentID)).withRel(S.getName()));
        }

        stud.add(linkTo(methodOn(HateoasStudentController.class).getStudent(yearID, studentID)).withSelfRel());
        return new ResponseEntity<Student>(stud, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/year/{yearID}/student/{studentID}/subjects",
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<Subject>> getSubjects(@PathVariable String yearID, @PathVariable String studentID) {

        List<Subject> listSubject = rm.getStudentsSubjects().get(studentID);
        return new ResponseEntity<List<Subject>>(listSubject, HttpStatus.OK);
    }

}
