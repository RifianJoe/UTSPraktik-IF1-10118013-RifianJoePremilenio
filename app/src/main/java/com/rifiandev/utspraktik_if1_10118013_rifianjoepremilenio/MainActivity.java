package com.rifiandev.utspraktik_if1_10118013_rifianjoepremilenio;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

        private DatePickerDialog datePickerDialog;
        private SimpleDateFormat dateFormatter;
        private TextView tvDateResult;
        private EditText btDatePicker;
        private String KEY_NAME = "NAMA";
        private String KEY_NIKK = "NIK";
        private String KEY_DATE = "TANGGAL";
        private String KEY_JK = "KELAMIN";
        private String KEY_HUB = "HUBUNGAN";

        Button bsimpan;
        EditText nik, nama, tempatlahir;
        TextView thasil;
        RadioGroup rgjk, rghub;




        /*private void showDateDialog(){
            Calendar newCalendar = Calendar.getInstance();
            datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                    Calendar newDate = Calendar.getInstance();
                    newDate.set(year, monthOfYear, dayOfMonth);
                    tvDateResult.setText(dateFormatter.format(newDate.getTime()));
                }

            },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

            datePickerDialog.show();
        }
*/



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            final Calendar myCalendar = Calendar.getInstance();

            EditText tanggalLahir= (EditText) findViewById(R.id.edtTanggal);
            DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {



                private void updateLabel() {
                    String myFormat = "MM/dd/yy"; //In which you need put here
                    SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                    tanggalLahir.setText(sdf.format(myCalendar.getTime()));
                }
                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear,
                                      int dayOfMonth) {
                    // TODO Auto-generated method stub
                    myCalendar.set(Calendar.YEAR, year);
                    myCalendar.set(Calendar.MONTH, monthOfYear);
                    myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                    updateLabel();
                }

            };

            tanggalLahir.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    new DatePickerDialog(MainActivity.this, date, myCalendar
                            .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                            myCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
            });


            /*dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
            tvDateResult = (TextView) findViewById(R.id.edtTanggal);
            btDatePicker = (EditText) findViewById(R.id.edtTanggal);*/


            bsimpan = (Button) findViewById(R.id.btnSelanjutnya);
            nik = (EditText) findViewById(R.id.edtNik);
            nama = (EditText) findViewById(R.id.edtNama);
            rgjk = (RadioGroup) findViewById(R.id.radioJk);
            rghub = (RadioGroup) findViewById(R.id.radioHub);
            tempatlahir = (EditText) findViewById(R.id.edtTanggal);
            bsimpan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    /*Intent intent = new Intent(getApplicationContext(),review.class);

                    Bundle b = new Bundle();

                    //Menyisipkan tipe data String ke dalam obyek bundle
                    b.putString("nama", nama.getText().toString());
                    b.putString("umur", nik.getText().toString());
                    int id = rgjk.getCheckedRadioButtonId();
                    RadioButton radioButton = (RadioButton) findViewById(id);
                    b.putString("radioJk", radioButton.getText().toString());

                    //Menambahkan bundle intent
                    intent.putExtras(b);

                    //memulai Activity kedua
                    startActivity(intent);*/


                    try{
                        String name = nama.getText().toString();
                        String nikk = nik.getText().toString();
                        String date = tanggalLahir.getText().toString();
                        String rg1 = Integer.toString(rgjk.getCheckedRadioButtonId());
                        String rg2 = Integer.toString(rghub.getCheckedRadioButtonId());
                        if (name != null && name != ""){
                            Intent i = new Intent(MainActivity.this, review.class);
                            i.putExtra(KEY_NAME, name);
                            i.putExtra(KEY_NIKK, nikk);
                            i.putExtra(KEY_DATE, date);
                            i.putExtra(KEY_JK, rg1);
                            i.putExtra(KEY_HUB, rg2);
                            startActivity(i);

                        } else {
                            Toast.makeText(getApplication(), "YOU NEED TO FILL YOUR NAME",Toast.LENGTH_SHORT);
                        }

                    } catch (Exception e){
                        e.printStackTrace();
                        Toast.makeText(getApplication(), "ERROR, TRY AGAIN !",Toast.LENGTH_SHORT);
                    }



                    /*String inputnik = String.valueOf(nik.getText().toString());
                    String inputnama = String.valueOf(nama.getText().toString());
                    String inputtempatlahir = String.valueOf(tempatlahir.getText().toString());
                    String inputotomatis = String.valueOf(tvDateResult.getText().toString());

                    int gender = rgjk.getCheckedRadioButtonId();
                    RadioButton jk = (RadioButton) findViewById(gender);
                    String inputjk = String.valueOf(jk.getText().toString());

                    thasil.setText("\n" + "NIK\t\t\t\t\t\t\t\t\t\t\t: " + inputnik + "\n" +
                            "Nama\t\t\t\t\t\t\t\t\t\t: " + inputnama + "\n" +
                            "Jenis Kelamin\t\t: " + inputjk + "\n" +
                            "Jenis Kelamin\t\t: " + inputtempatlahir + "\n" +
                            "Tanggal Lahir\t\t\t: " + inputotomatis + "\n");
                }
            });

            dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
            tvDateResult = (TextView) findViewById(R.id.edtTanggal);
            btDatePicker = (EditText) findViewById(R.id.edtTanggal);
            btDatePicker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showDateDialog();*/
                }
            });
    }
}