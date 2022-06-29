package fr.soumiabrk.patientapp

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.Button
import android.widget.TextView
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.Toast
import fr.soumiabrk.patientapp.model.User
import fr.soumiabrk.patientapp.rest.RetrofitClient
import fr.soumiabrk.patientapp.service.Authentication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {
    lateinit var email: EditText
    lateinit var pass: EditText
    lateinit var ConfirmPass: EditText
    lateinit var reg: Button
    lateinit var cancel: Button
    lateinit var Ibtn: TextView

    private val authentication: Authentication =
        RetrofitClient.client.create(Authentication::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        email = findViewById(R.id.register_edittext_email)
        pass = findViewById(R.id.register_edittext_password)
        ConfirmPass = findViewById(R.id.register_edittext_Confirmpassword)
        reg = findViewById(R.id.register_button_inscrire)
        Ibtn = findViewById(R.id.register_text_title)
        cancel = findViewById(R.id.register_button_cancel)

        reg.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val i = Intent(this@Register, AppointmentListActivity::class.java)
                startActivity(i)
                finish()
                val Mail: String
                val passw: String
                val Cpassw: String
                Mail = email.getText().toString()
                passw = pass.getText().toString()
                Cpassw = ConfirmPass.getText().toString()
                if (Mail == "");
                run { Toast.makeText(this@Register, "Email est vide", Toast.LENGTH_SHORT).show() }
                if (passw == "");
                run {
                    Toast.makeText(this@Register, "mot de passe est vide", Toast.LENGTH_SHORT)
                        .show()
                }
                if (Cpassw == "");
                run {
                    Toast.makeText(this@Register, "mot de passe est vide", Toast.LENGTH_SHORT)
                        .show()
                }
                if ((Mail == "") and (passw == "") and (Cpassw == ""));
                run {
                    Toast.makeText(this@Register, "les informations est vide", Toast.LENGTH_SHORT)
                        .show()
                }

                register()
            }
        })

        Ibtn.setOnClickListener(View.OnClickListener {
            val R = Intent(this@Register, Login::class.java)
            startActivity(R)
            finish()
        }
        )
    }

    private fun register() {
        val data = mapOf<String, Any?>(
            "username" to "usernameValueHere",
            "email" to email.text.toString(),
            "password" to pass.text.toString(),
            "first_name" to "firstNameValueHere",
            "last_name" to "lastNameValueHere",
            "account" to mapOf<String, Any?>(
                "user_type" to "P",
                "phone_num" to "phoneValueHere",
                "address" to "addressValueHere",
                "gender" to "genderValueHere",
            ),
        )

        authentication.register(data).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        Toast.makeText(
                            applicationContext,
                            "insecris avec succés",
                            Toast.LENGTH_SHORT
                        ).show()
                        startActivity(Intent(applicationContext, Login::class.java))
                        finish()
                    }
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                t.printStackTrace()
                Toast.makeText(
                    applicationContext,
                    "erreur a l'insecription",
                    Toast.LENGTH_SHORT
                ).show()
            }

        })
    }
}