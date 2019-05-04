package lin.kot.lat.myapplication.view


import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import lin.kot.lat.myapplication.R
import lin.kot.lat.myapplication.view.upload.Choose
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.login_layout.*


class Login : AppCompatActivity() {
    private val RC_SIGN_IN = 1
    lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_layout)
        val register = findViewById(R.id.register) as Button
        val login = findViewById(R.id.btnLogin) as Button
        val email = findViewById(R.id.etEmail) as EditText
        val password = findViewById(R.id.etPassword) as EditText
        register.setOnClickListener {
            val intent = Intent(this, Register::class.java)
            startActivity(intent);
        }
        login.setOnClickListener {
            if (email.text.toString().equals("admin") && password.text.toString().equals("1")) {
                val intent = Intent(this, Choose::class.java)
                startActivity(intent);
            } else {
                Toast.makeText(this, "Wrong Email or Password", Toast.LENGTH_SHORT).show()
            }
        }
        mAuth = FirebaseAuth.getInstance()
        val gso = GoogleSignInOptions.Builder(
            GoogleSignInOptions.DEFAULT_SIGN_IN
        ).requestIdToken("816100865447-oip367fcsvcsp9q19npf8gp16uingg56.apps.googleusercontent.com").requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso)

        emailSignInButton.setOnClickListener {
            signIn()
        }
    }

        private fun firebaseAuthWithGoogle(
            acct: GoogleSignInAccount
        ) {
            Log.d("LOGIN", "firebaseAuth" + acct.id!!)

            val credential = GoogleAuthProvider.getCredential(acct.idToken, null)

            mAuth.signInWithCredential(credential).addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("LOGIN", "Sign In SUKSES")
                    val user = mAuth.currentUser
                    updateUI(user)
                } else {
                    Log.w("LOGIN", "Sign In Error", task.exception)
                    Toast.makeText(this, "Sign In Failure", Toast.LENGTH_SHORT).show()
                    updateUI(null)
                }
            }
        }

        fun updateUI(user: FirebaseUser?) {
            if (user != null) {
                Toast.makeText(
                    this, "Hello" +
                            "${user.displayName}",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)


            if (requestCode == RC_SIGN_IN) {
                val task = GoogleSignIn.getSignedInAccountFromIntent(data)
                try {
                    val account = task.getResult(
                        ApiException::class.java
                    )
                    firebaseAuthWithGoogle(account!!)
                } catch (e: ApiException) {
                    Log.w("LOGIN", "login failed", e)
                }

            }
        }

        override fun onStart() {
            super.onStart()
            val currentUser = mAuth.currentUser
            updateUI(currentUser)
        }

    private fun signIn() {
        val signInIntent = mGoogleSignInClient.signInIntent
        startActivityForResult(signInIntent, RC_SIGN_IN)
    }
}
