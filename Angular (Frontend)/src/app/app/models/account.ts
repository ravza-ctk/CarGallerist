import { AttributeValue } from "./attribute";

export interface RootEntity<T> {
  status: number;
  payload: T;
  errorMessage: string | null;
}

export interface AccountRequest {
  accountNo: string;
  iban: string;
  amount: number;      
  currencyTypeId: number; 
}

export interface Account {
  id: number;
  accountNo: string;
  iban: string;
  amount: number;
  currencyType?: AttributeValue;
}