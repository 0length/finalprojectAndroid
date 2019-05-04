package lin.kot.lat.myapplication.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import lin.kot.lat.myapplication.R
import com.google.firebase.auth.FirebaseAuth




class Register : AppCompatActivity() {
    private lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_layout)
        mAuth = FirebaseAuth.getInstance();


    }
}
