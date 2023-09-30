import { Injectable, inject } from '@angular/core';
import {  CanActivateFn} from '@angular/router';
// import { RouteService } from '../services/route.service';



export const SalonauthGuard : CanActivateFn = (route, state) => {

    // const routeService = inject(RouteService)
    let token = sessionStorage.getItem('bearerToken')
    if (!token || token == 'undefined') {
      alert("Invalid credentials, Register first...!") ;
      return false;
    }
    else {

      return true;
    }

  };
