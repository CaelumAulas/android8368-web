package br.com.caelum.twittelumappweb.webservices

import android.util.Log
import br.com.caelum.twittelumappweb.modelo.Usuario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.POST

class UsuarioWebClient(retrofit: Retrofit) {

    private val service: UsuarioService by lazy {
        retrofit.create(UsuarioService::class.java)
    }

    fun cria(usuario: Usuario, sucesso: (usuario: Usuario) -> Unit, falha: (Throwable) -> Unit) {

        val chamadaPraCriar = service.cria(usuario)

        chamadaPraCriar.enqueue(object : Callback<Usuario> {
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                falha(t)
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful)
                    response.body()?.let(sucesso)
                else
                    Log.e("CONEXAO", "resposta mal sucedida ${response.code()}")
            }
        })
    }

    fun fazLogin(usuario: Usuario, sucesso: (usuario: Usuario) -> Unit, falha: (Throwable) -> Unit) {

        val chamadaPraLogar = service.loga(usuario)

        chamadaPraLogar.enqueue(object : Callback<Usuario> {
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                falha(t)
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                if (response.isSuccessful)
                response.body()?.let(sucesso)
                else
                    Log.e("CONEXAO", "resposta mal sucedida ${response.code()}")
            }
        })

    }


    private interface UsuarioService {

        @POST("/usuario")
        fun cria(@Body usuario: Usuario): Call<Usuario>

        @POST("/usuario/login")
        fun loga(@Body usuario: Usuario): Call<Usuario>
    }

}