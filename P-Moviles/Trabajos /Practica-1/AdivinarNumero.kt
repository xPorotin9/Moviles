private fun Random(): Int {
    return (1..30).random()
}

fun VerificadorDeNumero(eleccion: Int, random: Int): Boolean {
    return when {
        eleccion == random -> {
            println("Diablo Loco!")
            true
        }
        else -> {
            println("Numero equivocado")
            false
        }
    }
}

fun main(args: Array<String>) {
    var eleccion: Int
    var intentos = 5
    val random = Random()
    println(random)

    println("Se a generado un numero aleatorio entre 1-30")
    println("Tiene ${intentos} intentos")
    while (intentos > 0) {
        println("Ingrese su número a adivinar: ")
        val eleccion = readln().toIntOrNull() ?: -1

        if (eleccion !in 1..30) {
            println("Ingrese un número válido entre 1-30.")
            continue
        }

        if (VerificadorDeNumero(eleccion, random)) {
            break
        }
    }
}
