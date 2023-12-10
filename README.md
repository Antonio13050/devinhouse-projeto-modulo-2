# Medication Management

O projeto proposto é um sistema de gerenciamento de medicamentos para uma rede de farmácias, denominado "Medication Management". O backend do sistema deve ser implementado em Java, utilizando o framework Spring Boot, e os dados devem ser armazenados em um banco de dados PostgreSQL.

## Problema Resolvido
A expansão da rede de farmácias DEVinPharmacy LTDA demanda um sistema eficiente para gerenciamento de medicamentos. O Medication Management visa atender a essa necessidade, permitindo o cadastro e gerenciamento de farmácias, medicamentos e seus estoques.

## Técnicas e Tecnologias Utilizadas
- **Linguagem de Programação:** Java
- **Framework:** Spring Boot (para construção de uma API REST)
- **Banco de Dados:** PostgreSQL
- **Técnicas:** JPA (Java Persistence API) para mapeamento objeto-relacional, validações de dados, manipulação de estoque, entre outros.

## Execução do Sistema
1. Clone o repositório do GitHub em um ambiente de desenvolvimento.
2. Configure a string de conexão do banco de dados PostgreSQL no arquivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/farmaciadb

## Serviços da API

### Carga Inicial de Dados (RF01)
- Endpoint: POST /inicializacao
- Descrição: Inicializa o sistema com dados padrão.

### Consulta de Farmácias (RF02)
- Endpoint: GET /farmacias
- Descrição: Retorna a lista de farmácias cadastradas.

### Consulta de Farmácia pelo CNPJ (RF03)
- Endpoint: GET /farmacias/{cnpj}
- Descrição: Retorna informações sobre uma farmácia específica com base no CNPJ.
  
### Inclusão de Farmácia (RF04)
- Endpoint: POST /farmacias
- Descrição: Adiciona uma nova farmácia ao sistema.

### Consulta de Medicamentos (RF05)
- Endpoint: GET /medicamentos
- Descrição: Serviço de consulta de todos os medicamentos cadastrados no sistema.

### Inclusão de Medicamento (RF06)
- Endpoint: POST /medicamentos
- Descrição: Serviço de cadastro de novo medicamento.

### Consulta de Estoque de Farmácia (RF07)
- Endpoint: GET /estoque/{cnpj}
- Descrição: Serviço de consulta do estoque de medicamentos de determinada farmácia.

### Aquisição de Medicamentos para Estoque de farmácia (RF08)
- Endpoint: POST /estoque
- Descrição: Serviço de inclusão de medicamentos no estoque da farmácia. Quando a farmácia faz a compra de medicamentos dos fornecedores, devem ser adicionadas as respectivas quantidades no estoque.

### Venda de Medicamentos com atualização do Estoque de farmácia (RF09)
- Endpoint: DELETE /estoque
- Descrição: Serviço de lançamento de venda de medicamentos com a devida atualização no estoque da farmácia. Quando a farmácia faz a venda de medicamentos aos clientes, devem ser reduzidas as respectivas quantidades no estoque.

### Troca de Medicamentos entre Estoques de Farmácias (RF10)
- Endpoint: PUT /estoque
- Descrição: Serviço para registrar a troca de medicamentos entre as farmácias, para equilibrar os estoques entre elas quando necessário. A troca de medicamento consiste na diminuição na quantidade de determinado medicamento da farmácia origem e adição desta quantidade na farmácia destino. O estoque de ambas devem ser atualizados e refletir a quantidade final após a troca.

## Melhorias Futuras
- Implementar autenticação e autorização.
- Adicionar testes automatizados.
