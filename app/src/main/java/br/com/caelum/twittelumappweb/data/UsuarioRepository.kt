package br.com.caelum.twittelumappweb.data

import android.arch.lifecycle.MutableLiveData
import android.util.Log
import br.com.caelum.twittelumappweb.modelo.Usuario
import br.com.caelum.twittelumappweb.webservices.UsuarioWebClient

class UsuarioRepository(private val client: UsuarioWebClient) {

    val usuarioDaSessao: MutableLiveData<Usuario> = MutableLiveData()
    val estaLogado: MutableLiveData<Boolean> = MutableLiveData()
    val erro: MutableLiveData<Throwable> = MutableLiveData()

    fun loga(usuario: Usuario) = client.fazLogin(usuario, sucesso, falha)

    fun cria(usuario: Usuario) = client.cria(usuario, sucesso, falha)

    private val sucesso = { usuario: Usuario ->

        estaLogado.value = true
        usuarioDaSessao.value = usuario
    }

    private val falha = { excecao: Throwable ->
        estaLogado.value = false
        erro.value = excecao
    }
}

