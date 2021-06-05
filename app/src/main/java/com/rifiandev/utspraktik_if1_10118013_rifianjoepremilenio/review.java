package com.rifiandev.utspraktik_if1_10118013_rifianjoepremilenio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class review extends AppCompatActivity {

    private Button showDialogButton;

    TextView txtNama2;
    TextView txtNik2;
    TextView txtTanggal;
    TextView txtJk;
    TextView txtHub;
    private String name;
    private String nikk;
    private String tanggal;
    private String jk;
    private String hub;
    private String KEY_NAME = "NAMA";
    private String KEY_NIKK = "NIK";
    private String KEY_DATE = "TANGGAL";
    private String KEY_JK = "KELAMIN";
    private String KEY_HUB = "HUBUNGAN";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        /*Bundle b = getIntent().getExtras();
        //membuat obyek dari widget textview
        TextView nama = (TextView) findViewById(R.id.edtNama2);
        TextView nik = (TextView) findViewById(R.id.edtNik2);
        TextView jeniskelamin = (TextView) findViewById(R.id.edtJk2);
        //menset nilai dari widget textview
        nama.setText(b.getCharSequence("nama"));
        nik.setText(b.getCharSequence("nik"));
        jeniskelamin.setText(b.getCharSequence("jeniskelamin"));*/

        txtNama2 = (TextView) findViewById(R.id.edtNama2);
        txtNik2 = (TextView) findViewById(R.id.edtNik2);
        txtTanggal = (TextView) findViewById(R.id.edtTanggal2);
        txtJk = (TextView) findViewById(R.id.edtJk2);
        txtHub = (TextView) findViewById(R.id.edtHub2);


        Bundle extras = getIntent().getExtras();
        name = extras.getString(KEY_NAME);
        txtNama2.setText(name);
        nikk = extras.getString(KEY_NIKK);
        txtNik2.setText(nikk);
        tanggal = extras.getString(KEY_DATE);
        txtTanggal.setText(tanggal);
        jk = extras.getString(KEY_JK);
        txtJk.setText(jk);
        hub = extras.getString(KEY_HUB);
        txtHub.setText(hub);


        showDialogButton = (Button) findViewById(R.id.btnSimpan);

        showDialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showCustomDialog();
            }
        });

    }

    private void showCustomDialog() {
        final Dialog dialog = new Dialog(this);
        //Mengeset judul dialog
        dialog.setTitle("Add person");

        //Mengeset layout
        dialog.setContentView(R.layout.activity_dialog);

        //Membuat agar dialog tidak hilang saat di click di area luar dialog
        dialog.setCanceledOnTouchOutside(true);

        //Membuat dialog agar berukuran responsive
        DisplayMetrics metrics = getResources().getDisplayMetrics();
        int width = metrics.widthPixels;
        dialog.getWindow().setLayout((6 * width) / 7, RelativeLayout.LayoutParams.WRAP_CONTENT);

        Button okButton = (Button) dialog.findViewById(R.id.btnOk);

        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        /*Button saveButton = (Button) dialog.findViewById(R.id.button_save);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Data saved", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });*/

        //Menampilkan custom dialog
        dialog.show();
    }
}