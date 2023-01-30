import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login-service';
import { ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { isUserLogged } from '../isuserlogged'; 


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  cnp:string = '';

  constructor(private logged:isUserLogged ,
              private http: HttpClient){}


    onSubmit(){

      const registerJson = { username : this.email,
                     password: this.password,
                     personalNumericCode: this.cnp,
       }
      this.getData(this.email, this.password, this.cnp).subscribe(data => {
        this.logged.updateData( {success : 1, registerJson:data } );
      });

  }

  getData(param1: string, param2: string, param3: string) {
    const params = { username: param1, password: param2, personalNumericCode: param3 };
    return this.http.get('http://localhost:8080/users', { params });
  }
}

