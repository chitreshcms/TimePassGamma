package com.ibm.mobileappbuilder.businessdirectory20150916145512;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ibm.mobileappbuilder.businessdirectory20150916145512.ui.TimePassGammaMain;

public class Registration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeration);

        Button button = (Button)findViewById(R.id.btnRegister) ;
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Registration.this, TimePassGammaMain.class);
                startActivity(intent);
            }


        });
    }
}
