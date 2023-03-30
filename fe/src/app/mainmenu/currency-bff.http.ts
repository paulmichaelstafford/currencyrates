import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Currency } from './currency';
import { firstValueFrom } from 'rxjs';

@Injectable()
export class CurrencyBffHttp {
    private URL: string = environment.apiUrl + `/currencies`;

    constructor(private http: HttpClient) { }

    async convert(currency: Currency, value: number): Promise<number> {
        return firstValueFrom(this.http.get<number>(`${this.URL}/${currency}/${value}`));
    }
}
