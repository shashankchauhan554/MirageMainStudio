import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
import { PaymentComponent } from './components/payment/payment.component';
import { HomeComponent } from './components/home/home.component';

// import { authGuard } from './guard/auth.guard';

import { SalonContentComponent } from './components/salon/salon-content/salon-content.component';
import { SalonHomepageComponent } from './components/salon/salon-homepage/salon-homepage.component';
import { SalonAddSalonownerComponent } from './components/salon/salon-add-salonowner/salon-add-salonowner.component';
import { SalonUpdateSalonownerComponent } from './components/salon/salon-bookings/salon-update-salonowner.component';
import { SalonGetSalonComponent } from './components/salon/salon-get-salon/salon-get-salon.component';
import { SalonGetOwnerComponent } from './components/salon/salon-get-owner/salon-get-owner.component';
import { SalonauthGuard } from './guard/salonauth.gaurd';
import { SalonAddOwnerComponent } from './components/salon/salon-add-owner/salon-add-owner.component';
import { SalonAddsalonbyowneridSalonComponent } from './components/salon/salon-addsalonbyownerid-salon/salon-addsalonbyownerid-salon.component';
import { SalonAddcategorybysalonidSalonComponent } from './components/salon/salon-addcategorybysalonid-salon/salon-addcategorybysalonid-salon.component';
import { SalonUpdateSalonComponent } from './components/salon/salon-update-salon/salon-update-salon.component';
import { SalonGetSaloncategoryComponent } from './components/salon/salon-get-saloncategory/salon-get-saloncategory.component';
import { SalonGetbysalonidSalonComponent } from './components/salon/salon-getbysalonid-salon/salon-getbysalonid-salon.component';
import { UserProfileDashboardComponent } from './components/user-profile-dashboard/user-profile-dashboard.component';
import { BookingFormComponent } from './booking-form/booking-form.component';
import { BoxesComponent } from './boxes/boxes.component';
import { SalonDetailsComponent } from './components/salon/salon-details/salon-details.component';




const routes: Routes = [



  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },


  {path:"booking-form",component:BookingFormComponent},
{path:"boxes",component:BoxesComponent},
  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},
  {path: 'payment', component:PaymentComponent},
  {path:'userdashboard',component:UserProfileDashboardComponent},
  // {path: 'salon-get-salon',component: SalonGetSalonComponent,canActivate: [SalonauthGuard]},
  {path: 'salon-get-owner',component: SalonGetOwnerComponent,canActivate: [SalonauthGuard],},
  {path: 'boxes/salon-get-category',component: SalonGetSaloncategoryComponent,canActivate: [SalonauthGuard]},
  {path: 'boxes/salon-addbyownerid-salon',component: SalonAddsalonbyowneridSalonComponent,canActivate: [SalonauthGuard]},
  {path: 'boxes/salon-addbysalonid-salon',component: SalonAddcategorybysalonidSalonComponent,canActivate: [SalonauthGuard]},
  {path: 'boxes/salon-update-salon',component: SalonUpdateSalonComponent,canActivate: [SalonauthGuard]},
  {path: 'salon-getbyid-salon',component: SalonGetbysalonidSalonComponent,canActivate: [SalonauthGuard]},
  {path: 'salon-add-salonowner',component: SalonAddSalonownerComponent,canActivate: [SalonauthGuard]},
  {path: 'boxes/salon-bookings',component: SalonUpdateSalonownerComponent,canActivate: [SalonauthGuard]},
  {path: 'salon-homepage',component: SalonHomepageComponent,canActivate: [SalonauthGuard]},
  {path: 'boxes/salon-add-owner', component: SalonAddOwnerComponent,canActivate:[SalonauthGuard]},
  // Userside components
  {path: 'salon-get-salon',component: SalonGetSalonComponent,canActivate: [SalonauthGuard]},
  { path: 'salon/:id', component: SalonDetailsComponent },


  {path:'',component:HomeComponent},
 


  { path: '', component: HomeComponent },
  { path: '', redirectTo: 'home', pathMatch: 'full' },

  
    

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
