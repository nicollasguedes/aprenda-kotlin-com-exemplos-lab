// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }


data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel) {
    override fun toString(): String = "\n($nome, duracao=$duracao, nivel=$nivel)"

}

data class Usuario(val nome: String, val idade: Int) {
    override fun toString(): String = "\n($nome, idade=$idade)"
}

data class Formacao(val nome: String) {
    private var conteudoMutableList = mutableListOf<ConteudoEducacional>()
    private val usuarioMutableList = mutableListOf<Usuario>()

    fun isUsuarioAdded(usuario: Usuario): Boolean {
        return usuarioMutableList.contains(usuario)
    }

    fun isConteudoAdded(conteudoEducacional: ConteudoEducacional): Boolean {
        return conteudoMutableList.contains(conteudoEducacional)
    }

    fun addUsuario(usuario: Usuario) {
        if (!isUsuarioAdded(usuario)) {
            usuarioMutableList.add(usuario)
        } else
            throw Exception("${usuario.nome} já está cadastrado")
    }

    fun addConteudoEducacional(conteudoEducacional: ConteudoEducacional) {
        if (!isConteudoAdded(conteudoEducacional)) {
            conteudoMutableList.add(conteudoEducacional)
        } else
            throw Exception("${conteudoEducacional.nome} já está cadastrado")
    }

    override fun toString(): String = "$nome:\nconteudos=$conteudoMutableList\ninscritos=$usuarioMutableList)"
}

fun main() {
    val formacao = Formacao("Analise e Desenvolvimento de Sistema")
    formacao.addConteudoEducacional(ConteudoEducacional("Introdução á Programação", 150, Nivel.BASICO))
    formacao.addConteudoEducacional(ConteudoEducacional("Algoritmos e Estruturas de Dados", 170, Nivel.INTERMEDIARIO))
    formacao.addConteudoEducacional(ConteudoEducacional("Inteligência Artificial", 300, Nivel.DIFICIL))

    formacao.addUsuario(Usuario("Frank", 18))
    formacao.addUsuario(Usuario("Daniela", 22))
    formacao.addUsuario(Usuario("Zilda", 55))

    println(formacao.toString())


    /*
    As proximas linhas induzem o codigo a erro propositalmente
    em função de testar o uso de exeptions na verificação de cadastro
    formacao.addUsuario(Usuario("Frank", 18))
    formacao.addConteudoEducacional(ConteudoEducacional("Introdução á Programação", 150, Nivel.BASICO))
    */
}
