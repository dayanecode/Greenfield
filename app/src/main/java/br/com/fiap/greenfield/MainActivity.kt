package br.com.fiap.greenfield

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val seachZIP: Button = findViewById(R.id.seachZIP_button)
        val zip: EditText = findViewById(R.id.zip_input)
        val street: EditText = findViewById(R.id.street_input)
        val complement: EditText = findViewById(R.id.complement_input)
        val district: EditText = findViewById(R.id.district_input)
        val city: EditText = findViewById(R.id.city_input)

        seachZIP.setOnClickListener {
            val call = RetrofitFactory().retrofitService().getCEP(zip.text.toString())

            call.enqueue(object: retrofit2.Callback<ZIP> {

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