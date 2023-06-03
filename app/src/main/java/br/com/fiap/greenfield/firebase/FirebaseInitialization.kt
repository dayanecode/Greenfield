package br.com.fiap.greenfield.firebase

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.gson.Gson
import org.springframework.stereotype.Service
import java.io.ByteArrayInputStream
import java.io.InputStream
import javax.annotation.PostConstruct

@Service
object FirebaseInitialization {
    private val gson = Gson()
    private val jsonString = FirebaseConfig.jsonString
    private val firebaseConfig = gson.fromJson(jsonString, FirebaseConfig::class.java)

    @PostConstruct
    fun initialize() {
        val serviceAccount: InputStream = ByteArrayInputStream(firebaseConfig.private_key.toByteArray(Charsets.UTF_8))

        val options = FirebaseOptions.Builder()
            .setCredentials(GoogleCredentials.fromStream(serviceAccount))
            .setDatabaseUrl("https://${firebaseConfig.project_id}.firebaseio.com")
            .build()

        FirebaseApp.initializeApp(options)
    }
}