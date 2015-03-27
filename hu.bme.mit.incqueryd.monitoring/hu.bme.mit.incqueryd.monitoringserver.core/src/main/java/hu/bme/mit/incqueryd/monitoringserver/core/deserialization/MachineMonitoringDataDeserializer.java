package hu.bme.mit.incqueryd.monitoringserver.core.deserialization;

import hu.bme.mit.incqueryd.monitoringserver.core.model.MachineMonitoringData;
import hu.bme.mit.incqueryd.osmonitoringagent.metrics.OSMonitoringData;

import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class MachineMonitoringDataDeserializer implements JsonDeserializer<MachineMonitoringData> {

	public MachineMonitoringData deserialize(JsonElement json, Type typeOfT,
			JsonDeserializationContext context) throws JsonParseException {


		JsonObject jsonObject = json.getAsJsonObject();
		JsonObject data = jsonObject.getAsJsonObject("value");
		
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.create();

		OSMonitoringData osData = gson.fromJson( data.toString(), OSMonitoringData.class);
		
		MachineMonitoringData mData = new MachineMonitoringData();
		mData.setOs(osData);
		
		mData.setHost(data.getAsJsonPrimitive("Host").getAsString());

		return mData;
		
	}

}
