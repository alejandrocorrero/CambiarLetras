package com.correro.alejandro.cambiarletras;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.content.ClipData.*;

public class MainActivity extends AppCompatActivity  {

    private Button button;
    ClipboardManager clipboard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        button = (Button) findViewById(R.id.button);
        clipboard = (ClipboardManager) getSystemService(this.CLIPBOARD_SERVICE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String test= (String) clipboard.getText();
               transformar(test);
            }
        });
    }

    private void transformar(String test) {
        test=	test.replace('a','i').replace('e','i').replace('o','i' ).replace('u', 'i').replace('á','í').replace('é','í').replace('ó','í').replace('ú','í').replace('à','ì').replace('è','ì').replace('ò','ì').replace('ù','ì').replace('A','I').replace('E','I').replace('O','I').replace('U','I');
        ClipData clip = ClipData.newPlainText("simple text",test);
        clipboard.setPrimaryClip(clip);
        Toast.makeText(this,"Se ha cambiado correctamente",Toast.LENGTH_SHORT).show();
    }


}
