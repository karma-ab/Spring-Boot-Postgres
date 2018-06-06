package com.project.demo.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.project.demo.service.interfaces.IAdhocService;

@Service
public class AdhocService implements IAdhocService {

	@Override
	public String getJsonFlat(JSONObject obj) {
		
		JSONObject result = new JSONObject();
		obj.keySet().forEach(keys -> {
			if(obj.get(keys).getClass()==JSONObject.class||obj.get(keys).getClass()==JSONArray.class){
				JSONObject innerJson = obj.getJSONObject(keys);
				innerJson.keySet().forEach(innerKeys -> {
					result.put(keys+"_"+innerKeys, innerJson.get(innerKeys));
				});
			}
			else
			{
				result.put(keys, obj.get(keys));
			}
		});
		System.out.println(result);
		return result.toString();
	}
	
	private JSONObject checkFlat(JSONObject obj){
		obj.keySet().forEach(keys -> {
			if(obj.get(keys).getClass()==JSONObject.class||obj.get(keys).getClass()==JSONArray.class){
				JSONObject innerJson = obj.getJSONObject(keys);
				innerJson.keySet().forEach(innerKeys -> {
					checkFlat(innerJson);
					result.put(keys+"_"+innerKeys, innerJson.get(innerKeys));
				});
			}
			else
			{
				result.put(keys, obj.get(keys));
			}
		});
	}

}
