import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';

@Component({
  selector: 'app-bike-data',
  templateUrl: './bike-data.component.html',
  styleUrls: ['./bike-data.component.css']
})
export class BikeDataComponent implements OnInit {

  id!: number;
  bike!: Config['BikeObj'];
  booking:Config['BookingObj']=new Config().BookingObj;
  startdate:any;
  dated:any;
  datef:any;
  enddate:any;
  dayssubracted:any;
  error:any;
  price: any;
  valid=false;
  constructor(private route: ActivatedRoute,private router: Router,private renterService: ServicesService) { }

  ngOnInit() {
    this.bike= new Config().BikeObj;

    this.id = this.route.snapshot.params['id'];
    
    this.renterService.getBikeById(this.id).subscribe(data => {
        console.log(data)
        this.bike= data;
        this.price=JSON.parse(JSON.stringify(data)).rentAmount;
        console.log(this.price);
      }, error => console.log(error));
     
  }

  diff(){
  let date1 = new Date(this.startdate);
  let date2 = new Date(this.enddate);
  this.dayssubracted = (Math.floor((Date.UTC(date2.getFullYear(), date2.getMonth(), date2.getDate()) - Date.UTC(date1.getFullYear(), date1.getMonth(), date1.getDate()) ) /(1000 * 60 * 60 * 24)))*(+this.price);
  this.valid=true; 
  console.log("subracted days are  " + this.dayssubracted);

  this.booking.bookingDate=String(new Date(this.startdate));
  this.booking.endDate=String(new Date(this.enddate));
  this.booking.totalAmount=this.dayssubracted;
  this.booking.renterName=this.bike.ownerName;
  }

  saveBookingHistory(){
    
    this.router.navigate(['customer/payment']);
  }

  Back(){
    this.router.navigate(['customer/dashboard']);
  }

}
