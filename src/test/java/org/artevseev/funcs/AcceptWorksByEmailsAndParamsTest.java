package org.artevseev.funcs;

import org.artevseev.links.LinkWithParameters;
import org.artevseev.links.ListOfParameters;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AcceptWorksByEmailsAndParamsTest {

    @Test
    void addParameterToLinkTest() {
        LinkWithParameters link = new LinkWithParameters("https://api.100points.ru/student_homework/index?email=&name=&course_id=25&module_id=47&lesson_id=366");
        link.setParameter(ListOfParameters.EMAIL, "aevseev444@gmail.com")
                .setParameter(ListOfParameters.NAME, "Игорь")
                .setParameter(ListOfParameters.COURSE_ID, "82")
                .setParameter(ListOfParameters.COURSE_ID, "83")
                .setParameter(ListOfParameters.MODULE_ID, "10")
                .setParameter(ListOfParameters.LESSON_ID, "20")
                .deleteParameter(ListOfParameters.LESSON_ID)
                .deleteParameter(ListOfParameters.LESSON_ID)
                .setParameter(ListOfParameters.NAME, "AAAAAAA");
        List<String> arrayList = List.of("aevseev444@gmail.com", "AAAAAAA", "83", "10", "");
        for(int i = 0; i < ListOfParameters.values().length; i++){
            assertEquals(arrayList.get(i), link.getParameter(ListOfParameters.values()[i]));
        }
        System.out.println(link.getLink());
    }
}