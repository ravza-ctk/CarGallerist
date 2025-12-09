export interface RootEntity<T> {
  status: number;
  payload: T;
  errorMessage: string | null;
}

export interface AddressRequest {
  city: string;
  district: string;
  neighborhood: string;
  street: string;
}

export interface Address {
  id?: number; 
  city: string;
  district: string;
  neighborhood: string;
  street: string;
}