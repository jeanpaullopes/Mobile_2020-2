package br.edu.uniritter.mobile.minhaprimeiraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.button2);
        button.setText("de volta ao jogo");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SegundaActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
       /*
        Button button = (Button) findViewById(R.id.button2);
        button.setText("de volta ao jogo");
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), SegundaActivity.class);
                startActivity(intent);
            }
        });
        */
    }

    public void botaoClick(View view) {
        Button button = (Button) findViewById(R.id.button2);
        button.setText("clicado");
        Intent intent = new Intent(this, ActivityRecycler.class);
        startActivity(intent);

    }


}