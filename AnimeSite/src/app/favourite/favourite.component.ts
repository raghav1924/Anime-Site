import { Component } from '@angular/core';
import { DbServiceService } from '../services/db-service.service';

@Component({
  selector: 'app-favourite',
  templateUrl: './favourite.component.html',
  styleUrls: ['./favourite.component.css']
})
export class FavouriteComponent {


  constructor(private db:DbServiceService){}
  ngOnInit(): void {
    //Called after the constructor, initializing input properties, and the first call to ngOnChanges.
    //Add 'implements OnInit' to the class.
this.getAllFavorite();
  }

list:any=[]
list2:any=[];
responseData:any;
retrieveResonse:any;
base64Data:any;
retrievedImage:any;

  getAllFavorite(){
    console.log("step 1")
      this.db.getUserDetails().subscribe(res=>{
    console.log("step 2")

          this.responseData=res;
          this.list=this.responseData.animeList;
          console.log(this.list);
      this.getOtherDetails();
      })
    console.log("step 3")



  }
  getOtherDetails(){
    let count=0;
    for(let i of this.list) {
      console.log('inside other details')
      console.log(count);


      this.db.getPhoto(i.animeName).subscribe(res=>{
        console.log('inside other details getphoto method')

          this.retrieveResonse = res;
          console.log(res);
              this.base64Data = this.retrieveResonse.image;
              this.retrievedImage = 'data:image/jpeg;base64,' + this.base64Data;
            this.list2[count]=this.retrieveResonse;
            this.list2[count].image=this.retrievedImage;
            count++;
            console.log(count);
            console.log(this.list2);
            })

    }
  }
}
