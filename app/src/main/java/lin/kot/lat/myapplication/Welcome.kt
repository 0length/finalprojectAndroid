package lin.kot.lat.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import lin.kot.lat.myapplication.view.Login
import lin.kot.lat.myapplication.R


class Welcome : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.welcome_layout)

        val welcomeThread = object : Thread() {

            override fun run() {
                try {
                    super.run()
                    Thread.sleep(10000)  //Delay of 10 seconds
                } catch (e: Exception) {

                } finally {

                    val i = Intent(
                        this@Welcome,
                        Login::class.java
                    )
                    startActivity(i)
                    finish()
                }
            }
        }
        welcomeThread.start()
    }
}