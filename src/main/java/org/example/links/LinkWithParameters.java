package org.example.links;

public class LinkWithParameters {

    public LinkWithParameters(String link){
        this.link = link;
    }

    private String link;

    public String getLink(){
        return link;
    }

    public LinkWithParameters setParameter(ListOfParameters type, String value){
        int len = link.length();
        int indexOfStartValue = link.indexOf(type.getParam()+"=") + type.getParam().length() + 1;

        if(link.charAt(indexOfStartValue) != '&') {
            link = deleteParameter(type).getLink();
        }

        this.link = link.substring(0, indexOfStartValue)
                + value
                + link.substring(indexOfStartValue);
        return this;
    }

    public LinkWithParameters deleteParameter(ListOfParameters type){
        int indexOfStartValue = link.indexOf(type.getParam()+"=") + type.getParam().length() + 1;
        int len = link.length();

        for (int i = indexOfStartValue; i < len; i++) {
            if(link.charAt(i) == '&'){
                this.link = link.substring(0, indexOfStartValue)
                        + link.substring(i);
                break;
            }else if(i == len-1){
                this.link = link.substring(0, indexOfStartValue);
            }
        }
        return this;
    }

    public String getParameter(ListOfParameters type){
        int indexOfStartValue = link.indexOf(type.getParam()+"=") + type.getParam().length() + 1;
        int indexOfEndValue = 0;
        int len = link.length();

        for (int i = indexOfStartValue; i < len ; i++) {
            if(link.charAt(i) == '&'){
                indexOfEndValue = i;
                break;
            }else if(i == len-1){
                return link.substring(indexOfStartValue);
            }
        }
        if(indexOfStartValue >= indexOfEndValue) return "";
        return link.substring(indexOfStartValue, indexOfEndValue);
    }

    public void setParameters(Parameters parameters){
        this.setParameter(ListOfParameters.EMAIL, parameters.getEmail())
                .setParameter(ListOfParameters.NAME, parameters.getName())
                .setParameter(ListOfParameters.COURSE_ID, parameters.getCourse_id())
                .setParameter(ListOfParameters.MODULE_ID, parameters.getModule_id())
                .setParameter(ListOfParameters.LESSON_ID, parameters.getLesson_id());
    }

}

