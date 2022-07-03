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
    var gender = ""
    var selectedDate = ""

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
        LastName = findViewById(R.id.LastName)
        phone = findViewById(R.id.phone)
        address = findViewById(R.id.address)
        mydate = findViewById(R.id.myDate)





        radioGender = findViewById(R.id.radioGender)
        radioGender.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioMale -> gender = "M"
                R.id.radioFemale -> gender = "F"
            }
        }




        reg.setOnClickListener { register() }

        Ibtn.setOnClickListener {
            val R = Intent(this@Register, Login::class.java)
            startActivity(R)
            finish()
        }
        val datePicker = findViewById<DatePicker>(R.id.datePicker)
        val today = Calendar.getInstance()
        datePicker.init(
            today.get(Calendar.YEAR), today.get(Calendar.MONTH),
            today.get(Calendar.DAY_OF_MONTH)

        ) { view, year, month, day ->
            val mMonth = month + 1
            selectedDate = "$year-$mMonth-$day"
            val msg = "You Selected: $day/$mMonth/$year"
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
            "account" to mapOf(
                "user_type" to "P",
                "birthday" to selectedDate,
                "phone_num" to phone.text.toString(),
                "address" to address.text.toString(),
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