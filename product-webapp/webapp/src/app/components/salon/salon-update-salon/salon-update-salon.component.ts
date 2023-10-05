
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';
import { FormsModule } from '@angular/forms';
@Component({
  selector: 'app-salon-update-salon',
  templateUrl: './salon-update-salon.component.html',
  styleUrls: ['./salon-update-salon.component.css']
})
export class SalonUpdateSalonComponent {
  getJsonValue: any;
  salonId = "";
  salonName = "";
  salonAddress = "";
  location = "";
  referalCode = "";
  maintanance = "";
  price: any;
  acNonAc = "";
  wifi = "";
  nearbyTraspotation = "";
  constructor(private http: HttpClient, private getbyIdService: SalonownerService, private updateSalonService: SalonownerService) { }

  getbyid(id: String) {

    this.getbyIdService.getbyid(id).subscribe((data: any) => {
      this.getJsonValue = data;
      this.salonId = data.salonId;
      this.salonName = data.salonName;
      this.salonAddress = data.salonAddress;
      this.location = data.location;
      this.referalCode = data.referalCode;
      this.maintanance = data.maintanance;
      this.price = data.price;
      this.acNonAc = data.acNonAc;
      this.nearbyTraspotation = data.nearbyTraspotation;
      this.wifi = data.wifi;
    });
  }

  submitForm() {
    const formData = new FormData();

    formData.append('salonId', this.salonId);
    formData.append('salonName', this.salonName);
    formData.append('salonAddress', this.salonAddress);
    formData.append('location', this.location);
    formData.append('referalCode', this.referalCode);
    formData.append('price', this.price);
    formData.append('acNonAc', this.acNonAc);
    formData.append('wifi', this.wifi);
    formData.append('nearbyTraspotation', this.nearbyTraspotation)
    formData.append('maintanance', this.maintanance);

    this.updateSalonService.updatesalon(formData).subscribe(
      (response: any) => {

        alert('Salon Added Succesfully');
      },
      (error) => {
        console.log('error in adding Salon', error);
        alert('Enter valid details');
      }
    );
  }
}





