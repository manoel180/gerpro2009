-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.24a-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema gerprodb
--

CREATE DATABASE IF NOT EXISTS gerprodb;
USE gerprodb;

--
-- Definition of table `correcao`
--

DROP TABLE IF EXISTS `correcao`;
CREATE TABLE `correcao` (
  `id_proposta` int(11) NOT NULL default '0',
  `id_item` int(11) NOT NULL default '0',
  `matricula_professor` varchar(8) NOT NULL,
  `id_pergunta` int(11) NOT NULL default '0',
  `observacao` text,
  `data_correcao` date default NULL,
  `resposta` int(11) default NULL,
  PRIMARY KEY  USING BTREE (`id_proposta`,`id_item`,`matricula_professor`,`id_pergunta`),
  KEY `id_pergunta` USING BTREE (`id_pergunta`),
  KEY `FK_correcao_3` (`resposta`),
  KEY `matricula_professor` USING BTREE (`matricula_professor`),
  CONSTRAINT `FK_correcao_1` FOREIGN KEY (`matricula_professor`) REFERENCES `usuario` (`matricula`),
  CONSTRAINT `FK_correcao_2` FOREIGN KEY (`id_proposta`, `id_item`) REFERENCES `proposta_item` (`id_proposta`, `id_item`),
  CONSTRAINT `FK_correcao_3` FOREIGN KEY (`resposta`) REFERENCES `resposta` (`id`),
  CONSTRAINT `FK_correcao_4` FOREIGN KEY (`id_pergunta`) REFERENCES `pergunta` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `correcao`
--

/*!40000 ALTER TABLE `correcao` DISABLE KEYS */;
/*!40000 ALTER TABLE `correcao` ENABLE KEYS */;


--
-- Definition of table `cronograma`
--

DROP TABLE IF EXISTS `cronograma`;
CREATE TABLE `cronograma` (
  `id_proposta` int(11) NOT NULL,
  `id_item` int(11) NOT NULL,
  `nome_item` varchar(30) NOT NULL,
  `data_inicial` date default NULL,
  `data_final` date default NULL,
  `numero_sequencia` int(11) NOT NULL auto_increment,
  PRIMARY KEY  USING BTREE (`id_proposta`,`id_item`,`numero_sequencia`),
  KEY `Index_2` (`numero_sequencia`),
  CONSTRAINT `FK_cronograma_1` FOREIGN KEY (`id_proposta`, `id_item`) REFERENCES `proposta_item` (`id_proposta`, `id_item`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cronograma`
--

/*!40000 ALTER TABLE `cronograma` DISABLE KEYS */;
/*!40000 ALTER TABLE `cronograma` ENABLE KEYS */;


--
-- Definition of table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
CREATE TABLE `equipe` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipe`
--

/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` (`id`,`nome`) VALUES 
 (1,'M2R'),
 (2,'TESTE2'),
 (6,'Teste101');
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;


--
-- Definition of table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`id`,`nome`) VALUES 
 (1,'Missão do Produto'),
 (2,'Lista de Funções'),
 (3,'Justificativa'),
 (4,'Metodologia'),
 (5,'Cronograma'),
 (6,'Avaliação Geral');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


--
-- Definition of table `lista_funcao`
--

DROP TABLE IF EXISTS `lista_funcao`;
CREATE TABLE `lista_funcao` (
  `id_proposta` int(11) NOT NULL,
  `numero_sequencia` int(11) NOT NULL auto_increment,
  `UC` varchar(50) default NULL,
  `descricao` text,
  `id_item` int(11) NOT NULL default '0',
  `Id_tipo_funcao` tinyint(4) NOT NULL,
  PRIMARY KEY  USING BTREE (`id_proposta`,`numero_sequencia`,`id_item`),
  KEY `FK_lista_funcao_1` (`id_proposta`,`id_item`),
  KEY `Index_2` USING BTREE (`numero_sequencia`),
  KEY `FK_lista_funcao_2` (`Id_tipo_funcao`),
  CONSTRAINT `FK_lista_funcao_1` FOREIGN KEY (`id_proposta`, `id_item`) REFERENCES `proposta_item` (`id_proposta`, `id_item`),
  CONSTRAINT `FK_lista_funcao_2` FOREIGN KEY (`Id_tipo_funcao`) REFERENCES `tipo_funcao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lista_funcao`
--

/*!40000 ALTER TABLE `lista_funcao` DISABLE KEYS */;
/*!40000 ALTER TABLE `lista_funcao` ENABLE KEYS */;


--
-- Definition of table `pergunta`
--

DROP TABLE IF EXISTS `pergunta`;
CREATE TABLE `pergunta` (
  `id` int(11) NOT NULL auto_increment,
  `descricao` varchar(255) default NULL,
  `id_item` int(11) default NULL,
  PRIMARY KEY  (`id`),
  KEY `id_item` USING BTREE (`id_item`),
  CONSTRAINT `FK_pergunta_1` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pergunta`
--

/*!40000 ALTER TABLE `pergunta` DISABLE KEYS */;
INSERT INTO `pergunta` (`id`,`descricao`,`id_item`) VALUES 
 (1,'Apresentação e estilo (bem organizado, claro, correção gramatical e ortográfica), coesão e coerência textual?',6),
 (2,'Trabalho de acordo com os padrões de escrita definidos?',6),
 (3,'Justificativa clara, com texto bem organizado e, enfatizando a relevância e a  problemática que implica na necessidade do desenvolvimento do Sistema?',3),
 (4,'Missão do produto de acordo com a abrangência do sistema?',1),
 (5,'Lista de Funções bem definidas, demonstrando, no mínimo, 7 (sete) requisitos do sistema (entrada, processamento e saída). Sendo pelo menos 3 de processamento?',2),
 (6,'Metodologia coerente com os objetivos definidos e adequada abrangência do tema?',4),
 (7,'Sistema pertencente ao grupo de trabalhos aceitos?',6);
/*!40000 ALTER TABLE `pergunta` ENABLE KEYS */;


--
-- Definition of table `proposta`
--

DROP TABLE IF EXISTS `proposta`;
CREATE TABLE `proposta` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(100) NOT NULL,
  `id_status` int(10) unsigned NOT NULL,
  `data_criacao` varchar(10) NOT NULL,
  `data_submissao` varchar(10) NOT NULL,
  `id_equipe` int(11) NOT NULL,
  `periodo` varchar(8) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_proposta_1` (`id_status`),
  KEY `FK_proposta_2` (`id_equipe`),
  CONSTRAINT `FK_proposta_1` FOREIGN KEY (`id_status`) REFERENCES `status` (`id`),
  CONSTRAINT `FK_proposta_2` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proposta`
--

/*!40000 ALTER TABLE `proposta` DISABLE KEYS */;
INSERT INTO `proposta` (`id`,`nome`,`id_status`,`data_criacao`,`data_submissao`,`id_equipe`,`periodo`) VALUES 
 (1,'GerPro - Sistema de Geração e Apoio à Correção de PESw',1,'2008-01-01','0000-00-00',1,''),
 (2,'Teste 2 - Sistema de Teste do Gerpro',1,'2008-01-02','0000-00-00',2,'');
/*!40000 ALTER TABLE `proposta` ENABLE KEYS */;


--
-- Definition of table `proposta_item`
--

DROP TABLE IF EXISTS `proposta_item`;
CREATE TABLE `proposta_item` (
  `id_proposta` int(11) NOT NULL auto_increment,
  `id_item` int(11) NOT NULL default '0',
  `conteudo_item` text,
  `id_status` int(10) unsigned default NULL,
  PRIMARY KEY  (`id_proposta`,`id_item`),
  KEY `id_item` (`id_item`),
  KEY `FK_proposta_item_3` (`id_status`),
  KEY `Index_4` (`id_proposta`),
  CONSTRAINT `FK_proposta_item_3` FOREIGN KEY (`id_status`) REFERENCES `status` (`id`),
  CONSTRAINT `proposta_item_ibfk_1` FOREIGN KEY (`id_proposta`) REFERENCES `proposta` (`id`),
  CONSTRAINT `proposta_item_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proposta_item`
--

/*!40000 ALTER TABLE `proposta_item` DISABLE KEYS */;
INSERT INTO `proposta_item` (`id_proposta`,`id_item`,`conteudo_item`,`id_status`) VALUES 
 (1,1,'Agilizar o processo de criação de propostas pelos alunos e apoiar a correção das mesmas pelos professores.',1),
 (1,3,'          O TCC realizado hoje no Centro Universitário do Norte no curso de Tecnologia em Desenvolvimento de Software possui o mesmo processo desde o ano de 1996, quando o curso era ainda chamado de Tecnologia em Processamento de Dados e atravessou várias mudanças em seus documentos, critérios e métodos de avaliação.\r\n          Dentre os vários documentos que são avaliados existe o PESw – Proposta de Especificação de Software, que é o objeto inicial de um projeto de software, elaborado pelos alunos finalistas de curso e tem como objetivo a aprovação do corpo docente para o início do projeto de desenvolvimento de um software, o qual requer um cuidado minucioso na sua elaboração. Este documento causa vários transtornos tanto para o aluno, que em sua elaboração deixa muitas vezes à desejar na questão de formatação do documento, quanto para o professor que utiliza um excessivo tempo para a correção, por esta ainda ser feita manualmente, atrasando assim a entrega  e lançamento de notas das propostas.\r\n         Um agravante para essa situação é a grande quantidade de propostas, seus vários modelos e os conjuntos de critérios que devem ser analisados em cada um, fazendo com que a correção seja tarefa mais árdua para os professores que constituem as bancas de aprovação de projeto. Outros fatores que ocasionalmente ocorrem são os erros no cálculo de notas e a discrepância entre notas lançadas por dois ou mais professores para o mesmo trabalho, gerando dúvidas sobre a correção do mesmo. \r\n          Assim sendo, a automação parcial do processo de PESw será de grande auxílio aos professores e conseqüentemente aos alunos que disporão de uma ferramenta de apoio para cálculo de notas, formatação da proposta com base nos padrões exigidos e o comparativos de nota, função esta que informará ao professor se existe uma grande diferença entre a sua nota e as notas já lançadas por outros professore para o mesma proposta.\r\n.',1),
 (1,4,'     O levantamento de requisitos será realizado através de entrevista com pessoas envolvidas no processo da instituição, de modo a identificar os problemas do mundo real e levantar todas as informações necessárias para o desenvolvimento de um sistema, e com esses requisitos apresentar as possíveis soluções que resolvam os problemas descritos.\r\n            O processo de desenvolvimento de software será baseado no Praxis e para criação dos diagramas de análise e modelagem da UML , será feito o uso da ferramenta JUDE comunity 3.1.1. .	O projeto será baseando na tecnologia WEB e para ambiente de programação serão utilizados as IDEs NetBeans e Eclipse  utilizando a linguagem Java 2. Java foi escolhida por ser uma linguagem de programação orientada a objeto (POO) e ser uma linguagem adotado pelo instituição. \r\n        Para a parte de persistência de dados será utilizado o Sistema de Gerenciamento de Banco de Dados SGBD MySQL e como servidor WEB o Apache TomCat.\r\n',1);
/*!40000 ALTER TABLE `proposta_item` ENABLE KEYS */;


--
-- Definition of table `resposta`
--

DROP TABLE IF EXISTS `resposta`;
CREATE TABLE `resposta` (
  `id` int(11) NOT NULL auto_increment,
  `descricao` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resposta`
--

/*!40000 ALTER TABLE `resposta` DISABLE KEYS */;
INSERT INTO `resposta` (`id`,`descricao`) VALUES 
 (1,'SIM'),
 (2,'NÃO');
/*!40000 ALTER TABLE `resposta` ENABLE KEYS */;


--
-- Definition of table `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status`
--

/*!40000 ALTER TABLE `status` DISABLE KEYS */;
INSERT INTO `status` (`id`,`nome`) VALUES 
 (1,'Em construção'),
 (2,'Em correção'),
 (3,'Aprovado'),
 (4,'Aprovado com ressalvas'),
 (5,'Reprovado'),
 (6,'Concluído');
/*!40000 ALTER TABLE `status` ENABLE KEYS */;


--
-- Definition of table `tipo_funcao`
--

DROP TABLE IF EXISTS `tipo_funcao`;
CREATE TABLE `tipo_funcao` (
  `id` tinyint(4) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `abreviatura` char(1) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_funcao`
--

/*!40000 ALTER TABLE `tipo_funcao` DISABLE KEYS */;
INSERT INTO `tipo_funcao` (`id`,`nome`,`abreviatura`) VALUES 
 (1,'Manter','M'),
 (2,'Processamento','P'),
 (3,'Relatório','R');
/*!40000 ALTER TABLE `tipo_funcao` ENABLE KEYS */;


--
-- Definition of table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
CREATE TABLE `tipo_usuario` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `Index_1` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_usuario`
--

/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
INSERT INTO `tipo_usuario` (`id`,`nome`) VALUES 
 (1,'Aluno'),
 (2,'Professor'),
 (3,'Coordenador');
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `matricula` varchar(8) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `id_equipe` int(11) default NULL,
  `id_tipo` int(11) NOT NULL,
  `senha` varchar(10) NOT NULL,
  PRIMARY KEY  USING BTREE (`matricula`),
  KEY `FK_usuario_1` (`id_equipe`),
  KEY `FK_usuario_3` (`id_tipo`),
  CONSTRAINT `FK_usuario_1` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id`),
  CONSTRAINT `FK_usuario_3` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` (`matricula`,`nome`,`id_equipe`,`id_tipo`,`senha`) VALUES 
 ('0','teste',NULL,3,'0'),
 ('00000000','ÁUREA MELO',NULL,2,''),
 ('06057217','RILMAR GOMES',1,1,''),
 ('06139981','MARCELO DE SOUZA',1,1,'281075'),
 ('06142508','MANFRINE SILVA SANTOS',1,1,'');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
