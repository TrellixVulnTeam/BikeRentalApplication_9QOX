import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AdminDashBoardComponent } from './Mycomponents/admin/admin-dash-board/admin-dash-board.component';
import { LoginComponent } from './Mycomponents/login/login.component';
import { RenterDashBoardComponent } from './Mycomponents/renter-dash-board/renter-dash-board.component';
import { SignupComponent } from './Mycomponents/signup/signup.component';
import { AdminDashboardContentComponent } from './Mycomponents/admin/admin-dashboard-content/admin-dashboard-content.component';
import { AppComponent } from './app.component';
import { AllCustomersComponent } from './Mycomponents/admin/all-customers/all-customers.component';
import { RenterDetailsComponent } from './Mycomponents/admin/renter-details/renter-details.component';
import { BikeDetailsComponent } from './Mycomponents/admin/bike-details/bike-details.component';

const routes: Routes = [
 
  {path: '', component: LoginComponent},
  {path:'signup', component: SignupComponent},
  
  {path:'admin', component:AdminDashBoardComponent,
  children: [
            { path: 'dashboard', component: AdminDashboardContentComponent},
            {path:'', redirectTo:'dashboard', pathMatch: 'full'},
            {path:'dashboard/customerDetails',component:AllCustomersComponent},
            {path:'dashboard/renterDetails',component:RenterDetailsComponent},
            {path:'dashboard/bikeDetails/:id',component:BikeDetailsComponent}
    ] 
  },
 
  {path:'renter/dashboard', component: RenterDashBoardComponent},
  
 
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
