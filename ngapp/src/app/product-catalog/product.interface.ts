export interface IProduct {
    id: number;
    productName: string;
    description: string;
    price: IPrice[];
}
export interface IPrice {
    id: number;
    sapId: string;
    recurringPrice: number;
    oneTimePrice: number;
    timeLeft: Date;
    description: string;
    recurringCount: number;
}

export interface ICustomer {
    id: number;
    customerName: string;
    companyName: string;
    street: string;
    country: string;
    postalCode: string;
    city: string;
}

export interface IOrder {
    id: number;
    customerId: number;
}
