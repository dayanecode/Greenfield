package br.com.fiap.greenfield.firebase

import com.google.gson.Gson

data class FirebaseConfig (
    val type: String,
    val project_id: String,
    val private_key_id: String,
    val private_key: String,
    val client_email: String,
    val client_id: String,
    val auth_uri: String,
    val token_uri: String,
    val auth_provider_x509_cert_url: String,
    val client_x509_cert_url: String,
    val universe_domain: String,
)
{
    companion object {
        val gson: Gson = Gson()
        val jsonString = """
        {
            "type": "service_account",
            "project_id": "greenfieldesg-backend",
            "private_key_id": "efb291e70263abaff6f61d59246027676aa72fa7",
            "private_key": "-----BEGIN PRIVATE KEY-----\nMIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCejZyicOKbfEad\nWhYD5XxHLnKngj8YVXmk5damYlNnN+hh/mTxqakV9XjUWkOn7fsFfM6c7Fgr+iFU\nqKuYca+fkX3EtJyY+MzPWG85t+tuTnXHrevsjCIOQ8DoFvXPgMs5rZSkax45eiso\nPmwB8e5VbJDXUvhMHhx/JWCi4rT7QjIL3jD2tbxW1dNzwSk99sFKz2Psfduq0FTF\nHcJ4AR9BjcnTnnIGWcPTfLxyvyi/12Pgp8qO+KBp9VHU/Bjy2pR9eT3CTTPqUFsh\nzAeiUcXBthLDjoElz7tbg3kEpGyKL6dlqcU3vRtb9r3aHRXrpnto1EU2dlCNtR+b\nSeDbhLI1AgMBAAECggEABsndaP8YVLvvchFHXAdZWNreQdnLxcjzGmJU3G7dT1AP\nfRKdU9OFz9DgyYbL2sbPtp5vYjykUc2126AVKMPFVzmtftyUz9/nNQF+UaRUSjbF\nyDTkIw6k7qNsAQPqpmXHTcLm2FtVwfQ/IMv7Z+Hp6HJriSyeQPQRGEiLaK34PcG4\njLhwW4BN1QAEFk96p7l5AfU9ZWklyrhXgfwf/7Bnv4VOt3ZOoLUM9ApMuzanHNCb\nxHbOt7rq/sY8HEAHLwErI35KTNeVdt/04zjiA815eJIzm3OwFmISVEV2HhiFjfgs\nBYy5sjK0X8IlOXqXU6dionf9yfsnbapz9uB2s8pByQKBgQDO3ZyHfrUUbKyOYDKV\nv9xx8cyL9t4KF0823PBsJEErMggntMJa6dItOg4GtUdZ5Aw4DQwSiXzppqhZK7E/\n8tku7+iWYxTSG0gVqY7M7UUaJB3L38o5KZLF01uehcRj8H4k7nSXcDwK8XbnNnhR\ns8uDMH9ABwYnl3Uyt7jb4x76vwKBgQDENmCVOHGpzYckBS6Cx0KRc8+hKQe28r1P\nU1F3jY4CTLv8jbSrXSbphZye+euk8J7HX1MsBVWDJy4NyHtAuqLdvOA6VhuGQpYR\nuWaJSZ+fNCjGGaiWnyp3DTFOZunrLbLJpyDPuZmlFWw5kfYSqAHO/vsKerXqe9Nk\nSG5jpacUCwKBgQCRmGxI+ScdvvccJhy0RRs0n0il4hSY6Zr5NDuLAWFUs5wFxjVc\no2EoL8obco9LdzQaZyRuD5J5KLEoQZY5OgUeAgCjiAzpbAYqKPK2zPBr26uVCGde\nICKLVZ0QT3nQFT3TZHlu9LFtylEznqTEbFT6erG1MLxmNTVpguF68bmmJQKBgQCn\ndv3B/lXMpnVkQePrjKP9PsoEc994vv7ieGs8zZ1ZyyJbMJr182BlyTre2NHNie0K\nnwp+tOLCOKtu6iCAI4skE7ORNrLxSV2KLSIdpK/PEpaGVZn1TE3TJHhjwSR/LBa/\nU5yGjpNbOciP7ksGq0w33ppm3ErtodfPbJ6C//x09wKBgQCCtQLSskczbD2XLV9S\n7NXRWhK8YG1ZScKD6ShNH8D6poMyrB3aR4pE5349czVMvpdrd1AWkX/NVWp3bYcc\nqMVFHYEErecv5TutnjraoqP77s3UXbG79OCbHPeP3EJP/OPuFTN1/F4DKGjWm4qT\nbysuSR3NjzW9fdMorc3nYy3t9Q==\n-----END PRIVATE KEY-----\n,
            "client_email": "firebase-adminsdk-9ij20@greenfieldesg-backend.iam.gserviceaccount.com",
            "client_id":"117215022216735639023",
            "auth_uri":"https://accounts.google.com/o/oauth2/auth",
            "token_uri":"https://oauth2.googleapis.com/token",
            "auth_provider_x509_cert_url": "https://www.googleapis.com/oauth2/v1/certs",
            "client_x509_cert_url": "https://www.googleapis.com/robot/v1/metadata/x509/firebase-adminsdk-9ij20%40greenfieldesg-backend.iam.gserviceaccount.com",
            "universe_domain": "googleapis.com"
        }"""

        val firebaseConfig: FirebaseConfig? = gson.fromJson(jsonString, FirebaseConfig::class.java)
    }
}