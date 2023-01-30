import { Injectable } from '@angular/core';
import { BehaviorSubject  } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class isUserLogged {
  data: any;

  private dataSource = new BehaviorSubject<any>({});
  data$ = this.dataSource.asObservable();

  updateData(data: any) {
    this.dataSource.next(data);
  }
}