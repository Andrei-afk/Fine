import { Component } from '@angular/core';
import { isUserLogged } from '../isuserlogged'; 

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent {

  flag:number = 0;
  constructor(private isUserLogged: isUserLogged) {
    this.isUserLogged.data$.subscribe(obj => {
      this.flag=obj.success;
    });


  }
}
