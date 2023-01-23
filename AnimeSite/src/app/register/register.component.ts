import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { DbServiceService } from '../services/db-service.service';
import { Route, Router } from '@angular/router';
import { PageRouterService } from '../services/page-router.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  constructor(private help:DbServiceService,private router:PageRouterService){}
  signupForm=new FormGroup({
    'email':new FormControl(),
    'name':new FormControl(),
    'password':new FormControl(),
  })
receivedData:any;
  sendSignUpData(){
    console.log(this.signupForm.value);
    this.help.register(this.signupForm.value).subscribe({next:data=>{
      this.receivedData=data;
      this.router.navigateToLoginView();
    },error:e=>alert(`${e.message}\n${e.status}`)});

  }
}
