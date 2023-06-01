package br.com.fiap.greenfield

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.fiap.greenfield.databinding.ActivityRegisterBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val zip: TextView = binding.zip
        val street: ConstraintLayout = binding.streetInput
        val complement: ConstraintLayout = binding.complementInput
        val district: ConstraintLayout = binding.districtInput
        val city: ConstraintLayout = binding.cityInput
        binding.searchZIPButton.setOnClickListener {
            val call = RetrofitFactory().retrofitService().getCEP(zip.text.toString())

            call.enqueue(object: Callback<ZIP> {

                override fun onResponse(call: Call<ZIP>, response: Response<ZIP>) {

                    response.body()?.let {
                        Log.i("ZIP", it.toString())
                        Toast.makeText(this@MainActivity, it.toString(), Toast.LENGTH_LONG).show()
                    } ?: Toast.makeText(this@MainActivity, "CEP não localizado", Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<ZIP>?, t: Throwable?) {
                    t?.message?.let { it1 -> Log.e("Erro", it1) }
                }

            })
        }
    }
}