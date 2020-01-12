package com.example.mbanking;

public class Transaction {
    private int _id;
    private int _amount;
    private String type;

    public Transaction(String s,int a){
        type=s;
        _amount=a;
    }
    public Transaction(){

    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_amount() {
        return _amount;
    }

    public void set_amount(int _amount) {
        this._amount = _amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
