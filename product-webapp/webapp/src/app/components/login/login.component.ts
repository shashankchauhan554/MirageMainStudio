import { Component, inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UserServiceService } from '../../services/user-service/user-service.service';

import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  private scall=inject(UserServiceService);
  private fb = inject(FormBuilder);
  private router=inject(Router);
  responseData: any;
  
  loginForm = this.fb.group({


    userEmail: ['', [Validators.required, Validators.email]],
    userPassword: ['', [Validators.required, Validators.minLength(3)]],


  });
  onSubmit() {
    if (this.loginForm.valid && this.loginForm.dirty) {
      console.log(this.loginForm.value)
    this.scall.loginUser(this.loginForm.value).subscribe((data:any)=>{
      this.responseData = data;
        console.log('Form submitted successfully!',data);
        localStorage.setItem('Token', this.responseData.Token);
        localStorage.setItem('userEmail', this.responseData.userEmail);
        localStorage.setItem('userRole', this.responseData.userRole);
        alert('User logged in Successful!');
        
        this.router.navigate(['']);
      })

    } else {
      alert('Please fill the valid credentials!');
      console.log('Please fill the valid credentials');
    }
  }
}
