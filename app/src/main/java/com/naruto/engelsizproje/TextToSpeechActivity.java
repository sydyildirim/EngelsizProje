package com.naruto.engelsizproje;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;


public class TextToSpeechActivity extends ActionBarActivity {

    private Button seslendirButton;
    private EditText metin;
    TextToSpeech ttobj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_to_speech);

        seslendirButton = (Button) findViewById(R.id.seslendirButton);
        metin = (EditText) findViewById(R.id.editText);

        ttobj=new TextToSpeech(getApplicationContext(),
                new TextToSpeech.OnInitListener() {
                    @Override
                    public void onInit(int status) {
                        if(status != TextToSpeech.ERROR){

                            ttobj.setLanguage(Locale.ENGLISH);
                        }
                    }
                });


        seslendirButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                String toSpeak = metin.getText().toString();
                Toast.makeText(getApplicationContext(), toSpeak,
                        Toast.LENGTH_SHORT).show();
                ttobj.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);


            }
        });
    }
    @Override
    public void onPause(){
        if(ttobj !=null){
            ttobj.stop();
            ttobj.shutdown();
        }
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_text_to_speech, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
