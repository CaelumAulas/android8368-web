package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioViewModel(private val repository: UsuarioRepository) : ViewModel() {
    fun loga(usuario: Usuario) = repository.loga(usuario)

    fun cria(usuario: Usuario) = repository.cria(usuario)

    fun usuarioEstaLogado() = repository.estaLogado

    fun usuarioDaSessao() = repository.usuarioDaSessao

    fun falha() = repository.erro


}

