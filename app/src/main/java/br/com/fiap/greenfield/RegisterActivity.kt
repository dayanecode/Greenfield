package br.com.fiap.greenfield

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.greenfield.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityRegisterBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Initialize Firebase Auth
        auth = Firebase.auth

        // User Address Information
        val zip = binding.zipInput
        val street = binding.streetInput
        val district = binding.districtInput
        val city = binding.cityInput

        binding.btnSearchZip.setOnClickListener { it ->
            val call = RetrofitFactory().retrofitService().getZIP(zip.text.toString())

            call.enqueue(object: Callback<ZIP> {

                override fun onResponse(call: Call<ZIP>, response: Response<ZIP>) {

                    response.body().let {
                        Log.i("ZIP: ${zip.text} - ", "${it.toString()} - ${it?.street}, ${it?.district}, ${it?.city}")
                        Toast.makeText(this@RegisterActivity, it.toString(), Toast.LENGTH_LONG).show()

                        street.setText(it?.street.toString())
                        district.setText(it?.district.toString())
                        city.setText(it?.city.toString())
                    } ?: Toast.makeText(this@RegisterActivity, "CEP não localizado", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<ZIP>,t: Throwable) {
                    t.message?.let { it1 -> Log.e("Error", it1) }
                }
            })
        }

        binding.haveAccountTxt.setOnClickListener {
            val i = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(i)
        }

        binding.btnRegister.setOnClickListener {
            performSignUp()
        }
    }
    private fun performSignUp() {
        val name = binding.nameInput
        val email = binding.emailInput
        val confirmEmail = binding.confirmEmailInput
        val password = binding.passwordInput
        val confirmPassword = binding.confirmPasswordInput

        if (name.text.isEmpty() || email.text.isEmpty() || confirmEmail.text.isEmpty() || password.text.isEmpty() || confirmPassword.text.isEmpty()) {
            Toast.makeText(this, "Please fill all the 'User Information' fields", Toast.LENGTH_SHORT).show()
            return
        }
        else {
            val emailMatches: Boolean = email.text.equals(confirmEmail.text)
            val passwordMatches: Boolean = password.text.equals(confirmPassword.text)

            if (emailMatches && passwordMatches) {
                val inputEmail = email.text.toString()
                val inputPassword = password.text.toString()

                auth.createUserWithEmailAndPassword(inputEmail, inputPassword)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, move to the next Activity
                            val i = Intent(this, MainActivity::class.java)
                            startActivity(i)

                            Toast.makeText(
                                baseContext,"Success!",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(
                                baseContext,"Authentication failed.",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                    .addOnFailureListener {
                        Toast.makeText(this, "Error occurred ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
                    }
            }
            else {
                Toast.makeText(this, "Email or Password do not match", Toast.LENGTH_SHORT).show()
            }
        }
    }
}