import { Injectable } from '@angular/core';
import { Observable,of } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class fineService {

  currentFine: any;

  constructor() { }

  public setCurrentFine(currentFine: any){
    this.currentFine = currentFine;
  }

  public getCurrentFine(): Observable<any>{
    return of (this.currentFine);
  }
}
