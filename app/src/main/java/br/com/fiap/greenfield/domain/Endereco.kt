package br.com.fiap.greenfield.domain

import jakarta.persistence.Embeddable
import lombok.AllArgsConstructor
import lombok.Builder
import lombok.Data
import lombok.NoArgsConstructor

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Embeddable
class Endereco {
    private val logradouro: String? = null
    private val numero: Long? = null
    private val bairro: String? = null
    private val cidade: String? = null
    private val estado: String? = null
    private val complemento: String? = null
    private val cep: Long? = null
}