import { Component } from '@angular/core';
import { Router } from '@angular/router';
​
import { LoginComponent } from '../login/login.component';
import { UserServiceService } from '../../services/user-service/user-service.service';
import { LocalstorageservicesService } from 'src/app/services/localstorageservices.service';
import { SignupComponent } from '../signup/signup.component';
import { User } from 'src/app/model/user';
import { SalonHomepageComponent } from '../salon/salon-homepage/salon-homepage.component'; 
​
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
 constructor(private router: Router, private login: UserServiceService, local : LocalstorageservicesService
 ){}
 username: string | undefined;
​
 
​
 /*ngOnInit(): void {
   const currentUser: User | null = this.local.getCurrentUser();
   if (currentUser) {
    this.username = currentUser.userName;
  }
 }*/
​
​
   loginCheck(){
   this.router.navigateByUrl('login');
   }
   profile(){
     this.router.navigateByUrl('userdashboard');
   }
   order(){
     this.router.navigateByUrl('salon-homepage');
   }
   
   subscribe(){
     this.router.navigateByUrl('subscribe');
   }
   register(){
     this.router.navigateByUrl('signup');
   }
   
   Cart(){
     this.router.navigateByUrl('myBookings');
   }
   logout(){
    localStorage.removeItem('Token');
    this.router.navigateByUrl('login');
   }
   review(){
     this.router.navigateByUrl('testt');
   }
   bookings(){
    this.router.navigateByUrl('/booking');
   }
   feedback(){
    this.router.navigateByUrl("feedback");
   }

  }