import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { MatInputModule } from '@angular/material/input';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatTableModule } from '@angular/material/table';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookingServiceComponent } from './booking-service/booking-service.component';
import { BookingFormComponent } from './booking-form/booking-form.component';
import { AppointmentListComponent } from './appointment-list/appointment-list.component';
import { AvailabilityCheckerComponent } from './availability-checker/availability-checker.component';
import { HttpClientModule } from '@angular/common/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations'
import {MatSelectModule} from '@angular/material/select';
import { SuccessComponent } from './success/success.component';
import { FailureComponent } from './failure/failure.component';
import {MatIconModule} from '@angular/material/icon';



@NgModule({
  declarations: [
    AppComponent,
    BookingServiceComponent,
    BookingFormComponent,
    AppointmentListComponent,
    AvailabilityCheckerComponent,
    SuccessComponent,
    FailureComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    MatTableModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatFormFieldModule,
    HttpClientModule,
    MatSelectModule,
    MatIconModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
