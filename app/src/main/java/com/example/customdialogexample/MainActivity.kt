package com.example.customdialogexample

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)

        button.setOnClickListener {

            setCustomDialog()

        }

    }

    private fun setCustomDialog() {

        val customDialog = AlertDialog.Builder(this)
            .setView(R.layout.custom_dialog)
            .setCancelable(true)
            .create()

        // 뒷배경을 투명으로 바꾼다.
        customDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        customDialog.show()

        // customDialog 레이아웃에 view를 초기화 해준다.
        // 이과정이 번거로운 경우 viewBinding이나 DataBinding을 사용하면 간단히 할 수 있음
        val textViewCheck = customDialog.findViewById<TextView>(R.id.textViewCheck)
        val textViewCancel = customDialog.findViewById<TextView>(R.id.textViewCancel)

        textViewCheck!!.setOnClickListener {

            Toast.makeText(this,"확인을 눌렀습니다",Toast.LENGTH_SHORT).show()
            customDialog.dismiss()

        }

        textViewCancel!!.setOnClickListener {

            Toast.makeText(this,"취소를 눌렀습니다",Toast.LENGTH_SHORT).show()
            customDialog.dismiss()

        }


    }

}