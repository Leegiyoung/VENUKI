package com.venuki.venuki.app

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.venuki.venuki.MainActivity
import com.venuki.venuki.R
import com.venuki.venuki.adapter.DeviceAdapter
import com.venuki.venuki.data.DeviceObject
import com.venuki.venuki.data.FragIndex

class MainFragment : Fragment(){

    private val TAG : String = MainFragment::class.simpleName.toString()

    private var btnSet : Button? = null
    private var btnAuth : Button? = null

    //리스트 (리사이클)
    var rcvDevice : RecyclerView? = null

    //Sample Data
    val deviceList = arrayListOf<DeviceObject>(
            DeviceObject("Diamond Black","VOD123KKL","Ver 1.2","VNK001","01033005729"),
            DeviceObject("MAX","VJNK12OL","Ver 3.0","VNK002","01033005729"),
            DeviceObject("Diamond Black","BNM12K09","Ver 1.1","VNK003","01033005729")
    )

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.frag_app_main, container, false)

        btnSet = view.findViewById(R.id.btn_set) as Button
        btnAuth = view.findViewById(R.id.btn_auth) as Button

        btnSet!!.setOnClickListener(mClickListener)
        btnAuth!!.setOnClickListener(mClickListener)

        rcvDevice = view.findViewById(R.id.rcv_device)
        rcvDevice!!.adapter = DeviceAdapter(deviceList, this)

        return view
    }

    fun selectDevice(){

    }

    //OnClick
    val mClickListener = object : View.OnClickListener{
        override fun onClick(v: View?) {
            when(v?.id){
                R.id.btn_set -> {
                    Log.e(TAG, "setting button")
                    (activity as MainActivity).setFrag(FragIndex.FRAG_APP_SET)
                }
                R.id.btn_auth -> {
                    Log.e(TAG, "regist button")
                    (activity as MainActivity).setFrag(FragIndex.FRAG_APP_AUTH)
                }
            }
        }
    }



}