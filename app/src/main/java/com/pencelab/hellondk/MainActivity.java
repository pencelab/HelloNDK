package com.pencelab.hellondk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private TextView textResult;
    private TextView textHelloName;
    private TextView textByeName;
    private TextView textOpeOne;
    private TextView textOpeTwo;

    private Button btnSayHello;
    private Button btnSayBye;
    private Button btnCalculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String hello = this.getGreeting();
        this.textResult = findViewById(R.id.result);
        this.textResult.setText(hello);

        this.textHelloName = findViewById(R.id.name_hello);
        this.textByeName = findViewById(R.id.name_bye);
        this.textOpeOne = findViewById(R.id.ope_one);
        this.textOpeTwo = findViewById(R.id.ope_two);

        this.btnSayHello = findViewById(R.id.action_hello);
        this.btnSayBye = findViewById(R.id.action_bye);
        this.btnCalculate = findViewById(R.id.action_calculate);

        this.btnSayHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textHelloName.getText().toString().trim();
                if(isValidText(text))
                    showResult(sayHello(text));
                else
                    showAlert(getString(R.string.text_not_valid));
            }
        });

        this.btnSayBye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = textByeName.getText().toString().trim();
                if(isValidText(text))
                    showResult(sayBye(text));
                else
                    showAlert(getString(R.string.text_not_valid));
            }
        });

        this.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textOne = textOpeOne.getText().toString().trim();
                String textTwo = textOpeTwo.getText().toString().trim();
                if(isValidNumber(textOne) && isValidNumber(textTwo))
                    showResult(calculateAdd(Integer.parseInt(textOne), Integer.parseInt(textTwo)));
                else
                    showAlert(getString(R.string.number_not_valid));
            }
        });
    }

    private boolean isValidText(String text){
        return text != null && text.trim().length() > 0;
    }

    private boolean isValidNumber(String text){
        boolean validText = text != null && text.length() > 0;

        if(!validText)
            return false;

        try{
            Integer.parseInt(text);
        }catch(NumberFormatException nfe){
            return false;
        }

        return true;
    }

    private void showAlert(String text){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    private void showResult(String text){
        this.textResult.setText(text);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String getGreeting();
    public native String sayHello(String name);
    public native String sayBye(String name);
    public native String calculateAdd(int x, int y);
}
