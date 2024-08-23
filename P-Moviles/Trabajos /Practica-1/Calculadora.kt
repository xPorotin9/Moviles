fun Suma() {
    println("Ingrese el primer valor:")
    val num1 = readLine()?.toIntOrNull() ?: 0

    println("Ingrese el segundo valor:")
    val num2 = readLine()?.toIntOrNull() ?: 0

    val resultado = num1 + num2
    println("El resultado de la suma es: $resultado")
}

fun Resta() {
    println("Ingrese el primer valor:")
    val num1 = readLine()?.toIntOrNull() ?: 0

    println("Ingrese el segundo valor:")
    val num2 = readLine()?.toIntOrNull() ?: 0

    val resultado = num1 - num2
    println("El resultado de la resta es: $resultado")
}

fun Multiplicacion() {
    println("Ingrese el primer valor:")
    val num1 = readLine()?.toDoubleOrNull() ?: 0.0

    println("Ingrese el segundo valor:")
    val num2 = readLine()?.toDoubleOrNull() ?: 0.0

    val resultado = num1 * num2
    println("El resultado de la multiplicación es: $resultado")
}

fun Division() {
    println("Ingrese el primer valor:")
    val num1 = readLine()?.toDoubleOrNull() ?: 0.0

    println("Ingrese el segundo valor:")
    val num2 = readLine()?.toDoubleOrNull() ?: 0.0

    if (num2 != 0.0) {
        val resultado = num1 / num2
        println("El resultado de la división es: $resultado")
    } else {
        println("Error: No se puede dividir por cero")
    }
}

fun main() {
    var option: Int

    do {
        println("\tMenú de opciones:")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Salir")
        print("Seleccione una opción: ")
        option = readLine()?.toIntOrNull() ?: 0

        when (option) {
            1 -> Suma()
            2 -> Resta()
            3 -> Multiplicacion()
            4 -> Division()
            5 -> println("Programa finalizado")
            else -> println("Opcion invalida.")
        }

        println()

    } while (option != 5)
}
