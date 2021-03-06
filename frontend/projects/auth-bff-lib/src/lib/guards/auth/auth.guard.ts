import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

import { Observable } from 'rxjs';

import { AuthService } from 'auth-lib';

@Injectable({
  providedIn: 'root'
})
export class BffAuthGuard implements CanActivate {

  constructor(private router: Router,
              private authService: AuthService) {}

  canActivate(next: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    if (this.authService.isAuthenticated()) {
      return true;
    }

    // this.router.navigate(['/login'], { queryParams: { returnUrl: state.url }});
    this.authService.loginWithRedirect();

    return false;
  }

}
