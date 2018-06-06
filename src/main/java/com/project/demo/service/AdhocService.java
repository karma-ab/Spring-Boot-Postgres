package com.project.demo.service;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.project.demo.service.interfaces.IAdhocService;

@Service
public class AdhocService implements IAdhocService {

	@Override
	public String getJsonFlat(JSONObject obj) {

		JSONObject result = new JSONObject();
		// obj.keySet().forEach(keys -> {
		// if(obj.get(keys).getClass()==JSONObject.class||obj.get(keys).getClass()==JSONArray.class){
		// JSONObject innerJson = obj.getJSONObject(keys);
		// innerJson.keySet().forEach(innerKeys -> {
		// result.put(keys+"_"+innerKeys, innerJson.get(innerKeys));
		// });
		// }
		// else
		// {
		// result.put(keys, obj.get(keys));
		// }
		// });

		// Map<String, Object> flattenJson = JsonFlattener.flattenAsMap(obj.toString());
		// return flattenJson.toString();
		//return flatten(obj,result).toString();
		return checkFlat(obj, result).toString();
	}

	/*private JSONObject flatten(JSONObject object, JSONObject flattened){
	    if(flattened == null){
	        flattened = new JSONObject();
	    }
	    Iterator<?> keys = object.keys();
	    while(keys.hasNext()){
	        String key = (String)keys.next();
	        try {
	            if(object.get(key) instanceof JSONObject){
	            	flatten(object.getJSONObject(key), flattened);
	            } else {
	                flattened.put(key, object.get(key));
	            }
	        } catch(JSONException e){
	            System.out.println(e);
	        }
	    }
	    return flattened;
	}*/
	
	private JSONObject checkFlat(JSONObject obj, JSONObject returnObj) {

		AtomicInteger count = new AtomicInteger(0);
		obj.keySet().forEach(keys -> {
			if (obj.get(keys).getClass() == JSONObject.class || obj.get(keys).getClass() == JSONArray.class) {

				JSONObject innerJson = obj.getJSONObject(keys);
				innerJson.keySet().forEach(innerKeys -> {

					returnObj.put(keys + "_" + innerKeys, innerJson.get(innerKeys));
					checkFlat(innerJson, returnObj);
				});
			} else {
					returnObj.put(keys, obj.get(keys));
			}
		});
		return returnObj;
	}

}
