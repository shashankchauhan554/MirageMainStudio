import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';

@Component({
  selector: 'app-salon-get-salon',
  templateUrl: './salon-get-salon.component.html',
  styleUrls: ['./salon-get-salon.component.css']
})

export class SalonGetSalonComponent {
  public getJsonValue: any[] = [];
  public postJsonValue: any;
  constructor(private http: HttpClient, private getAllService: SalonownerService) { }
  ngOnInit() {
    this.
      getAllDetails()
  }

  getAllDetails() {
    this.getAllService.getAllSalons().subscribe((data: any) => {
      this.getJsonValue = data.content;
    });
  }

  deletesalon(id: String) {
    this.getAllService.deletebysalonid(id).subscribe((response: any) => {
      if (response.success) {
        alert("Salon Data Deleted succesfully")
      }
    })
  }

}
