import { Component, OnInit } from '@angular/core';
import { UntypedFormControl, UntypedFormBuilder, FormGroup, Validators, UntypedFormArray, UntypedFormGroup, FormBuilder } from '@angular/forms';
import { Currency } from './currency';
import { CurrencyBffHttp } from './currency-bff.http';

@Component({
    selector: 'mainmenu',
    templateUrl: './mainmenu.component.html',
    styleUrls: ['./mainmenu.component.css']
})

export class MainMenuComponent implements OnInit {  

  currencies = Object.keys(Currency).filter(v => isNaN(parseInt(v, 10)));

  private leftCurrency: Currency = Currency.EUR;
  private rightCurrency: Currency = Currency.USD;
  public leftInputValue: number = 0;
  public rightInputValue: number = 0;

  currencyFormGroup = this._formBuilder.group({
    leftCurrency: new UntypedFormControl(this.leftCurrency, [Validators.required]),
    rightCurrency: new UntypedFormControl(this.rightCurrency, [Validators.required]),
    leftText: new UntypedFormControl(this.leftInputValue, [Validators.required]),
    rightText: new UntypedFormControl(this.rightInputValue, [Validators.required]),  
  });

  constructor(
    public _formBuilder: FormBuilder,
    public currencyBffHttp: CurrencyBffHttp) {
  }

  ngOnInit() {
  }

  async leftDropDownChanged(currency: String) {
    this.leftCurrency = currency as Currency;
    this.leftUpdate(this.leftInputValue)
  }

  async rightDropDownChanged(currency: String) {
    this.rightCurrency = currency as Currency;
    this.rightUpdate(this.rightInputValue)
  }

  async leftInputChanged(event: any) {
    this.leftUpdate(event.target.value)
  }

  async rightInputChanged(event: any) {
    this.rightUpdate(event.target.value)
  }

  async leftUpdate(value: number) {
    if(value)
      this.rightInputValue = await this.callServer(this.leftCurrency, this.rightCurrency, value);
  }

  async rightUpdate(value: number) {
    if(value)
      this.leftInputValue = await this.callServer(this.leftCurrency, this.rightCurrency, value);
  }

  async callServer(fromCurrency: Currency, toCurrency: Currency, value: number): Promise<number> {
    return await this.currencyBffHttp.convert(fromCurrency, toCurrency, value);
  }  
  
}
