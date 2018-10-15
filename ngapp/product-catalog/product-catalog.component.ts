import { Component, OnInit, ViewChild } from '@angular/core';
import { CustomerService } from '../customer/customer.service';
import { MatSelectionList } from '@angular/material';
import { IProduct, ICustomer } from './product.interface';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-product-catalog',
  templateUrl: './product-catalog.component.html',
  styleUrls: ['./product-catalog.component.css'],
  providers: [CustomerService]
})
export class ProductCatalogComponent implements OnInit {

  products: IProduct[] = [];
  customer: ICustomer[] = [];

  constructor(
    private customerService: CustomerService
  ) { }

  ngOnInit() {
    this.customerService.getProductList().subscribe(
      (products) => {
        this.products = products;
      },
      (error) => console.log('Error: ', error),
      () => {
      }
    );
  }
  onSubmit(form: NgForm, product) {
    if (form !== undefined && product !== undefined) {
      this.customerService.postCustomerOrder(form, product);
    }
  }

}
