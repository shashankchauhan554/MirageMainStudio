import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Salon } from 'src/app/model/Salon';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';

@Component({
  selector: 'app-salon-add-owner',
  templateUrl: './salon-add-owner.component.html',
  styleUrls: ['./salon-add-owner.component.css']
})
export class SalonAddOwnerComponent {
  ownerId = "";
  email = "";
  name = "";
  mobileNo = "";
  referalCode = "";
  addr = "";
  dob = "";
  SalonList?: Array<Salon>;

  constructor(
    private http: HttpClient,
    private addOwnerService: SalonownerService
  ) { }


  submitForm() {
    const formData = new FormData();



    formData.append('ownerId', this.ownerId);
    formData.append('email', this.email);
    formData.append('name', this.name);
    formData.append('mobileNo', this.mobileNo);
    formData.append('addr', this.addr);
    formData.append('dob', this.dob);

    formData.append('maintanance', this.referalCode);


    this.addOwnerService.addOwner(formData).subscribe(
      (response: any) => {
        alert('Owner Added Succesfully');
      },
      (error) => {

        alert('Add valid details');
      }
    );
  }

}






