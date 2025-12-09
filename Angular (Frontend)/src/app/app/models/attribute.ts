// Genel Cevap Yapısı
export interface RootEntity<T> {
  status: number;
  payload: T;
  errorMessage: string | null;
}

export interface Attribute {
  id: number;
  code: string;
  name: string;
}

export interface AttributeRequest {
  code: string;
  name: string;
}


export interface AttributeValue {
  id: number;
  value: string;
  attributeId: number; 
}

export interface AttributeValueRequest {
  value: string;
  attributeId: number; 
}