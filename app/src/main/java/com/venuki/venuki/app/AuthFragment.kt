package com.venuki.venuki.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.venuki.venuki.MainActivity
import com.venuki.venuki.R
import com.venuki.venuki.data.FragIndex

class AuthFragment : Fragment(){

    private val TAG : String = AuthFragment::class.simpleName.toString()

    private var edtSerial : EditText? = null
    private var edtPhone : EditText? = null
    private var btnConfirm : Button? = null

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.frag_app_auth, container, false)

        edtSerial = view.findViewById(R.id.edt_serial) as EditText
        edtPhone = view.findViewById(R.id.edt_phone) as EditText
        btnConfirm = view.findViewById(R.id.btn_confirm) as Button

        btnConfirm!!.setOnClickListener(mClickListener)

        return view
    }

    //OnClick
    val mClickListener = object : View.OnClickListener{
        override fun onClick(v: View?) {
            when(v?.id){
                R.id.btn_confirm -> {
                    var serial = edtSerial!!.text.toString()
                    var phone = edtPhone!!.text.toString()
                    Log.e(TAG, "Popup 띄우고 메인으로 이동 = ${serial} / ${phone}")
                }
            }
        }
    }
}