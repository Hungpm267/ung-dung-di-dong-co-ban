package com.example.myapplication10;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edt_hoten, edt_cmnd, edt_thongtinbosung;
    RadioGroup idgroup;
    CheckBox ckb_nhac, ckb_sach, ckb_tienganh;
    Button btn_gui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Anh xa id
        edt_hoten = findViewById(R.id.edt_hoten);
        edt_cmnd = findViewById(R.id.edt_cmnd);
        edt_thongtinbosung = findViewById(R.id.edt_thongtinbosung);
        idgroup = findViewById(R.id.radioGroup);
        ckb_nhac = findViewById(R.id.ckb_nhac);
        ckb_sach = findViewById(R.id.ckb_sach);
        ckb_tienganh = findViewById(R.id.ckb_tienganh);
        btn_gui = findViewById(R.id.btn_gui);

        // Xu ly su kien click vao button
        btn_gui.setOnClickListener(view -> {
            // LAY DU LIEU TU CAC EDITTEXT:
            // lay thong tin ho ten
            String hoten = edt_hoten.getText().toString();
            if(hoten.length() < 6) {
                Toast.makeText(this, "ho ten phai lon hon 6 ky tu", Toast.LENGTH_SHORT).show();
                edt_hoten.requestFocus();
                edt_hoten.selectAll();
                return;
            }

            // Lay thong tin cmnd
            String cmnd = edt_cmnd.getText().toString();
            if(cmnd.length() != 9) {
                Toast.makeText(this, "cmnd phai co 9 ky tu", Toast.LENGTH_SHORT).show();
                edt_cmnd.requestFocus();
                edt_cmnd.selectAll();
                return;
            }

            // Lay thong tin bang cap
            int idbtngr = idgroup.getCheckedRadioButtonId();
            RadioButton radioButton = findViewById(idbtngr);
            String bangcap = radioButton.getText().toString();

            // Lay thong tin so thich
            String sothich = "";
            if(ckb_nhac.isChecked()) {
                sothich += ckb_nhac.getText().toString() + "-";
            }
            if(ckb_sach.isChecked()) {
                sothich += ckb_sach.getText().toString() + "-";
            }
            if(ckb_tienganh.isChecked()) {
                sothich += ckb_tienganh.getText().toString();
            }

            // Lay thong tin bo sung
            String thongtinbosung = edt_thongtinbosung.getText().toString();

            // Hien thi thong tin
            String tonghop = hoten +"\n" + cmnd+"\n" + bangcap+"\n" + sothich+"\n" + thongtinbosung;

            // Tao dialog va hien thi thong tin tong hop len no
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Thong tin ca nhan");
            builder.setMessage(tonghop);
            builder.setPositiveButton("OK DONSG", (dialogInterface, i) -> dialogInterface.cancel());
            builder.show();
        });
    }
}
