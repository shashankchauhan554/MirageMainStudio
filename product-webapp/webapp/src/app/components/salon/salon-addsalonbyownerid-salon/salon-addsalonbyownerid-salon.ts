import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { HotelownerService } from 'src/app/services/salonowner/salonowner.service';

@Component({
  selector: 'app-hotel-addsalonbyownerid-hotel',
  templateUrl: './hotel-addsalonbyownerid-salon.component.html',
  styleUrls: ['./hotel-addsalonbyownerid-salon.component.css']
})
export class SalonAddsalonbyowneridSalonComponent {
  ownerId: any;
  salonId = "";
  salonName = "";
  price: any;
  acNonAc = "";
  wifi = "";
  maintanance = "";
  salonAddress = "";
  location = "";
  referalCode = "";
  nearbyTraspotation = "";
  gstNumber = "";

  constructor(
    private http: HttpClient,
    private addSalonService: SalonownerService
  ) { }

  getbyid(id: String) {
    this.ownerId = id;
  }
  submitForm() {
    const formData = new FormData();
       formData.append('salonId', this.salonId);
    formData.append('salonName', this.salonName);
    formData.append('price', this.price);
    formData.append('acNonAc', this.acNonAc);
    formData.append('wifi', this.wifi);
    formData.append('salonAddress', this.salonAddress);
    formData.append('location', this.location);
    formData.append('referalCode', this.referalCode);
    formData.append('maintanance', this.maintanance);
    formData.append('nearbyTranspotation', this.nearbyTraspotation);
    formData.append('gstNumber', this.gstNumber);


    this.addSalonService.addSalon(formData, this.ownerId).subscribe(
      (response: any) => {
        alert('added Succesfully');
      },
      (error) => {
        console.log('error in adding Category', error);
        alert('Please give correct details');
      }
    );
  }
}






