import { Component } from '@angular/core';
import { CarRequest } from '../models/car';
import { CarService } from '../services/car';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { AttributeValue } from '../models/attribute';
import { AttributeService } from '../services/attribute';

@Component({
  selector: 'app-car',
  imports: [CommonModule, FormsModule],
  templateUrl: './car.html',
  styleUrl: './car.css',
})
export class Car {
  carRequest: CarRequest = {
    plaka: '',
    brand: '',
    model: '',
    productionYear: 2023,
    price: 0,
    damagePrice: 0,
    currencyTypeId: 0,
    carStatusTypeId: 0,
    galleristId: 0
  };

  currencyList: AttributeValue[] = [];
  statusList: AttributeValue[] = [];

  constructor(
    private carService: CarService,
    private attributeService: AttributeService 
  ) {}

  ngOnInit(): void {
    this.loadDropdowns();
  }

  loadDropdowns() {
     this.attributeService.getValuesByCode('currencyType').subscribe({
      next: (res: any) => {
        if (res.status === 200) {
          this.currencyList = res.payload;
          console.log("Para birimleri yüklendi:", this.currencyList);
        }
      },
      error: (err: any) => console.error("Para birimleri yüklenemedi", err)
    });

    
    this.attributeService.getValuesByCode('carStatusType').subscribe({
      next: (res: any) => {
        if(res.status === 200) {
          this.statusList = res.payload;
          console.log("Durum listesi yüklendi:", this.statusList);
        }
      },
      error: (err: any) => console.error("Durum listesi yüklenemedi", err)
    });
  }

  onSave() {
    console.log("Gönderilen Araba:", this.carRequest);

    this.carService.saveCar(this.carRequest).subscribe({
      next: (res: any) => {
        if(res.status === 200) {
          alert("Araba başarıyla kaydedildi! Plaka: " + res.payload.plaka);
        } else {
          alert("Hata: " + res.errorMessage);
        }
      },
      error: (err: any) => {
        console.error("Kayıt Hatası:", err);
        alert("Sunucu hatası oluştu. (Lütfen giriş yaptığınızdan emin olun)");
      }
    });
  }
}
