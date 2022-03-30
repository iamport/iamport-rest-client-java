package com.siot.IamportRestClient.request;

import com.google.gson.annotations.SerializedName;

public class GetScheduleData {

    @SerializedName("schedule_from")
    private int schedule_from;

    @SerializedName("schedule_to")
    private int schedule_to;

    @SerializedName("schedule_status")
    private String schedule_status;

    @SerializedName("page")
    private int page;

    @SerializedName("limit")
    private int limit;

    public GetScheduleData(int schedule_from, int schedule_to, String schedule_status, int page, int limit) {
        this.schedule_from = schedule_from;
        this.schedule_to = schedule_to;
        this.schedule_status = schedule_status;
        this.page = page;
        this.limit = limit;
    }

    public int getSchedule_from() {
        return schedule_from;
    }

    public void setSchedule_from(int schedule_from) {
        this.schedule_from = schedule_from;
    }

    public int getSchedule_to() {
        return schedule_to;
    }

    public void setSchedule_to(int schedule_to) {
        this.schedule_to = schedule_to;
    }

    public String getSchedule_status() {
        return schedule_status;
    }

    public void setSchedule_status(String schedule_status) {
        this.schedule_status = schedule_status;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
