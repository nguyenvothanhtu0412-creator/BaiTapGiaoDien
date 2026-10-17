package com.ute.baitap

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtHoTen = findViewById<EditText>(R.id.edtHoTen)
        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val rgGioiTinh = findViewById<RadioGroup>(R.id.rgGioiTinh)
        val swNhanThongBao = findViewById<Switch>(R.id.swNhanThongBao)
        val swCheDoToi = findViewById<Switch>(R.id.swCheDoToi)
        val btnLuu = findViewById<Button>(R.id.btnLuu)

        btnLuu.setOnClickListener {
            val hoTen = edtHoTen.text.toString().trim()
            val email = edtEmail.text.toString().trim()

            if (hoTen.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val idGioiTinh = rgGioiTinh.checkedRadioButtonId
            val rbChon = findViewById<RadioButton>(idGioiTinh)
            val gioiTinh = rbChon?.text.toString()

            val thongBao = if (swNhanThongBao.isChecked) "Bật" else "Tắt"
            val cheDoToi = if (swCheDoToi.isChecked) "Bật" else "Tắt"

            val ketQua = "Họ tên: $hoTen\n" +
                    "Email: $email\n" +
                    "Giới tính: $gioiTinh\n" +
                    "Nhận thông báo: $thongBao\n" +
                    "Chế độ tối: $cheDoToi"

            Toast.makeText(this, ketQua, Toast.LENGTH_LONG).show()
        }
    }
}