import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { PostService } from './services/post.service';
import { AuthService } from './components/auth/auth.service';

@Injectable({
	providedIn: 'root'
})
export class AdminGuard implements CanActivate {

	constructor(private as:AuthService, private router:Router ){}

	canActivate( route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
		if (this.as.isLogged) return true;
    else return this.router.createUrlTree(['/']);
  }
}
