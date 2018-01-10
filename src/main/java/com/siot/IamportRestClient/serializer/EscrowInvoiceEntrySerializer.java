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
import com.siot.IamportRestClient.request.escrow.EscrowLogisInvoiceData;
import com.siot.IamportRestClient.response.escrow.EscrowLogisInvoice;

public class EscrowInvoiceEntrySerializer implements JsonSerializer<EscrowLogisInvoiceData>, JsonDeserializer<EscrowLogisInvoice> {

	public JsonElement serialize(EscrowLogisInvoiceData logis, Type typeOfSrc, JsonSerializationContext context) {
		final JsonObject jsonObject = new JsonObject();
	    jsonObject.addProperty("company", logis.getCompany());
	    jsonObject.addProperty("invoice", logis.getInvoice());
	    jsonObject.addProperty("sent_at", logis.getSentAt().getTime() / 1000L);

	    return jsonObject;
	}
	
	public EscrowLogisInvoice deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
			throws JsonParseException {
		
		if ( json.isJsonObject() ) {
			JsonObject obj = (JsonObject)json;
			
			String company = obj.get("company").getAsString();
			String invoice = obj.get("invoice").getAsString();
			Date sent_at = new Date( obj.get("sent_at").getAsLong() * 1000L );
			Date applied_at = new Date( obj.get("applied_at").getAsLong() * 1000L );
			
			return new EscrowLogisInvoice(company, invoice, sent_at, applied_at);
		}
		
		return null;
	}

}
