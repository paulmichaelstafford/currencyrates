package currencyexchange.app.exchange.proxy;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import currencyexchange.app.exchange.Currency;

public class Eurofxref {
    @CsvBindByName(column = "Date")
    @CsvBindByPosition(position = 0)
    private String date;
    @CsvBindByName(column = "USD")
    @CsvBindByPosition(position = 1)
    private Float USD;
    @CsvBindByName(column = "JPY")
    @CsvBindByPosition(position = 2)
    private Float JPY;
    @CsvBindByName(column = "BGN,")
    @CsvBindByPosition(position = 4)
    private Float BGN;
    @CsvBindByName(column = "CZK")
    @CsvBindByPosition(position = 5)
    private Float CZK;
    @CsvBindByName(column = "DKK")
    @CsvBindByPosition(position = 6)
    private Float DKK;
    @CsvBindByName(column = "GBP")
    @CsvBindByPosition(position = 7)
    private Float GBP;
    @CsvBindByName(column = "HUF")
    @CsvBindByPosition(position = 8)
    private Float HUF;
    @CsvBindByName(column = "PLN")
    @CsvBindByPosition(position = 9)
    private Float PLN;
    @CsvBindByName(column = "RON")
    @CsvBindByPosition(position = 10)
    private Float RON;
    @CsvBindByName(column = "SEK")
    @CsvBindByPosition(position = 11)
    private Float SEK;
    @CsvBindByName(column = "CHF")
    @CsvBindByPosition(position = 12)
    private Float CHF;
    @CsvBindByName(column = "ISK")
    @CsvBindByPosition(position = 13)
    private Float ISK;
    @CsvBindByName(column = "NOK")
    @CsvBindByPosition(position = 14)
    private Float NOK;
    @CsvBindByName(column = "TRY")
    @CsvBindByPosition(position = 15)
    private Float TRY;
    @CsvBindByName(column = "CNY")
    @CsvBindByPosition(position = 16)
    private Float CNY;
    @CsvBindByName(column = "AUD")
    @CsvBindByPosition(position = 17)
    private Float AUD;
    @CsvBindByName(column = "BRL")
    @CsvBindByPosition(position = 18)
    private Float BRL;
    @CsvBindByName(column = "CAD")
    @CsvBindByPosition(position = 19)
    private Float CAD;
    @CsvBindByName(column = "IDR")
    @CsvBindByPosition(position = 20)
    private Float IDR;
    @CsvBindByName(column = "ILS")
    @CsvBindByPosition(position = 21)
    private Float ILS;
    @CsvBindByName(column = "INR")
    @CsvBindByPosition(position = 22)
    private Float INR;
    @CsvBindByName(column = "KRW")
    @CsvBindByPosition(position = 23)
    private Float KRW;
    @CsvBindByName(column = "MXN")
    @CsvBindByPosition(position = 24)
    private Float MXN;
    @CsvBindByName(column = "MYR")
    @CsvBindByPosition(position = 25)
    private Float MYR;
    @CsvBindByName(column = "NZD")
    @CsvBindByPosition(position = 26)
    private Float NZD;
    @CsvBindByName(column = "PHP")
    @CsvBindByPosition(position = 27)
    private Float PHP;
    @CsvBindByName(column = "SGD")
    @CsvBindByPosition(position = 28)
    private Float SGD;
    @CsvBindByName(column = "THB")
    @CsvBindByPosition(position = 29)
    private Float THB;
    @CsvBindByName(column = "ZAR")
    @CsvBindByPosition(position = 30)
    private Float ZAR;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getUSD() {
        return USD;
    }

    public void setUSD(Float USD) {
        this.USD = USD;
    }

    public Float getJPY() {
        return JPY;
    }

    public void setJPY(Float JPY) {
        this.JPY = JPY;
    }

    public Float getBGN() {
        return BGN;
    }

    public void setBGN(Float BGN) {
        this.BGN = BGN;
    }

    public Float getCZK() {
        return CZK;
    }

    public void setCZK(Float CZK) {
        this.CZK = CZK;
    }

    public Float getDKK() {
        return DKK;
    }

    public void setDKK(Float DKK) {
        this.DKK = DKK;
    }

    public Float getGBP() {
        return GBP;
    }

    public void setGBP(Float GBP) {
        this.GBP = GBP;
    }

    public Float getHUF() {
        return HUF;
    }

    public void setHUF(Float HUF) {
        this.HUF = HUF;
    }

    public Float getPLN() {
        return PLN;
    }

    public void setPLN(Float PLN) {
        this.PLN = PLN;
    }

    public Float getRON() {
        return RON;
    }

    public void setRON(Float RON) {
        this.RON = RON;
    }

    public Float getSEK() {
        return SEK;
    }

    public void setSEK(Float SEK) {
        this.SEK = SEK;
    }

    public Float getCHF() {
        return CHF;
    }

    public void setCHF(Float CHF) {
        this.CHF = CHF;
    }

    public Float getISK() {
        return ISK;
    }

    public void setISK(Float ISK) {
        this.ISK = ISK;
    }

    public Float getNOK() {
        return NOK;
    }

    public void setNOK(Float NOK) {
        this.NOK = NOK;
    }

    public Float getTRY() {
        return TRY;
    }

    public void setTRY(Float TRY) {
        this.TRY = TRY;
    }

    public Float getCNY() {
        return CNY;
    }

    public void setCNY(Float CNY) {
        this.CNY = CNY;
    }

    public Float getAUD() {
        return AUD;
    }

    public void setAUD(Float AUD) {
        this.AUD = AUD;
    }

    public Float getBRL() {
        return BRL;
    }

    public void setBRL(Float BRL) {
        this.BRL = BRL;
    }

    public Float getCAD() {
        return CAD;
    }

    public void setCAD(Float CAD) {
        this.CAD = CAD;
    }

    public Float getIDR() {
        return IDR;
    }

    public void setIDR(Float IDR) {
        this.IDR = IDR;
    }

    public Float getILS() {
        return ILS;
    }

    public void setILS(Float ILS) {
        this.ILS = ILS;
    }

    public Float getINR() {
        return INR;
    }

    public void setINR(Float INR) {
        this.INR = INR;
    }

    public Float getKRW() {
        return KRW;
    }

    public void setKRW(Float KRW) {
        this.KRW = KRW;
    }

    public Float getMXN() {
        return MXN;
    }

    public void setMXN(Float MXN) {
        this.MXN = MXN;
    }

    public Float getMYR() {
        return MYR;
    }

    public void setMYR(Float MYR) {
        this.MYR = MYR;
    }

    public Float getNZD() {
        return NZD;
    }

    public void setNZD(Float NZD) {
        this.NZD = NZD;
    }

    public Float getPHP() {
        return PHP;
    }

    public void setPHP(Float PHP) {
        this.PHP = PHP;
    }

    public Float getSGD() {
        return SGD;
    }

    public void setSGD(Float SGD) {
        this.SGD = SGD;
    }

    public Float getTHB() {
        return THB;
    }

    public void setTHB(Float THB) {
        this.THB = THB;
    }

    public Float getZAR() {
        return ZAR;
    }

    public void setZAR(Float ZAR) {
        this.ZAR = ZAR;
    }
}
