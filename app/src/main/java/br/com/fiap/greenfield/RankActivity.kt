package br.com.fiap.greenfield

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.fiap.greenfield.databinding.ActivityRankingBinding

class RankActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRankingBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRankingBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.homeMenu.setOnClickListener {
            val i = Intent(this@RankActivity, HomeActivity::class.java)
            startActivity(i)
        }
    }
}