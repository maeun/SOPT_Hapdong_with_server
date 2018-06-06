package com.maeun.sopt_hapdong_with_server

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.actionbar_layout.*
import kotlinx.android.synthetic.main.framelayout_main.*

class MainTab : Fragment(), View.OnClickListener {
    override fun onClick(v: View?) {
        when (v) {
            korean_btn -> {
                Toast.makeText(context, "한식", Toast.LENGTH_SHORT).show()
                //activity!! 없이 그냥 actionbar_title.setText("야식")으로 작성하면 NullPointException 발생
                //여기는 Fragment에 대한 클래스이고, actionbar는 Activity에 대한 클래스에서 접근이 가능해서 그런 듯
                activity!!.actionbar_title.setText("한식")
                replaceFragment(RestaurantListTab())
            }
            chicken_btn -> {
                Toast.makeText(context, "치킨", Toast.LENGTH_SHORT).show()
                activity!!.actionbar_title.setText("치킨")
                replaceFragment(RestaurantListTab())
            }
            pizza_btn -> {
                Toast.makeText(context, "피자", Toast.LENGTH_SHORT).show()
                activity!!.actionbar_title.setText("피자")
                replaceFragment(RestaurantListTab())
            }
            night_btn -> {
                Toast.makeText(context, "야식", Toast.LENGTH_SHORT).show()
                activity!!.actionbar_title.setText("야식")
                replaceFragment(RestaurantListTab())
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.framelayout_main, container, false)

        //인플레이터인 v 값을 바탕으로 각각에 대한 id 값이 framelayout_main.xml에서 온다는 것을 명시해야함
        //그렇지 않으면 리스너의 this에서 NullPointException 뜸 ㅅㅂ
        val korean_btn = v!!.findViewById(R.id.korean_btn) as ImageButton
        val chicken_btn = v!!.findViewById(R.id.chicken_btn) as ImageButton
        val pizza_btn = v!!.findViewById(R.id.pizza_btn) as ImageButton
        val night_btn = v!!.findViewById(R.id.night_btn) as ImageButton

        //위에서 언급했지만, 그냥 얘들만 적으면 this에서 NullPointException 뜸
        //왜냐하면 얘들이 framelayout_main.xml에서 오는지 모르니까 ㅅㅂ
        korean_btn.setOnClickListener(this)
        chicken_btn.setOnClickListener(this)
        pizza_btn.setOnClickListener(this)
        night_btn.setOnClickListener(this)
        return v
    }

    fun replaceFragment(fragment: Fragment) {
        //FragmentManager는 액티비티만 가질 수 있음, 따라서 MainTab과 같은 Fragment에서는 activity!!.supportFragmentManager 이렇게 호출해줘야 함
        val fm = activity!!.supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.main_frame, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

}