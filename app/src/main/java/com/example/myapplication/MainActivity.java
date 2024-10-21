package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText e1 , e2 ;
    private Button sumbutton ,subbutton ;
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);

            e1 = (EditText) findViewById(R.id.edittext1);
            e2 = (EditText) findViewById(R.id.edittext2);

            sumbutton = (Button) findViewById(R.id.sumbuttonid);
            subbutton = (Button) findViewById(R.id.subbuttonid);
            result = (TextView) findViewById(R.id.textid);

            sumbutton.setOnClickListener(this);
            subbutton.setOnClickListener(this);

            return insets;
        });
    }

    public static void foo(void) {
        .. .. 
    }

    @Override
    public void onClick(View v) {
        try{
            String num1 =e1.getText().toString();
            String num2 =e2.getText().toString();

            double a = Double.parseDouble(num1);
            double b = Double.parseDouble(num2);

            if(v.getId() == R.id.sumbuttonid)
            {
                double sum= a+b;
                result.setText("Result : "+sum);
                // Log.d("tag","Sum");
            }
            if(v.getId() == R.id.subbuttonid)
            {
                double sum= a-b;
                result.setText("Result : "+sum);
                //. Log.d("tag","Sub");
            }
        }catch(Exception e){
            Toast.makeText(MainActivity.this,"Please enter a number ",Toast.LENGTH_SHORT).show();
        }



    }
}