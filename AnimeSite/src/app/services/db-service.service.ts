import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Photo } from '../model/Photo';

@Injectable({
  providedIn: 'root'
})
export class DbServiceService {

  authAppUrl="http://localhost:9999/auth/";
  userApp="http://localhost:999/userApp/";
  photodb="http://localhost:666/photodb/";

  constructor(private httpclient:HttpClient) { }

  getPhoto(data:any){
    return this.httpclient.get(this.photodb+"anime/"+data);
  }
  getAllPhoto(){
    return this.httpclient.get(this.photodb+"animes");
  }

  addPhoto(data:object){
      return this.httpclient.post(this.photodb+"addImage",data);
  }

  register(data:any){
    return this.httpclient.post(this.authAppUrl+"register",data);
  }
  login(data:any){
    return this.httpclient.post(this.authAppUrl+"login",data);
  }

  addToUserFavorite(data:any){
    console.log('inside addtouserfavorite');
    console.log(localStorage.getItem('token'));
    let httpHeaders= new HttpHeaders({
      'Authorization': 'Bearer '+localStorage.getItem('token')
    });
    let requestQption= {headers: httpHeaders};
    console.log(requestQption);
      return this.httpclient.put(this.userApp+"addAnime",data,requestQption);
  }
  getUserDetails(){
    console.log('inside GETUSERDETAILS SERVICE')
    let httpHeaders= new HttpHeaders({
      'Authorization': 'Bearer '+localStorage.getItem('token')
    });
    let requestQption= {headers: httpHeaders};
    console.log(requestQption);
    return this.httpclient.get(this.userApp+"userDetails",requestQption);
  }

  getAllUser(){
    return this.httpclient.get(this.userApp+"getAllUser");
  }

  deleteUserFromMySql(data:any){
      return this.httpclient.delete(this.authAppUrl="deleteUser/"+data);
  }
  deleteUserFromMongo(data:any){
      return this.httpclient.delete(this.userApp="deleteUser/"+data);
  }
}
