import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { RouterModule, Router } from '@angular/router';
import { isUserLogged } from '../isuserlogged'; 

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {

  email: string = '';
  password: string = '';
  cnp: string = '';
  serie: string = '';
  numar: string = '';
  success: number = 2;
  displayForm: number = 1;
  
  constructor(private http:HttpClient,
              private router: Router,
              private logged:isUserLogged  ) {}

  onSubmit() {
    
    const indentificationJson ={ personalNumericCode: this.cnp,
                                 series: this.serie,
                                 seriesNumber: this.numar };

const registerJson = { username: this.email,
                       password: this.password,
                       identificationUserData: indentificationJson,
                       admin:  false }; 

this.http.post('http://localhost:8080/users', registerJson ).subscribe((response) => {
  console.log(response);
  if( response === "CONFLICT")
  {
    this.success = 0;
  }
  else
  {
    this.success = 1;
    this.logged.updateData( {success : 1, registerJson: registerJson} );
  }

});


}

}
