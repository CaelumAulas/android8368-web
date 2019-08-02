package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.view.*
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.adapter.TweetAdapter
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_lista.*

class BuscaFragment : Fragment() {
    val tweetViewModel: TweetViewModel by lazy {
        ViewModelProviders.of(this, ViewModelFactory).get(TweetViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lista, container, false)

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.menu_busca, menu)

        val itemBusca: MenuItem? = menu?.findItem(R.id.menu_item_filtra)

        val searchView = itemBusca?.actionView as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(texto: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(texto: String?): Boolean {
                val tweets = tweetViewModel.tweets().value
                texto?.let {
                    val filtrados = tweets?.filter { tweet ->
                        tweet.mensagem.contains(texto, true)
                    }
                    filtrados?.let {
                        val adapter = TweetAdapter(filtrados)
                        lista_tweets.adapter = adapter
                    }
                }
                return true
            }

        })

    }
}

