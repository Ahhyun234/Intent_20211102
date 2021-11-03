package com.neppplus.intent_20211102

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val REQ_CODE_FOR_NICKNAME = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveToOther.setOnClickListener {

//            버튼이 눌리면 > OtherActivity로 이동하자. (화면 전환)

//            Intent로 어디서 출발 / 어디로 도착하는지 정보 설정. => 변수에 저장.
            val myIntent = Intent( this, OtherActivity::class.java )
//            출발/도착 정보를 가지고 이동
            startActivity( myIntent )


        }

        btnSendMessage.setOnClickListener {

//             입력한 내용을 변수로 저장.
            val inputMessage = edtMessage.text.toString()

//            메시지 화면으로 이동. Intent 활용
            val myIntent = Intent(this, ViewMessageActivity::class.java)
            
//            필요 데이터를 첨부하는 코드
            myIntent.putExtra("message", inputMessage)
            
            startActivity(myIntent)

        }

        btnEditNickname.setOnClickListener {

//            닉네임을 변경하기 위해 화면 이동(다른 화면으로 넘어갔다 돌아올것이라는 것을 암시하는 메소드 startActivityForResult)
//            어떤 데이터를 들고 돌아올 것인지 명시해야 함
            val myIntent = Intent(this, EditNicknameActivity::class.java)
            startActivityForResult(myIntent,REQ_CODE_FOR_NICKNAME)




        }

        btnDial.setOnClickListener {
//            안드로이드 전화 화면으로 이동 1. 어떤 화면(Action)으로 갈것인가 2. 세부 정보 (URI)

//            입력한 전화번호를 저장
            val inputPhoneNum = edtPhoneNum.text.toString()

            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent =Intent(Intent.ACTION_DIAL,myUri)
            startActivity(myIntent)


        }

        btnCall.setOnClickListener {
            val inputPhoneNum = edtPhoneNum.text.toString()

            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL,myUri)
            startActivity(myIntent)

        }
        btnSMS.setOnClickListener {
            val inputPhoneNum = edtPhoneNum.text.toString()

            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO,myUri)

            myIntent.putExtra("sms_body","자동으로 입력되는 문구")
            startActivity(myIntent)


        }

        btnNaver.setOnClickListener {

            val myUri = Uri.parse("htpps://www.naver.com/")
            val myIntent = Intent(Intent.ACTION_VIEW,myUri)
            startActivity(myIntent)

        }
    }
//  onActivityResult 무엇이든지 결과를 받아서 돌아오면 실행되는 함수
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Log.d("메인화면","결과를 받아오면 로그가 찍힘")
//    구별해야 할 요소 1)어떤 것을 가지러 다녀온것인지? - requestcode 2)확인/취소 구별 3)첨부한 데이터
    Log.d("리퀘스트 코드",requestCode.toString())
//    닉네임을 가지고 온게 맞는가? & 확인이 눌린게 맞는가? -> if 안에 if하나 더 씀

    if (requestCode == REQ_CODE_FOR_NICKNAME) {
        if (resultCode== RESULT_OK){

//            담아준 결과용 Intent ->data에 담겨 있다. -> "Nick"으로 이름 붙인 String을 꺼내 주자
            val newNickname = data?.getStringExtra("nick")
            txtNickname.text = newNickname

        }

    }
    
    }
}