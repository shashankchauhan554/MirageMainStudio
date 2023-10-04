
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';

@Component({
  selector: 'app-salon-getbysalonid-salon',
  templateUrl: './salon-getbysalonid-salon.component.html',
  styleUrls: ['./salon-getbysalonid-salon.component.css']
})
export class SalonGetbysalonidSalonComponent {
  getJsonValue: any;
  constructor(private http: HttpClient,private getbyIdService: SalonownerService) {}

  getbyid(id :String){

    this.getbyIdService.getbyid(id).subscribe((data:any)=>{
      this.getJsonValue = data.content;

    });
  }
  deletesalon(id:String){
    this.getbyIdService.deletebysalonid(id).subscribe((response: any) => {
      if(response.success){
       alert("Salon  Data  Deleted succesfully")}
    })
  }


}
