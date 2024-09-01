// Descripción: Clase para Producto con precio, descuento, cálculo del precio final.
// Autor: Jose C. Machaca
// Fecha creación: 2024-30-08
// Fecha última modificación: 2024-31-08

import java.util.Scanner

// Clase abstracta que define los métodos para calcular el área y el perímetro
abstract class Shape {
    abstract fun calcularArea(): Double
    abstract fun calcularPerimetro(): Double

    fun imprimirResultados() {
        println("Área: ${calcularArea()}")
        println("Perímetro: ${calcularPerimetro()}")
    }
}

// Subclase que representa un cuadrado, heredando de Shape
class Cuadrado(val lado: Double) : Shape() {
    // Implementación del cálculo del área para un cuadrado
    override fun calcularArea(): Double {
        return lado * lado
    }

    // Implementación del cálculo del perímetro para un cuadrado
    override fun calcularPerimetro(): Double {
        return 4 * lado
    }
}

// Subclase que representa un círculo, heredando de Shape
class Circulo(val radio: Double) : Shape() {
    // Implementación del cálculo del área para un círculo
    override fun calcularArea(): Double {
        return Math.PI * radio * radio
    }

    // Implementación del cálculo del perímetro para un círculo
    override fun calcularPerimetro(): Double {
        return 2 * Math.PI * radio
    }
}

// Subclase que representa un rectángulo, heredando de Shape
class Rectangulo(val largo: Double, val ancho: Double) : Shape() {
    // Implementación del cálculo del área para un rectángulo
    override fun calcularArea(): Double {
        return largo * ancho
    }

    // Implementación del cálculo del perímetro para un rectángulo
    override fun calcularPerimetro(): Double {
        return 2 * (largo + ancho)
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    while (true) { // Bucle infinito
        // Menú de selección de figura geométrica
        println("Seleccione la figura que desea calcular:")
        println("1. Cuadrado")
        println("2. Círculo")
        println("3. Rectángulo")
        println("4. Salir")
        print("Opción: ")

        when (scanner.nextInt()) {
            1 -> {
                // Manejo de la opción Cuadrado
                println("Se selecciono Cuadrado.")
                print("Ingresa el valor del lado: ")
                val lado = scanner.nextDouble() // Captura del valor del lado
                val cuadrado = Cuadrado(lado) // Creación de la instancia Cuadrado
                cuadrado.imprimirResultados() 
            }
            2 -> {
                // Manejo de la opción Círculo
                println("Se selecciono Círculo.")
                print("Ingresa el valor del radio: ")
                val radio = scanner.nextDouble() 
                val circulo = Circulo(radio) 
                circulo.imprimirResultados()
            }
            3 -> {
                // Manejo de la opción Rectángulo
                println("Se selecciono Rectángulo.")
                print("Ingresa el valor del largo: ")
                val largo = scanner.nextDouble() 
                print("Ingresa el valor del ancho: ")
                val ancho = scanner.nextDouble() 
                val rectangulo = Rectangulo(largo, ancho) 
                rectangulo.imprimirResultados()
            }
            4 -> {
                // Salida del programa
                println("Saliendo del programa. ¡Adiós!")
                break
            }
            else -> {
                // Manejo de opción inválida
                println("Opción inválida. Por favor, selecciona una opción válida.")
            }
        }
        println("=========================================")
    }
}
