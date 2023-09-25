import { Component, inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { UserServiceService } from '../user-service.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  private scall=inject(UserServiceService);
  private fb = inject(FormBuilder);
  loginForm = this.fb.group({
    

    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8)]],
   
   
  });





  

  onSubmit() {
    if (this.loginForm.valid && this.loginForm.dirty) {
    this.scall.loginUser(this.loginForm.value).subscribe((data:any)=>{
        console.log('Form submitted successfully!',data);
        alert('User logged in Successful!');
        // this.router.navigate(['/home']);
      })
      
    } else {
      console.log('Please fill the valid credentials');
    }
  }
}