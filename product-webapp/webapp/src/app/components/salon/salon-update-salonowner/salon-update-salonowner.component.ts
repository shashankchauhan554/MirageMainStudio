import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Salon } from 'src/app/model/Salon';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';

@Component({
  selector: 'app-salon-update-salonowner',
  templateUrl: './salon-update-salonowner.component.html',
  styleUrls: ['./salon-update-salonowner.component.css']
})
export class SalonUpdateSalonownerComponent {
  getJsonValue: any;
  ownerId = "";
  image: File[] = [];
  email = "";
  name = "";
  mobileNo = "";
  referalCode = "";
  addr = "";
  dob = "";
  salonList?: Array<Salon>;
  constructor(private http: HttpClient, private getbyownerIdService: SalonownerService, private updateOwnerService: SalonownerService) { }

  getbyownerid(id: String) {

    this.getbyownerIdService.getbyownerid(id).subscribe((data: any) => {
      this.getJsonValue = data;
      this.ownerId = data.ownerId;
      this.name = data.name;
      this.email = data.email;
      this.mobileNo = data.mobileNo;
      this.referalCode = data.referalCode;
      this.addr = data.addr;
      this.dob = data.dob;
      this.image = data.salonImage;

    });
  }


  imageUpload(event: any) {
    this.image = event.target.files;
  }
  submitForm() {
    const formData = new FormData();



    formData.append('ownerId', this.ownerId);
    formData.append('name', this.name);
    formData.append('email', this.email);
    formData.append('mobileNo', this.mobileNo);
    formData.append('referalCode', this.referalCode);
    formData.append('addr', this.addr);
    formData.append('dob', this.dob);

    // formData.append('image', this.image);
    for (const image of this.image) {
      formData.append('image', image);
    }

    this.updateOwnerService.updateOwner(formData).subscribe(
      (response: any) => {

        alert('Update Succesfully');
      },
      (error) => {

        alert('ownerId not exist in DataBase ');
      }
    );
  }


}







