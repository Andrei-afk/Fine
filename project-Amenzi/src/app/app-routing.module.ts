import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { FinesComponent } from './fines/fines.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  {  path: 'fines', component: FinesComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
