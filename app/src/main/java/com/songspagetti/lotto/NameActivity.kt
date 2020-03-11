package com.songspagetti.lotto

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_name.*
import java.util.*

class NameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)
       // Toast.makeText(applicationContext, "Name 입니다.", Toast.LENGTH_LONG).show()

        goButton.setOnClickListener {
            val name = editText.text.toString()
            if(TextUtils.isEmpty(name)){
                Toast.makeText(applicationContext, "이름을 입력하세요", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            val intent = Intent(this, ResultActivity::class.java)

            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getLottoNumbersFromHash(name)))
            intent.putExtra("name", name)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
        }

    }

}
