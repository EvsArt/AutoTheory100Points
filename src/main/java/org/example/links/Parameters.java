package org.example.links;

import lombok.Getter;

@Getter
public class Parameters {
    private String email;
    private String name;
    private String course_id;
    private String module_id;
    private String lesson_id;

    public Parameters setEmail(String email){
        this.email = email;
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
}
