package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
//import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nomesAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        val listViewNome = findViewById<ListView>(R.id.listViewNome)

        val list_view_nomes = findViewById<ListView>(R.id.listViewNome)
        list_view_nomes.adapter = nomesAdapter

        val btn_Inserir = findViewById<Button>(R.id.btnInserir)
        btn_Inserir.setOnClickListener {

            val txt_Nome = findViewById<TextView>(R.id.txtNome)
            val nome = txt_Nome.text.toString()
            if(nome.isNotEmpty()){
                nomesAdapter.add(nome)
                //txt_Nome.text.clear()
            } else{
                txt_Nome.error = "Informe o e-mail:"
            }

        }

        list_view_nomes.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id ->
            val item = nomesAdapter.getItem(position)
            nomesAdapter.remove(item)

        }
    }
}
