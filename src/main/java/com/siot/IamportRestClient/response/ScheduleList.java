package com.siot.IamportRestClient.response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ScheduleList {
    @SerializedName("total")
    private int total;

    @SerializedName("previous")
    private int previous;


    @SerializedName("next")
    private int next;


    @SerializedName("list")
    private List<Schedule> list;

    public ScheduleList(int total, int previous, int next, List<Schedule> list) {
        this.total = total;
        this.previous = previous;
        this.next = next;
        this.list = list;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPrevious() {
        return previous;
    }

    public void setPrevious(int previous) {
        this.previous = previous;
    }

    public int getNext() {
        return next;
    }

    public void setNext(int next) {
        this.next = next;
    }

    public List<Schedule> getList() {
        return list;
    }

    public void setList(List<Schedule> list) {
        this.list = list;
    }
}
