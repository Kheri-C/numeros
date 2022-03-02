package edu.itesm.numeros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import edu.itesm.numeros.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    val numeros = mutableListOf<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI(){
        binding.agregar.setOnClickListener {
            interfaceAddNumber()
        }
        binding.promedio.setOnClickListener {
            interfaceAverage()
        }
        binding.mayor.setOnClickListener {
            interfaceHighestNumber()
        }
        binding.pares.setOnClickListener {
            interfaceEvenNumbers()
        }
    }

    private fun interfaceAddNumber(){
        val newNumberValue = binding.editTextNumberSigned.text.toString().toIntOrNull()
        //val newNumberValue = newNumber.toIntOrNull()
        if(newNumberValue == null){
            Toast.makeText(this,"Número inválido, prueba nuevamente",Toast.LENGTH_SHORT).show()
            return
        }
        numeros.add(newNumberValue)
        Toast.makeText(this,"El número ${newNumberValue} ha sido agregado",Toast.LENGTH_SHORT).show()
    }

    private fun interfaceHighestNumber(){
        var highestNumber = numeros.maxOrNull()
        if(numeros.isEmpty()){
            Toast.makeText(this,"No hay ningún número todavía",Toast.LENGTH_SHORT).show()
            return
        }
        binding.resultados.text = highestNumber.toString()
    }

    private fun interfaceEvenNumbers(){
        val numerosPares = numeros.filter { x -> x % 2 == 0 }.average()
        if(numerosPares.isNaN()){
            Toast.makeText(this,"No hay ningún número par",Toast.LENGTH_SHORT).show()
            return
        }
        binding.resultados.text = numerosPares.toString()
    }

    private fun interfaceAverage(){
        val numeroPromedio = numeros.average()
        if(numeroPromedio.isNaN()) {
            Toast.makeText(this,"No hay ningún número todavía",Toast.LENGTH_SHORT).show()
            return
        }
        binding.resultados.text = numeroPromedio.toString()
    }
}