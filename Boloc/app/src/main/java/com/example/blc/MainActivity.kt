package com.example.blc

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val arr = arrayOf(
        "Tất cả",
        "Giỏi",
        "Trung bình",
        "Yếu kém"
    )
    val arr2 = arrayOf(
        "khác",
        "Đà Nẵng",
        "Thái Nguyên",
        "Quãng Nam"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            arr
        )

        val adapter2 = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            arr2
        )
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
        adapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
        trinhlanhdao.setAdapter(adapter)
        noigui.setAdapter(adapter2)
        btntimkiem.setOnClickListener {
            click()
        }


    }

    fun  click()
    {

        var msg : String=""
        msg+="Từ khoá: "+ txttukhoa.text+"\n"
        msg+="Ngày cập nhật : Từ ngày "+ capnhatdi.text+"\t Ngày đến "+ capnhatdi.text+"\n"
        msg+="Ngày công văn : Từ ngày "+ congvandi.text+"\t Ngày đến "+ congvanden.text+"\n"
        msg+="Trình lãnh đạo: "+ arr[trinhlanhdao.selectedItemPosition].toString()+"\n"
        if(noigui.selectedItemPosition!=0)
            msg+="Nơi gửi: "+ arr2[noigui.selectedItemPosition].toString()
        else
            msg+="Nơi gửi: "+ noiguikhac.text
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Bộ lộc")
        builder.setMessage(msg)
        builder.create().show()

    }

}