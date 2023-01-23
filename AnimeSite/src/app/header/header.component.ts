import { Component, Input } from '@angular/core';
import { PageRouterService } from '../services/page-router.service';
import { count } from 'rxjs';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
  @Input()
  login:boolean=false;
  @Input()
  check:boolean=false;

constructor(private route:PageRouterService){
  // window.location.reload();
  // this.count=1;
  // this.checkfun();
}

count:number=1;
  logout(){
    localStorage.setItem('token','off');
    localStorage.setItem('role','off');
    localStorage.setItem('count','1')

    this.check=false;
      this.route.navigateToLoginView();
  }
  // checkfun(){
  //   if(localStorage.getItem('token')=='off'){
  //     this.check=false;
  //   }else{
  //     this.check=true;
  //     // window.location.reload();


  //   }
  //   // if(localStorage.getItem('count')==='1'){
  //   //   console.log(localStorage.getItem('count'))
  //   //   localStorage.setItem('count','2')
  //   //   console.log(localStorage.getItem('count'))

  //   //     window.location.reload();
  //   // }
  // }
}
