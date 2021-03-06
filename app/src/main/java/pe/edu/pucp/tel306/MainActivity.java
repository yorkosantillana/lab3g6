package pe.edu.pucp.tel306;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import pe.edu.pucp.tel306.ViewModels.ContadorMainMin;
import pe.edu.pucp.tel306.ViewModels.ContadorMainSeg;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Para el contador principal Segundos
        ViewModelProvider viewModelProvider1 = new ViewModelProvider(this);
        ContadorMainSeg contadorViewModel1 = viewModelProvider1.get(ContadorMainSeg.class);

        contadorViewModel1.getContadorSeg().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                TextView textView = findViewById(R.id.contador3);
                textView.setText(String.valueOf(integer));
            }
        });



        //Para el contador principal Minutos
        ViewModelProvider viewModelProvider2 = new ViewModelProvider(this);
        ContadorMainMin contadorViewModel2 = viewModelProvider2.get(ContadorMainMin.class);

        contadorViewModel2.getContadorMin().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                TextView textView = findViewById(R.id.contador2);
                textView.setText(String.valueOf(integer));
            }
        });

        registerForContextMenu(findViewById(R.id.contador));
        registerForContextMenu(findViewById(R.id.contador2));
        registerForContextMenu(findViewById(R.id.contador3));
        registerForContextMenu(findViewById(R.id.contador4));
        registerForContextMenu(findViewById(R.id.contador5));



        Intent intent = getIntent();

        int trabajo = intent.getIntExtra("trabajo",0);
        int descanso = intent.getIntExtra("descanso",0);
        int ciclo = intent.getIntExtra("ciclo",0);


        //TextView minutosText = findViewById(R.id.contador4);
        //minutosText.setText(String.valueOf(trabajo));



    }


    public void iniciarContador(View view){

        TextView nuevoMinutos = findViewById(R.id.contador4);
        String minutosPausa = (String) nuevoMinutos.getText();
        int minutosPausaInt = Integer.valueOf(minutosPausa);
        nuevoMinutos.setVisibility(View.INVISIBLE);

        TextView nuevoSegundos = findViewById(R.id.contador5);
        String segPausa = (String) nuevoSegundos.getText();
        int segPausaInt = Integer.valueOf(segPausa);
        nuevoSegundos.setVisibility(View.INVISIBLE);


        ViewModelProvider viewModelProvider1 = new ViewModelProvider(this);
        ContadorMainSeg contadorViewModel1 = viewModelProvider1.get(ContadorMainSeg.class);
        contadorViewModel1.iniciarContador1(segPausaInt);


        ViewModelProvider viewModelProvider2 = new ViewModelProvider(this);
        ContadorMainMin contadorViewModel2 = viewModelProvider2.get(ContadorMainMin.class);
        contadorViewModel2.iniciarContador2(minutosPausaInt);

        ImageButton botonPlay = findViewById(R.id.imageButton);
        botonPlay.setVisibility(View.INVISIBLE);

        ImageButton botonPausa = findViewById(R.id.imageButton4);
        botonPausa.setVisibility(View.VISIBLE);

        TextView textMinutos = findViewById(R.id.contador2);
        textMinutos.setVisibility(View.VISIBLE);
        TextView textSegundos = findViewById(R.id.contador3);
        textSegundos.setVisibility(View.VISIBLE);


    }


    public void botonPausa(View view){


        ImageButton botonPausa = findViewById(R.id.imageButton4);
        botonPausa.setVisibility(View.INVISIBLE);

        ImageButton botonPlay = findViewById(R.id.imageButton);
        botonPlay.setVisibility(View.VISIBLE);




        TextView textMinutos = findViewById(R.id.contador2);
        String minutoActual = (String) textMinutos.getText();
        textMinutos.setVisibility(View.INVISIBLE);
        TextView textSegundos = findViewById(R.id.contador3);
        String segundoActual = (String) textSegundos.getText();
        textSegundos.setVisibility(View.INVISIBLE);

        TextView nuevoMinutos = findViewById(R.id.contador4);
        nuevoMinutos.setText(minutoActual);
        nuevoMinutos.setVisibility(View.VISIBLE);

        TextView nuevoSegundos = findViewById(R.id.contador5);
        nuevoSegundos.setText(segundoActual);
        nuevoSegundos.setVisibility(View.VISIBLE);



    }

    public void botonReset(View view){

        TextView nuevoMinutos = findViewById(R.id.contador4);
        nuevoMinutos.setVisibility(View.INVISIBLE);

        TextView nuevoSegundos = findViewById(R.id.contador5);
        nuevoSegundos.setVisibility(View.INVISIBLE);

        int segPausaInt = 59;
        int minutosPausaInt = 24;


        ViewModelProvider viewModelProvider1 = new ViewModelProvider(this);
        ContadorMainSeg contadorViewModel1 = viewModelProvider1.get(ContadorMainSeg.class);
        contadorViewModel1.iniciarContador1(segPausaInt);


        ViewModelProvider viewModelProvider2 = new ViewModelProvider(this);
        ContadorMainMin contadorViewModel2 = viewModelProvider2.get(ContadorMainMin.class);
        contadorViewModel2.iniciarContador2(minutosPausaInt);

        ImageButton botonPlay = findViewById(R.id.imageButton);
        botonPlay.setVisibility(View.INVISIBLE);

        ImageButton botonPausa = findViewById(R.id.imageButton4);
        botonPausa.setVisibility(View.VISIBLE);

        TextView textMinutos = findViewById(R.id.contador2);
        textMinutos.setVisibility(View.VISIBLE);
        TextView textSegundos = findViewById(R.id.contador3);
        textSegundos.setVisibility(View.VISIBLE);



    }




    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_editar:
                Toast.makeText(this, "Boton Editar", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this,MainActivity_edit.class));
                break;
            case R.id.menu_reset:
                Toast.makeText(this, "Boton Reset", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onContextItemSelected(item);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_info,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_info:
                startActivity(new Intent(MainActivity.this,MainActivity_info.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}