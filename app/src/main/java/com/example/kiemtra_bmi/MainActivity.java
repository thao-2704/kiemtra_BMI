package com.example.kiemtra_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.Math;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener{
    EditText can_nang,chieu_cao;
    TextView ket_qua,danh_gia;
    Button tinh,nhaplai;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();// ẩn thanh tiêu đề
        AddControl();
        tinh.setOnClickListener(this);// goi nut tinh chi so
        nhaplai.setOnClickListener(this);// goi nut nhap lai

    }
    @Override
    public void onClick(View v) {
        try {
            //Lấy giá trị nhập vào và ép kiểu về double
            double cao = Double.parseDouble(chieu_cao.getText().toString());
            double nang = Double.parseDouble(can_nang.getText().toString());
            double chiso_BMI = nang / Math.pow(cao, 2);
            DecimalFormat dinhdang = new DecimalFormat("0.00"); //định dạng lấy đến 2 con số
            switch (v.getId()) //lấy id của các Button
            {
                case R.id.bt_kiemtra: //chon id la button tinh BMI
                    ket_qua.setText(dinhdang.format(chiso_BMI) + "");
                    if (chiso_BMI < 18)
                        danh_gia.setText("Người gầy");
                    else if (18 <= chiso_BMI && chiso_BMI < 25)
                        danh_gia.setText("Người bình thường");
                    else if (25 <= chiso_BMI && chiso_BMI < 30)
                        danh_gia.setText("Người béo phì độ I");
                    else if (30 <= chiso_BMI && chiso_BMI < 35)
                        danh_gia.setText("Người béo phì độ II");
                    else if (35 <= chiso_BMI)
                        danh_gia.setText("Người béo phì độ III");
                    break;
                case R.id.bt_nhaplai: //chon id la button nhap lai
                    chieu_cao.setText("");
                    can_nang.setText("");
                    ket_qua.setText("");
                    danh_gia.setText("");
                    break;
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), "Bạn chưa nhập dữ liệu", Toast.LENGTH_SHORT).show();
        }
    }
    public void AddControl(){
        can_nang=(EditText) findViewById(R.id.cannang);
        chieu_cao=(EditText) findViewById(R.id.chieucao);
        tinh=(Button) findViewById(R.id.bt_kiemtra);
        nhaplai=(Button) findViewById(R.id.bt_nhaplai);
        ket_qua=(TextView) findViewById(R.id.ketqua);
        danh_gia=(TextView) findViewById(R.id.text_danhgia);

    }
}