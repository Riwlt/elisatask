import { Injectable } from '@angular/core';
import { IProduct } from '../product-catalog/product.interface';
import { Http } from '@angular/http';
import { Observable } from 'rxjs';
import { AppConstants } from '../app.constants';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';

@Injectable({
  providedIn: 'root'
})

export class CustomerService {

  products: IProduct[] = [];

  constructor(
    private http: Http
  ) { }

  getProductList(): Observable<IProduct[]> {
    return this.http.get(AppConstants.PRODUCTS_URL).map(result => result.json())
      .catch((error: any) => Observable.throw(error.json().error || 'Server error'));
  }

  postCustomerOrder(form, product): Promise<IProduct[]> {
    const formData: FormData = new FormData();
    formData.append('customerData', JSON.stringify(form.value));
    formData.append('productId', product.value);
    return this.http.post(AppConstants.ORDER_POST_URL, formData)
      .toPromise()
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<any> {
    return Promise.reject(error.message || error);
  }

}
