package com.songspagetti.lotto

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : AppCompatActivity() {

    val lottoImageStartId : Int = R.drawable.ball_01

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        //Toast.makeText(applicationContext, "", Toast.LENGTH_LONG).show()

        val lottoResult = intent.getIntegerArrayListExtra("result")
        val nameResult = intent.getStringExtra("name")
        val constellation = intent.getStringExtra("constellation")
        resultLabel.text = "랜덤으로 생성된\n로또번호입니다."

        if(!TextUtils.isEmpty(nameResult)){
            resultLabel.text = "${nameResult} 님의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또 번호입니다."
        }
        if(!TextUtils.isEmpty(constellation)){
            resultLabel.text = "오늘 ${constellation}의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또 번호입니다."
        }

        lottoResult?.let {
            updateLottoBallImage(lottoResult.sortedBy{ it })
        }


    }

    private fun updateLottoBallImage(result: List<Int>){
        if(result.size < 6) return

        imageView1.setImageResource(lottoImageStartId+result[0]-1)
        imageView2.setImageResource(lottoImageStartId+result[1]-1)
        imageView3.setImageResource(lottoImageStartId+result[2]-1)
        imageView4.setImageResource(lottoImageStartId+result[3]-1)
        imageView5.setImageResource(lottoImageStartId+result[4]-1)
        imageView6.setImageResource(lottoImageStartId+result[5]-1)


    }


}
