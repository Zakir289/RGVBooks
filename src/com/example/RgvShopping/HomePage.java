package com.example.RgvShopping;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

/**
 * Created by zakirelahi on 29/08/15.
 */


public class HomePage extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);

        final LinearLayout lm = (LinearLayout) findViewById(R.id.linearMain);
        final Button secondBtn = (Button) findViewById(R.id.second);


        final Controller bookController = (Controller) getApplicationContext();



        BookModel book = null;
        for(int i=1;i<=4;i++)
        {
            int price = 10+i;

            book = new BookModel("Product "+i,"Description "+i,price);


            bookController.setBook(book);

        }


        int noOfBooks = bookController.noOfBooks();

        // create the layout params that will be used to define how your
        // button will be displayed
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);

        /******** Dynamically create view elements - Start **********/

        for(int j=0;j< noOfBooks;j++)
        {

            String pName = bookController.getBook(j).getBookName();
            int pPrice   = bookController.getBook(j).getBookPrice();

            // Create LinearLayout to view elemnts
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);

            TextView product = new TextView(this);
            product.setText(" "+pName+"    ");


            ll.addView(product);

            TextView price = new TextView(this);
            price.setText("  $"+pPrice+"     ");


            ll.addView(price);

            final Button btn = new Button(this);
            btn.setId(j+1);
            btn.setText("Add To Cart");


            btn.setLayoutParams(params);

            final int index = j;


            btn.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {

                  Log.i("TAG", "index :" + index);


                    BookModel selectedBook = bookController.getBook(index);


                    if(!bookController.getCart().checkProductInCart(selectedBook))
                    {
                        btn.setText("Added");

                        bookController.getCart().addBookToCart(selectedBook);

                        Toast.makeText(getApplicationContext(), "Now Cart size: " + bookController.getCart().getCartSize(),
                                Toast.LENGTH_LONG).show();
                    }
                    else
                    {

                        Toast.makeText(getApplicationContext(), "Product "+(index+1)+" already added in cart.",
                                Toast.LENGTH_LONG).show();
                    }
                }
            });

            //Add button to LinearLayout
            ll.addView(btn);

            //Add LinearLayout to XML layout
            lm.addView(ll);
        }



        secondBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(getBaseContext(), CheckoutPage.class);

                startActivity(i);
            }
        });
    }
}
