import { Component } from '@angular/core';
import { Auth } from '../services/auth';
import { Router, RouterLink } from '@angular/router';
import { AuthRequest } from '../models/auth';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-register',
  imports: [CommonModule, FormsModule, RouterLink],
  templateUrl: './register.html',
  styleUrl: './register.css',
})
export class Register {
  registerRequest: AuthRequest = {
    username: '',
    password: ''
  };

  constructor(private authService: Auth, private router: Router) {}

  onRegister() {
    this.authService.register(this.registerRequest).subscribe({
      next: (res) => {
        if (res.status === 200) {
          alert("Kayıt Başarılı! Giriş sayfasına yönlendiriliyorsunuz.");
          this.router.navigate(['/login']); 
        } else {
          alert("Kayıt Başarısız: " + res.errorMessage);
        }
      },
      error: (err) => {
        console.error("Register Hatası:", err);
        alert("Kayıt sırasında bir hata oluştu.");
      }
    });
  }

}
