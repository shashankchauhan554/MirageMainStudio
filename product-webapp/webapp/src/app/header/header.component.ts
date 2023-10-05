import { Component } from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';
import { Router } from '@angular/router';
import { UserServiceService } from '../services/user-service/user-service.service';
import { LocalstorageservicesService } from 'src/app/services/localstorageservices.service';


@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  isLoggedIn: boolean = false;
  constructor(
    private router: Router,
     private login: UserServiceService,
    local : LocalstorageservicesService,
     
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
 


  

}
