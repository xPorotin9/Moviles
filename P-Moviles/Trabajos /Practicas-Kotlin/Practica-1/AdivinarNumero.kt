// Generador de numero segun el usuario
private fun Random(maximo: Int): Int {
    return (1..maximo).random()
}
// Incrementa el numero de intentos segun el numero maximo  sea mayor
fun calcularIntentos(maximo: Int): Int {
    return when {
        maximo <= 10 -> 5
        maximo <= 50 -> 7
        maximo <= 125 -> 10
        maximo <= 250 -> 15
        else -> 20
    }
}
// Verifica si el numero es el correcto, si es menor o mayor
fun verificadorNumero(eleccion: Int, random: Int): Boolean {
    when {
        eleccion == random -> {
            println("Diablo Loco!")
            return true
        }
        eleccion < random -> {
            println("Número equivocado. El número es mayor.")
        }
        eleccion > random -> {
            println("Número equivocado. El número es menor.")
        }
    }
    return false
}
// Añade una pista con formato [OOO---] segun la aproximacion
fun Pista(eleccion: Int, random: Int, maximo: Int): String {
    val diferencia = Math.abs(eleccion - random)
    val pasos = maximo / 10
    val cercania = when {
        diferencia == 0 -> 10
        diferencia <= pasos -> 9
        diferencia <= 2 * pasos -> 8
        diferencia <= 3 * pasos -> 7
        diferencia <= 4 * pasos -> 6
        diferencia <= 5 * pasos -> 5
        diferencia <= 6 * pasos -> 4
        diferencia <= 7 * pasos -> 3
        diferencia <= 8 * pasos -> 2
        else -> 1
    }

    return "[${"O".repeat(cercania)}${"-".repeat(10 - cercania)}]" //Imprime "Pista: [OOOOOOOOO-]"
}

fun main(args: Array<String>) {
    println("Ingrese el valor máximo del rango en el que se generará el número aleatorio:")
    val maximo = readln().toIntOrNull() ?: run { // Valor maximo de intervalo
        println("Valor inválido. Usando el valor por defecto de 30.")
        30 // Si de añade un valor invalido se usar 30 como maximo
    }

    val random = Random(maximo)
    var intentos = calcularIntentos(maximo)

    println("Se ha generado un número entre 1 - $maximo")
    println("Tienes $intentos intentos")

    // Bucle para adivinar el numero
    while (intentos > 0) {
        println("Ingrese su número a adivinar: ")
        val eleccion = readln().toIntOrNull() ?: -1
        // Muestra un mensaje en caso se ingrese un valor erroneo
        if (eleccion !in 1..maximo) {
            println("Ingrese un número válido entre 1 y $maximo.")
            continue
        }
        // Muestra la pista e intentos
        if (verificadorNumero(eleccion, random)) {
            break
        } else {
            intentos--
            val pista = Pista(eleccion, random, maximo)
            println("Pista: $pista")
            println("Te quedan $intentos intentos.")
        }
    }
// Muestra si se perdio y el numero a adivinar
    if (intentos == 0) {
        println("Se acabaron los intentos\n El número era: $random.")
    }
}
