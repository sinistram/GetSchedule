package com.marikyan.scheduling;

/**
 * Created by Marikyan on 12-May-15.
 */
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Marikyan
 */
public class DaySchedule {
    private final List<Lesson> lessons = new LinkedList<>();

    /**
     * @return the lessons
     */
    public List<Lesson> getLessons() {
        return lessons;
    }
}
