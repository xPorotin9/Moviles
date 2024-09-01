// Descripción: Clase para Producto con precio, descuento, cálculo del precio final.
// Autor: Jose C. Machaca
// Fecha creación: 2024-31-08
// Fecha última modificación: 2024-30-08

import java.util.Scanner

class Producto {
    private var precio: Double = 0.0
    private var descuento: Double = 0.0

    // Setter para establecer el precio con validación
    fun setPrecio(precio: Double) {
        if (precio >= 0) {
            this.precio = precio
            println("Precio establecido correctamente: $$precio")
        } else {
            println("Error: El precio no puede ser negativo. Inténtalo de nuevo.")
        }
    }

    // Getter para obtener el precio
    fun getPrecio(): Double {
        return precio
    }

    // Setter para establecer el descuento con validación
    fun setDescuento(descuento: Double) {
        if (descuento in 0.0..100.0) {
            this.descuento = descuento
            println("Descuento establecido correctamente: $descuento%")
        } else {
            println("Error: El descuento debe estar entre 0 y 100. Inténtalo de nuevo.")
        }
    }

    // Getter para obtener el descuento
    fun getDescuento(): Double {
        return descuento
    }

    // Funcion para calcular el precio final después de descuento
    fun calcularPrecioFinal(): Double {
        return precio - (precio * (descuento / 100))
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val producto = Producto()
    var precioValido = false
    var descuentoValido = false

    // Ingreso y validación del precio
    while (!precioValido) {
        try {
            print("Ingresa el precio del producto: $")
            val inputPrecio = scanner.nextDouble()
            producto.setPrecio(inputPrecio)
            precioValido = inputPrecio >= 0
        } catch (e: Exception) {
            println("Error: Entrada inválida. Por favor, ingresa un número válido para el precio.")
            scanner.next()
        }
    }

    // Ingreso y validación del descuento
    while (!descuentoValido) {
        try {
            print("Ingresa el porcentaje de descuento: ")
            val inputDescuento = scanner.nextDouble()
            producto.setDescuento(inputDescuento)
            descuentoValido = inputDescuento in 0.0..100.0
        } catch (e: Exception) {
            println("Error: Entrada inválida. Por favor, ingresa un número válido para el descuento.")
            scanner.next() 
        }
    }

    // Mostrar el precio final al usuario

    println("\tBoleta")
        println("=========================================")
    println("Precio original: $${producto.getPrecio()}")
    println("Descuento aplicado: ${producto.getDescuento()}%")
    println("Precio final: $${producto.calcularPrecioFinal()}")
    println("=========================================")
}
