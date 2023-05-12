# Blockedu - Serviço de Emissão de Certificados em Blockchain

O Blockedu é um serviço de emissão de certificados em blockchain que permite às instituições de ensino emitirem certificados de forma segura, confiável e imutável. Ele utiliza a tecnologia de blockchain para garantir a integridade e autenticidade dos certificados emitidos, proporcionando transparência e rastreabilidade.

## Funcionalidades Principais

- **Emissão de Certificados**: Permite que as instituições de ensino emitam certificados para os alunos que concluíram com sucesso os cursos oferecidos.
- **Validação em Blockchain**: Integra-se a um microsserviço de blockchain para registrar os certificados emitidos como transações na cadeia de blocos, garantindo sua segurança e imutabilidade.
- **Cadastro de Alunos**: Permite o cadastro de alunos, incluindo informações como nome, e-mail e número de identificação.
- **Cadastro de Cursos**: Permite o cadastro de cursos oferecidos pelas instituições, incluindo informações como nome, carga horária e descrição.
- **Autenticação e Segurança**: Implementa um sistema de autenticação seguro para as instituições de ensino acessarem o serviço. Utiliza criptografia e assinaturas digitais para proteger os certificados e garantir sua autenticidade.

## Arquitetura do Sistema

O Blockedu é construído em uma arquitetura de microsserviços, composta pelos seguintes componentes:

1. **Microsserviço de Emissão de Certificados**: Responsável pela emissão dos certificados, cadastro de alunos e cursos, autenticação das instituições de ensino e integração com o microsserviço da blockchain.

2. **Microsserviço da Blockchain**: Gerencia a blockchain utilizada para registrar os certificados emitidos. Responsável pela criação de blocos, validação da cadeia, verificação de consenso e segurança das transações.

3. **Comunicação via Sockets**: Os microsserviços se comunicam por meio de sockets para trocar informações e realizar operações relacionadas à emissão e registro de certificados.

## Cronograma de Implementação

O desenvolvimento do Blockedu será realizado em um cronograma de quatro semanas, com as seguintes etapas:

1. **Semana 1**: Modelagem dos microsserviços
   - Revisar requisitos
   - Modelar microsserviço de emissão de certificados
   - Modelar microsserviço da blockchain
   - Definir escopo das funcionalidades

2. **Semana 2**: Implementação do microsserviço de Emissão de Certificados
   - Cadastro de alunos e cursos
   - Emissão de certificados
   - Testes Unitários
   - Integração com o microsserviço da blockchain

3. **Semana 3**: Implementação do microsserviço da Blockchain
   - Criação de blocos
   - Validação da cadeia
   - Verificação de consenso
   - Testes Unitários

4. **Semana 4**: Integração por Sockets e Testes
   - Implementação da comunicação via sockets
   - Integração dos microsserviços
   - Testes de integração
