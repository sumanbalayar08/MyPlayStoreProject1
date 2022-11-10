package com.example.youtubemusicplayer;

import android.annotation.SuppressLint;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText editText;
    Button btnplay;
    Button btnpaste;
    private ClipboardManager clipboard;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @SuppressLint({"UseSupportActionBar", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar1);
        editText = findViewById(R.id.editText3); //this is pasteitem
        btnpaste = findViewById(R.id.button2);
        btnplay = findViewById(R.id.button);
        btnpaste.setOnClickListener(view -> {
            clipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = clipboard.getPrimaryClip();
            if (clip == null) {
                Toast.makeText(this, "No item Available", Toast.LENGTH_SHORT).show();
            } else {
                ClipData.Item item = clip.getItemAt(0);
                String txtpaste = item.getText().toString();
                editText.setText(txtpaste);
                Toast.makeText(getApplicationContext(), "Data Pasted from Clipboard", Toast.LENGTH_SHORT).show();
            }
        });
        btnplay.setOnClickListener(view -> {
            String url=editText.getText().toString();
           if(url.isEmpty())
           {
               Toast.makeText(this,"Please Enter the link", Toast.LENGTH_SHORT).show();
           }
           else{
               if(!URLUtil.isValidUrl(url)){
                   Toast.makeText(this,"Please Enter the valid URL", Toast.LENGTH_SHORT).show();
               } else{
                   Intent i=new Intent();
                   i.putExtra("hell", url);
                   startActivity(i);
               }
           }
        });
    }
    public void onBa
    public void onDestroy(){
        super.onDestroy();
    }
}
