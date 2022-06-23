package fr.soumiabrk.patientapp

import android.Manifest
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import fr.soumiabrk.patientapp.Constants.apiKey
import fr.soumiabrk.patientapp.model.User
import fr.soumiabrk.patientapp.rest.RetrofitClient
import fr.soumiabrk.patientapp.service.Authentication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Login : AppCompatActivity() {
    val TAG: String? = MainActivity::class.simpleName

    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var login: Button
    lateinit var register: Button
    var btn: TextView? = null
    var image: ImageView? = null

    private val userService: Authentication =
        RetrofitClient.client.create(Authentication::class.java)
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        requestPermissions(arrayOf(Manifest.permission.CAMERA), 102)

        sharedPreferences = getSharedPreferences("prefs", MODE_PRIVATE)


        email = findViewById(R.id.login_edittext_email)
        pass = findViewById(R.id.login_edittext_password)
        login = findViewById<Button>(R.id.login_button_seConnectez)
        register = findViewById(R.id.login_button_inscrire)

        login.setOnClickListener { login(email.text.toString(), pass.text.toString()) }

        register.setOnClickListener {
            val i = Intent(this@Login, Register::class.java)
            startActivity(i)
            finish()
        }

        if (checkLoggedIn()) {
            apiKey = sharedPreferences.getString("api_key", null)
            startActivity(Intent(this@Login, AppointmentListActivity::class.java))
            finish()
        }
    }

    private fun checkLoggedIn(): Boolean {
        return sharedPreferences.getString("api_key", null) != null
    }

    private fun setLoggedIn(token: String) {
        sharedPreferences.edit().putString("api_key", token).apply()
    }

    private fun login(username: String, password: String) {
        userService.login(mapOf("username" to username, "password" to password))
            .enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        val user = response.body()!!
                        if (user.userType != "P") {
                            Toast.makeText(
                                applicationContext,
                                "Vous n'etes pas un patient.",
                                Toast.LENGTH_SHORT
                            ).show()
                            return
                        }
                        setLoggedIn(user.token)
                        apiKey = user.token
                        startActivity(Intent(this@Login, AppointmentListActivity::class.java))
                        finish()
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(applicationContext, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            })
    }
}