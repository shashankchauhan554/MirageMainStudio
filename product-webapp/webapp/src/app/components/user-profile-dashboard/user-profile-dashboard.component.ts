import { Component,  OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UserRegistrationServiceService } from 'src/app/services/user-dashboard-service/user-registration-service.service';


export class userdata{
  email: string | undefined;
}

export class Data{
  username: string | undefined;
  email    : userdata | undefined;
  gender  : String | undefined;
  phonenumber : number | undefined;
  Role  : String | undefined;
  city  : String | undefined; 
}

@Component({
  selector: 'app-user-profile-dashboard',
  templateUrl: './user-profile-dashboard.component.html',
  styleUrls: ['./user-profile-dashboard.component.css']
})
export class UserProfileDashboardComponent implements OnInit {
  isEditing:boolean = false;
  constructor(private router:Router, private userregistrationservice:UserRegistrationServiceService){}
  userprofiledata:any = {
    "email":'',
    "fullName":'',
    "password":'',
    "gender":'',
    "role":'',
    "phonenumber":'',
    "city":'',
    "age":''
};
  data : Array<Data> = [];
  ngOnInit(): void {
    this.userregistrationservice.getById().subscribe(
        (data) => {
          console.log(data)
          this.userprofiledata = data;
          console.log(data)
        },
        (error) => {
          console.error('Error fetching profile', error);
        }
      );
  }
  onEdit(){
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

    this.router.navigate(['/']);
  }
  cancelEdit(){
    this.isEditing = false;
  }
  
}
