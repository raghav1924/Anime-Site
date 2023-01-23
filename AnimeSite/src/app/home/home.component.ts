import { Component } from '@angular/core';
import { DbServiceService } from '../services/db-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {


  arr:any=[];
  constructor(private db:DbServiceService,private snackBar: MatSnackBar){}
  ngOnInit(): void {
    this.getAllPhoto();
    this.getUserDetails();
    console.log('count='+localStorage.getItem('count'))

  }
  getAllPhoto(){

    this.db.getAllPhoto().subscribe(res=>{

      this.arr=res;
      for(let i of this.arr) {
        i.image='data:image/jpeg;base64,'+i.image;
    }

      console.log(res);
      // console.log(this.retrieveResonse);
      // console.log(this.retrieveResonse.image)

        })
  }

  addToUserFavorite(p:any){
    let data={'animeName':p.animeName}
        this.db.addToUserFavorite(data).subscribe(res=>{
          console.log(res);
          let btn:any;
          btn=document.getElementById(p.animeName);
          btn.style.color="#ff0000";
          this.snack(p.animeName)
        })
  }

  snack(data:any){
    console.log("inside snack bar")
    this.snackBar.open(data+' Added to Favorite List', 'success', {​
      duration: 5000,​
      panelClass: ['mat-toolbar', 'mat-primary']​
      })
  }

  user:any='';
  getUserDetails(){
    this.db.getUserDetails().subscribe(res=>{
        this.user=res;
        console.log("user Deatails "+res)
    })
  }


}
