# 🎮 GameTime

## 📜 Descrição
GameTime é um projeto 🛠️ que permite aos usuários 🕹️ registrar e gerenciar uma lista de jogos que já jogaram, que desejam jogar ou que estão jogando atualmente. A intenção é manter um registro organizado de suas jornadas de jogo.

## 🌟 Funcionalidades
- 📝 Registro de jogos completados
- 📅 Planejamento de jogos futuros
- 🎮 Acompanhamento de jogos atuais

## 💻 Tecnologias Utilizadas
- ☕ Java
- 🍃 Spring Framework
- 🎨 Thymeleaf
- ✔️ Bean Validation
- ✂️ Lombok

## 🚀 Executando o aplicativo
Para executar o aplicativo, siga as etapas abaixo:

1. Crie um banco de dados usando MySql.
2. Clone este repositório.
3. Abra o `application.properties` arquivo localizado em src/main/resources.
4. Modifique as propriedades `spring.datasource.url`, ``spring.datasource.username`` e ``spring.datasource.password`` de acordo com as configurações do seu banco de dados.
5. Navegue até o diretório raiz do projeto.
6. Execute o seguinte comando para compilar e executar o aplicativo:

```
mvnw spring-boot:run
```
7. Entre no seu navegador e o aplicativo estará disponível em http://localhost:8080 .

## 🚀 Implementações Futuras
No futuro, planejo adicionar as seguintes funcionalidades ao GameTime:

- **Integração com API de Imagens**: Implementar uma conexão com uma API externa para automatizar a adição de imagens aos jogos, eliminando a necessidade de os usuários carregarem manualmente as imagens correspondentes aos jogos.
- **Autenticação**: Verificação segura das credenciais dos usuários, garantindo que apenas usuários autorizados possam acessar suas contas e interagir com o sistema.
- **Criptografia de Senhas**: Uso de algoritmos de hash modernos para armazenar senhas de forma segura, evitando que sejam comprometidas mesmo no caso de um acesso não autorizado ao banco de dados.

## 🌱 Origem do Projeto
A ideia do GameTime surgiu durante um período de transição profissional, com o objetivo de criar um projeto do zero que demonstrasse minhas habilidades em programação. Inspirado pelo aplicativo TVtime, que permite aos usuários acompanhar séries e filmes assistidos, bem como próximos lançamentos, percebi a ausência de uma plataforma semelhante dedicada aos jogos (Até hoje não conheço algo parecido). Diante dessa lacuna, decidi criar o GameTime, um lugar que eu pudesse registrar e gerenciar minhas experiências de jogo. Este projeto é o resultado de uma paixão pessoal por programação, jogos e o desejo de construir algo funcional.
