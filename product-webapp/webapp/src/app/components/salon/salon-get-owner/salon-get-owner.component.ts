import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';

@Component({
  selector: 'app-salon-get-owner',
  templateUrl: './hotel-get-owner.component.html',
  styleUrls: ['./hotel-get-owner.component.css']
})
export class SalonGetOwnerComponent {
  public getJsonValue: any[] = [];
  public postJsonValue: any;
  constructor(private http: HttpClient, private getAllService: SalonownerService) { }
  ngOnInit(): void {
    this.
      getAllDetails()
  }

  getAllDetails() {
    this.getAllService.getAllOwner().subscribe((data: any) => {
      this.getJsonValue = data;

    });
  }

}
