package com.example.tdpa_3p_ej03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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

        opcionales.remove("YEN")
        opcionales.removeAt(2)

        opcionales.first() // Muestra el primer valor de la lista
        opcionales.last() // Muestra el ultomo valor de la lista
        opcionales.firstOrNull() // Te lanza el primer valor pero si esta vacio lo arroja como nullo
        opcionales.elementAt(1) // Muestra los datos del indice que ingreses
        opcionales.clear() // Limpia la lista

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

    }
    /* En esta funcion de agregar que hace es que al usar la palbra "View" dentro de la funcion
       Podemos asignarselos a un boton o cualquer herramienta sin tener que asignarse codificando*/
    fun agregar(view : View){
        Toast.makeText(this, "AGREGADO", Toast.LENGTH_SHORT).show()
    }
}