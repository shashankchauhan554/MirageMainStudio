import { Component, Output } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
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

 
  constructor(private bookingService: AppointmentService,private route:Router) {}

  // toppings = new FormControl();

  toppingList = [ 'Hair Cutting', 'Shaving','Facial', 'Massage', ];



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
      // if(this.booking_value_change_from_backend===true){
      //   setTimeout(()=>{
      //     this.route.navigate(['payment'])
      //     console.log("redirect to payment")
      //   },1000)
      // }
    },1000)
    
  }
}
interface Appointment{
  appointmentDate:string;
  customerName:string;
  //phone:string;
 // barberId:number;
  salonName:string;
  slotTime:string;
  servicesReq:string;
  totalPrice:string;


}