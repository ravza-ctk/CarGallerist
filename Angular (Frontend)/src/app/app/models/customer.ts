export interface RootEntity<T> {
  status: number;
  payload: T;
  errorMessage: string | null;
}

export interface CustomerRequest {
  firstName: string;
  lastName: string;
  tckn: string;
  birthOfDate: Date; 
  addressId: number; 
  accountId: number; 
}

export interface Customer {
  id: number;
  firstName: string;
  lastName: string;
  tckn: string;
  birthOfDate: Date;
}