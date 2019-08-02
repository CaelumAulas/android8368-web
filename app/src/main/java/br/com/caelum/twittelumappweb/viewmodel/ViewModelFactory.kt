package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import br.com.caelum.twittelumappweb.webservices.InicializadorDeRetrofit
import br.com.caelum.twittelumappweb.webservices.UsuarioWebClient

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private fun getTweetRepository() = TweetRepository()
    private fun getUsuarioRepository(): UsuarioRepository {

        val retrofit = InicializadorDeRetrofit.retrofit
        val usuarioWebClient = UsuarioWebClient(retrofit)

        return UsuarioRepository(usuarioWebClient)
    }


    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        TweetViewModel::class.java -> {
            TweetViewModel(getTweetRepository()) as T
        }
        else -> {
            UsuarioViewModel(getUsuarioRepository()) as T
        }
    }
}