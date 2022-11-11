package com.example.tdpa_3p_ej03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var fijas: List<String> = listOf("MXN", "USD", "EUR") // Este sera una lista inmutable osea que no se podra agregar
                                                              // o eliminar datos
        var opcionales: MutableList<String> = mutableListOf("YEN", "GBP") // En esta si se pude modicar agregar o eliminar datos

        opcionales.add("ARG") // Estas 2 lineas solo agregan datos a la lista "opcionales"
        opcionales.add("AUD") // Estas 2 lineas solo agregan datos a la lista "opcionales"

        //opcionales.remove("YEN")
        //opcionales.removeAt(2)

        opcionales.first() // Muestra el primer valor de la lista
        opcionales.last() // Muestra el ultomo valor de la lista
        opcionales.firstOrNull() // Te lanza el primer valor pero si esta vacio lo arroja como nullo
        opcionales.elementAt(1) // Muestra los datos del indice que ingreses
        //opcionales.clear() // Limpia la lista

        for(i in opcionales)
            print(i)
                                  // En estos 2 ciclos se imprime en consola las listas con los valores ingresados
        for (i in fijas)
            print(i)

        // MAPAS INMUTABLES (En estas listas no se pueden modificar)
        var mapaInm:Map<Int,String> = mapOf(
            // De esta forna es la que se asigna o crea un datos en un mapa inmutable, poniendole una posicion y el dato que contendra
            1 to "Mexico",
            2 to "Estados Unidos",
            3 to "Union Europea"

        )

          mapaInm[2]
        //------------------------------------

                                                                                                                                   // MAPAS MUTABLE (Aqui se declran que tipo de datos queremos que reciba nuestro mapa)
        var inversiones = mutableMapOf<String,Float>() //
        inversiones.put("FEMSA", 50f)
        inversiones.put("APPLE", 30f)
        inversiones.put("CEMEX", 40f)

        inversiones.remove("FEMSA")

        var fondo = 100f
        var saldo = 100f
        while (saldo >= 20f ){
            inversiones.put("Tiendita Don Chuy",20f)
            saldo = saldo - 20f
        }

        var txt = findViewById<TextView>(R.id.txtPrincipal)
        // De esta forma
        val spinner: Spinner = findViewById(R.id.spnOrigen)
        val spinnerDestino: Spinner = findViewById(R.id.spnDestino)

        val arrayAdapter: ArrayAdapter<*>
        val arrayDestino: ArrayAdapter<*>

        arrayAdapter = ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,fijas) // Para el spinner Origen
        arrayDestino = ArrayAdapter(this,android.R.layout.simple_list_item_1,opcionales)
        spinner.adapter = arrayAdapter
        spinnerDestino.adapter = arrayDestino

        var monedaOrigen = ""
        var monedaDestino = ""

        spinner.onItemSelectedListener = object :
        AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int,Id: Long){
                Toast.makeText(this@MainActivity,"Se ha seleccionado " + fijas[position],
                   Toast.LENGTH_SHORT).show()
                monedaOrigen = fijas[position] // Mostramos la posicion seleccioanda a la variable monedaOrigen
                when(monedaOrigen){
                    "MNX", "mxn", "mx", "MX"->{
                        txt.text = "La moneda de origen es: MXN"
                    }
                    "USD"->{
                        txt.text = "La moneda de origen es: USD"
                    }
                    "EUR" ->{
                        txt.text = "La moneda de origen es EUR"
                    }
                    else->{
                        txt.text = "No se selecciono una moneda valida"
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Se dispara cuando no haya ningun elemento sleccioando
                Toast.makeText(this@MainActivity, "No se ha seleccionado ninguna moneda",
                Toast.LENGTH_SHORT).show()
            }
        }

        spinnerDestino.onItemSelectedListener = object :
            AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>,
                                        view: View, position: Int,Id: Long){
                Toast.makeText(this@MainActivity,"Se ha seleccionado " + opcionales[position],
                    Toast.LENGTH_SHORT).show()
                monedaDestino = opcionales[position] // Mostramos la posicion seleccioanda a la variable monedaOrigen

            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                // Se dispara cuando no haya ningun elemento sleccioando
                Toast.makeText(this@MainActivity, "No se ha seleccionado ninguna moneda",
                    Toast.LENGTH_SHORT).show()
            }
        }
        var btnCalcular = findViewById<Button>(R.id.btnCalcular)
        var txtmonto = findViewById<TextView>(R.id.txtMonto)
        btnCalcular.setOnClickListener{

            txt.text = "La conversion de ${monedaOrigen} a ${monedaDestino} es: ${calcular(monedaOrigen,monedaDestino, txtmonto.text.toString().toFloat())}"
        }
    }
    /* En esta funcion de agregar que hace es que al usar la palbra "View" dentro de la funcion
       Podemos asignarselos a un boton o cualquer herramienta sin tener que asignarse codificando*/

    fun agregar(view : View){
        Toast.makeText(this, "AGREGADO", Toast.LENGTH_SHORT).show()
    }

    fun calcular(origen:String, destino:String, monto:Float):Float{
        var resultado = 0f
        when(origen){
            "MNX"->{
                when(destino){
                    "YEN"->{
                        resultado = monto * 0.14f
                    }
                    "GBP"->{
                        resultado = monto * 0.43f
                    }
                    "ARG"->{
                        resultado = monto * 8.24f
                    }
                    "AUD"->{
                        resultado = monto * 0.076f
                    }
                    else->{
                        resultado = 0f
                    }
                }
            }
            "USD"->{
                when(destino){
                    "YEN"->{
                        resultado = monto * 0.14f
                    }
                    "GBP"->{
                        resultado = monto * 0.43f
                    }
                    "ARG"->{
                        resultado = monto * 8.24f
                    }
                    "AUD"->{
                        resultado = monto * 0.076f
                    }
                    else->{
                        resultado = 0f
                    }
                }
            }
            "EUR"->{
                when(destino){
                    "YEN"->{
                        resultado = monto * 0.14f
                    }
                    "GBP"->{
                        resultado = monto * 0.43f
                    }
                    "ARG"->{
                        resultado = monto * 8.24f
                    }
                    "AUD"->{
                        resultado = monto * 0.076f
                    }
                    else->{
                        resultado = 0f
                    }
                }
            }
            else->{
                resultado = 0f
            }
        }
        return resultado
    }
}