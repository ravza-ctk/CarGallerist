import { Routes } from '@angular/router';
import { GalleristComponent } from './app/gallerist/gallerist';
import { Address } from './app/address/address';
import { Login } from './app/login/login';
import { Register } from './app/register/register';
import { Car } from './app/car/car';
import { Customer } from './app/customer/customer';
import { Account } from './app/account/account';
import { HomePage } from './app/home-page/home-page';


export const routes: Routes = [
     {path: 'address', component: Address},
    {path: 'gallerist', component: GalleristComponent},
    { path: 'login', component: Login },
    { path: 'register', component: Register },
    { path: 'car', component: Car },
    { path: 'customer', component: Customer },
    { path: 'account', component: Account },
    { path: 'home', component: HomePage },
    
    { path: '', redirectTo: 'login', pathMatch: 'full' }
   
];
