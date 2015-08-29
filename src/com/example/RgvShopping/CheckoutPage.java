package com.example.RgvShopping;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by zakirelahi on 29/08/15.
 */
public class CheckoutPage extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkoutscreen);

        TextView showCartContent    = (TextView) findViewById(R.id.showCart);
        final Button thirdBtn 		= (Button) findViewById(R.id.third);

        Intent currIntent = getIntent();
//        final Controller bookController = (Controller) currIntent.getSerializableExtra("controller");
//
        final Controller bookController = (Controller) getApplicationContext();

        // Get Cart Size
        final int cartSize = bookController.getCart().getCartSize();

        String showString = "";

/******** Show Cart Products on screen - Start ********/

        if(cartSize >0)
        {

            for(int i=0;i<cartSize;i++)
            {
                //Get product details
                String pName 	= bookController.getCart().getBooks(i).getBookName();
                int pPrice   	= bookController.getCart().getBooks(i).getBookPrice();
                String pDisc   	= bookController.getCart().getBooks(i).getBookDescription();

                showString += "\n\nProduct Name : "+pName+"\n"+
                        "Price : "+pPrice+"\n"+
                        "Discription : "+pDisc+""+
                        "\n -----------------------------------";
            }
        }
        else
            showString = "\n\nShopping cart is empty.\n\n";

        showCartContent.setText(showString);

/******** Show Cart Products on screen - End ********/

        thirdBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(cartSize >0)
                {
                    Intent i = new Intent(getBaseContext(), PaymentConfirmation.class);
                    startActivity(i);
                }
                else
                    Toast.makeText(getApplicationContext(),
                            "Shopping cart is empty.",
                            Toast.LENGTH_LONG).show();
            }
        });

    }
}
