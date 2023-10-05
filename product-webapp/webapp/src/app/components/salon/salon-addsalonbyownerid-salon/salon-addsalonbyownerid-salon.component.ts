import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
// import { HotelownerService } from 'src/app/services/salonowner/salonowner.service';
import { SalonownerService } from '../../../services/salonowner/salonowner.service';
//import { SalonServices } from 'src/app/model/SalonServices';
@Component({
  selector: 'app-salon-addsalonbyownerid-salon',
  templateUrl: './salon-addsalonbyownerid-salon.component.html',
  styleUrls: ['./salon-addsalonbyownerid-salon.component.css']
})
export class SalonAddsalonbyowneridSalonComponent {
  salonId: any;
  
  //salonServices : any[] = [];
 
  serviceId = "";
  serviceName ="";
  price: any;

  
  

  constructor(
    private http: HttpClient,
    //salonServices : SalonServices[],
    private addSalonService: SalonownerService,
    // private salonServices:[{serviceId:String;
    //   serviceName:String;
    //   price:any; 
    // }]
  ) { }

  getbyid(id: String) {
    this.salonId = id;
  }
  submitForm() {
    // const formData = new FormData();
    // formData.append('salonId', this.salonId);
    // formData.append('serviceId', this.serviceId);
    // formData.append('serviceName', this.serviceName);
    // formData.append('price', this.price);
    
    // console.log(formData)

    const newServiceData = {
      // salonId: this.salonId,
      serviceId: this.serviceId,
      serviceName: this.serviceName,
      price: this.price,
      
    };
     
    
    


      console.log(newServiceData)
      
      

    this.addSalonService.addSalon(newServiceData, this.salonId).subscribe(
      (response: any) => {
        console.log(response)
        alert('added Succesfully');
      },
      (error) => {
        console.log('error in adding Category', error);
        alert('Please give correct details');
      }
    );
  }
}






