import { Component } from '@angular/core';
import { Router } from '@angular/router';
​
import { LoginComponent } from '../login/login.component';
import { UserServiceService } from '../../services/user-service/user-service.service';
​
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
 constructor(private router: Router, private login: UserServiceService,private local: LocalStorageService){}
 username: string | undefined;
​
 
​
 ngOnInit(): void {
   const currentUser: User | null = this.local.getCurrentUser();
   if (currentUser) {
     this.username = currentUser.userName;
   }
 }
​
​
   loginCheck(){
   this.router.navigateByUrl('login');
   }
   profile(){
     this.router.navigateByUrl('profile');
   }
   order(){
     this.router.navigateByUrl('Services');
   }
   
   subscribe(){
     this.router.navigateByUrl('subscribe');
   }
   register(){
     this.router.navigateByUrl('register');
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
}