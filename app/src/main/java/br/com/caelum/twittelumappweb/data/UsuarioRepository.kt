package br.com.caelum.twittelumappweb.data

import android.util.Log
import br.com.caelum.twittelumappweb.modelo.Usuario

class UsuarioRepository {
    fun criarConta(usuario: Usuario) {
        Log.i("criaConta", "$usuario")
    }

    fun login(usuario: Usuario) {
        Log.i("loginConta", "$usuario")
    }

}
