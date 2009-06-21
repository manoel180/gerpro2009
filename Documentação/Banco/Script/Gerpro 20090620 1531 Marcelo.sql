-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.51a-community-nt


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
-- Definition of table `artefatos`
--

DROP TABLE IF EXISTS `artefatos`;
CREATE TABLE `artefatos` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artefatos`
--

/*!40000 ALTER TABLE `artefatos` DISABLE KEYS */;
INSERT INTO `artefatos` (`id`,`nome`) VALUES 
 (1,'PESW'),
 (2,'Elaboração'),
 (3,'Relatório I'),
 (4,'Elaboração - Projeto DDSW'),
 (5,'Construção Implementação'),
 (6,'Elaboração - MUSW'),
 (7,'Relatório Final II'),
 (8,'Manual do Usuário'),
 (9,'Defesa Final II');
/*!40000 ALTER TABLE `artefatos` ENABLE KEYS */;


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
  `id_status_correcao` int(10) unsigned NOT NULL default '2',
  PRIMARY KEY  (`id_proposta`,`id_item`,`matricula_professor`,`id_pergunta`),
  KEY `id_pergunta` (`id_pergunta`),
  KEY `FK_correcao_3` (`resposta`),
  KEY `matricula_professor` (`matricula_professor`),
  KEY `FK_correcao_5` (`id_status_correcao`),
  CONSTRAINT `FK_correcao_1` FOREIGN KEY (`matricula_professor`) REFERENCES `usuario` (`matricula`),
  CONSTRAINT `FK_correcao_2` FOREIGN KEY (`id_proposta`, `id_item`) REFERENCES `proposta_item` (`id_proposta`, `id_item`),
  CONSTRAINT `FK_correcao_3` FOREIGN KEY (`resposta`) REFERENCES `resposta` (`id`),
  CONSTRAINT `FK_correcao_4` FOREIGN KEY (`id_pergunta`) REFERENCES `pergunta` (`id`),
  CONSTRAINT `FK_correcao_5` FOREIGN KEY (`id_status_correcao`) REFERENCES `status` (`id`)
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
  `data_inicial` date default NULL,
  `data_final` date default NULL,
  `numero_sequencia` int(11) NOT NULL auto_increment,
  `id_artefatos` int(10) unsigned NOT NULL,
  PRIMARY KEY  (`id_proposta`,`id_item`,`numero_sequencia`),
  KEY `Index_2` (`numero_sequencia`),
  KEY `FK_cronograma_2` (`id_artefatos`),
  CONSTRAINT `FK_cronograma_1` FOREIGN KEY (`id_proposta`, `id_item`) REFERENCES `proposta_item` (`id_proposta`, `id_item`),
  CONSTRAINT `FK_cronograma_2` FOREIGN KEY (`id_artefatos`) REFERENCES `artefatos` (`id`)
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipe`
--

/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
INSERT INTO `equipe` (`id`,`nome`) VALUES 
 (1,'m2r'),
 (2,'1'),
 (3,'2'),
 (7,'3'),
 (8,'4'),
 (9,'5'),
 (10,'6');
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;


--
-- Definition of table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`id`,`nome`) VALUES 
 (1,'Missão do Produto'),
 (2,'Lista de Função'),
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
  `numero_sequencia` int(11) NOT NULL default '1',
  `UC` varchar(100) default NULL,
  `descricao` text,
  `id_item` int(11) NOT NULL default '0',
  `id_tipo_funcao` tinyint(4) NOT NULL,
  PRIMARY KEY  (`id_proposta`,`numero_sequencia`,`id_item`),
  KEY `FK_lista_funcao_1` (`id_proposta`,`id_item`),
  KEY `Index_2` (`numero_sequencia`),
  KEY `FK_lista_funcao_2` (`id_tipo_funcao`),
  CONSTRAINT `FK_lista_funcao_1` FOREIGN KEY (`id_proposta`, `id_item`) REFERENCES `proposta_item` (`id_proposta`, `id_item`),
  CONSTRAINT `FK_lista_funcao_2` FOREIGN KEY (`id_tipo_funcao`) REFERENCES `tipo_funcao` (`id`)
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
  KEY `id_item` (`id_item`),
  CONSTRAINT `FK_pergunta_1` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

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
 (7,'Sistema pertencente ao grupo de trabalhos aceitos?',6),
 (8,'O cronograma apresenta datas coerentes?',5);
