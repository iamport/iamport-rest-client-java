package com.siot.IamportRestClient.request;

import com.google.gson.annotations.SerializedName;

public class ScheduleUpdateData {

	@SerializedName("schedule_at")
	private long schedule_at;

	public ScheduleUpdateData(long schedule_at) {
		this.schedule_at = schedule_at;
	}

	public long getSchedule_at() {
		return schedule_at;
	}
}
