package br.com.fiap.greenfield.domain

import androidx.room.Embedded
import androidx.room.Entity
import com.fasterxml.jackson.annotation.JsonFormat
import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor
import java.util.*


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int? = null
    @JvmField
    var nome: String? = null
    var sobrenome: String? = null
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    var dataNasc: Date? = null
    @Embedded
    var endereco: Endereco? = null
    var email: String? = null
    var senha: String? = null

}