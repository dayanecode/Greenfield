package br.com.fiap.greenfield.controller

import br.com.fiap.greenfield.domain.Usuario
import br.com.fiap.greenfield.service.UsuarioService
import java.util.concurrent.ExecutionException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuario")
class UsuarioController {

    private lateinit var usuarioService: UsuarioService

    @PostMapping("/cadastrar")
    @Throws(ExecutionException::class, InterruptedException::class)
    fun save(@RequestBody usuario: Usuario): String {
        return usuarioService.save(usuario)
    }

    @GetMapping("/{nome}")
    @Throws(ExecutionException::class, InterruptedException::class)
    fun list(@PathVariable nome: String): Usuario? {
        return usuarioService.getUsuarioDetailsByName(nome)
    }

    @GetMapping("/listar")
    @Throws(ExecutionException::class, InterruptedException::class)
    fun listAll(): List<Usuario> {
        return usuarioService.getUsuarioDetails()
    }

    @PutMapping("/atualizar")
    @Throws(ExecutionException::class, InterruptedException::class)
    fun replace(@RequestBody usuario: Usuario): String {
        return usuarioService.replaceUsuario(usuario)
    }

    @DeleteMapping("/excluir/{nome}")
    @Throws(ExecutionException::class, InterruptedException::class)
    fun delete(@PathVariable nome: String): String {
        return usuarioService.deleteUsuario(nome)
    }
}