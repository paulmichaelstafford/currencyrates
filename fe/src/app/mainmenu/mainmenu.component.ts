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

  currencyFormGroup = this._formBuilder.group({
    leftCurrency: new UntypedFormControl('', [Validators.required]),
    rightCurrency: new UntypedFormControl('', [Validators.required]),
    leftText: new UntypedFormControl('', [Validators.required]),
    rightText: new UntypedFormControl('', [Validators.required]),  
  });

  constructor(
    public _formBuilder: FormBuilder,
    currencyBffHttp: CurrencyBffHttp) {
  }

  ngOnInit() {
  }
}
