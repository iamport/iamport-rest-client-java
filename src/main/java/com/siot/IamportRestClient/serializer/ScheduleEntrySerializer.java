package com.siot.IamportRestClient.serializer;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.siot.IamportRestClient.request.ScheduleEntry;
import com.siot.IamportRestClient.response.Schedule;

public class ScheduleEntrySerializer implements JsonSerializer<ScheduleEntry>, JsonDeserializer<Schedule> {

    public JsonElement serialize(ScheduleEntry entry, Type typeOfSrc, JsonSerializationContext context) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("merchant_uid", entry.getMerchantUid());
        jsonObject.addProperty("schedule_at", entry.getScheduleAt().getTime() / 1000L);
        jsonObject.addProperty("amount", entry.getAmount());
        jsonObject.addProperty("tax_free", entry.getTaxFree());
        jsonObject.addProperty("name", entry.getName());
        jsonObject.addProperty("buyer_name", entry.getBuyerName());
        jsonObject.addProperty("buyer_email", entry.getBuyerEmail());
        jsonObject.addProperty("buyer_tel", entry.getBuyerTel());
        jsonObject.addProperty("buyer_addr", entry.getBuyerAddr());
        jsonObject.addProperty("buyer_postcode", entry.getBuyerPostcode());
        jsonObject.addProperty("custom_data", entry.getCustomData());
        jsonObject.addProperty("notice_url", entry.getNoticeUrl());

        return jsonObject;
    }

    public Schedule deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {

        if (json.isJsonObject()) {
            JsonObject obj = (JsonObject) json;

            long unix_time = obj.get("schedule_at").getAsLong();
            Date schedule_dt = new Date(unix_time * 1000L);

            return new Schedule(obj.get("customer_uid").getAsString(), obj.get("merchant_uid").getAsString(), schedule_dt, obj.get("amount").getAsBigDecimal());
        }

        return null;
    }

}
