fun main() {
    print("Ingrese su salario mensual: ")
    val salario = readLine()?.toDoubleOrNull() ?: 0.0
  
    print("Ingrese su puntuación (0 a 10): ")
    val puntuacion = readLine()?.toIntOrNull() ?: 0
  
    // Determinar nivel
    val nivelRendimiento = when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Puntuación inválida"
    }

    // Calcular dinero
    val cantidadDinero = if (puntuacion in 0..10) salario * (puntuacion / 10.0) else 0.0

    println("Resultado: Nivel de Rendimiento $nivelRendimiento, Cantidad de Dinero Recibido $${"%.2f".format(cantidadDinero)}")
}
