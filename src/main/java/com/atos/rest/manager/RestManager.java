package com.atos.rest.manager;

import com.atos.rest.model.Student;
import com.atos.rest.model.Subject;
import com.atos.rest.model.Year;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestManager {
    // Mapa przechowujaca mozliwe lata studiowania
    Map<String,Year> year = new HashMap<String,Year>();
    // Year/Student
    Map<String, Map<String, Student>> yearStudent = new HashMap<String, Map<String, Student>>();
    //Id Studenta, Lista Przedmiotow
    Map<String, List<Subject>> studentsSubjects = new HashMap<String, List<Subject>>();

    //Ten kawalek kodu po stworzeniu obiektu zostanie zawsze wykonany (niezaleznie od uzycia konstruktora) !
    {
        //zawartosc bloku na nastepnym slajdzie
        year.put("1" , new Year(1 ,"Rok pierwszy"));
        year.put("2" , new Year(2 ,"Rok drugi"));
        year.put("3" , new Year(3 ,"Rok trzeci"));
        year.put("4" , new Year(4 ,"Rok czwarty"));

        Map<String,Student> mapStudents = new HashMap<String,Student>();
        mapStudents.put("123",new Student(123,"Jan","Kowalski","FTIMS"));
        mapStudents.put("124",new Student(124,"Tomasz","Nowak","FTIMS"));
        mapStudents.put("125",new Student(125,"Maurycy","Polaski","FTIMS"));
        yearStudent.put("1",mapStudents);
        List<Subject> listSubject = new ArrayList<Subject>();
        listSubject.add(new Subject("SSBD",5));
        listSubject.add(new Subject("BAR",5));
        listSubject.add(new Subject("WAS",5));

        studentsSubjects.put("123",listSubject);
        studentsSubjects.put("124",listSubject);
        studentsSubjects.put("125",listSubject);
    }

    public Map<String, Year> getYear() {
        return year;
    }

    public Map<String, Map<String, Student>> getYearStudent() {
        return yearStudent;
    }

    public Map<String, List<Subject>> getStudentsSubjects() {
        return studentsSubjects;
    }
}
