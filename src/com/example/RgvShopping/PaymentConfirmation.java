package com.example.RgvShopping;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by zakirelahi on 29/08/15.
 */
public class PaymentConfirmation extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.paymentscreen);

        TextView showCartContent    = (TextView) findViewById(R.id.showCart);


        final Controller bookController = (Controller) getApplicationContext();

        int cartSize = bookController.getCart().getCartSize();

        String showString = "";



        for(int i=0;i<cartSize;i++)
        {

            String pName 	= bookController.getCart().getBooks(i).getBookName();
            int pPrice   	= bookController.getCart().getBooks(i).getBookPrice();
            String pDisc   	= bookController.getCart().getBooks(i).getBookDescription();

            showString += "\n\nProduct Name : "+pName+"\n"+
                    "Price : "+pPrice+"\n"+
                    "Discription : "+pDisc+""+
                    "\n -----------------------------------";
        }


        showCartContent.setText(showString);



    }

}
