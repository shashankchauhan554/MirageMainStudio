package com.stackroute.AuthenticationService.UserModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.simple.JSONObject;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
    private JSONObject jsonObject;
}
