import { Component ,OnInit} from '@angular/core';

import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router } from '@angular/router';
import { UserServiceService } from '../services/user-service/user-service.service';
import { LocalstorageservicesService } from 'src/app/services/localstorageservices.service';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent   {
  isLoggedIn: boolean = false;
  constructor(
    private http: HttpClient,
    private router: Router,
     private login: UserServiceService,
    local : LocalstorageservicesService,
     
   ){
    this.isLoggedIn = !!localStorage.getItem('Token');
   }
    username: string | undefined;
   ​
    
   ​
   /* ngOnInit(): void {
      const isLoggedIn = localStorage.getItem('isLoggedIn');
      this.isLoggedIn = isLoggedIn === 'true';


    }*/
   ​
   ​
      loginCheck(){
    
        this.router.navigateByUrl('login');
        this.isLoggedIn = true;
     

      }
      profile(){
        this.router.navigateByUrl('userdashboard');
        this.isLoggedIn = true;
      }
      order(){
        this.router.navigateByUrl('salon');
      }
      
      subscribe(){
        this.router.navigateByUrl('subscribe');
      }
      register(){
        this.router.navigateByUrl('signup');
        this.isLoggedIn = true;
      }
      
      Cart(){
        this.router.navigateByUrl('myBookings');
      }
      logout(){
        this.isLoggedIn = false;
       localStorage.removeItem('Token');
       //this.router.navigateByUrl('login');
       localStorage.removeItem('userEmail');
       localStorage.removeItem('userRole');
       this.router.navigateByUrl('');
       
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
 


  

}
