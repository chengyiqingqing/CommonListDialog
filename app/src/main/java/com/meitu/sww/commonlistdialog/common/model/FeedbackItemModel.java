package com.meitu.sww.commonlistdialog.common.model;

import java.io.Serializable;

/**
 * @author ShaoWenWen
 * @date 2019-07-08
 */
public class FeedbackItemModel implements Serializable {

    private int actionType;
    private String title;
    private int eventId;

    public FeedbackItemModel(int actionType, String title, int eventId) {
        this.actionType = actionType;
        this.title = title;
        this.eventId = eventId;
    }

    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

}
