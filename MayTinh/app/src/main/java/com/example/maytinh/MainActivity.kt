package com.example.maytinh

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    fun caculation( char: Char ): Boolean
    {
        return (char == '+' || char == '-' || char == 'x' || char == '/' || char == '%' || char == '.')
    }

    fun fix( text1: String ): Boolean
    {
        if ( text1.isEmpty() )
            return false

        val firstChar: Char = text1[ 0 ]

        if ( firstChar == '/' || firstChar == 'x' || firstChar == '%' || firstChar == '.' )
            return false

        var beforeChar = '0'

        text1.forEach {
            if ( caculation( it ) && caculation( beforeChar ) )
                return false
            beforeChar = it
        }

        var beforeHd = '0'

        text1.forEach {

            if ( it == '.' && beforeHd == '.' )
                return false

            if ( caculation(it) )
                beforeHd = it
        }

        return true
    }

    fun solveProblems( text2: String ): Double
    {
        var text1 = text2

        if ( caculation( text1.first() ) )
            text1 = "0" + text1

        val dauStringList: List<String> = text1.split( "+", "-", "x", "/", "%" )

        val soList = ArrayList<Double>()

        val hdList = ArrayList<Char>()

        dauStringList.forEach {

            soList.add( it.toDouble() )

        }

        if ( text1[ 0 ] != '+' && text1[ 0 ] != '-' )
            hdList.add('+')

        text1.forEach {

            if ( it == '+' || it == '-' || it == 'x' || it == '/' || it == '%' )
                hdList.add(it)

        }

        val size = soList.size

        var i = 0

        var kq = 0.0

        while ( i < size )
        {
            if ( hdList[ i ] == 'x' || hdList[ i ] == '/' || hdList[ i ] == '%' )
            {
                var j = i
                var tempSo = soList[j - 1]

                while ( j < size && !( hdList[j] == '+' || hdList[j] == '-' ) )
                {
                    if ( hdList[j] == 'x' )
                        tempSo *= soList[ j ]

                    else if ( hdList[j] == '/' )
                        tempSo /= soList[ j ]

                    else if ( hdList[j] == '%' )
                        tempSo %= soList[ j ]

                    Log.e("", hdList[ j ].toString())
                    j++

                }

                if ( hdList[ i - 1 ] == '-' )
                    kq -= tempSo - soList[ i - 1 ]

                else kq += tempSo - soList[ i - 1 ]

                i = j - 1

            }

            if (hdList[i] == '+')
                kq += soList[i]

            if (hdList[i] == '-')
                kq -= soList[i]

            i++

        }

//        kq = Math.round( kq * 100000000000.0 ) / 100000000000.0
        return kq
    }

    override fun onCreate(savedInstanceState: Bundle?)
    {
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

        var checkdaucham = false
        var checkketqua = false
        var gtridau: String = "0"
        var gtrihai: String = "0"
        var dau: String = "0"
        var text: String = "0"


//        fun TextView.OnClick1(click: (values: String) -> Unit) {
//            this.setOnTouchListener { _, motionEvent ->
//                when (motionEvent.action) {
//                    MotionEvent.ACTION_DOWN -> {
//                        click(this.text.toString())
//                        this.setBackgroundResource(R.drawable.boder6)
//                    }
//                    MotionEvent.ACTION_UP -> {
//                        this.setBackgroundResource(R.drawable.boder1)
//                    }
//                }
//                true
//            }
//        }
//
//        fun ImageView.OnClick2(click: (String) -> Unit) {
//            this.setOnTouchListener { _, motionEvent ->
//                when (motionEvent.action) {
//                    MotionEvent.ACTION_DOWN -> {
//                        click(this.imageAlpha.toString())
//                        this.setBackgroundResource(R.drawable.boder6)
//                    }
//                    MotionEvent.ACTION_UP -> {
//                        this.setBackgroundResource(R.drawable.boder1)
//                    }
//                }
//                true
//            }
//        }


        so0.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + "0")
                    so0.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    so0.setBackgroundResource(R.drawable.boder2)

                }
            }
            true
        }

        so1.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + "1")
                    so1.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    so1.setBackgroundResource(R.drawable.boder2)

                }
            }
            true
        }

        so2.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + "2")
                    so2.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    so2.setBackgroundResource(R.drawable.boder2)

                }
            }
            true
        }

        so3.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + "3")
                    so3.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    so3.setBackgroundResource(R.drawable.boder2)

                }
            }
            true
        }

        so4.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + "4")
                    so4.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    so4.setBackgroundResource(R.drawable.boder2)

                }
            }
            true
        }

        so5.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + "5")
                    so5.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    so5.setBackgroundResource(R.drawable.boder2)

                }
            }
            true
        }

        so6.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + "6")
                    so6.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    so6.setBackgroundResource(R.drawable.boder2)

                }
            }
            true
        }

        so7.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + "7")
                    so7.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    so7.setBackgroundResource(R.drawable.boder2)

                }
            }
            true
        }

        so8.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + "8")
                    so8.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    so8.setBackgroundResource(R.drawable.boder2)

                }
            }
            true
        }

        so9.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + "9")
                    so9.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    so9.setBackgroundResource(R.drawable.boder2)

                }
            }
            true
        }

        ////////////////////////////////////////

        tong.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + " + ")
                    tong.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    tong.setBackgroundResource(R.drawable.boder3)

                }
            }
            true
        }

        hieu.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + " - ")
                    hieu.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    hieu.setBackgroundResource(R.drawable.boder3)

                }
            }
            true
        }

        tich.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + " x ")
                    tich.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    tich.setBackgroundResource(R.drawable.boder3)

                }
            }
            true
        }

        thuong.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + " / ")
                    thuong.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    thuong.setBackgroundResource(R.drawable.boder3)

                }
            }
            true
        }

        percent.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + " % ")
                    percent.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    percent.setBackgroundResource(R.drawable.boder1)

                }
            }
            true
        }

        delete.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString().dropLast(1))
                    delete.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    delete.setBackgroundResource(R.drawable.boder1)

                }
            }
            true
        }

        ac.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.text = " "
                    ra.text = " "
                    ac.setBackgroundResource(R.drawable.boder2)

                }

                MotionEvent.ACTION_UP -> {
                    ac.setBackgroundResource(R.drawable.boder1)

                }
            }
            true
        }

        dauphay.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    nhap.setText(nhap.text.toString() + ".")
                    dauphay.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    dauphay.setBackgroundResource(R.drawable.boder2)

                }
            }
            true
        }

        val qua2: Unit = qua.setText( qua.text.toString() + "Ỏ, đúng thì đc cho iem kẹo nha!")
        val qua1: Unit = qua.setText( qua.text.toString() + "Mò lỗi thì cx cho iem kẹo lun ạ!" )
        ketqua.setOnTouchListener { _, motionEvent ->
            when (motionEvent.action)
            {
                MotionEvent.ACTION_DOWN -> {

                    val ans: String = nhap.text.toString()

                    if ( ans.length == 0 )
                    {
                        ra.text = " 0"
                    }
                    else if ( !fix( ans ) )
                    {
                        ra.setText( ra.text.toString() + "Huhuhu, phép tính bị lỗi mất gòi!!!" )
                    }
                    else
                    {
                        ra.text = solveProblems( ans ).toString()
                    }

                    ketqua.setBackgroundResource(R.drawable.boder6)

                }

                MotionEvent.ACTION_UP -> {
                    ketqua.setBackgroundResource(R.drawable.boder3)

                }
            }
            true
        }

    }



}







