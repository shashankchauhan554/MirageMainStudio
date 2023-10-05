import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatSelectModule } from '@angular/material/select';
import { MatRadioModule } from '@angular/material/radio';
import { MatCardModule } from '@angular/material/card';
import { RouterModule } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { SignupComponent } from './components/signup/signup.component';
import { HeaderComponent } from './header/header.component';
import { LayoutModule } from '@angular/cdk/layout';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatSidenavModule } from '@angular/material/sidenav';
import { MatIconModule } from '@angular/material/icon';
import { MatListModule } from '@angular/material/list';
import { PaymentComponent } from './components/payment/payment.component';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatNativeDateModule} from '@angular/material/core';
// import { FormsModule } from '@angular/forms';

import { SalonHomepageComponent } from './components/salon/salon-homepage/salon-homepage.component';
import { SalonHeaderComponent } from './components/salon/salon-header/salon-header.component';
import { SalonFooterComponent } from './components/salon/salon-footer/salon-footer.component';
import { SalonContentComponent } from './components/salon/salon-content/salon-content.component';

// import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { SalonAddSalonownerComponent } from './components/salon/salon-add-salonowner/salon-add-salonowner.component';
import { SalonUpdateSalonownerComponent } from './components/salon/salon-update-salonowner/salon-update-salonowner.component';
import { SalonGetSalonComponent } from './components/salon/salon-get-salon/salon-get-salon.component';
import { SalonGetOwnerComponent } from './components/salon/salon-get-owner/salon-get-owner.component';
import { MatMenuModule } from '@angular/material/menu';
import { SalonAddOwnerComponent } from './components/salon/salon-add-owner/salon-add-owner.component';
import { SalonAddsalonbyowneridSalonComponent } from './components/salon/salon-addsalonbyownerid-salon/salon-addsalonbyownerid-salon.component';
import { SalonAddcategorybysalonidSalonComponent } from './components/salon/salon-addcategorybysalonid-salon/salon-addcategorybysalonid-salon.component';
import { SalonGetSaloncategoryComponent } from './components/salon/salon-get-saloncategory/salon-get-saloncategory.component';
import { SalonGetbysalonidSalonComponent } from './components/salon/salon-getbysalonid-salon/salon-getbysalonid-salon.component';
import { SalonUpdateSalonComponent } from './components/salon/salon-update-salon/salon-update-salon.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    HeaderComponent,
    PaymentComponent,
    SalonHomepageComponent,
    SalonHeaderComponent,
    SalonFooterComponent,
    SalonContentComponent,
    SalonAddSalonownerComponent,
    SalonUpdateSalonownerComponent,
    SalonGetSalonComponent,
    SalonAddcategorybysalonidSalonComponent,
    SalonGetSaloncategoryComponent,
    SalonGetbysalonidSalonComponent,
    SalonUpdateSalonComponent,
    SalonGetOwnerComponent,
    SalonAddOwnerComponent,
    SalonAddsalonbyowneridSalonComponent,
  ],
  imports: [
    FormsModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatInputModule,
    MatButtonModule,
    MatMenuModule,
    MatSelectModule,
    MatRadioModule,
    MatCardModule,
    ReactiveFormsModule,
    RouterModule,
    HttpClientModule,
    LayoutModule,
    MatToolbarModule,
    MatSidenavModule,
    MatIconModule,
    MatListModule,
    FormsModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatNativeDateModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
