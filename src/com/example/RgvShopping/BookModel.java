package com.example.RgvShopping;

/**
 * Created by zakirelahi on 29/08/15.
 */

public class BookModel {

    private String bookName;
    private String bookDescription;
    private int bookPrice;

    public BookModel(String bookName,String bookDescription,int bookPrice)
    {
        this.bookName = bookName;
        this.bookDescription = bookDescription;
        this.bookPrice = bookPrice;
    }

    public String getBookName() {

        return bookName;
    }

    public String getBookDescription() {

        return bookDescription;
    }

    public int getBookPrice() {

        return bookPrice;
    }

}
