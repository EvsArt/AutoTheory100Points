package org.artevseev.links;

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

    private void setEmail(String email){
        this.email = email;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    private void setModule_id(String module_id) {
        this.module_id = module_id;
    }

    private void setLesson_id(String lesson_id) {
        this.lesson_id = lesson_id;
    }

    public Parameters setEmptyLink(String emptyLink){
        this.emptyLink = emptyLink;
        return this;
    }

    private String getEmail() {
        return email;
    }

    private String getName() {
        return name;
    }

    private String getCourse_id() {
        return course_id;
    }

    private String getModule_id() {
        return module_id;
    }

    private String getLesson_id() {
        return lesson_id;
    }

    public Parameters setParameter(ListOfParameters type, String value){
        switch (type){
            case EMAIL: setEmail(value); break;
            case NAME: setName(value); break;
            case COURSE_ID: setCourse_id(value); break;
            case MODULE_ID: setModule_id(value); break;
            case LESSON_ID: setLesson_id(value); break;
        }
        return this;
    }

    public String getParameter(ListOfParameters type){
        switch (type){
            case EMAIL: return getEmail();
            case NAME: return getName();
            case COURSE_ID: return getCourse_id();
            case MODULE_ID: return getModule_id();
            case LESSON_ID: return getLesson_id();
            default: return "";
        }
    }

    public Parameters deleteParameter(ListOfParameters type){
        switch (type){
            case EMAIL: email = ""; break;
            case NAME: name = ""; break;
            case COURSE_ID: course_id = ""; break;
            case MODULE_ID: module_id = ""; break;
            case LESSON_ID: lesson_id = ""; break;
        }
        return this;
    }

    private String setParameterToLink(ListOfParameters type, String value, String link){
        String res;
        int len = link.length();
        int indexOfStartValue = link.indexOf(type.getParam()+"=") + type.getParam().length() + 1;

        if(indexOfStartValue != len && link.charAt(indexOfStartValue) != '&') {
            link = deleteParameterFromLink(type, link);
        }

        if(indexOfStartValue == len-1){
            res = link.substring(0, indexOfStartValue)
                    + value;
        }

        res = link.substring(0, indexOfStartValue)
                + value
                + link.substring(indexOfStartValue);
        return res;
    }

    private String deleteParameterFromLink(ListOfParameters type, String link){
        String res = "";
        int indexOfStartValue = link.indexOf(type.getParam()+"=") + type.getParam().length() + 1;
        int len = link.length();

        for (int i = indexOfStartValue; i < len; i++) {
            if(link.charAt(i) == '&'){
                res = link.substring(0, indexOfStartValue)
                        + link.substring(i);
                break;
            }else if(i == len-1){
                res = link.substring(0, indexOfStartValue);
            }
        }
        return res;
    }

    public String generateLink(){
        String res;
        res = setParameterToLink(ListOfParameters.EMAIL, email, emptyLink);
        res = setParameterToLink(ListOfParameters.NAME, name, res);
        res = setParameterToLink(ListOfParameters.COURSE_ID, course_id, res);
        res = setParameterToLink(ListOfParameters.MODULE_ID, module_id, res);
        res = setParameterToLink(ListOfParameters.LESSON_ID, lesson_id, res);

        return res;
    }


    public Parameters copy(){
        Parameters res = new Parameters(emptyLink);
        res.emptyLink = this.emptyLink;
        res.email = this.email;
        res.name = this.name;
        res.course_id = this.course_id;
        res.module_id = this.module_id;
        res.lesson_id = this.lesson_id;
        return res;
    }


}
