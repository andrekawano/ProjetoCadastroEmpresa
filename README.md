# ProjetoCadastroEmpresa
API Rest

-Importar o projeto pelo no Eclipse, é um projeto Maven
-Ao subir a aplicação, também vai subir um banco em memório, o H2, que ficará disponivel em http://localhost:8080/h2-console, jdbc:h2:mem:ibge-empresas, Login: admin, Senha: admin
-Para listar as empresas cadastradas: http://localhost:8080/empresas
-Para cadastrar pelo metodo Post, http://localhost:8080/empresas
{
        "nome": "KAWANO INFORMATICA 3",
        "quantidadeFuncionario": 1,
        "faturamento": 10000.0,
        "estado": "SAO PAULO",
        "municipio": "BAURU"
}

-Para Alterar pelo metodo Put, http://localhost:8080/empresas/1
{
        "nome": "KAWANO INFORMATICA editado",
        "quantidadeFuncionario": 4,
        "faturamento": 40000.0,
        "estado": "SAO PAULO editado",
        "municipio": "BAURU editado"
}

-Para Excluir pelo metodo Delete, http://localhost:8080/empresas/1

-Para Buscar pelo Id, metodo get, http://localhost:8080/empresas/1

-Para Buscar os estados com uma Api externa do IGBE, http://localhost:8080/estados

-No Eclipse executar os testes com mock.
