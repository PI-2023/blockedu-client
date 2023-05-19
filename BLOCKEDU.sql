-- Criação da tabela Instituição de Ensino
CREATE TABLE InstituicaoEnsino (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  chave_privada TEXT NOT NULL,
  chave_publica TEXT NOT NULL,
  codigo_acesso CHAR(8) NOT NULL
);

-- Criação da tabela Aluno
CREATE TABLE Aluno (
  id INT PRIMARY KEY AUTO_INCREMENT,
  instituicao_id INT NOT NULL,
  cpf CHAR(11) NOT NULL UNIQUE,
  nome VARCHAR(255) NOT NULL,
  email VARCHAR(255) NOT NULL,
  data_nascimento DATE NOT NULL,
  telefone_celular CHAR(11) NOT NULL,
  FOREIGN KEY (instituicao_id) REFERENCES InstituicaoEnsino(id)
);

-- Criação da tabela Curso
CREATE TABLE Curso (
  id INT PRIMARY KEY AUTO_INCREMENT,
  instituicao_id INT NOT NULL,
  nome VARCHAR(255) NOT NULL,
  descricao TEXT NOT NULL,
  carga_horaria INT NOT NULL,
  FOREIGN KEY (instituicao_id) REFERENCES InstituicaoEnsino(id)
);

-- Criação da tabela Certificado
CREATE TABLE Certificado (
  id INT PRIMARY KEY AUTO_INCREMENT,
  aluno_id INT NOT NULL,
  curso_id INT NOT NULL,
  instituicao_id INT NOT NULL,
  data_emissao DATE NOT NULL,
  assinatura TEXT NOT NULL,
  informacoes_adicionais TEXT,
  FOREIGN KEY (aluno_id) REFERENCES Aluno(id),
  FOREIGN KEY (curso_id) REFERENCES Curso(id),
  FOREIGN KEY (instituicao_id) REFERENCES InstituicaoEnsino(id)
);
