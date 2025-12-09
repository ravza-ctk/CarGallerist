
export interface RootEntity<T> {
  status: number;     
  payload: T;             
  errorMessage: string | null; 
}

export interface GalleristSaveRequest {
  firstName: string;
  lastName: string;
  addressId: number; 
}

export interface Gallerist {
  firstName: string;
  lastName: string;
  address: any; 
}