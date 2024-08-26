fun main() {
    var continuar = true

    while (continuar) {
        when (mostrarMenu()) {
            1 -> {
                val puntuacion = solicitarPuntuacion()
                val salario = solicitarSalario()

                val nivelRendimiento = determinarNivel(puntuacion)
                val cantidadDinero = calcularCantidadDinero(puntuacion, salario)

                println("\n\tResultado")
                println("Nivel de Rendimiento: $nivelRendimiento")
                println("Cantidad de Dinero Recibido: $${"%.2f".format(cantidadDinero)}")
            }
            2 -> mostrarInformacionNiveles()
            3 -> {
                println("Terminando programa")
                continuar = false
            }
            else -> println("Escoja una opción válida.")
        }
    }
}

// Muestra y lee opcion para el menu
fun mostrarMenu(): Int {
    println("\n\t--- Menú ---")
    println("1. Calcular nivel de rendimiento y dinero recibido")
    println("2. Mostrar información sobre los niveles de rendimiento")
    println("3. Salir")
    print("Seleccione una opción: ")
    return readLine()?.toIntOrNull() ?: 0
}

// lee el puntuacion y valida que este entre el rango
fun solicitarPuntuacion(): Int {
    while (true) {
        print("Ingrese su puntuación (0 a 10): ")
        val puntuacion = readLine()?.toIntOrNull()
        if (puntuacion != null && puntuacion in 0..10) {
            return puntuacion
        } else {
            println("Debe estar entre 0 y 10.")
        }
    }
}

// lee el salario del y valida que sea mayor que 0
fun solicitarSalario(): Double {
    while (true) {
        print("Ingrese su salario mensual: ")
        val salario = readLine()?.toDoubleOrNull()
        if (salario != null && salario > 0) {
            return salario
        } else {
            println("Debe ser un número mayor que 0")
        }
    }
}
// Determina el nivel segun el usuario
fun determinarNivel(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación inválida"
    }
}

fun calcularCantidadDinero(puntuacion: Int, salario: Double): Double {
    return salario * (puntuacion / 10.0)
}
// Detalla la informacion de los niveles
fun mostrarInformacionNiveles() {
    println("\n--- Información sobre los niveles de rendimiento ---")
    println("Inaceptable: 0-3")
    println("Aceptable: 4-6")
    println("Meritorio: 7-10")
    println("El dinero recibido se calcula multiplicando el salario mensual por la puntuación dividida entre 10.")
}
