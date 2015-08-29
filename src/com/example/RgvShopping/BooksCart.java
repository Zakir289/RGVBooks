package com.example.RgvShopping;

/**
 * Created by zakirelahi on 29/08/15.
 */
import java.util.ArrayList;

public class BooksCart {

    private  ArrayList<BookModel> booksInCart = new ArrayList<BookModel>();


    public BookModel getBooks(int bookPosition) {

        return booksInCart.get(bookPosition);
    }

    public void addBookToCart(BookModel book) {

        booksInCart.add(book);

    }

    public int getCartSize() {

        return booksInCart.size();

    }

    public boolean checkProductInCart(BookModel aProduct) {

        return booksInCart.contains(aProduct);

    }

}
