package lin.kot.lat.myapplication.view.upload

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
//import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
//import com.aurelhubert.ahbottomnavigation.AHBottomNavigationAdapter
//import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
//import com.aurelhubert.ahbottomnavigation.AHBottomNavigationViewPager
import kotlinx.android.synthetic.main.upload_type.*
import lin.kot.lat.myapplication.R
import lin.kot.lat.myapplication.view.Register
import lin.kot.lat.myapplication.view.upload.type.FullCost
import lin.kot.lat.myapplication.view.upload.type.OtherAsk
import lin.kot.lat.myapplication.view.upload.type.PeopleWanted
import java.util.ArrayList

/**
 *
 */

class Choose : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.upload_type)
        full_cost.setOnClickListener {
            val intent = Intent(this, FullCost::class.java)
            startActivity(intent);
        }
        people_wanted.setOnClickListener {
            val intent = Intent(this, PeopleWanted::class.java)
            startActivity(intent);
        }
        otherask.setOnClickListener {
            val intent = Intent(this, OtherAsk::class.java)
            startActivity(intent);
        }

    }
}
