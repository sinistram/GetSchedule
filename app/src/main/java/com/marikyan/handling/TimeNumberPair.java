package com.marikyan.handling;

/**
 * Created by Marikyan on 12-May-15.
 */
import com.marikyan.scheduling.Time;


/**
 *
 * @author Marikyan
 */
public class TimeNumberPair {
    final private Time time;
    private int lineNumber;
    private boolean isFirstPairOfDay;

    public TimeNumberPair(Time time, int lineNumber, boolean isFirstPairOfDay) {
        this.time = time;
        this.lineNumber = lineNumber;
        this.isFirstPairOfDay = isFirstPairOfDay;
    }

    /**
     * @return the time
     */
    public Time getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Time time) {
        this.time.setHours(time.getHours());
        this.time.setMinutes(time.getMinutes());
    }

    /**
     * @return the lineNumber
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * @param lineNumber the lineNumber to set
     */
    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * @return the isFirstPairOfDay
     */
    public boolean isIsFirstPairOfDay() {
        return isFirstPairOfDay;
    }

    /**
     * @param isFirstPairOfDay the ifFirstPairOfDay to set
     */
    public void setIsFirstPairOfDay(boolean isFirstPairOfDay) {
        this.isFirstPairOfDay = isFirstPairOfDay;
    }

}
