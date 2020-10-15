package com.venuki.venuki.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.venuki.venuki.MainActivity
import com.venuki.venuki.R
import com.venuki.venuki.app.MainFragment
import com.venuki.venuki.data.DeviceObject
import com.venuki.venuki.data.FragIndex
import org.w3c.dom.Text

class DeviceAdapter(val deviceList:ArrayList<DeviceObject>, val mFrag : MainFragment) : RecyclerView.Adapter<DeviceAdapter.ViewHolder>(){

    override fun getItemCount(): Int {
        return deviceList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_device, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.e("Device Adapter","bind view holder")
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, deviceList[position].DeviceName.toString(), Toast.LENGTH_SHORT).show()
            (mFrag.activity as MainActivity).setFrag(FragIndex.FRAG_DEV_MAIN)
        }
        holder.bind(listener, deviceList[position])
    }

    class ViewHolder(private var v : View) : RecyclerView.ViewHolder(v){

        fun bind(listener : View.OnClickListener, item : DeviceObject){
            var txtName : TextView = v.findViewById(R.id.txt_name)
            txtName.text = item.DeviceName

            var txtSerial : TextView = v.findViewById(R.id.txt_serial)
            txtSerial.text = item.DeviceSerial

            var txtVersion : TextView = v.findViewById(R.id.txt_version)
            txtSerial.text = item.DeviceVersion

            v.setOnClickListener(listener)
            Log.e("Device Adapter","!@#!@#!@#")
        }
    }

}