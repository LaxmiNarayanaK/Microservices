package com.pstravelaggregator.SearchMicroservice.services;

import com.fasterxml.jackson.databind.JsonNode;
import okhttp3.*;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SearchService {

    @Autowired
    OkHttpClient client;

    public JSONObject getAll(String collectionName, JsonNode query){

        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, query.toString());
        Request request = new Request.Builder()
                .url("https://search-ps-ta-opensearch-service-t3-ghpivubkvzslbo4j2yjk5lf6iu.us-east-1.es.amazonaws.com/" + collectionName + "/_search")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Basic YWRtaW46UGFzc3dvcmRAMTIz")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            if(response.isSuccessful()){
                if(response.body()!=null){
                    return new JSONObject(response.body().string());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return new JSONObject("{'status' : '404'}");
    }

}
