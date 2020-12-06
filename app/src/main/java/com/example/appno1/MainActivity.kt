package com.example.appno1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //遊戲設計

        btn_play.setOnClickListener {
            if (enter_name.length() < 1)
                name_text.text = "請輸入名字"
            else {
                //打印玩家名
                tx_name.text = String.format("名字\n%s", enter_name.text)
                //打印我方出拳
                me_play.text = String.format(
                    "我方出拳\n%s", when {
                        btn_S.isChecked -> "剪刀"
                        btn_R.isChecked -> "石頭"
                        else -> "布"
                    }
                )
                //使用亂數產生電腦出拳
                val computer = (Math.random() * 3).toInt()
                com_play.text = String.format(
                    "電腦出拳\n%s", when (computer) {
                        0 -> "剪刀"
                        1 -> "石頭"
                        else -> "布"
                    }
                )
                //判斷勝負
                when {
                    btn_S.isChecked && computer == 2 || btn_R.isChecked && computer == 0 ||
                            btn_P.isChecked && computer == 1 -> {
                        tx_winner.text = String.format("勝利者\n%s", enter_name.text)
                        name_text.text = "恭喜你獲勝了！！！"
                    }
                    btn_S.isChecked && computer == 1 || btn_R.isChecked && computer == 2 ||
                            btn_P.isChecked && computer == 0 -> {
                        tx_winner.text = "勝利者\n電腦"
                        name_text.text = "可惜，電腦獲勝了！"
                    }
                    else -> {
                        tx_winner.text = "勝利者\n平手"
                        name_text.text = "平局，請再試一次！"
                    }


                }
            }

        }
    }
}