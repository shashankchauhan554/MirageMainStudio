
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';

@Component({
  selector: 'app-salon-addcategorybysalonid-salon',
  templateUrl: './salon-addcategorybysalonid-salon.component.html',
  styleUrls: ['./salon-addcategorybysalonid-salon.component.css']
})
export class SalonAddcategorybysalonidSalonComponent {
  salonId: any;
  categoryId = "";
  categoryType = "";
  price: any;
  acNonAc = "";
  wifi = "";
  maintanance = "";

  constructor(
    private http: HttpClient,
    private addCategoryService: SalonownerService
  ) { }


  getbyid(id: String) {
    this.salonId = id;
  }
  submitForm() {
    const formData = new FormData();



    formData.append('categoryId', this.categoryId);
    formData.append('categoryType', this.bedType);
    formData.append('price', this.price);
    formData.append('acNonAc', this.acNonAc);
    formData.append('wifi', this.wifi);
    formData.append('maintanance', this.maintanance);


    this.addCategoryService.addCategory(formData, this.salonId).subscribe(
      (response: any) => {

        alert('Category added Succesfully');
      },
      (error) => {
        console.log('error in adding Category', error);
        alert('Enter valid details.');
      }
    );
  }
}





