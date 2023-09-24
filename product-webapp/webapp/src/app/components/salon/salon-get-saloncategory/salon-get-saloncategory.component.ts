import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';

@Component({
  selector: 'app-salon-get-saloncategory',
  templateUrl: './salon-get-saloncategory.component.html',
  styleUrls: ['./salon-get-saloncategory.component.css']
})
export class SalonGetSaloncategoryComponent {
  public getJsonValue: any[] = [];
  public postJsonValue: any;
  constructor(private http: HttpClient, private getCategoryService: SalonownerService) { }
  ngOnInit(): void {
    this.getAllDetails()
  }

  getAllDetails() {
    this.getCategoryService.getAllCategory().subscribe((data: any) => {
      this.getJsonValue = data;
    });
  }
  deletecategory(id: String) {
    this.getCategoryService.deletebycategoryid(id).subscribe((response: any) => {
      if (response.success) {
        alert("Category  Data  Deleted succesfully")
      }
    })
  }


}
