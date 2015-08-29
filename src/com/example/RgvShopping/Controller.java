package com.example.RgvShopping;

/**
 * Created by zakirelahi on 30/08/15.
 */




import java.util.ArrayList;
import android.app.Application;

public class Controller extends Application{

    private  ArrayList<BookModel> books = new ArrayList<BookModel>();
    private BooksCart myCart = new BooksCart();


    public BookModel getBook(int bookPosition) {

        return books.get(bookPosition);
    }

    public void setBook(BookModel book) {

        books.add(book);

    }

    public BooksCart getCart() {

        return myCart;

    }

    public int noOfBooks() {

        return books.size();
    }

}
