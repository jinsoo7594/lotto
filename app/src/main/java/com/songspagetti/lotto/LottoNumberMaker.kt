package com.songspagetti.lotto

import java.text.SimpleDateFormat
import java.util.*
import kotlin.random.Random

// object : 클래스를 정의하면서 객체 생성, 싱글톤 패턴 적용  --> 객체 한번만 생성, 익명객체를 생성할 때도 사용
object LottoNumberMaker {
    fun getRandomLottoNumbers():MutableList<Int>{
        val lottoNumbers = mutableListOf<Int>()

        for(i in 1..6){
            var number = 0
            do{
                number = getRandomLottoNumber()
            }while(lottoNumbers.contains(number))

            lottoNumbers.add(number)
        }
        return lottoNumbers
    }

    fun getRandomLottoNumber():Int {
        return java.util.Random().nextInt(45) + 1
    }

    fun getShuffleLottoNumbers():MutableList<Int>{
        val list = mutableListOf<Int>()
        for(number in 1..45){
            list.add(number)
        }
        list.shuffle()
        return list.subList(0, 6)
    }

    fun getLottoNumbersFromHash(str: String): MutableList<Int>{
        val list = mutableListOf<Int>()

        for(number in 1..45){
            list.add(number)
        }
        val targetString = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(Date()) +str
        list.shuffle(Random(targetString.hashCode().toLong()))

        return list.subList(0, 6)
    }

}