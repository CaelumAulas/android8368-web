package br.com.caelum.twittelumappweb.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import br.com.caelum.twittelumappweb.R
import br.com.caelum.twittelumappweb.fragment.BuscaFragment
import br.com.caelum.twittelumappweb.fragment.ListaFragment
import br.com.caelum.twittelumappweb.fragment.MapaFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationListener()

        bottom_navigation.selectedItemId = R.id.menu_item_lista

        main_fab.setOnClickListener {

            val intent = Intent(this, TweetActivity::class.java)
            startActivity(intent)

        }

    }

    private fun bottomNavigationListener() {
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_item_lista -> {
                    exibeNaTela(ListaFragment())
                    true
                }
                R.id.menu_item_busca -> {
                    exibeNaTela(BuscaFragment())
                    true
                }
                R.id.menu_item_mapa -> {
                    exibeNaTela(MapaFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun exibeNaTela(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.espaco_vazio, fragment)
        transaction.commit()
    }
}
