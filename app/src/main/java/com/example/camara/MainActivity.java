package com.example.camara;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnCamara;

    // Definir la identificación de la foto
    private static final int pic_id = 123;
    ImageView click_image_id;

    Bitmap photo;
    boolean photoTook = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCamara = findViewById(R.id.btn_tomar_foto);

        click_image_id = findViewById(R.id.imagen_camara);

        // El botón Camera_open es para abrir la cámara y agregar el setOnClickListener en este botón
        btnCamara.setOnClickListener(v -> {
            // Cree camera_intent ACTION_IMAGE_CAPTURE, se abrirá la cámara para capturar la imagen.
            Intent camera_intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            //
            //Inicie la actividad con camera_intent y solicite una identificación con foto
            startActivityForResult(camera_intent, pic_id);
        });
    }


    // Este método ayudará a recuperar la imagen.
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Haga coincidir la solicitud 'id de imagen con requestCode
        if (requestCode == pic_id) {
            // BitMap es la estructura de datos del archivo de imagen que almacena la imagen en la memoria
            photo = (Bitmap) data.getExtras().get("data");
            // Establecer la imagen en la vista de imagen para mostrar

            click_image_id.setImageBitmap(photo);
        }
    }
}