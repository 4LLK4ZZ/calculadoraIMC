package com.alcidesnogueira.aulacalculadoraimc

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.round

class ResultadoActivity : AppCompatActivity() {

    private lateinit var textPeso: TextView
    private lateinit var textAltura: TextView
    private lateinit var textResultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        textPeso = findViewById(R.id.text_peso)
        textAltura = findViewById(R.id.text_altura)
        textResultado = findViewById(R.id.text_resultado)

        val bundle = intent.extras

        if (bundle != null){

            val peso = bundle.getDouble("peso")
            val altura = bundle.getDouble("altura")

            textPeso.text = "Peso informado: $peso KG!"
            textAltura.text = "Altura informada: $altura M!"

            val imc = peso / (altura * altura)
            val imcarredondado = round(imc * 10) /10

            val resultado = if (imc < 18.5){
                "Baixo! Seu IMC: $imcarredondado"
            }
            else if(imc in 18.5 .. 24.9){
                "Normal! Seu IMC: $imcarredondado"
            }
            else if(imc in 25.0 .. 29.9){
                "Sobrepeso! Seu IMC: $imcarredondado"
            }
            else{
                "Obeso! Seu IMC: $imcarredondado"
            }

            textResultado.text = resultado

        }


        }
    }