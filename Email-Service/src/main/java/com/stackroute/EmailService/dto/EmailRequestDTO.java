package com.stackroute.EmailService.dto;

import lombok.Data;
import org.json.simple.JSONObject;

@Data
public class EmailRequestDTO {

    public static JSONObject jsonObject ;

    public static JSONObject getJsonObject() {
        return  jsonObject;
    }
}