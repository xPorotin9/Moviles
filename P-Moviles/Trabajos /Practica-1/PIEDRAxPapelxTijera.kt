// Función para generar número aleatorio
private fun Random(): Int {
    return (1..3).random()
}

// Función para visualizar la opción de la máquina
fun mostrarOpcionPC(opcion: Int): String {
    return when (opcion) {
        1 -> "Piedra"
        2 -> "Papel"
        3 -> "Tijera"
        else -> "Error"
    }
}

// Función para visualizar la opción del jugador
fun mostrarOpcionJugador(opcion: Int): String {
    return when (opcion) {
        1 -> "Piedra"
        2 -> "Papel"
        3 -> "Tijera"
        else -> "Error"
    }
}

fun main(args: Array<String>) {
    var victoriasJugador = 0
    var victoriasPC = 0

    while (true) {
        var option: Int // Opcion de Jugador
        val random = Random() // Valor random 1,2 o 3

        // Verificador de opción correcta
        while (true) {
            println("Piedra = 1, Papel = 2, Tijera = 3")
            print("Escoge una opción: ")

            // Convertir "option" a entero
            option = readln().toIntOrNull() ?: -1

            if (option in 1..3) {
                break  // Salir del ciclo si es válida
            } else {
                println("Opción inválida. Por favor, escoge 1, 2 o 3.")
            }
        }

        // Mostrar ambas elecciones
        println("\n\tElecciones")
        println("Jugador: ${mostrarOpcionJugador(option)}")
        println("Computadora: ${mostrarOpcionPC(random)}\n")

        println("\tResultado")
        // Determinar resultado
        when {
            random == option -> println("Empate")
            (option == 1 && random == 3) || (option == 2 && random == 1) || (option == 3 && random == 2) -> {
                println("Gana el Jugador!")
                victoriasJugador++
            }
            else -> {
                println("Pierde el jugador!")
                victoriasPC++
            }
        }

        // Mostrar el puntaje
        println("\n\tPuntaje \nJugador: $victoriasJugador, Computadora: $victoriasPC")

        // Verificar si se desea continuar
        println("\n¿Desea continuar?\n'si' para continuar")
        val respuesta = readln().lowercase()
        if (respuesta != "si") {
            break
        }
    }
}
