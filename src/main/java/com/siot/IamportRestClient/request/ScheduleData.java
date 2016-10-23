package com.siot.IamportRestClient.request;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class ScheduleData {

	@SerializedName("customer_uid")
	private String customer_uid;
	
	@SerializedName("schedules")
	private List<ScheduleEntry> schedules;
	
	public ScheduleData(String customer_uid) {
		this.customer_uid = customer_uid;
		this.schedules = new ArrayList<ScheduleEntry>();
	}
	
	public void addSchedule(ScheduleEntry entry) {
		schedules.add(entry);
	}
	
	public List<ScheduleEntry> getSchedules() {
		return schedules;
	}
	
}
