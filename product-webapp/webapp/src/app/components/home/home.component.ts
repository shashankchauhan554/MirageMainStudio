import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { LoginComponent } from '../login/login.component';
import { UserServiceService } from '../../services/user-service/user-service.service';
import { LocalstorageservicesService } from 'src/app/services/localstorageservices.service';
import { SignupComponent } from '../signup/signup.component';
import { User } from 'src/app/model/user';



@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
 

​
 /*ngOnInit(): void {
   const currentUser: User | null = this.local.getCurrentUser();
   if (currentUser) {
    this.username = currentUser.userName;
  }
 }*/
​
​
  /* loginCheck(){
   this.router.navigateByUrl('login');
   }
   profile(){
     this.router.navigateByUrl('userdashboard');
   }
   order(){
     this.router.navigateByUrl('salon');
   }
   
   subscribe(){
     this.router.navigateByUrl('subscribe');
   }
   register(){
     this.router.navigateByUrl('signup');
   }
   
   Cart(){
     this.router.navigateByUrl('booking-service');
   }
   logout(){
    localStorage.removeItem('Token');
    this.router.navigateByUrl('login');
   }
   review(){
     this.router.navigateByUrl('testt');
   }
   bookings(){
    console.log('hello')
    this.router.navigate(['booking-form']);
   }
   feedback(){
    this.router.navigateByUrl("feedback");
   }
*/
  }