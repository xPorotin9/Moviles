// Función que evalúa una expresión
fun evaluarExpresionSimple(expresion: String): Double {
    // Lista de operadores
    val operadores = listOf('+', '-', '*', '/')
    // Almacena los números o operadores
    val numeros = mutableListOf<Double>()
    val ops = mutableListOf<Char>()

    var numero = ""

    // Bucle para cada caracter
    for (caracter in expresion) {
        // Si el caracter es un operador, se guarda el número anterior y el operador
        if (caracter in operadores) {
            numeros.add(numero.toDouble())
            ops.add(caracter)
            numero = ""
        } else {
            numero += caracter
        }
    }
    // Agrega a la lista de numeros si uno queda pendiente
    if (numero.isNotEmpty()) {
        numeros.add(numero.toDouble())
    }

    // Agrega jerarquia de operadores (* o /)
    var i = 0
    while (i < ops.size) {
        if (ops[i] == '*' || ops[i] == '/') {
            val operacion = operar(numeros[i], ops[i], numeros[i + 1])
            numeros[i] = operacion
            numeros.removeAt(i + 1) // Elimina número ya procesado
            ops.removeAt(i) // Elimina operador ya procesado
        } else {
            i++
        }
    }

    // Procesa sumas o restas
    var resultado = numeros[0]
    for (j in ops.indices) {
        resultado = operar(resultado, ops[j], numeros[j + 1])
    }

    return resultado
}

// Función que realiza una operación entre dos números basándose en el operador
fun operar(a: Double, operador: Char, b: Double): Double {
    return when (operador) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        '/' -> if (b != 0.0) a / b else Double.NaN // Verifica si la división es por cero.
        else -> Double.NaN
    }
}

// Maneja el proceso de ingresar una expresión matemática completa y evaluarla.
fun OperacionesCombinadas() {
    println("Ingrese la expresión matemática que desea calcular (por ejemplo, 2+3-4*5/2):")
    // Lee la expresión ingresada por el usuario, eliminando los espacios en blanco.
    val expresion = readLine()?.replace(" ", "") ?: ""

    // Llama a la función para evaluar la expresión y obtiene el resultado.
    val resultado = evaluarExpresionSimple(expresion)
    println("El resultado de la expresión '$expresion' es: $resultado")
}

// Realizar sumas
fun Suma() {
    println("Ingrese el primer valor:")
    val num1 = readLine()?.toIntOrNull() ?: 0

    println("Ingrese el segundo valor:")
    val num2 = readLine()?.toIntOrNull() ?: 0

    val resultado = num1 + num2
    println("El resultado de la suma es: $resultado")
}

// Realizar restas
fun Resta() {
    println("Ingrese el primer valor:")
    val num1 = readLine()?.toIntOrNull() ?: 0

    println("Ingrese el segundo valor:")
    val num2 = readLine()?.toIntOrNull() ?: 0

    val resultado = num1 - num2
    println("El resultado de la resta es: $resultado")
}

// Realizar multiplicaciones
fun Multiplicacion() {
    println("Ingrese el primer valor:")
    val num1 = readLine()?.toDoubleOrNull() ?: 0.0

    println("Ingrese el segundo valor:")
    val num2 = readLine()?.toDoubleOrNull() ?: 0.0

    val resultado = num1 * num2
    println("El resultado de la multiplicación es: $resultado")
}

// Realizar divisiones y verifica que no se divida entre 0
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
        // Menu
        println("\tMenú de opciones:")
        println("1. Suma")
        println("2. Resta")
        println("3. Multiplicación")
        println("4. División")
        println("5. Operaciones combinadas")
        println("6. Salir")
        print("Seleccione una opción: ")

        option = readLine()?.toIntOrNull() ?: 0

        // Ejecuta la función según la opción 
        when (option) {
            1 -> Suma()
            2 -> Resta()
            3 -> Multiplicacion()
            4 -> Division()
            5 -> OperacionesCombinadas()
            6 -> println("Saliendo del programa...")
            else -> println("Opción inválida.")
        }

        println()

    } while (option != 6) // Bucle hasta que se selecciones "Salir"
}
