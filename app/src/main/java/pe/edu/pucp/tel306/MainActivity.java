package pe.edu.pucp.tel306;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import pe.edu.pucp.tel306.ViewModels.ContadorPrincipal;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para el contador principal
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        ContadorPrincipal contadorViewModel = viewModelProvider.get(ContadorPrincipal.class);

        contadorViewModel.getContadorSeg().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                TextView textView = findViewById(R.id.contador3);
                textView.setText(String.valueOf(integer));
            }
        });

        contadorViewModel.getContadorMin().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                TextView textView = findViewById(R.id.contador2);
                textView.setText(String.valueOf(integer));
            }
        });










    }


    public void iniciarContador(View view){

        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        ContadorPrincipal contadorViewModel = viewModelProvider.get(ContadorPrincipal.class);
        contadorViewModel.iniciarContador();



    }





}