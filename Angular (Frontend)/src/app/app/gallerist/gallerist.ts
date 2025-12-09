import { Component } from '@angular/core';
import { GalleristService } from '../services/gallerist';
import { GalleristSaveRequest } from '../models/gallerist';
import { CommonModule } from '@angular/common'; 
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-gallerist',
  imports: [FormsModule,CommonModule],
  templateUrl: './gallerist.html',
  styleUrl: './gallerist.css',
})
export class GalleristComponent {

  requestModel: GalleristSaveRequest = {
    firstName: '',
    lastName: '',
    addressId: 0
  };

  constructor(private galleristService: GalleristService) {}

  onSubmit() {
    this.galleristService.save(this.requestModel).subscribe({
      next: (response) => {
        if (response.status === 200) {
            console.log("İşlem Başarılı. Gelen Data:", response.payload);
            alert("Kaydedildi: " + response.payload.firstName + " " + response.payload.lastName);
        } else {
            console.error("Hata:", response.errorMessage);
            alert("Bir hata oluştu: " + response.errorMessage);
        }
      },
      error: (httpError) => {
        console.error("HTTP Hatası:", httpError);
      }
    });
  }
}