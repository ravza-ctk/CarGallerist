import { Component } from '@angular/core';
import { CustomerRequest } from '../models/customer';
import { CustomerService } from '../services/customer';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-customer',
  imports: [CommonModule,FormsModule],
  templateUrl: './customer.html',
  styleUrl: './customer.css',
})
export class Customer {
  customerRequest: CustomerRequest = {
    firstName: '',
    lastName: '',
    tckn: '',
    birthOfDate: new Date(), 
    addressId: 0,
    accountId: 0
  };

  constructor(private customerService: CustomerService) {}

  onSave() {
    console.log("Gönderilen Müşteri:", this.customerRequest);

    this.customerService.saveCustomer(this.customerRequest).subscribe({
      next: (res) => {
        if (res.status === 200) {
          alert("Müşteri Kaydedildi: " + res.payload.firstName + " " + res.payload.lastName);
        } else {
          alert("Hata: " + res.errorMessage);
        }
      },
      error: (err) => {
        console.error("Müşteri Kayıt Hatası:", err);
        alert("Sunucu hatası oluştu.");
      }
    });
  }
}
