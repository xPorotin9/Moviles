// Descripción corta del problema: Sistema de Gestión de Biblioteca con clases para materiales, usuarios, y operaciones de préstamo y devolución.
// Autor: Jose C. Machaca
// Fecha creación: 2024-31-08
// Fecha última modificación: 2024-01-09

// Clase base abstracta para Material, que define las propiedades básicas y un método para mostrar detalles
abstract class Material(val titulo: String, val autor: String, val anioPublicacion: Int) {
    abstract fun mostrarDetalles()
}

// Clase que representa un Libro, hereda de Material y agrega más detalles específicos
class Libro(titulo: String, autor: String, anioPublicacion: Int, val genero: String, val numeroPaginas: Int) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Libro: '$titulo' de $autor, publicado en $anioPublicacion")
        println("Género: $genero, Número de páginas: $numeroPaginas")
    }
}

// Clase que representa una Revista, hereda de Material y tiene propiedades adicionales
class Revista(titulo: String, autor: String, anioPublicacion: Int, val issn: String, val volumen: Int, val numero: Int, val editorial: String) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        println("Revista: '$titulo' de $autor, publicada en $anioPublicacion")
        println("ISSN: $issn, Volumen: $volumen, Número: $numero, Editorial: $editorial")
    }
}

// Clase para representar a un usuario de la biblioteca
data class Usuario(val nombre: String, val apellido: String, val edad: Int)

// Interfaz que define las operaciones que debe soportar la biblioteca
interface IBiblioteca {
    fun agregarMaterial(material: Material)
    fun agregarUsuario(usuario: Usuario)
    fun prestarMaterial(usuario: Usuario, material: Material)
    fun recibirMaterialDevolucion(usuario: Usuario, material: Material)
    fun listarMaterialesDisponibles()
    fun listarMaterialesPrestadosPorUsuario(usuario: Usuario)
}

// Clase que gestiona las operaciones de la biblioteca, como prestar y devolver materiales
class Biblioteca : IBiblioteca {
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuarios = mutableMapOf<Usuario, MutableList<Material>>()

    // Agrega un material a la lista de disponibles
    override fun agregarMaterial(material: Material) {
        materialesDisponibles.add(material)
        println("¡Material agregado! Título: '${material.titulo}'")
    }

    // Registra un usuario en la biblioteca
    override fun agregarUsuario(usuario: Usuario) {
        usuarios[usuario] = mutableListOf()
        println("¡Bienvenido, ${usuario.nombre}! Ahora eres miembro de la biblioteca.")
    }

    // Realiza un préstamo de material a un usuario
    override fun prestarMaterial(usuario: Usuario, material: Material) {
        if (materialesDisponibles.contains(material)) {
            materialesDisponibles.remove(material)
            usuarios[usuario]?.add(material)
            println("El material '${material.titulo}' ha sido prestado a ${usuario.nombre} ${usuario.apellido}. ¡Disfruta la lectura!")
        } else {
            println("Lo siento, el material '${material.titulo}' no está disponible en este momento.")
        }
    }

    // Recibe la devolución de un material prestado por un usuario
    override fun recibirMaterialDevolucion(usuario: Usuario, material: Material) {
        if (usuarios[usuario]?.contains(material) == true) {
            usuarios[usuario]?.remove(material)
            materialesDisponibles.add(material)
            println("Gracias, ${usuario.nombre}, por devolver '${material.titulo}'.")
        } else {
            println("${usuario.nombre}, no tienes prestado el material '${material.titulo}'.")
        }
    }

    // Lista todos los materiales disponibles en la biblioteca
    override fun listarMaterialesDisponibles() {
        if (materialesDisponibles.isEmpty()) {
            println("No hay materiales disponibles en la biblioteca.")
        } else {
            println("Estos son los materiales que puedes solicitar:")
            materialesDisponibles.forEach { it.mostrarDetalles() }
        }
    }

    // Lista los materiales que un usuario tiene en préstamo
    override fun listarMaterialesPrestadosPorUsuario(usuario: Usuario) {
        val materialesPrestados = usuarios[usuario]
        if (materialesPrestados.isNullOrEmpty()) {
            println("${usuario.nombre}, no tienes materiales prestados.")
        } else {
            println("Estos son los materiales que tienes en préstamo, ${usuario.nombre}:")
            materialesPrestados.forEach { it.mostrarDetalles() }
        }
    }
}

fun main() {
    val biblioteca = Biblioteca()

    // Agregamos algunos materiales a la biblioteca
    val libro1 = Libro("1984", "George Orwell", 1949, "Distopía", 328)
    val revista1 = Revista("National Geographic", "Varios", 2023, "ISSN 0027-9358", 155, 4, "National Geographic Society")

    biblioteca.agregarMaterial(libro1)
    biblioteca.agregarMaterial(revista1)

    // Registramos a dos usuarios en la biblioteca
    val usuario1 = Usuario("Juan", "Pérez", 25)
    val usuario2 = Usuario("Ana", "Gómez", 30)

    biblioteca.agregarUsuario(usuario1)
    biblioteca.agregarUsuario(usuario2)

    // Realizamos algunas operaciones de préstamo y devolución
    biblioteca.listarMaterialesDisponibles()

    biblioteca.prestarMaterial(usuario1, libro1)
    biblioteca.listarMaterialesDisponibles()

    biblioteca.listarMaterialesPrestadosPorUsuario(usuario1)

    biblioteca.recibirMaterialDevolucion(usuario1, libro1)
    biblioteca.listarMaterialesDisponibles()

    biblioteca.listarMaterialesPrestadosPorUsuario(usuario1)
}
