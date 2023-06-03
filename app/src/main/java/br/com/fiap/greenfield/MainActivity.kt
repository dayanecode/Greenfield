package br.com.fiap.greenfield

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.greenfield.databinding.ActivityMainBinding
import br.com.fiap.greenfield.databinding.ActivityRegisterBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnSignUp.setOnClickListener {
            val i = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(i)
        }

        binding.btnLogin.setOnClickListener {
            val i = Intent(this@MainActivity, HomeActivity::class.java)
            startActivity(i)
        }
    }
}