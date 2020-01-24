import { Injectable } from '@angular/core';
import { CanActivate, RouterStateSnapshot, ActivatedRouteSnapshot, Router } from '@angular/router';
import { DataService } from "./data.service";
@Injectable({
  providedIn: 'root'
})
export class AuthService  implements CanActivate
{
  constructor(private router:Router,private s:DataService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot)
  {
   if(this.IsLoggedIn())
   {
     console.log("User Has Logged in");
     return true;
   }
   else
   {
    console.log("User Has not Logged in");
     this.router.navigate(['/admin']);
     return false;  
   }
  }

  IsLoggedIn()
  {
    
    if(window.sessionStorage.getItem("isActive")!=null 
        && 
       window.sessionStorage.getItem("isActive")=="1")
    {
      // some logic to check if person has logged in
      return true;
    }
    else{
      return false;
    }
  }
  result:any;
  CheckCredentialsWithDB(credentials)
  {
    //Call Some  Service using Post Method
    //to check credentials with DB 
    console.log(credentials);
    this.s.validate(credentials).subscribe(r=>{
      this.result = r;
      console.log(this.result)
      if(this.result!=null)
      {
        window.sessionStorage.setItem("isActive", "1");
        window.sessionStorage.setItem("name",this.result.userName)
        this.router.navigate(['/admin/home']);
      }
      else
      {
        return false;
      }
  
    })
    return false;

   
  }

  Logout()
  {
    window.sessionStorage.setItem("isActive", "0");
    this.router.navigate(['']);
  }

}


