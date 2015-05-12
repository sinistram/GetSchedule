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
public class Schedule {

    public Schedule(String article, int numberOfGroups) {
        this.article = article;
        this.numberOfGroups = numberOfGroups;
    }

    private String article;

    private int numberOfGroups;

    private final List<Group> groups = new LinkedList<>();

    public void setArticle(String Article) {
        this.article = Article;
    }

    public String getArticle() {
        return article;
    }

    /**
     * @return the numberOfGroups
     */
    public int getNumberOfGroups() {
        return numberOfGroups;
    }

    /**
     * @param numberOfGroups the numberOfGroups to set
     */
    public void setNumberOfGroups(int numberOfGroups) {
        this.numberOfGroups = numberOfGroups;
    }

    public Group getGroupAt(int index) {
        return groups.get(index);
    }

    /**
     * Adds a group in the groups
     * @param group
     */
    public void addGroup(Group group) {
        groups.add(group);
    }


}

