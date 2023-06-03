package br.com.fiap.greenfield

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.fiap.greenfield.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val zip = binding.zipInput
        val street = binding.streetInput
        val complement = binding.complementInput
        val district = binding.districtInput
        val city = binding.cityInput

        binding.btnSearchZip.setOnClickListener {
            val call = RetrofitFactory().retrofitService().getCEP(zip.text.toString())

            call.enqueue(object: Callback<ZIP> {

                override fun onResponse(call: Call<ZIP>, response: Response<ZIP>) {

                    response.body()?.let {
                        Log.i("ZIP", it.toString())
                        Toast.makeText(this@RegisterActivity, it.toString(), Toast.LENGTH_LONG).show()
                    } ?: Toast.makeText(this@RegisterActivity, "CEP não localizado", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<ZIP>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                }
            })
        }

        binding.haveAccountTxt.setOnClickListener {
            val i = Intent(this@RegisterActivity, MainActivity::class.java)
            startActivity(i)
        }
    }
}