package org.artevseev.links;

public enum ListOfParameters {

    EMAIL("email"),
    NAME("name"),
    COURSE_ID("course_id"),
    MODULE_ID("module_id"),
    LESSON_ID("lesson_id");

    ListOfParameters(String param){
        this.param = param;
    }

    private final String param;

    public String getParam() {
        return param;
    }
}
