package com.stackroute.BookingService.Model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
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
    private String CustomerName;
   // private String phone;
   // private long barberId;
    private String salonName;
    private String startTime;
    private String endTime;

}







