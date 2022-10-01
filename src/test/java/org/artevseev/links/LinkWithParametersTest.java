package org.artevseev.links;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkWithParametersTest {

    @Test
    void TestSetParameters() {
        Parameters parametersKW1 = new LinkWithParameters("https://api.100points.ru/exchange/index?email=&name=&course_id=25&module_id=47&lesson_id=141")
                .getParameters();
        Parameters parametersKW2 = new Parameters("https://api.100points.ru/exchange/index?email=&name=&course_id=&module_id=&lesson_id=");
        parametersKW2
                .setCourse_id("25")
                .setModule_id("47")
                .setLesson_id("141");
        assertEquals(parametersKW2.getLesson_id(), parametersKW1.getLesson_id());
    }

    @Test
    void TestGetParameters() {
        LinkWithParameters link = new LinkWithParameters("https://api.100points.ru/exchange/index?email=&name=&course_id=25&module_id=47&lesson_id=141");
        Parameters par = new Parameters("https://api.100points.ru/exchange/index?email=&name=&course_id=25&module_id=47&lesson_id=");
        par.setLesson_id("141");
        String s = link.getParameters().getLesson_id();
        assertEquals(par.getLesson_id(), s);
    }
}