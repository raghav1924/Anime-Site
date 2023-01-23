import { formatCurrency } from '@angular/common';
import { Component } from '@angular/core';
import { DbServiceService } from '../services/db-service.service';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Photo } from '../model/Photo';

@Component({
  selector: 'app-admin-edit-page',
  templateUrl: './admin-edit-page.component.html',
  styleUrls: ['./admin-edit-page.component.css']
})
export class AdminEditPageComponent {

selectedFile?: File;
retrievedImage: any;
base64Data: any;
retrieveResonse: any;
animeName='';
lang='';
releaseData='';
genre='';
director='';
rating='';
descp='';





constructor(private db:DbServiceService,private snackBar: MatSnackBar){
// this.getPhoto();
this.getAllUser();

}

  onFileChange(event:any){
    this.selectedFile=event.target.files[0];
    console.log(this.selectedFile);
    // alert(this.selectedFile);
  }
  onUpload(){
    const uploadImageData= new FormData();
    console.log("inside onupload")
    uploadImageData.append('image',this.selectedFile!,this.selectedFile?.name);
    uploadImageData.append('animeName',this.animeName);
    uploadImageData.append('lang',this.lang);
    uploadImageData.append('releaseData',this.releaseData);
    uploadImageData.append('genre',this.genre);
    uploadImageData.append('director',this.director);
    uploadImageData.append('rating',this.rating);
    uploadImageData.append('descp',this.descp);
    console.log(uploadImageData);
    this.db.addPhoto(uploadImageData).subscribe({next:data=>this.snack(data),error:e=>alert(`${e.message}\n${e.status}`)});
  }
  snack(data:any){
    console.log("inside snack bar")
    this.snackBar.open('Image Successfully added with ID: '+data, 'success', {​
      duration: 5000,​
      panelClass: ['mat-toolbar', 'mat-primary']​
      })
  }

  userList:any=[];
  getAllUser(){
    this.db.getAllUser().subscribe(res=>{
      console.log(res);
      this.userList=res;
    })
  }
  deleteUser(data:any){
    this.db.deleteUserFromMySql(data).subscribe();
    this.db.deleteUserFromMongo(data).subscribe();
  }

}
