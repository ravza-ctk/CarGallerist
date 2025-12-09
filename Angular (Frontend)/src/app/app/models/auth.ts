export interface RootEntity<T> {
  status: number;
  payload: T;
  errorMessage: string | null;
}

export interface AuthRequest {
  username: string;
  password: string;
}

export interface AuthResponse {
  accessToken: string;
  refreshToken: string;
}

export interface User {
  username: string;
  password: string;
}