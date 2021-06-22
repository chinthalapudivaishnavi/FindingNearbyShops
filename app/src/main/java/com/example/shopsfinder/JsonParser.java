package com.example.shopsfinder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParser //if possible public here
{
    private HashMap<String,String> parseJsonObject(JSONObject object)
    {
        HashMap<String,String> dataList=new HashMap<>();

        try {
            //get name from object
            String name=object.getString("name");
            String latitude=object.getJSONObject("geometry").getJSONObject("location").getString("lat");
            String longitude=object.getJSONObject("geometry").getJSONObject("location").getString("lng");
            //putting all values in hash map
            dataList.put("name",name);
            dataList.put("lat",latitude);
            dataList.put("lng",longitude);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return dataList;
    }
    private List<HashMap<String,String>> parseJsonArray(JSONArray jsonArray)
    {
        //initializing hashmaplist
        List<HashMap<String,String>> dataList=new ArrayList<>();
        for(int i=0;i<jsonArray.length();i++)  //---------------------Afrin see htis whether length or lenght()
        {
            try {
                HashMap<String,String> data=parseJsonObject((JSONObject)jsonArray.get(i));
                //adding data in hashmap list
                dataList.add(data);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return dataList;
    }
    public List<HashMap<String,String>> parseResult(JSONObject object)
    {
        JSONArray jsonArray=null;

        try {
            //get result array
            jsonArray=object.getJSONArray("results");

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return parseJsonArray(jsonArray);
    }
}
