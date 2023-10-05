import { Component, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AppointmentService } from '../appointment.service'; // Import your service

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrls: ['./booking-form.component.css']
})
export class BookingFormComponent {
  bookingDetails: any = {};
  
  loading:any;

  booking_value_change_from_backend:any;

  data_send_to_success:any={}

  foods: any = [
    {value: 'salon-0', viewValue: 'Salon 0'},
    {value: 'salon-1', viewValue: 'Salon 1'},
    {value: 'salon-2', viewValue: 'Salon 2'},
  ];
  constructor(private bookingService: AppointmentService) {}

  submitBooking(bookingForm:NgForm) {
    const formdata:any=bookingForm.value;
    console.log("Actual Form:",formdata);
    this.loading=true
    this.bookingService.createAppointment(formdata).subscribe((Response:any)=>{
      console.log("Backend Response :",Response);
      this.data_send_to_success=Response;
      console.log("send to child",this.data_send_to_success);    
    },(error:any)=>{
      console.log(error);
    }
    );
    setTimeout(()=>{
      this.loading=false;
      this.booking_value_change_from_backend=true
      if(this.booking_value_change_from_backend===true){
        setTimeout(()=>{
          console.log("redirect to payment")
        },1000)
      }
    },1000)
    
  }
}
interface Appointment{
  appointmentDate:string;
  customerName:string;
  //phone:string;
 // barberId:number;
  salonName:string;
  startTime:string;
  endTime:string;


}