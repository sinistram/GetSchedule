package com.marikyan.scheduling;

/**
 * Created by Marikyan on 12-May-15.
 */
/**
 *
 * @author Marikyan
 */
public class Group {

    private String groupName;
    private int groupNumber;
    private final DaySchedule[] allSchedules;

    public Group() {
        this.allSchedules = new DaySchedule[7];
    }

    /**
     *
     * @param weekDay the week day < 7 (0 = monday) @return
     * @return shcedule at weekDay
     */
    public DaySchedule getScheduleAt(int weekDay) {
        return allSchedules[weekDay];
    }

    public boolean setScheduleAt(int weekDay, final DaySchedule daySchedule) {
        if (allSchedules[weekDay] == null) {
            allSchedules[weekDay] = daySchedule;
            return true;
        } else {
            return false;
        }
    }

    /**
     * @return the groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * @param groupName the groupName to set
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * @return the groupNumber
     */
    public int getGroupNumber() {
        return groupNumber;
    }

    /**
     * @param groupNumber the groupNumber to set
     */
    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }
}
