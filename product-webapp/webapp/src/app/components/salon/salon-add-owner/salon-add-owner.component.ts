import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Salon } from 'src/app/model/Salon';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';

@Component({
  selector: 'app-salon-add-owner',
  templateUrl: './salon-add-owner.component.html',
  styleUrls: ['./salon-add-owner.componet.css']
})
export class SalonAddOwnerComponent {
  ownerId = "";
  email = "";
  name = "";
  mobileNo = "";
  referalCode = "";
  addr = "";
  dob = "";
  salonList?: [];
  aprovedbyadmin?: false;

  constructor(
    private http: HttpClient,
    private addOwnerService: SalonownerService
  ) { }

  submitForm() {
    // this.salonList = [];
    // const formData = new FormData();
    // formData.append('ownerId', this.ownerId);
    // formData.append('email', this.email);
    // formData.append('name', this.name);
    // formData.append('mobileNo', this.mobileNo);
    // formData.append('addr', this.addr);
    // formData.append('dob', this.dob);
    // formData.append('salonList', JSON.stringify(this.salonList));
    // formData.append('approvedByAdmin', String(this.aprovedbyadmin));
    // formData.append('maintanance', this.referalCode);
  //   const jsonData = { 
  //     ownerId: "sddddddddddddv",
  //     email: "durgassaha123gmail.com", 
  //     "name": "Backend End Development", 
  //     "mobileNo": "8258734192", 
  //     "referalCode": "sddsds",
  //     "addr": "sdv",
  //     "dob": "1990-04-07",
  //     "approvedByAdmin": false
  // }
  const newOwnerData = {
    ownerId: this.ownerId,
    email: this.email,
    name: this.name,
    mobileNo: this.mobileNo,
    addr: this.addr,
    dob: this.dob,
    approvedByAdmin: false,
    salonList: [],
    maintenance: this.referalCode
  };
    this.addOwnerService.addOwner(newOwnerData).subscribe(
      (response: any) => {
        alert('Owner Added Succesfully');
      },
      (error) => {
        alert('Add valid details');
        console.log(error);
        console.log(error.error.message);
      }
    );
  }

}






