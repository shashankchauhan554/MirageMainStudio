import { Injectable, inject } from '@angular/core';
import { CanActivateFn, RouterLink } from '@angular/router';
import { Router } from '@angular/router';
// import { RouteService } from '../services/route.service';

export const SalonauthGuard: CanActivateFn = (router, state) => {

  
  //const routeService = inject(RouteService)
  let role = localStorage.getItem('userRole');
  if (role == 'OWNER') {
    // alert("Invalid credentials, Register first...!") ;
    return true;

  }
  else {
  alert("Not Allowed: Please log in as a Salon Owner")
  return false;
  }
};