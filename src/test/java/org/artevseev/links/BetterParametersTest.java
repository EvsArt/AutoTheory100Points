package org.artevseev.links;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BetterParametersTest {

    @Test
    void setEmptyLink() {
        Parameters parameters = new Parameters("https://api.100points.ru/student_homework/index?email=&name=&course_id=&module_id=&lesson_id=");
        String s = parameters.setParameter(ListOfParameters.EMAIL, "wads@saw.ru")
                .generateLink();
        assertEquals("https://api.100points.ru/student_homework/index?email=wads@saw.ru&name=&course_id=&module_id=&lesson_id=", s);
    }

    @Test
    void setParameter() {
    }

    @Test
    void getParameter() {
    }

    @Test
    void deleteParameter() {
    }

    @Test
    void generateLink() {
    }

    @Test
    void copy() {
    }
}