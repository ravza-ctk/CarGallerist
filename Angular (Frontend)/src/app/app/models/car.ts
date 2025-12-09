export interface RootEntity<T> {
  status: number;
  payload: T;
  errorMessage: string | null;
}

export interface CarRequest {
  plaka: string;
  brand: string;
  model: string;
  productionYear: number;
  price: number;
  damagePrice: number;
  currencyTypeId: number; 
  carStatusTypeId: number;       
  galleristId: number;    
}

export interface Car {
  id: number;
  plaka: string;
  brand: string;
  model: string;
  price: number;
}