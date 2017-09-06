package com.siot.IamportRestClient.serializer;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.siot.IamportRestClient.response.Balance;
import com.siot.IamportRestClient.response.PaymentBalanceEntry;

public class BalanceEntrySerializer  implements JsonDeserializer<PaymentBalanceEntry>  {

	public PaymentBalanceEntry deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		if ( json.isJsonObject() ) {
			JsonObject obj = (JsonObject)json;
			
			long unix_time = obj.get("created").getAsLong();
			Date createdAt = new Date( unix_time * 1000L );
			
			return new PaymentBalanceEntry(
					(Balance)context.deserialize(obj.get("cash_receipt"), Balance.class),
					(Balance)context.deserialize(obj.get("primary"), Balance.class),
					(Balance)context.deserialize(obj.get("secondary"), Balance.class),
					(Balance)context.deserialize(obj.get("discount"), Balance.class),
					createdAt
					);
		}
		
		return null;
	}

}