/*!40000 ALTER TABLE `pergunta` ENABLE KEYS */;


--
-- Definition of table `proposta`
--

DROP TABLE IF EXISTS `proposta`;
CREATE TABLE `proposta` (
  `id` int(11) NOT NULL auto_increment,
  `nome` varchar(100) NOT NULL,
  `id_status_proposta` int(10) unsigned NOT NULL default '1',
  `data_criacao` date NOT NULL,
  `data_submissao` date default NULL,
  `id_equipe` int(11) NOT NULL,
  `periodo` varchar(8) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `Proposta` (`periodo`,`id_equipe`),
  KEY `FK_proposta_2` (`id_equipe`),
  KEY `FK_proposta_1` (`id_status_proposta`),
  CONSTRAINT `FK_proposta_1` FOREIGN KEY (`id_status_proposta`) REFERENCES `status` (`id`),
  CONSTRAINT `FK_proposta_2` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proposta`
--

/*!40000 ALTER TABLE `proposta` DISABLE KEYS */;
INSERT INTO `proposta` (`id`,`nome`,`id_status_proposta`,`data_criacao`,`data_submissao`,`id_equipe`,`periodo`) VALUES 
 (4,'p1',4,'2009-06-09',NULL,1,'2009/01'),
 (5,'p2',4,'2009-06-09',NULL,2,'2009/01'),
 (6,'p3',5,'2009-06-09',NULL,3,'2009/01'),
 (9,'p4',3,'2009-06-09',NULL,7,'2009/01'),
 (10,'p5',3,'2009-06-09',NULL,8,'2009/01');
/*!40000 ALTER TABLE `proposta` ENABLE KEYS */;


--
-- Definition of table `proposta_item`
--

DROP TABLE IF EXISTS `proposta_item`;
CREATE TABLE `proposta_item` (
  `id_proposta` int(11) NOT NULL auto_increment,
  `id_item` int(11) NOT NULL default '0',
  `conteudo_item` text,
  `id_status_criacao` int(10) unsigned default NULL,
  PRIMARY KEY  (`id_proposta`,`id_item`),
  KEY `id_item` (`id_item`),
  KEY `Index_4` (`id_proposta`),
  KEY `FK_proposta_item_3` (`id_status_criacao`),
  CONSTRAINT `FK_proposta_item_3` FOREIGN KEY (`id_status_criacao`) REFERENCES `status` (`id`),
  CONSTRAINT `proposta_item_ibfk_1` FOREIGN KEY (`id_proposta`) REFERENCES `proposta` (`id`),
  CONSTRAINT `proposta_item_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proposta_item`
--

/*!40000 ALTER TABLE `proposta_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `proposta_item` ENABLE KEYS */;


--
-- Definition of table `resposta`
--

DROP TABLE IF EXISTS `resposta`;
CREATE TABLE `resposta` (
  `id` int(11) NOT NULL auto_increment,
  `descricao` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resposta`
--

/*!40000 ALTER TABLE `resposta` DISABLE KEYS */;
INSERT INTO `resposta` (`id`,`descricao`) VALUES 
 (1,'Sim'),
 (2,'Não');
/*!40000 ALTER TABLE `resposta` ENABLE KEYS */;


--
-- Definition of table `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

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
 (6,'Concluído'),
 (7,'Corrigido');
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

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
  `senha` varchar(32) NOT NULL default '202CB962AC59075B964B07152D234B70',
  PRIMARY KEY  (`matricula`),
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
 ('1','master',NULL,3,'202CB962AC59075B964B07152D234B70'),
 ('2','Manoel da Silva Neto',1,1,'202CB962AC59075B964B07152D234B70'),
 ('3','prof',NULL,2,'202CB962AC59075B964B07152D234B70');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
