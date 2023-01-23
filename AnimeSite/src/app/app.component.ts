import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AnimeSite';
check:boolean=false;
  login:boolean=false;
  islogged(){
    if(localStorage.getItem('token')=='off'){
      this.login=false
    }
    else{
      this.login=true
    }
    if(localStorage.getItem('role')=='ADMIN'){
      this.check=true
    }
    else{
      this.check=false
    }
  }
}
