import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { RegisterComponent } from './register/register.component';
import { AdminEditPageComponent } from './admin-edit-page/admin-edit-page.component';
import { FavouriteComponent } from './favourite/favourite.component';
import { AuthGuard } from './services/auth.guard';

const routes: Routes = [
  {path: 'admin', component:AdminEditPageComponent,canActivate:[AuthGuard]},
  {path: 'favorite', component:FavouriteComponent,canActivate:[AuthGuard]},
  {path: 'home', component:HomeComponent,canActivate:[AuthGuard]},
  {path: 'register', component:RegisterComponent},
  {path: 'login', component:UserLoginComponent},
  {path: '', redirectTo:'/home',pathMatch:'full'},
  {path: '**', component:PageNotFoundComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
