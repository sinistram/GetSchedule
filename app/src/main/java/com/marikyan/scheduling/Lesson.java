package com.marikyan.scheduling;

/**
 * Created by Marikyan on 12-May-15.
 */
public class Lesson {

    public enum TypeOfLesson {
        seminar, lecture
    }


    /**
     * @return the typeOfLesson
     */
    public TypeOfLesson getTypeOfLesson() {
        return typeOfLesson;
    }

    /**
     * @param typeOfLesson the typeOfLesson to set
     */
    public void setTypeOfLesson(TypeOfLesson typeOfLesson) {
        this.typeOfLesson = typeOfLesson;
    }

    /**
     * @return the startTime
     */
    public Time getStartTime() {
        return startTime;
    }

    /**
     * @param startTime the startTime to set
     */
    public void setStartTime(Time startTime) {
        this.startTime.setHours(startTime.getHours());
        this.startTime.setMinutes(startTime.getMinutes());
    }

    /**
     * @return the endTime
     */
    public Time getEndTime() {
        return endTime;
    }

    /**
     * @param endTime the endTime to set
     */
    public void setEndTime(Time endTime) {
        this.endTime.setHours(endTime.getHours());
        this.endTime.setMinutes(endTime.getMinutes());
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the teacherName
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * @param teacherName the teacherName to set
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }


    private TypeOfLesson typeOfLesson;
    private Time startTime;
    private Time endTime;
    private String subject;
    private String teacherName;

}

