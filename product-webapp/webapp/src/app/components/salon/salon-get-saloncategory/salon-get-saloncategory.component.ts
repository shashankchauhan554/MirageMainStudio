import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';

@Component({
  selector: 'app-salon-get-saloncategory',
  templateUrl: './salon-get-saloncategory.component.html',
  styleUrls: ['./salon-get-saloncategory.component.css']
})
export class SalonGetSaloncategoryComponent {
  salonId: any;
  public getJsonValue: any[] = [];
  public getServicesValue: any[] = [];
  getDetails ={
    salonId:[''],
    salonName:[''],
    salonOwnerName:[''],
    city:[''],
    contactNumber:[''],
    gstNumber:[''],
    email:[''],
    slots:[''],
    salonServices:['']
  };
  public postJsonValue: any;
  constructor(private http: HttpClient, private getCategoryService: SalonownerService) { }
  // ngOnInit(): void {
  //   this.getAllDetails()
    
  // }
  getbyid(id: String) {
    this.salonId = id;
    this.getAllDetails()
  }
  getAllDetails() {
    this.getCategoryService.getAlldetailsById(this.salonId).subscribe((data: any) => {
      this.getJsonValue = data.slots;
      this.getServicesValue = data.salonServices;
      this.getDetails= data;
    });
  }
  deletecategory(id: String) {
    this.getCategoryService.deletebycategoryid(id).subscribe((response: any) => {
      if (response.success) {
        alert("Category  Data  Deleted succesfully")
      }
    })
  }


}
