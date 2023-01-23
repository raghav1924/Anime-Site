import { Component } from '@angular/core';
import { DbServiceService } from '../services/db-service.service';
import { FormControl, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.css']
})
export class UserLoginComponent {
  constructor(private help:DbServiceService,private router:Router){}
  loginForm=new FormGroup({
    'email':new FormControl(),
    'password':new FormControl(),
  })
receivedData:any;
  sendSignUpData(){
    console.log(this.loginForm.value);
    this.help.login(this.loginForm.value).subscribe({next:data=>{
      this.receivedData=data;
      console.log(this.receivedData);
      console.log(this.receivedData.userEmail)
      console.log(this.receivedData.token)
      console.log(this.receivedData.userRole)
      localStorage.setItem('token',this.receivedData.token)
      localStorage.setItem('role',this.receivedData.userRole)
      localStorage.setItem('count','1');
      if(this.receivedData.userRole=="ADMIN"){
        this.router.navigateByUrl("/admin");
      }else{
        this.router.navigateByUrl("/home")
      }

    },error:e=>alert(`${e.message}\n${e.status}`)});

  }
}
