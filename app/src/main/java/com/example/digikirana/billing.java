package com.example.digikirana;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class billing extends AppCompatActivity {


    private ArrayList<String> data = new ArrayList<String>();
    private ArrayList<String> data1 = new ArrayList<String>();
    private ArrayList<String> data2 = new ArrayList<String>();
    private ArrayList<String> data3 = new ArrayList<String>();
    private TableLayout table;
    private EditText eed1, eed2, eed3, eed4, eed5, eed6;
    private Button b1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_billing);
       /*
        Intent billingIntent = new Intent(billing.this ,MainActivity.class);
        startActivity(billingIntent);
        */

        eed1 = findViewById(R.id.xproname);
        eed2 = findViewById(R.id.xprice);
        eed3 = findViewById(R.id.xqty);

        eed4 = findViewById(R.id.xsubtotal);
        eed5 = findViewById(R.id.txtpay);
        eed6 = findViewById(R.id.xbal);
        b1 = findViewById(R.id.xadd);


        eed5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                int subtotal = Integer.parseInt(eed4.getText().toString());
                int pay = Integer.parseInt(eed5.getText().toString());
                int bal = pay - subtotal;
                eed6.setText(String.valueOf(bal));
            }
        });


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add();
            }
        });
    }

    public void add() {


        int tot;

        String prodname = eed1.getText().toString();
        int price = Integer.parseInt(eed2.getText().toString());
        int qty = Integer.parseInt(eed3.getText().toString());
        tot = price * qty;
        // tot = Integer.parseInt(eed4.getText().toString());

        data.add(prodname);
        data1.add(String.valueOf(price));
        data2.add(String.valueOf(qty));
        data3.add(String.valueOf(tot));
        TableLayout table = (TableLayout) findViewById(R.id.xtable);
        TableRow row = new TableRow(this);
        TextView t1 = new TextView(this);
        TextView t2 = new TextView(this);
        TextView t3 = new TextView(this);
        TextView t4 = new TextView(this);
        String total;
        int sum = 0;
        for (int i = 0; i < data.size(); i++) {
            String pname = data.get(i);
            String pro = data1.get(i);
            String qtyy = data2.get(i);
            total = data3.get(i);

            sum = sum + Integer.parseInt(data3.get(i).toString());
            t1.setText(pname);
            t2.setText(pro);
            t3.setText(qtyy);
            t4.setText(total);

        }
        row.addView(t1);
        row.addView(t2);
        row.addView(t3);
        row.addView(t4);
        table.addView(row);

        eed4.setText(String.valueOf(sum));
        eed1.setText("");
        eed2.setText("");
        eed3.setText("");
        eed1.requestFocus();

    }


}



