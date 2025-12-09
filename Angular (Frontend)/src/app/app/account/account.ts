import { Component, OnInit } from '@angular/core';
import { AccountRequest } from '../models/account';
import { AttributeValue } from '../models/attribute';
import { AccountService } from '../services/account';
import { AttributeService } from '../services/attribute';
import { CommonModule, DatePipe } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CurrencyService } from '../services/currency';

@Component({
  selector: 'app-account',
  imports: [CommonModule,FormsModule],
  providers: [DatePipe],
  templateUrl: './account.html',
  styleUrl: './account.css',
})
export class Account implements OnInit{
accountRequest: AccountRequest = {
    accountNo: '',
    iban: '',
    amount: 0,
    currencyTypeId: 1 
  };

  
  currencyList: AttributeValue[] = [];
  
  currentUsdRate: string = "Yükleniyor...";

  constructor(
    private accountService: AccountService,
    private attributeService: AttributeService, // Dropdown için
    private currencyService: CurrencyService,   // Kur çekmek için
    private datePipe: DatePipe
  ) {}

  ngOnInit(): void {
    this.loadCurrencies();
    this.fetchTodayRate();
  }

  
  loadCurrencies() {
    this.attributeService.getValuesByCode('currencyType').subscribe({
      next: (res: any) => {
        if (res.status === 200) {
          this.currencyList = res.payload;
          console.log("Para birimleri yüklendi:", this.currencyList);
        }
      },
      error: (err: any) => console.error("Para birimleri yüklenemedi", err)
    });
  }

  
  fetchTodayRate() {
    const today = new Date();
    const dateStr = this.datePipe.transform(today, 'dd-MM-yyyy') || '';

    this.currencyService.getRates(dateStr, dateStr).subscribe({
      next: (res: any) => {
        
        if(res.status === 200 && res.payload.items && res.payload.items.length > 0) {
            const rate = res.payload.items[0].usd;
            this.currentUsdRate = rate ? rate : "Veri Yok";
        } else {
            this.currentUsdRate = "Veri Bulunamadı";
        }
      },
      error: (err: any) => {
          console.error("Kur çekilemedi:", err);
          this.currentUsdRate = "Hata!";
      }
    });
  }

  
  onSave() {
    if (this.accountRequest.currencyTypeId === 0) {
      alert("Lütfen bir Para Birimi seçiniz!");
      return;
    }

    console.log("Gönderilen Hesap:", this.accountRequest);

    this.accountService.saveAccount(this.accountRequest).subscribe({
      next: (res: any) => {
        if(res.status === 200) {
          alert("Hesap Başarıyla Oluşturuldu! Hesap No: " + res.payload.accountNo);
          
         
          this.accountRequest = { accountNo: '', iban: '', amount: 0, currencyTypeId: 0 };
        } else {
          alert("Hata: " + res.errorMessage);
        }
      },
      error: (err: any) => {
        console.error("Hesap Kayıt Hatası:", err);
        alert("Sunucu hatası oluştu. Lütfen giriş yaptığınızdan emin olun.");
      }
    });
  }
}
