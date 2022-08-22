import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Config } from 'src/app/config';
import { ServicesService } from '../../services/services.service';

@Component({
  selector: 'app-customer-payment',
  templateUrl: './customer-payment.component.html',
  styleUrls: ['./customer-payment.component.css']
})
export class CustomerPaymentComponent implements OnInit {

  renterId!: number;
  // customer:Customer;
   submitted = false;
   cardDetails:Config['CardDetails']=new Config().CardDetails;
 
   constructor(private cardService:ServicesService ,
     private router: Router) { }
 
   ngOnInit(): void {}
     // this.customer=new Customer();
     // this.submitted = false;
     // this.renterId=this.route.snapshot.params['id'];
 
     // 
 
     
 
     
 

}