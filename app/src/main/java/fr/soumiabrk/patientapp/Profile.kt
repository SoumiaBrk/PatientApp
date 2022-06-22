package fr.soumiabrk.patientapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import fr.soumiabrk.patientapp.model.User
import fr.soumiabrk.patientapp.rest.RetrofitClient
import fr.soumiabrk.patientapp.service.Authentication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Profile : AppCompatActivity() {
    private lateinit var SeDeconnecter: TextView
    private lateinit var nom: TextView
    private lateinit var prenom: TextView
    private lateinit var email: TextView
    private lateinit var dateNaissance: TextView
    private lateinit var sexe: TextView
    private lateinit var changePass: TextView
    private lateinit var arrow: ImageView
    private lateinit var profileQrCode: ImageView
    private lateinit var editeProfile: TextView

    private val userService: Authentication =
        RetrofitClient.client.create(Authentication::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        changePass = findViewById(R.id.profil_chanagepassword)
        arrow = findViewById<View>(R.id.profil_image_arrow) as ImageView
        profileQrCode = findViewById<View>(R.id.profileQrCode) as ImageView
        nom = findViewById<View>(R.id.nom) as TextView
        SeDeconnecter = findViewById<View>(R.id.tollbar_text_SeDeconnecter) as TextView
        prenom = findViewById<View>(R.id.prenom) as TextView
        email = findViewById<View>(R.id.email) as TextView
        dateNaissance = findViewById<View>(R.id.dateNaissance) as TextView
        sexe = findViewById<View>(R.id.sexe) as TextView
        editeProfile = findViewById<View>(R.id.profil_text_editerprofl) as TextView


        // Obtenez les données transférées de l'activité source.
        val intent = intent
        nom.text = intent.getStringExtra("nom")
        prenom!!.text = intent.getStringExtra("prenom")
        email!!.text = intent.getStringExtra("email")
        dateNaissance!!.text = intent.getStringExtra("date_naissance")
        sexe!!.text = intent.getStringExtra("sexe")
        changePass.setOnClickListener(View.OnClickListener {
            val i = Intent(this@Profile, ForgotPassword::class.java)
            startActivity(i)
            finish()
        })
        SeDeconnecter!!.setOnClickListener {
            val i = Intent(this@Profile, Login::class.java)
            startActivity(i)
            finish()
        }
        arrow!!.setOnClickListener {
            val i = Intent(this@Profile, AppointmentListActivity::class.java)
            startActivity(i)
            finish()
        }
        editeProfile!!.setOnClickListener {
            val i = Intent(this@Profile, EditProfile::class.java)
            startActivity(i)
            finish()
        }

        getUser()
    }

    private fun getUser() {
        userService.getUser()
            .enqueue(object : Callback<User> {
                override fun onResponse(call: Call<User>, response: Response<User>) {
                    if (response.isSuccessful) {
                        val user = response.body()!!
                        setUpViews(user)
                    }
                }

                override fun onFailure(call: Call<User>, t: Throwable) {
                    Toast.makeText(applicationContext, "Login Failed", Toast.LENGTH_SHORT).show()
                }
            })
    }

    private fun setUpViews(user: User) {
        profileQrCode.setImageBitmap(getQrCodeBitmap(user.id.toString()))
    }

}