package com.songspagetti.lotto

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Toast.makeText(applicationContext, "사장님 1등 가즈아아!!!", Toast.LENGTH_LONG).show()

        //랜덤으로 번호생성
        cardview1.setOnClickListener {
            val intent = Intent(this, ResultActivity::class.java)

            intent.putIntegerArrayListExtra("result", ArrayList(LottoNumberMaker.getShuffleLottoNumbers()))

            startActivity(intent)
        }
        //별자리로 번호생성
        cardview2.setOnClickListener {
            startActivity(Intent(this, ConstellationActivity::class.java))
        }
        //이름으로 번호생성
        cardview3.setOnClickListener {
            startActivity(Intent(this,NameActivity::class.java))
        }

    }

}
