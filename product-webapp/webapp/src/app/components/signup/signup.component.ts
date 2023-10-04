import { Component, inject } from '@angular/core';
import { FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UserServiceService } from '../../services/user-service/user-service.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {
  private scall=inject(UserServiceService)
  private router=inject(Router)
  private fb = inject(FormBuilder);
  signupForm = this.fb.group({
    
    fullName: ['', Validators.required],
    email: ['', [Validators.required, Validators.email]],
    password: ['', [Validators.required, Validators.minLength(8)]],
    phonenumber: ['', [Validators.required, Validators.pattern('^[0-9]{10}$')]],
    role: ['CUSTOMER', Validators.required],
    gender: ['MALE', Validators.required],
    age: [null, Validators.required]
   
  });

  





  

  onSubmit() {
    if (this.signupForm.valid && this.signupForm.dirty) {

 console.log('Form submitted successfully!',this.signupForm);
      this.scall.registerUser(this.signupForm.value).subscribe((data:any)=>{
        console.log('Form submitted successfully!',data);
        alert('Form submitted successfully!');
        
        this.router.navigate(['/login']);
      })
     
      
    } else {
      console.log('Please fill in all the required fields.');
    }
  }
 
}

