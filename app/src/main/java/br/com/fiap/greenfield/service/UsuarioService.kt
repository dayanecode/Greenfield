package br.com.fiap.greenfield.service

import br.com.fiap.greenfield.domain.Usuario
import com.google.api.core.ApiFuture
import com.google.cloud.firestore.DocumentReference
import com.google.cloud.firestore.DocumentSnapshot
import com.google.cloud.firestore.Firestore
import com.google.cloud.firestore.WriteResult
import com.google.firebase.cloud.FirestoreClient
import org.springframework.stereotype.Service

import java.util.ArrayList
import java.util.concurrent.ExecutionException

@Service
class UsuarioService {

    private companion object {
        const val COLLECTION_NAME = "usuarios"
    }

    @Throws(ExecutionException::class, InterruptedException::class)
    fun save(usuario: Usuario): String {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val collectionApiFuture: ApiFuture<WriteResult> = dbFirestore
            .collection(COLLECTION_NAME)
            .document(usuario.nome.toString())
            .set(usuario)
        return collectionApiFuture.get().updateTime.toString()
    }

    @Throws(ExecutionException::class, InterruptedException::class)
    fun getUsuarioDetailsByName(nome: String): Usuario? {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val documentReference: DocumentReference = dbFirestore.collection(COLLECTION_NAME).document(nome)
        val future: ApiFuture<DocumentSnapshot> = documentReference.get()
        val document: DocumentSnapshot = future.get()
        var usuario: Usuario? = null
        if (document.exists()) {
            usuario = document.toObject(Usuario::class.java)
        }
        return usuario
    }

    @Throws(ExecutionException::class, InterruptedException::class)
    fun getUsuarioDetails(): List<Usuario> {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val documentReference: Iterable<DocumentReference> = dbFirestore.collection(COLLECTION_NAME).listDocuments()
        val iterator: Iterator<DocumentReference> = documentReference.iterator()
        val usuarioList: MutableList<Usuario> = ArrayList()
        var usuario: Usuario?
        while (iterator.hasNext()) {
            val documentReference1: DocumentReference = iterator.next()
            val future: ApiFuture<DocumentSnapshot> = documentReference1.get()
            val document: DocumentSnapshot = future.get()
            usuario = document.toObject(Usuario::class.java)
            if (usuario != null) {
                usuarioList.add(usuario)
            }
        }
        return usuarioList
    }

    @Throws(ExecutionException::class, InterruptedException::class)
    fun replaceUsuario(usuario: Usuario): String {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val collectionApiFuture: ApiFuture<WriteResult> = dbFirestore
            .collection(COLLECTION_NAME)
            .document(usuario.nome.toString())
            .set(usuario)
        return collectionApiFuture.get().getUpdateTime().toString()
    }

    @Throws(ExecutionException::class, InterruptedException::class)
    fun deleteUsuario(nome: String): String {
        val dbFirestore: Firestore = FirestoreClient.getFirestore()
        val collectionApiFuture: ApiFuture<WriteResult> = dbFirestore
            .collection(COLLECTION_NAME)
            .document(nome)
            .delete()
        return "O Usuário $nome foi excluído com sucesso"
    }
}