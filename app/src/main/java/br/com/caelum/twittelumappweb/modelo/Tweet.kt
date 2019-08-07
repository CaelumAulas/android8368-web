package br.com.caelum.twittelumappweb.modelo

data class Tweet(val mensagem: String,
                 val foto: String?,
                 val dono: Usuario,
                 val latitude: Double = 0.0,
                 val longitude: Double = 0.0) {

    override fun toString(): String {
        return mensagem
    }

}