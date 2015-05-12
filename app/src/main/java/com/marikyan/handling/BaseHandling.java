package com.marikyan.handling;

/**
 * Created by Marikyan on 12-May-15.
 */
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import com.marikyan.scheduling.*;

/**
 *
 * @author Marikyan
 */
public class BaseHandling {

    String filePath = null;
    private List<List<String>> data = null;
    private List<String> groupsNames = null;
    private final static String GROUP_STRING = "групп";

    private final static String DAY_MONDAY = "пн";
    private final static String DAY_TUESDAY = "вт";
    private final static String DAY_WEDNESDAY = "ср";
    private final static String DAY_THURSDAY = "чт";
    private final static String DAY_FRIDAY = "пт";
    private final static String DAY_SATURDAY = "сб";

    private int groupLineNumber = -1;
    private int groupColumnNumber = -1;

    private String seminarString = ("(с.)");

    /**
     * First app should call this method to initialize data
     *
     * @param fileName
     * @throws IOException
     */
    private void initializeData(String fileName) throws Exception {
        filePath = fileName;
        data = XLSXHandling.getDataList(filePath);
    }

    public List<String> getGroupNames(String fileName) throws Exception {
        initializeData(fileName);
        getNumberOfGroups();
        return groupsNames;
    }

    private void getGroupLineNumbers() {
        for (int i = 0; i < data.size(); i++) {
            for (int j = 0; j < data.get(i).size(); j++) {
                if (data.get(i).get(j).toLowerCase().contains(GROUP_STRING)) {
                    groupLineNumber = i;
                    groupColumnNumber = j;
                    return;
                }
            }
        }
    }

    private int getNumberOfGroups() {
        int numberOfGroups = 0;
        getGroupLineNumbers();
        for (String temp : data.get(groupLineNumber) ) {
            if (temp.contains(GROUP_STRING)) {
                numberOfGroups++;
                groupsNames.add(temp);
            }
        }
        return numberOfGroups;
    }

    private int getFirstWeekNumber() {
        for (int i = groupLineNumber; i < data.size(); i++) {
            if (data.get(i).get(0).toLowerCase().contains(DAY_MONDAY)) {
                return 0;
            }
            if (data.get(i).get(0).toLowerCase().contains(DAY_TUESDAY)) {
                return 1;
            }
            if (data.get(i).get(0).toLowerCase().contains(DAY_WEDNESDAY)) {
                return 2;
            }
            if (data.get(i).get(0).toLowerCase().contains(DAY_THURSDAY)) {
                return 3;
            }
            if (data.get(i).get(0).toLowerCase().contains(DAY_FRIDAY)) {
                return 4;
            }
            if (data.get(i).get(0).toLowerCase().contains(DAY_SATURDAY)) {
                return 5;
            }
        }
        return 0;
    }

    private String getFileName(String filePath) {
        int lastIndex1 = filePath.lastIndexOf("\\");
        int lastIndex2 = filePath.lastIndexOf(".");
        return filePath.substring(lastIndex1, lastIndex2);
    }

    public Time getStartTime(String timeString) {
        String trimString = " |\\-|\\.|\\:|\\;|\\,";
        String[] times = timeString.split(trimString);
        int hours = Integer.parseInt(times[0]);
        int minutes = Integer.parseInt(times[1]);
        return new Time(hours, minutes);
    }

    final List<TimeNumberPair> timesPairs = new LinkedList<>();

    public void setSeminarString(String semString) {
        seminarString = semString;
    }

    public void getSchedule() {
        int numberOfGroups = getNumberOfGroups();
        Schedule newSchedule = new Schedule(getFileName(filePath), numberOfGroups);
        Time beforeTime = new Time(0,0);
        for (int i = groupLineNumber + 1; i < data.size(); i++) {
            try {
                Time startTime = getStartTime(data.get(i).get(1));
                boolean over = startTime.compare(beforeTime) > 0;
                timesPairs.add(new TimeNumberPair(startTime, i, over));
            }
            catch (Exception e) {
                //just skip this line
            }
        }
    }


}
