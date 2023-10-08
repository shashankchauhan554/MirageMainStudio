package com.stackroute.BookingService.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Arrays;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "appointments_new")
public class Appointment {
    @Id
    private long id;
    private String appointmentDate;
    private String customerName;
    private String salonName;
    private String slotTime;
    private String[] servicesReq;
    private String totalPrice;
    private String email;
    private String city;

}







