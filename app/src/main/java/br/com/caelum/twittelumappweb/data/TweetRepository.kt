package br.com.caelum.twittelumappweb.data

import br.com.caelum.twittelumappweb.modelo.Tweet

class TweetRepository {

    fun salva(tweet: Tweet) {}

    fun lista() = listOf(
            Tweet("tweet 1", null),
            Tweet("tweet 2", null),
            Tweet("tweet 3", null),
            Tweet("tweet 4", null),
            Tweet("tweet 5", null)
    )

}