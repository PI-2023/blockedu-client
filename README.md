# Microsserviço de Emissão de Certificados

Este é o microsserviço responsável pela emissão de certificados das instituições de ensino. Ele permite que as instituições cadastrem alunos, cursos e emitem certificados relacionados aos cursos concluídos pelos alunos. O microsserviço também integra-se com a blockchain para registrar os certificados de forma segura e imutável.

## Funcionalidades

- **Autenticação**: Permite que as instituições de ensino realizem autenticação no sistema para acessar as funcionalidades de emissão de certificados.
- **Cadastro de Alunos**: Permite o cadastro de novos alunos no sistema, fornecendo informações como nome, e-mail e número de identificação do aluno.
- **Cadastro de Cursos**: Permite o cadastro de novos cursos no sistema, informando o nome do curso, a carga horária e outros detalhes relevantes.
- **Emissão de Certificados**: Permite a emissão de certificados para os alunos que concluíram com sucesso um curso específico. O certificado contém informações sobre o aluno, o curso concluído e é assinado digitalmente para garantir sua autenticidade.
- **Integração com a Blockchain**: O microsserviço se integra com o microsserviço da blockchain para registrar os certificados emitidos de forma segura e imutável. Os certificados são armazenados na blockchain como transações em blocos, garantindo a rastreabilidade e a integridade dos dados.

## Configuração e Execução

Para executar o microsserviço de Emissão de Certificados, siga as instruções abaixo:

### Pré-requisitos

- Certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina.
- Verifique se todas as dependências necessárias estão instaladas corretamente.

### Configuração

- Configure as informações de conexão com a blockchain no arquivo de configuração correspondente.
- Verifique se as configurações do banco de dados estão corretas.

### Execução

- Execute o microsserviço de acordo com o ambiente de desenvolvimento escolhido.
- Certifique-se de que o serviço está sendo executado na porta correta.

### Testes

- Execute os testes unitários disponíveis para garantir o funcionamento correto das funcionalidades.
- Verifique se todas as funcionalidades do microsserviço estão operacionais.

## Atenção

Nota: Certifique-se de ter os microsserviços de Emissão de Certificados e de Blockchain configurados e em execução corretamente para garantir o funcionamento adequado do sistema como um todo.
