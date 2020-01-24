package com.naruto.mekvahandelivery.signature;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.naruto.mekvahandelivery.R;
import com.williamww.silkysignature.views.SignaturePad;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Locale;

public class SignatureActivity extends AppCompatActivity {

    SignaturePad mSignaturePad;
    Button clear_button, save_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signature);

        clear_button = findViewById(R.id.clear_button);
        save_button = findViewById(R.id.save_button);
        mSignaturePad = findViewById(R.id.signature_pad);

        try{
            final Drawable upArrow = getDrawable(R.drawable.ic_keyboard_backspace_black_24dp);
            if (getSupportActionBar() != null && upArrow != null) {
                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
                getSupportActionBar().setTitle(Html.fromHtml("<font color='#000000'>Signature</font>"));
                upArrow.setColorFilter(getColor(R.color.chart_deep_red), PorterDuff.Mode.SRC_ATOP);
                getSupportActionBar().setHomeAsUpIndicator(upArrow);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        clear_button.setOnClickListener(v -> mSignaturePad.clear());

        save_button.setOnClickListener(view -> {
            Bitmap signatureBitmap = mSignaturePad.getSignatureBitmap();
            Intent intent= new Intent();
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            signatureBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream);
            byte[] bytes = stream.toByteArray();
            intent.putExtra("image", bytes);
            intent.setFlags(Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            setResult(2,intent);
            finish();

        });
        mSignaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {
               // Toast.makeText(SignatureActivity.this, "OnStartSigning", Toast.LENGTH_SHORT).show();
                clear_button.setEnabled(false);
                save_button.setEnabled(false);
            }

            @Override
            public void onSigned() {
                clear_button.setEnabled(true);
                save_button.setEnabled(true);
                //Event triggered when the pad is signed
            }

            @Override
            public void onClear() {
                clear_button.setEnabled(true);
                save_button.setEnabled(true);
                //Event triggered when the pad is cleared
            }
        });
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

}