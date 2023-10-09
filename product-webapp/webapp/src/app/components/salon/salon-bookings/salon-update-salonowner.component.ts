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
  public getJsonValue: any[] = [];
  public postJsonValue: any;
  constructor(
    private http: HttpClient,
    private getAllService: SalonownerService
  ) {}
  ngOnInit() {
    const email = localStorage.getItem('userEmail');
    this.getAllDetails(email);
  }
  getAllDetails(email:any) {
    this.getAllService.getAllSalonbookings(email).subscribe((data: any) => {
      this.getJsonValue = data;
      console.log(data);
    });
  }
  deletesalon(id: String) {
    this.getAllService.deletebysalonid(id).subscribe((response: any) => {
      if (response.success) {
        alert('Salon Data Deleted succesfully');
      }
    });
  }

}







