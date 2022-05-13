package com.example.ERP.System.model.rest;

public class ResponseMessages {

    private String ru;
    private String kz;
    private String en;

    public ResponseMessages() {
    }

    public ResponseMessages(String ru) {
        this.en = this.kz = this.ru = ru;
    }

    public ResponseMessages(String ru, String kz, String en) {
        this.ru = ru;
        this.kz = kz;
        this.en = en;
    }

    public String getRu() {
        return ru;
    }

    public void setRu(String ru) {
        this.ru = ru;
    }

    public String getKz() {
        return kz;
    }

    public void setKz(String kz) {
        this.kz = kz;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    @Override
    public String toString() {
        return "Messages{" +
                "ru='" + ru + '\'' +
                ", kz='" + kz + '\'' +
                ", en='" + en + '\'' +
                '}';
    }
}
