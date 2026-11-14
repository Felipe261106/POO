# Sistema de Almoxarifado StarLog

Projeto Java com Maven, JDBC e SQLite para demonstrar o CRUD de produtos.

## Requisitos
- JDK 17 ou superior
- Maven
- IDE com suporte a projetos Maven (VS Code, IntelliJ ou Eclipse)

## Como executar
1. Extraia o ZIP.
2. Abra a pasta `StarLog` na IDE como projeto Maven.
3. Aguarde o Maven baixar a dependência `sqlite-jdbc`.
4. Execute `src/main/java/br/com/starlog/Main.java`.

O banco `starlog.db` será criado automaticamente no diretório de execução.

## Observação sobre os testes
O roteiro cadastra dois produtos toda vez que é executado. Para repetir o teste esperando exatamente um produto ao final, feche a aplicação e apague o arquivo `starlog.db` antes de executar novamente. O banco será recriado automaticamente.
