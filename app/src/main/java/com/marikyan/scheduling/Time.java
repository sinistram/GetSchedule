package com.marikyan.scheduling;

/**
 * Created by Marikyan on 12-May-15.
 */
/**
 *
 * @author Marikyan
 */

public class Time {

    private int hours;
    private int minutes;

    public Time(int hours, int minutes) {
        this.hours = hours;
        this.minutes = minutes;
    }

    public Time() {
        hours = 0;
        minutes = 0;
    }

    /**
     * @return the hours
     */
    public int getHours() {
        return hours;
    }

    /**
     * @param hours the hours to set
     */
    public void setHours(int hours) {
        if (hours >= 24) {
            this.hours = hours % 24;
        }
        this.hours = hours;
    }

    /**
     * @return the minutes
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * @param minutes the minutes to set
     */
    public void setMinutes(int minutes) {
        if (minutes >= 60) {
            this.minutes = minutes % 60;
        }
        this.minutes = minutes;
    }

    /**
     * Adds time to the object
     *
     * @param time
     */
    public void add(Time time) {
        minutes += time.getMinutes();
        int adding = minutes / 60;
        minutes %= 60;
        hours += adding + time.getHours();
        hours %= 24;
    }

    /**
     * Compare time with the object
     *
     * @param time
     * @return -1, if time > object; 1, if time < object; 0, if time = object
     */
    public int compare(Time time) {
        if (time.getHours() == hours) {
            if (time.getMinutes() == minutes) {
                return 0;
            } else if (time.getMinutes() > minutes) {
                return -1;
            } else {
                return 1;
            }
        } else if (time.getHours() > hours) {
            return -1;
        } else {
            return 1;
        }
    }

}

