import { Component } from '@angular/core';
import { AuthRequest } from '../models/auth';
import { Auth } from '../services/auth';
import { Router, RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common'; 
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  imports: [CommonModule,FormsModule,RouterLink],
  templateUrl: './login.html',
  styleUrl: './login.css',
})
export class Login {
  loginRequest: AuthRequest = {
    username: '',
    password: ''
  };

  constructor(private authService: Auth, private router: Router) {}

  onLogin() {
    this.authService.login(this.loginRequest).subscribe({
      next: (res) => {
        if (res.status === 200) {
          alert("Giriş Başarılı! Hoşgeldiniz " + this.loginRequest.username);
          this.router.navigate(['/home']); 
        } else {
          alert("Giriş Başarısız: " + res.errorMessage);
        }
      },
      error: (err) => {
        console.error("Login Hatası:", err);
        alert("Kullanıcı adı veya şifre hatalı!");
      }
    });
  }
}
