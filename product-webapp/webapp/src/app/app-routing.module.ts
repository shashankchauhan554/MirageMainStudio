
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/login/login.component';
import { SignupComponent } from './components/signup/signup.component';
// import { authGuard } from './guard/auth.guard';





const routes: Routes = [
  {path:'',redirectTo:'home',pathMatch:'full'},

  {path:'login',component:LoginComponent},
  {path:'signup',component:SignupComponent},

   
    // { path: 'landing-page', component: LandingPageComponent },
    { path: '', redirectTo: 'home', pathMatch: 'full' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
