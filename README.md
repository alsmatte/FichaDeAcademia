# FichaDeAcademia - Ficha de Academia Online
Projeto Integrador do Módulo III do Curso Técnico de Desenvolvimento de Sistemas do SENAC EAD.

## Apresentação

O projeto web em questão será uma ficha de academia online, onde pode-se adicionar “treinos” e indicar as informações necessárias sobre estes (máquinas, pesos, séries, repetições, observações).

**Status**: Em desenvolvimento.

### Tecnologias aplicadas:

Aplicação seguindo o padrão **Spring MVC**, programada em linguagem **Java** e **JavaScript**, desenvolvida usando **NetBeans** e banco de dados em linguagem **SQL** desenvolvido usando o **MySQL**. 

**Time de desenvolvedores**: Alexandra Matte.

---

## Descrição dos objetivos:

O projeto deve permitir:

1. Que o usuário crie “treinos”, onde ele informa o nome do treino, o que ele está treinando (perna, braço, costas...) e quantas vezes na semana ele deve ser feito. Deve haver a opção de informar quais dias na semana ele deve ser feito (não obrigatória).
2. O usuário deve poder adicionar exercícios em um treino, informando o nome do exercício/máquina, os pesos a serem utilizados nestes, quantidade de séries, quantidade de repetições em uma série e observações (opcional). 
3. Os treinos criados devem ser mostrados em uma lista na página de treinos.
4. Os exercícios de um treino devem ser mostrados em uma lista que pode ser acessada ao clicar sobre o treino em questão na lista da página de treinos. 
5. O usuário deve poder editar os treinos para alterar os dados inseridos anteriormente. 
6. O usuário deve poder editar os exercícios para alterar os dados inseridos anteriormente. 
7. O usuário deve poder excluir um treino.
8. O usuário deve poder excluir um exercício.

---

## Páginas:

1. **Página inicial (homepage)**: É a partir dela que se acessa a página de treinos.
2. **Página de treinos**: Contém a lista de todos os treinos criados, mostrada em uma tabela. Cada linha da tabela representa um treino e traz os dados sobre ele, além de três botões:
   - O botão 1 leva à página de detalhes do treino.
   - O botão 2 leva à página de atualização de treino.
   - O botão 3 exclui o treino em questão.
   - Além disso, há o botão “adicionar treino”, que leva à página de criação de treino.
3. **Página de detalhes**: Traz as informações do treino juntamente com uma lista de todos os exercícios incluídos nesse treino. A lista é mostrada em uma tabela, com botões de **atualizar** (que leva à página de atualização de exercício) e **excluir** (que deleta o exercício). Há também o botão “adicionar exercício” que leva à página de criação de exercício. 
4. **Página de adicionar treino**: Traz um formulário vazio com campos “nome”, “tipo de treino”, “vezes na semana” e um botão “adicionar”, que leva de volta à página de treinos em caso de sucesso.
5. **Página de atualizar treino**: Traz o mesmo formulário da página de adicionar treino, porém com os campos já preenchidos com as informações atuais do treino. O botão deve dizer “atualizar” ao invés de “adicionar”, e também leva de volta à página de treinos em caso de sucesso.
6. **Página de adicionar exercício**: Traz um formulário com campos “nome do exercício/máquina”, “peso”, “número de séries”, “número de repetições” e “observações”, além de um botão “adicionar” que retorna à página de detalhes em caso de sucesso.
7. **Página de atualizar exercício**: Traz o mesmo formulário da página de adicionar exercício, porém com os campos já preenchidos com as informações atuais do exercício. O botão deve dizer “atualizar” ao invés de “adicionar”, que também leva de volta à página de detalhes em caso de sucesso.

---

## Necessidades observadas/regras de negócio

Por motivos de organização, os treinos que tiverem a informação opcional de dia da semana devem aparecer com uma cor diferente na tabela. Cada dia da semana tem uma cor específica. Treinos que ocorrem no mesmo dia da semana devem ser pintados da mesma cor. Treinos que não possuem essa informação têm cor padrão.

---

## Funcionalidades do sistema:

### Requisitos funcionais

- **[RF001]** Adicionar novo treino  
  **Ator**: Usuário  
  **Descrição**: Informar o nome do treino, o que ele está treinando (perna, braço, costas...) e quantas vezes na semana ele deve ser feito. Informar dias da semana se desejar.

- **[RF002]** Editar treinos desejados  
  **Ator**: Usuário  
  **Descrição**: Editar as informações de um treino já existente, caso necessário.

- **[RF003]** Excluir treinos desejados  
  **Ator**: Usuário  
  **Descrição**: Excluir as informações de um treino já existente, caso necessário.

- **[RF004]** Adicionar novo exercício ao treino  
  **Ator**: Usuário  
  **Descrição**: Em um treino, informar o nome do exercício/máquina, os pesos a serem utilizados nestes, quantidade de séries, quantidade de repetições em uma série e observações, caso haja alguma.

- **[RF005]** Editar exercícios desejados  
  **Ator**: Usuário  
  **Descrição**: Editar as informações de um exercício já existente, caso necessário.

- **[RF006]** Excluir exercícios desejados  
  **Ator**: Usuário  
  **Descrição**: Excluir as informações de um exercício já existente, caso necessário.

- **[RF007]** Trazer a lista de treinos ao carregar a página de treinos  
  **Ator**: Aplicação web  
  **Descrição**: Quando a página de treinos for acessada, a aplicação deve automaticamente buscar a lista de treinos e preencher a tabela com os dados.

- **[RF008]** Trazer a lista de exercícios ao carregar a página de detalhes  
  **Ator**: Aplicação web  
  **Descrição**: Quando a página de detalhes for acessada, a aplicação deve automaticamente buscar a lista de exercícios e preencher a tabela com os dados.

---

### Requisitos não funcionais

- **[RNF001]** Deve rodar nos principais navegadores  
  **Descrição**: A aplicação deve rodar em navegadores como Chrome e Firefox.

- **[RNF002]** Banco de dados relacional  
  **Descrição**: O banco de dados deve ser relacional.

- **[RNF003]** Aplicação Web  
  **Descrição**: Deve funcionar com a máquina conectada à internet.

- **[RNF004]** Spring MVC com back-end em Java  
  **Descrição**: Back-end deve ser programado em Java e seguir o padrão **MODEL-VIEW-CONTROLLER**.

