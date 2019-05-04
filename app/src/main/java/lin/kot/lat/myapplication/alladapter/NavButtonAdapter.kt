//package lin.kot.lat.myapplication.alladapter
//
//import android.support.v4.app.Fragment
//import android.support.v4.app.FragmentManager
//import android.view.ViewGroup
//import lin.kot.lat.myapplication.view.upload.type.FullCost
//import lin.kot.lat.myapplication.view.upload.type.OtherAsk
//import lin.kot.lat.myapplication.view.upload.type.PeopleWanted
//
//class NavButtonAdapter : Fragment() {
//    internal val RG = 3
//    private var currentFreagment: Fragment? = null
//
//    fun NavButtonAdapter(fm: FragmentManager): ??? {
//        super(fm)
//    }
//
//    override fun getItem(i: Int): Fragment? {
//        when (i) {
//            0 -> {
//                currentFreagment = FullCost.newInstance(0)
//            }
//            1 -> {
//                currentFreagment = OtherAsk.newInstance(1)
//            }
//            2 -> {
//                currentFreagment = PeopleWanted.newInstance(2)
//            }
//            else -> {
//            }
//        }
//        return currentFreagment
//    }
//
//    override fun getCount(): Int {
//        return RG
//    }
//
//    override fun setPrimaryItem(container: ViewGroup, position: Int, `object`: Any) {
//        super.setPrimaryItem(container, position, `object`)
//    }
//
//    fun getCurrentFragment(): Fragment? {
//        return currentFreagment
//    }
//}