package com.naruto.engelsizproje;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.content.DialogInterface.OnClickListener;


public class AcilDurumActivity extends ActionBarActivity {

    private String[] acilDurumlar =
            {"İMDAT", "YARDIM EDİN", "HIRSIZ VAR"};

    private MediaPlayer imdat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acil_durum);


        ListView listemiz=(ListView) findViewById(R.id.AcilDurumlistView);

        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, acilDurumlar);

        listemiz.setAdapter(veriAdaptoru);

        listemiz.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                AlertDialog.Builder diyalogOlusturucu =
                        new AlertDialog.Builder(AcilDurumActivity.this);

                diyalogOlusturucu.setMessage(acilDurumlar[position])
                        .setCancelable(false)
                        .setPositiveButton("Tamam", new OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                diyalogOlusturucu.create().show();

                imdat = MediaPlayer.create(AcilDurumActivity.this, R.raw.siren);
                imdat.start();
            }

        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_acil_durum, menu);
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
