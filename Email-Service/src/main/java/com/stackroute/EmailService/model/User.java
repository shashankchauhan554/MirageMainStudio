package com.stackroute.EmailService.model;

import lombok.*;
import org.springframework.data.annotation.Id;

@Data

@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    private String email;
    private boolean confirmed;


}
