package com.neppplus.intent_20211102

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)

        btnOK.setOnClickListener {

//            1. 입력한 닉네임 변수에 저장
            val inpitNickName = edtNewNickname.text.toString()
//            1. 닉네임 들고가야 함 -> 결과를 담아줘야 함 -> 인텐트 추가 활용
//            이전에 왔다 간다는 왕복을 이야기 해줬기 때문에 출발 도착지를 적지 않음
            val resultIntent=intent()

//            실제 데이터 첨부, putExtra()
            resultIntent.putExtra("nick",inpitNickName)

//            최종 결과 (확인을 눌렀을 때, 들고 돌아갈 데이터 지정)
            setResult(RESULT_OK, resultIntent)

//            실제 이전 화면으로 돌아가는 것
            finish()

        }
    }
}