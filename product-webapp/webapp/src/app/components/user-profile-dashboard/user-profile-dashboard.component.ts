import { Component,  OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserRegistrationServiceService } from 'src/app/services/user-dashboard-service/user-registration-service.service';

@Component({
  selector: 'app-user-profile-dashboard',
  templateUrl: './user-profile-dashboard.component.html',
  styleUrls: ['./user-profile-dashboard.component.css']
})
export class UserProfileDashboardComponent implements OnInit {
  //isEditing:boolean = false;
  constructor(private router:Router, private userregistrationservice:UserRegistrationServiceService){}
  userprofiledata:any= { };
  public getJsonValue: any[] = [];
  ngOnInit(): void {
    const email = localStorage.getItem('userEmail');
    this.userregistrationservice.getUserByEmail(email).subscribe(
        (data:any) => {
          console.log(data)
          this.userprofiledata = data;
          console.log(data)
        },
        (error) => {
          console.error('Error fetching profile', error);
        }
      );
      this.getAllDetails(email);
  }

  getAllDetails(email:any) {
    console.log(email);
    this.userregistrationservice.getAllSalonbookings(email).subscribe((data: any) => {
      this.getJsonValue = data;
      console.log("hi");
      console.log(data);
    });
  }

 /* onEdit(){
    this.isEditing = true;
  }
  saveProfile(){
    console.log(this.userprofiledata)
    this.userregistrationservice.putById(this.userprofiledata).subscribe(
    (response) => {
      console.log("Update successful", response)
    },
    (error)=>
    {
      console.log("Error", error)
    }
    );

    this.router.navigate(['home']);
  }
  cancelEdit(){
    this.isEditing = false;
  }*/
  
}
