package org.artevseev.links;

import lombok.Getter;

@Getter
public class Parameters {
    private String email = "";
    private String name = "";
    private String course_id = "";
    private String module_id = "";
    private String lesson_id = "";
    private String emptyLink;

    public Parameters(String emptyLink){
        this.emptyLink = emptyLink;
    }

    public Parameters setEmail(String email){
        int index = email.indexOf("@");
        if(index != -1) {
            this.email = email.substring(0, index)
                    + "%40" + email.substring(index + 1);
        }
        else this.email = email;
        return this;
    }

    public Parameters setName(String name) {
        this.name = name;
        return this;
    }

    public Parameters setCourse_id(String course_id) {
        this.course_id = course_id;
        return this;
    }

    public Parameters setModule_id(String module_id) {
        this.module_id = module_id;
        return this;
    }

    public Parameters setLesson_id(String lesson_id) {
        this.lesson_id = lesson_id;
        return this;
    }

    public Parameters setEmptyLink(String emptyLink){
        this.emptyLink = emptyLink;
        return this;
    }

}
