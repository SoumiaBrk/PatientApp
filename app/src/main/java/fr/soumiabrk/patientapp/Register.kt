package fr.soumiabrk.patientapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.content.Intent
import android.widget.*
import fr.soumiabrk.patientapp.model.User
import fr.soumiabrk.patientapp.rest.RetrofitClient
import fr.soumiabrk.patientapp.service.Authentication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class Register : AppCompatActivity() {
    lateinit var username: EditText
     var gender = " "

    lateinit var firstName: EditText
    lateinit var LastName: EditText
    lateinit var phone: EditText
    lateinit var address: EditText
    lateinit var radioGender: RadioGroup
    private var mydate: TextView? = null

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

        email = findViewById(R.id.email)
        pass = findViewById(R.id.register_edittext_password)
        ConfirmPass = findViewById(R.id.register_edittext_Confirmpassword)
        reg = findViewById(R.id.register_button_inscrire)
        Ibtn = findViewById(R.id.register_text_title)
        cancel = findViewById(R.id.register_button_cancel)
        username = findViewById(R.id.username)
        firstName = findViewById(R.id.firstName)
        LastName =  findViewById(R.id.LastName)
        phone = findViewById(R.id.phone)
        address = findViewById(R.id.address)
        mydate = findViewById(R.id.myDate)





        radioGender = findViewById(R.id.radioGender)
        radioGender.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioMale -> {gender == "M"
                }
                R.id.radioFemale -> {gender == "F" }
            }
        }




        reg.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val Mail: String
                val passw: String
                val Cpassw: String
                val username: String
                val firstName: String
                val LastName: String
                val phone: String
                val address: String

                Mail = email.getText().toString()
                passw = pass.getText().toString()
                Cpassw = ConfirmPass.getText().toString()
                username = this@Register.username.getText().toString()
                firstName = this@Register.firstName.getText().toString()
                LastName = this@Register.LastName.getText().toString()
                phone = this@Register.phone.getText().toString()
                address = this@Register.address.getText().toString()

                if (username == "");
                run { Toast.makeText(this@Register, "Nom utilisateur est vide", Toast.LENGTH_SHORT).show() }
                if (firstName == "");
                run { Toast.makeText(this@Register, "Prénom est vide", Toast.LENGTH_SHORT).show() }
                if (LastName == "");
                run { Toast.makeText(this@Register, "Nom est vide", Toast.LENGTH_SHORT).show() }
                if (phone == "");
                run { Toast.makeText(this@Register, "Numéro de téléphone est vide", Toast.LENGTH_SHORT).show() }
                if (address == "");
                run { Toast.makeText(this@Register, "Adresse est vide", Toast.LENGTH_SHORT).show() }
                if (Mail == "");
                run { Toast.makeText(this@Register, "Email est vide", Toast.LENGTH_SHORT).show() }
                if (passw == "");
                run { Toast.makeText(this@Register, "mot de passe est vide", Toast.LENGTH_SHORT).show() }
                if (Cpassw == "");
                run { Toast.makeText(this@Register, "mot de passe est vide", Toast.LENGTH_SHORT).show() }
                if ((Mail == "") and (passw == "") and (Cpassw == ""));
                run { Toast.makeText(this@Register, "les informations sont vide", Toast.LENGTH_SHORT).show() }

                register()
            }
        })

        Ibtn.setOnClickListener(View.OnClickListener {
            val R = Intent(this@Register, Login::class.java)
            startActivity(R)
            finish()
        }
        )
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val today = Calendar.getInstance()
        datePicker.init(today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val month = month + 1
            val msg = "You Selected: $day/$month/$year"
            mydate!!.text = msg
            Toast.makeText(this@Register, msg, Toast.LENGTH_SHORT).show()
        }

    }

    private fun register() {
        val data = mapOf<String, Any?>(
            "username" to username.text.toString(),
            "email" to email.text.toString(),
            "password" to pass.text.toString(),
            "first_name" to firstName.text.toString(),
            "last_name" to LastName.text.toString(),
            "account" to mapOf<String, Any?>(
                "user_type" to "P",
                "birthday" to mydate,
                "phone_num" to phone.text.toString(),
                "address" to  address.text.toString(),
                "gender" to gender,
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