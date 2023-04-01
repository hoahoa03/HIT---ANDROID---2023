package com.example.maytinh

import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nhap: TextView = findViewById(R.id.nhap)
        val qua: TextView = findViewById(R.id.qua)
        val ra: TextView = findViewById(R.id.ra)

        val ac: TextView = findViewById(R.id.ac)
        val percent: TextView = findViewById(R.id.percent)
        val delete: ImageView = findViewById(R.id.delete)
        val tich: TextView = findViewById(R.id.tich)
        val thuong: TextView = findViewById(R.id.thuong)
        val tong: TextView = findViewById(R.id.tong)
        val hieu: TextView = findViewById(R.id.hieu)
        val ketqua: TextView = findViewById(R.id.ketqua)
        val dauphay: TextView = findViewById(R.id.dauphay)

        val so1: TextView = findViewById(R.id.so1)
        val so2: TextView = findViewById(R.id.so2)
        val so3: TextView = findViewById(R.id.so3)
        val so4: TextView = findViewById(R.id.so4)
        val so5: TextView = findViewById(R.id.so5)
        val so6: TextView = findViewById(R.id.so6)
        val so7: TextView = findViewById(R.id.so7)
        val so8: TextView = findViewById(R.id.so8)
        val so9: TextView = findViewById(R.id.so9)
        val so0: TextView = findViewById(R.id.so0)

        var gtridau: String = "0"
        var gtrihai: String = "0"
        var dau: String = "0"
        var text: String = "0"


        fun TextView.OnClick(click: (values: String) -> Unit) {
            this.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        click(this.text.toString())
                        this.setBackgroundResource(R.drawable.boder6)
                    }
                    MotionEvent.ACTION_UP -> {
                        this.setBackgroundResource(R.drawable.boder7)
                    }
                }
                true
            }
        }

        fun ImageView.OnClick(click: (String) -> Unit) {
            this.setOnTouchListener { _, motionEvent ->
                when (motionEvent.action) {
                    MotionEvent.ACTION_DOWN -> {
                        click(this.imageAlpha.toString())
                        this.setBackgroundResource(R.drawable.boder6)
                    }
                    MotionEvent.ACTION_UP -> {
                        this.setBackgroundResource(R.drawable.boder7)
                    }
                }
                true
            }
        }


        fun dau() {
            tong.OnClick { values -> " + " }

            hieu.OnClick { values -> " - " }

            tich.OnClick { values -> " * " }

            thuong.OnClick { values -> " / " }

            percent.OnClick { values -> " % " }

            dauphay.OnClick { values -> " . " }


        }


        fun so() {
            so0.OnClick { values -> "0" }

            so1.OnClick { values -> "1" }

            so2.OnClick { values -> "2" }

            so3.OnClick { values -> "3" }

            so4.OnClick { values -> "4" }

            so5.OnClick { values -> "5" }

            so6.OnClick { values -> "6" }

            so7.OnClick { values -> "7" }

            so8.OnClick { values -> "8" }

            so9.OnClick { values -> "9" }
        }

        ketqua.OnClick {
            gtrihai = ra.text.toString()

            if( dau.length == 0 )

            else if( gtrihai.toDouble() == 0.0 && dau[dau.length-1].toString() == "/" )
                ra.text = "Phép tính bị lỗi, mẫu số không bằng 0!"

            else
            {
                ra.text = giai( gtridau.toDouble() , gtrihai.toDouble() , dau ).toString()
                ketqua.setBackgroundResource(R.drawable.boder6)
            }
        }

        delete.OnClick {
            nhap.setText(nhap.text.toString().dropLast(1))
        }

        ac.OnClick {
            nhap.text = ""
            nhap.text = ""
            ac.setBackgroundResource(R.drawable.boder5)
        }

    }


    fun cal(dau : String , sonhapvaoT1 : Double , sonhapvaoT2 : Double): Double
    {
        if( dau == "+" )
            return sonhapvaoT1 + sonhapvaoT2

        else if( dau == "-" )
            return sonhapvaoT1 - sonhapvaoT2

        else if( dau == "*" )
            return sonhapvaoT1 * sonhapvaoT2

        else if( dau == "/" )
            return sonhapvaoT1 / sonhapvaoT2

        else if( dau == "%" )
            return sonhapvaoT1 % sonhapvaoT2

        return 0.0
    }


    fun giai(gtridau : Double , gtrihai : Double , dau : String) : Double
    {
        return cal( dau[dau.length-1].toString() , gtridau , gtrihai )
        return 0.0
    }


}






