package com.example.lab2practica

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.appcompat.widget.SearchView


class MainActivity : AppCompatActivity(), ContadorListener {


    var fragment1:Fragment1? = null
    var fragment2:Fragment2? = null
    var fragment3:Fragment3? = null



    var cont = 0;


/*
    val sv = item?.actionView as android.widget.SearchView?
    sv?.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
        android.widget.SearchView.OnQueryTextListener{

        override fun onQueryTextChange(newText: String?): Boolean {
            val activity = sv.context as MainActivity
            Toast.makeText(activity,newText,Toast.LENGTH_SHORT).show()

            return true
        }

        override fun onQueryTextSubmit(query: String?): Boolean {
            val activity = sv.context as MainActivity
            Toast.makeText(activity,"buscar :"+query, Toast.LENGTH_SHORT).show()
            return true
        }

    })
 */









    override fun incrementar() {

        cont++
    }

    override fun getValorActual(): Int {


        return cont
    }

    override fun resetear() {

        cont = 0
    }

    override fun reducir() {

        if(cont>0)  cont--
        else    cont = 0

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val infla = menuInflater
        infla.inflate(R.menu.menutoolbar,menu)

        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.itemAjustes)
            Toast.makeText(this, "Pulsaste Ajustes", Toast.LENGTH_SHORT).show()
        if(item.itemId == R.id.itemGuardar)
            Toast.makeText(this, "Pulsaste Guardar", Toast.LENGTH_SHORT).show()
        if(item.itemId == R.id.buscarmenuItem)
            Toast.makeText(this, "Pulsaste Buscar", Toast.LENGTH_SHORT).show()

        return super.onOptionsItemSelected(item)
    }






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)


        val toolbar = findViewById<Toolbar>(R.id.mytoolbarbasico)
        setSupportActionBar(toolbar)



        fragment1 = Fragment1()
        fragment2 = Fragment2()
        fragment3 = Fragment3()


        fragment1?.addListener1(this)
        fragment2?.addListener2(this)
        fragment3?.addListener3(this)






        val btn1 = findViewById<Button>(R.id.btnMostrarF1)
        val btn2 = findViewById<Button>(R.id.btnMostrarF2)
        val btn3 = findViewById<Button>(R.id.btnMostrarF3)






        btn1.setOnClickListener {
            val trn = getSupportFragmentManager().beginTransaction()
            trn.replace(R.id.frameContenedor,fragment1!!)
            trn.commit()

        }

        btn2.setOnClickListener {
            val trn = getSupportFragmentManager().beginTransaction()
            trn.replace(R.id.frameContenedor,fragment2!!)
            trn.commit()

        }


        btn3.setOnClickListener {
            val trn = getSupportFragmentManager().beginTransaction()
            trn.replace(R.id.frameContenedor,fragment3!!)
            trn.commit()

        }

    }



}