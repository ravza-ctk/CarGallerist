import { Component } from '@angular/core';
import { AddressRequest } from '../models/address';
import { AddressService } from '../services/address';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-address',
  imports: [FormsModule,CommonModule],
  templateUrl: './address.html',
  styleUrl: './address.css',
})
export class Address {

  addressModel: AddressRequest = {
    city: '',
    district: '',
    neighborhood: '',
    street: ''
  };

  constructor(private addressService: AddressService) {}

  onSubmit() {


    console.log("Butona basıldı! Veriler:", this.addressModel);

    
    if (!this.addressModel.city || !this.addressModel.district) {
      alert('Lütfen şehir ve ilçe bilgilerini giriniz.');
      return;
    }

    this.addressService.saveAddress(this.addressModel).subscribe({
      next: (response) => {
        if (response.status === 200) {
          console.log('Adres Kaydedildi:', response.payload);
          alert(`Adres başarıyla eklendi: ${response.payload.district} / ${response.payload.city}`);
          
          this.addressModel = { city: '', district: '', neighborhood: '', street: '' };
        } else {
          alert('Hata: ' + response.errorMessage);
        }
      },
      error: (err) => {
        console.error('HTTP Hatası:', err);
        alert('Sunucuya bağlanırken hata oluştu.');
      }
    });
  }
}
