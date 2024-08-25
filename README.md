# sicredi-desafio

## Descrição
Projeto de automação de testes de api em java utilizando o framework de teste Rest Assured. O framework foi criado para testar uma aplicação que é responsável por gerenciar produtos eletrônicos.

## Como Executar

Este projeto é configurado como um projeto Maven e pode ser executado dentro do IDE Eclipse ou via linha de comando. Aqui estão os passos para configurar e executar o projeto localmente.

### Pré-requisitos

- Java JDK 11 ou superior instalado.
- Eclipse IDE para desenvolvedores Java.
- Maven integrado no Eclipse ou instalado separadamente.

### Instalação

1. **Clonar o Repositório**
   - Clone o repositório em sua máquina local usando:
     ```bash
     git clone https://github.com/droidtrail/desafioSicrediApi.git
     ```

2. **Importar o Projeto no Eclipse**
   - Abra o Eclipse e vá para `File` > `Import...`.
   - Escolha `Existing Maven Projects` e clique em `Next`.
   - Navegue até o diretório onde você clonou o projeto e certifique-se de que o arquivo `pom.xml` está selecionado.
   - Clique em `Finish` para importar o projeto.

3. **Instalar Dependências**
   - O Eclipse, com Maven integrado, geralmente resolve e baixa as dependências automaticamente.
   - Para garantir que todas as dependências sejam instaladas, clique com o botão direito do mouse no projeto no Eclipse, vá em `Maven` e selecione `Update Project`. Marque a caixa `Force Update of Snapshots/Releases`.

### Execução

Para executar os testes usando o Maven dentro do Eclipse:

1. **Abrir o Terminal do Eclipse**
   - Abra o terminal integrado do Eclipse ou use o console.
   - Navegue até a raiz do projeto onde o arquivo `pom.xml` está localizado.

2. **Executar Testes**
   - Execute o seguinte comando no terminal:
     ```bash
     mvn clean test
     ```
   - Este comando limpa os artefatos de compilações anteriores e executa todos os testes no projeto. O Rest Assured é usado para realizar os testes de API definidos no código.

Os resultados dos testes serão exibidos no console do Eclipse, e qualquer saída configurada será mostrada lá, permitindo a você verificar os detalhes de execuções bem-sucedidas ou falhas nos testes.

## Plano de Teste e Estratégia de Testes

O projeto implementa uma abordagem de teste automatizado para validar a funcionalidade da API de gerenciamento de produtos, utilizando o framework Rest Assured com Java. Os testes estão projetados para garantir que a autenticação e autorização funcionem corretamente, assim como a lógica de negócio da API.

### Objetivos de Teste

Os testes implementados neste projeto têm como objetivo principal validar a funcionalidade e a segurança da API de gerenciamento de produtos eletrônicos, garantindo que as operações críticas atendam aos requisitos especificados e maneje adequadamente os cenários de erro.

- **Autenticação e Autorização**: Verificar se o sistema de segurança impede acessos não autorizados e permite acessos com credenciais válidas.
  - `deveObterListaDeProdutosComSucesso` verifica se usuários autenticados podem acessar os produtos.
  - `deveExibirMensagemDeNaoAutorizado` e `deveExibirMensagemDeProblemaNaAutenticacao` testam a resposta da API a tokens inválidos ou ausentes.

- **Integridade dos Dados**: Confirmar que a API gerencia corretamente os dados dos produtos, retornando as informações corretas e permitindo a modificação desses dados sob as condições certas.
  - `deveObterObjetoComTodosProdutosCadastrados` e `deveObterProdutoPorId` verificam se a API retorna os produtos corretos com todas as suas propriedades.
  - `deveAdicionarProdutoComSucesso` testa a capacidade da API de adicionar novos produtos ao sistema.

- **Gerenciamento de Erros**: Avaliar como a API responde a solicitações mal formadas ou a dados inesperados.
  - `deveExibirErroDeProdutoNaoEncontrado` verifica a resposta adequada quando um produto não existe.
  - `naoDeveGerarTokenSemUsername` e `naoDeveGerarTokenSemPassword` testam a robustez da autenticação tratando o caso de credenciais incompletas.

- **Performance e Confiabilidade**: Assegurar que a API responde dentro dos parâmetros aceitáveis de tempo e com a consistência esperada em diferentes condições de carga.
  - Todos os testes incluem verificações de status de resposta e log completo para análise detalhada em caso de falhas.

### Estratégias de Teste

- **Testes de Integração**: Executar chamadas para a API real para verificar a integração do sistema e o comportamento dos endpoints.
- **Validação de Respostas**: Checar se as respostas da API estão em conformidade com o esperado, incluindo códigos de status HTTP e payloads de resposta.

### Ferramentas de Teste

- **JUnit**: Utilizado para organizar e executar os casos de teste.
- **Rest Assured**: Empregado para fazer chamadas de API e validar as respostas utilizando a sintaxe fluente do Rest Assured.
- **Maven**: Gerencia as dependências do projeto e a execução dos testes.

## Bugs

### Problema Conhecido

**POST /products/add**:
- **Descrição**: O serviço está adicionando um produto com objeto vazio.
- **Impacto**: Isso pode levar à inserção de dados não intencionais no sistema, afetando a integridade dos dados de produtos.

## Melhorias

**POST /auth/login**:
- **Descrição**: A documentação da API especifica que o status code esperado para um login bem-sucedido deve ser 201, mas atualmente está retornando 200 conforme verificado no Postman.
- **Impacto**: Isso pode causar confusão na integração com clientes da API que esperam um status específico como parte do contrato da API.
- **Sugestão**: Revisar a implementação do endpoint para alinhar com a documentação da API ou atualizar a documentação para refletir o comportamento atual.
