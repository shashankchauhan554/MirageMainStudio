import { Injectable } from '@angular/core';
import { UserServiceService } from './user-service/user-service.service';
import { User } from '../model/user';
@Injectable({
  providedIn: 'root'
})
export class LocalstorageservicesService {
  


  constructor( private userServices:UserServiceService) { }

  getCurrentUser():User{
   this.userServices
   .loginUser(this.userServices.loginUser)
   .subscribe((DataTransfer:any )=> {
    localStorage.setItem('currrentUser',JSON.stringify(DataTransfer))
   });
   return JSON.parse(localStorage.getItem("currentUser")|| '{userEmail : "Guest",token:"null" }')
  }

}
