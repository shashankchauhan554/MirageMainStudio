import { Component } from '@angular/core';
import { Router } from '@angular/router';
​
import { LoginComponent } from '../login/login.component';
import { UserServiceService } from '../../services/user-service/user-service.service';
import { LocalstorageservicesService } from 'src/app/services/localstorageservices.service';
import { SignupComponent } from '../signup/signup.component';
import { User } from 'src/app/model/user';


​
@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
 

  }