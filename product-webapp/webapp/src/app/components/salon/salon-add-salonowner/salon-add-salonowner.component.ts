
import { Component } from '@angular/core';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import {
  FormBuilder,
  FormGroup,
  FormsModule,
  Validators,
} from '@angular/forms';

import { BreakpointObserver } from '@angular/cdk/layout';
import { StepperOrientation } from '@angular/cdk/stepper';
import { Observable, map } from 'rxjs';
import { SalonownerService } from 'src/app/services/salonowner/salonowner.service';
import { Router } from '@angular/router';
// import { AuthService } from 'src/app/services/auth.service';
import { SalonOwner } from 'src/app/model/SalonOwner';
import { Salon } from 'src/app/model/Salon';
import { Category } from 'src/app/model/Category';

@Component({
  selector: 'app-salon-add-salonowner',
  templateUrl: './salon-add-salonowner.component.html',
  styleUrls: ['./salon-add-salonowner.component.css'],
})
export class SalonAddSalonownerComponent {
  ngOnInit(): void {}
  salonOwner: SalonOwner;
  salon: Salon;
  category: Category;

  errorMsg: string = 'Error occured while submission.';

  constructor(

    private salonownerService: SalonownerService
  ) {
    this.salonOwner = new SalonOwner();
    this.salon = new Salon();
    this.category = new Category();
  }

  saveData() {

    this.salon.categoryList = Array(this.category);
    this.salonOwner.salonList = Array(this.salon);

    this.salonownerService.addSalonOwner(this.salonOwner).subscribe(
      (resp) => {

        this.salonOwner = new SalonOwner();
        this.salon = new Salon();
        this.category = new Category();
      },
      (error) => {
        console.log(this.errorMsg);
      }
    );
  }

  addSalonOwner() {
    // console.log(this.salonOwner);
  }

  addSalon() {
    // console.log(this.salon);
  }
  addCategory() {
    // console.log(this.category);
  }

}
