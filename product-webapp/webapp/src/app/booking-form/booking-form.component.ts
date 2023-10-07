import { Component, Output, OnInit} from '@angular/core';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AppointmentService } from '../appointment.service'; // Import your service
import { SalonownerService } from '../services/salonowner/salonowner.service';

@Component({
  selector: 'app-booking-form',
  templateUrl: './booking-form.component.html',
  styleUrls: ['./booking-form.component.css']
})
export class BookingFormComponent implements OnInit{
  bookingDetails: any = {};
  selectedService :any;
  selectedSlot:any;
  salonName:string='';
  totalPrice:number=0;
  formdata:any={};
  servicesReq:string[]=[];
  
  loading:any;

  booking_value_change_from_backend:any;

  data_send_to_success:any={}

 
  constructor(private bookingService: AppointmentService,private route:Router,private sos:SalonownerService) {}

  // toppings = new FormControl();

  toppingList = [ 'Hair Cutting', 'Shaving','Facial', 'Massage', ];

  ngOnInit(){
    // this.selectedService=this.sos.getSalonServices();
    // console.log(this.selectedService)
    // this.selectedSlot=this.sos.getSlots();
    // console.log(this.selectedSlot);
    this.selectedService=this.sos.selectedSalonServices;
    this.selectedSlot=this.sos.selectedSlots;
    this.salonName=this.sos.salonName;
    this.totalPrice=this.sos.totalPrice;

    console.log(this.selectedService)
    console.log(this.selectedSlot)
    console.log(this.salonName)
    console.log(this.totalPrice)
    console.log(this.selectedService)
   for(const service of this.selectedService){
    this.servicesReq.push(service.serviceName);
   }
   console.log(this.servicesReq)
    

  }


  submitBooking(bookingForm:NgForm) {
   this.formdata=bookingForm.value;
   this.formdata.salonName=this.salonName;
   this.formdata.servicesReq=this.servicesReq;
   this.formdata.appointmentDate=this.selectedSlot[0].slotDate;
   this.formdata.slotTime=this.selectedSlot[0].slotTime;
   this.formdata.totalPrice=this.totalPrice;
    
    console.log("Actual Form:",this.formdata);
    this.loading=true
    this.bookingService.createAppointment(this.formdata).subscribe((Response:any)=>{
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