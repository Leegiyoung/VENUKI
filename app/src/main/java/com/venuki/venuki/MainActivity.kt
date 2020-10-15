package com.venuki.venuki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.venuki.venuki.app.AuthFragment
import com.venuki.venuki.app.MainFragment
import com.venuki.venuki.app.SetFragment
import com.venuki.venuki.data.FragIndex
import com.venuki.venuki.dev.DMainFragment

class MainActivity : AppCompatActivity() {

    //현재 화면
    var mFragNum : Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFrag(FragIndex.FRAG_APP_MAIN)
    }

    fun setFrag(fragNum : Int) {
        mFragNum = fragNum
        Log.e("main ","set frag = " + fragNum)
        val ft = supportFragmentManager.beginTransaction()
        when(fragNum){
            FragIndex.FRAG_APP_MAIN -> {
                ft.replace(R.id.app_controller,MainFragment()).commit()
                Log.e("main ","set frag 123 = " + fragNum)
            }
            FragIndex.FRAG_APP_AUTH -> {
                ft.replace(R.id.app_controller,AuthFragment()).commit()
            }
            FragIndex.FRAG_APP_SET -> {
                ft.replace(R.id.app_controller,SetFragment()).commit()
            }
            FragIndex.FRAG_DEV_MAIN -> {
                ft.replace(R.id.app_controller,DMainFragment()).commit()
            }
        }
    }

    override fun onBackPressed() {
        when(mFragNum){
            FragIndex.FRAG_APP_AUTH, FragIndex.FRAG_APP_SET, FragIndex.FRAG_DEV_MAIN -> {
                setFrag(FragIndex.FRAG_APP_MAIN)
            }
            else -> {
                super.onBackPressed()
            }
        }
    }
}