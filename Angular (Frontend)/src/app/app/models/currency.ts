export interface RootEntity<T> {
  status: number;
  payload: T;
  errorMessage: string | null;
}

export interface CurrencyItem {
  date: string; 
  usd: string;  
}


export interface CurrencyResponse {
  totalCount: number;
  items: CurrencyItem[];
}