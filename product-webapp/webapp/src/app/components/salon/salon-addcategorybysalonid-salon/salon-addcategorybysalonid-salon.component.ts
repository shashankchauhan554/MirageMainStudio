
import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatInputModule} from '@angular/material/input';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatNativeDateModule} from '@angular/material/core';


@Component({
  selector: 'app-salon-addcategorybysalonid-salon',
  templateUrl: './salon-addcategorybysalonid-salon.component.html',
  styleUrls: ['./salon-addcategorybysalonid-salon.component.css'],
  // imports: [MatFormFieldModule, MatInputModule, MatDatepickerModule, MatNativeDateModule],
})
export class SalonAddcategorybysalonidSalonComponent {
  salonId: any;
  slotId:any;
  slotTime:any;
  slotDate: Date = new Date();  
  slotStatus:any;
  constructor(
    private http: HttpClient,
    private addCategoryService: SalonownerService
  ) { }


  getbyid(id: String) {
    this.salonId = id;
  }

  // getEndDate(type: string, event: MatDatepickerInputEvent<Date>){
  //   console.log(event.value);
  // }
  submitForm() {
    
    
    const newServiceData = {
      // salonId: this.salonId,
      slotId: this.slotId,
      slotDate: this.slotDate,
      slotTime: this.slotTime,
      slotStatus:"Available"
      
    };
     
    
    


      console.log(newServiceData)

   


    this.addCategoryService.addslot(newServiceData, this.salonId).subscribe(
      (response: any) => {

        alert('Slot added Succesfully');
        
        window.location.reload();
      },
      (error) => {
        console.log('error in adding Slot', error);
        alert('Enter valid details.');
      }
    );
  }
}





