package com.devin.bullshitgenerator.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JSONUtils {

    private JSONUtils() {
    }

    public static List<String> getList(String key) {
        BufferedReader reader = null;
        StringBuilder sb = new StringBuilder();

        try {
            ClassPathResource classPathResource = new ClassPathResource("data.json");
            InputStream inputStream = classPathResource.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            reader = new BufferedReader(inputStreamReader);

            String tempStr = null;
            while ((tempStr = reader.readLine()) != null) {
                sb.append(tempStr);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        String jsonContent = sb.toString();
        JSONObject jsonObject = JSON.parseObject(jsonContent);
        JSONArray jsonArray = jsonObject.getJSONArray(key);

        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }
}
