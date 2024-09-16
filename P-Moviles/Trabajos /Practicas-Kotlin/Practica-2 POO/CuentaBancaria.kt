// Descripción: Clase para gestionar una cuenta bancaria con saldo y límite de retiro, con manejo de errores y entrada de datos por el usuario.
// Autor: Jose C. Machaca
// Fecha creación: 2024-29-8
// Fecha última modificación: 2024-31-08

import java.util.Scanner

class CuentaBancaria(private var saldo: Double, private var limiteRetiro: Double) {

    // Getter para el saldo
    fun getSaldo(): Double {
        return saldo
    }

    // Setter para el saldo validando que no sea negativo
    fun setSaldo(nuevoSaldo: Double) {
        if (nuevoSaldo >= 0) {
            saldo = nuevoSaldo
            println("El saldo ha sido actualizado a: $saldo")
        } else {
            println("Error: El saldo no puede ser negativo.")
        }
    }

    // Getter para el límite de retiro
    fun getLimiteRetiro(): Double {
        return limiteRetiro
    }

    // Setter para el límite de retiro validando que sea mayor que cero
    fun setLimiteRetiro(nuevoLimite: Double) {
        if (nuevoLimite > 0) {
            limiteRetiro = nuevoLimite
            println("El límite de retiro ha sido actualizado a: $limiteRetiro")
        } else {
            println("Error: El límite de retiro debe ser mayor que cero.")
        }
    }

    // Funcion para realizar un retiro
    fun retirar(cantidad: Double): Boolean {
        return when {
            cantidad <= 0 -> {
                println("Error: La cantidad a retirar debe ser mayor que cero.")
                false
            }
            cantidad > saldo -> {
                println("Error: Fondos insuficientes. Saldo disponible: $saldo")
                false
            }
            cantidad > limiteRetiro -> {
                println("Error: La cantidad excede el límite de retiro. Límite: $limiteRetiro")
                false
            }
            else -> {
                saldo -= cantidad
                println("Retiro exitoso. Saldo restante: $saldo")
                true
            }
        }
    }

    // Funcion para mostrar la información de la cuenta
    fun mostrarInformacionCuenta() {
        println("Saldo actual: $saldo")
        println("Límite de retiro: $limiteRetiro")
    }
}

fun main() {
    val scanner = Scanner(System.`in`)

    // Solicitar datos iniciales de la cuenta
    println("Ingrese el saldo inicial de la cuenta:")
    val saldoInicial = scanner.nextDouble()
    println("Ingrese el límite de retiro inicial:")
    val limiteInicial = scanner.nextDouble()

    val cuenta = CuentaBancaria(saldoInicial, limiteInicial)

    var continuar = true

    while (continuar) {
        println("\n¿\tMenu de Operaciones")
        println("1. Consultar saldo y límite de retiro")
        println("2. Realizar un retiro")
        println("3. Actualizar saldo")
        println("4. Actualizar límite de retiro")
        println("5. Salir")
        print("Ingrese la opción: ")

        when (scanner.nextInt()) {
            1 -> cuenta.mostrarInformacionCuenta()
            2 -> {
                println("Ingrese la cantidad que desea retirar:")
                val cantidadRetiro = scanner.nextDouble()
                cuenta.retirar(cantidadRetiro)
            }
            3 -> {
                println("Ingrese el nuevo saldo:")
                val nuevoSaldo = scanner.nextDouble()
                cuenta.setSaldo(nuevoSaldo)
            }
            4 -> {
                println("Ingrese el nuevo límite de retiro:")
                val nuevoLimite = scanner.nextDouble()
                cuenta.setLimiteRetiro(nuevoLimite)
            }
            5 -> {
                continuar = false
                println("Gracias por usar el sistema de cuenta bancaria.")
            }
            else -> println("Opción no válida. Por favor, intente nuevamente.")
        }
    }
}
