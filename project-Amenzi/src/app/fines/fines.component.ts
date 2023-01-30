import { Component, OnInit } from '@angular/core';
import { isUserLogged } from '../isuserlogged'; 
import { fineService } from '../fineService';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-fines',
  templateUrl: './fines.component.html',
  styleUrls: ['./fines.component.css']
})
export class FinesComponent implements OnInit{

  carCompany: string = '';
  color: string = '';
  licensePlate: string = '';
  calendarDate: string = '';
  hourFrom: string = '';
  hourTo: string = '';
  county: string = '';
  city: string = '';
  street: string = '';
  number: string = '';
  lawNumber: string = '';
  lawDescription: string = '';
  fineAmount: string = '';
  pointsDeducted: string = '';
  policemanName: string = '';
  driverName: string = '';
  cnp: string = '';
  series: string = '';
  seriesNumber: string = '';
  countyDriver: string = '';
  cityDriver: string = '';
  streetDriver: string = '';
  numberDriver: string = '';
  
  flag:boolean = true;

  data:any='';
  fines:any = '';

  currentFine:any = '';
  
  constructor(private isUserLogged: isUserLogged,
              private fineService: fineService,
              private http:HttpClient) {
                
  }
  ngOnInit(): void {
    this.isUserLogged.data$.subscribe(obj => {
      this.data = obj;
      this.flag = this.data.registerJson.admin;
      console.log(this.data.registerJson.identificationUserData.personalNumericCode + ' ' + this.data.registerJson.username);
    });

    this.getData(this.data.registerJson.username, this.data.registerJson.identificationUserData.personalNumericCode ).subscribe(data => {
      console.log(data)
      this.fines = data;
    });

    
  }


  getData(param1: string, param2: string) {
    const params = { username: param1, personalNumericCode: param2 };
    return this.http.get('http://localhost:8080/fines', { params });
  }

  onSubmit()
  {
    const carJson = {carCompany: this.carCompany,
                     color: this.color,
                     licensePlate: this.licensePlate}
    const dateInformation = { calendarDate: this.calendarDate, 
                              dayDateStart: this.hourFrom,
                              dayDateFinish: this.hourTo }
    const law = { lawNumber : this.lawNumber,
                          lawDescription : this.lawDescription }     
    const fineAddress = { county : this.county,
        city : this.city,
        street : this.street,
        number : this.number}  
    const penalty = { fineAmount : this.fineAmount,
                      pointsDeducted : this.pointsDeducted } 
    const identificationUserData = { personalNumericCode: this.cnp,
    series : this.series,
    seriesNumber:this.seriesNumber
   }  
   const driverAddress = { county : this.county,
    city : this.city,
    street : this.street,
    number : this.number}  

    const fineJason = { car: carJson,
                        dateInformation: dateInformation,
                        fineAddress: fineAddress,
                        law: law,
                        penalty:penalty,
                        policemanName: this.policemanName,
                        driverName: this.driverName,
                        identificationUserData: identificationUserData,
                        driverAddress: driverAddress }; 

  this.http.post('http://localhost:8080/fines', fineJason ).subscribe((response) => {
  console.log(response);
  this.fines = response;
});
}

  selectFine( item:any )
  {
    console.log(item.driverName);
    this.fineService.setCurrentFine( item );

   
    
    this.fineService.getCurrentFine( ).subscribe( data => { 
      this.currentFine = data 

   });
    console.log(this.currentFine);
  }

}
