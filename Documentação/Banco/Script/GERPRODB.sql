-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.34-community


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
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `artefatos`
--

/*!40000 ALTER TABLE `artefatos` DISABLE KEYS */;
SET AUTOCOMMIT=0;
INSERT INTO `artefatos` (`id`,`nome`) VALUES 
 (1,'Elaboração'),
 (2,'Relatório I'),
 (3,'Elaboração - Projeto DDSW'),
 (4,'Construção Implementação'),
 (5,'Elaboração - MUSW'),
 (6,'Relatório Final II'),
 (7,'Manual do Usuário'),
 (8,'Defesa Final II');
COMMIT;
/*!40000 ALTER TABLE `artefatos` ENABLE KEYS */;


--
-- Definition of table `correcao`
--

DROP TABLE IF EXISTS `correcao`;
CREATE TABLE `correcao` (
  `id_proposta` int(11) NOT NULL DEFAULT '0',
  `id_item` int(11) NOT NULL DEFAULT '0',
  `matricula_professor` varchar(8) NOT NULL,
  `id_pergunta` int(11) NOT NULL DEFAULT '0',
  `observacao` text,
  `data_correcao` date DEFAULT NULL,
  `resposta` int(11) DEFAULT NULL,
  `id_status_correcao` int(10) unsigned NOT NULL DEFAULT '2',
  PRIMARY KEY (`id_proposta`,`id_item`,`matricula_professor`,`id_pergunta`) USING BTREE,
  KEY `id_pergunta` (`id_pergunta`) USING BTREE,
  KEY `FK_correcao_3` (`resposta`),
  KEY `matricula_professor` (`matricula_professor`) USING BTREE,
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
SET AUTOCOMMIT=0;
COMMIT;
/*!40000 ALTER TABLE `correcao` ENABLE KEYS */;


--
-- Definition of table `cronograma`
--

DROP TABLE IF EXISTS `cronograma`;
CREATE TABLE `cronograma` (
  `id_proposta` int(11) NOT NULL,
  `id_item` int(11) NOT NULL,
  `data_inicial` date DEFAULT NULL,
  `data_final` date DEFAULT NULL,
  `numero_sequencia` int(11) NOT NULL AUTO_INCREMENT,
  `id_artefatos` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_proposta`,`id_item`,`numero_sequencia`),
  KEY `Index_2` (`numero_sequencia`),
  KEY `FK_cronograma_2` (`id_artefatos`),
  CONSTRAINT `FK_cronograma_1` FOREIGN KEY (`id_proposta`, `id_item`) REFERENCES `proposta_item` (`id_proposta`, `id_item`),
  CONSTRAINT `FK_cronograma_2` FOREIGN KEY (`id_artefatos`) REFERENCES `artefatos` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cronograma`
--

/*!40000 ALTER TABLE `cronograma` DISABLE KEYS */;
SET AUTOCOMMIT=0;
COMMIT;
/*!40000 ALTER TABLE `cronograma` ENABLE KEYS */;


--
-- Definition of table `equipe`
--

DROP TABLE IF EXISTS `equipe`;
CREATE TABLE `equipe` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Index_2` (`nome`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `equipe`
--

/*!40000 ALTER TABLE `equipe` DISABLE KEYS */;
SET AUTOCOMMIT=0;
COMMIT;
/*!40000 ALTER TABLE `equipe` ENABLE KEYS */;


--
-- Definition of table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
SET AUTOCOMMIT=0;
INSERT INTO `item` (`id`,`nome`) VALUES 
 (1,'Missão do Produto'),
 (2,'Lista de Funções'),
 (3,'Justificativa'),
 (4,'Metodologia'),
 (5,'Cronograma'),
 (6,'Avaliação Geral');
COMMIT;
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


--
-- Definition of table `lista_funcao`
--

DROP TABLE IF EXISTS `lista_funcao`;
CREATE TABLE `lista_funcao` (
  `id_proposta` int(11) NOT NULL,
  `numero_sequencia` int(11) NOT NULL DEFAULT '1',
  `UC` varchar(100) DEFAULT NULL,
  `descricao` text,
  `id_item` int(11) NOT NULL DEFAULT '0',
  `Id_tipo_funcao` tinyint(4) NOT NULL,
  PRIMARY KEY (`id_proposta`,`numero_sequencia`,`id_item`) USING BTREE,
  KEY `FK_lista_funcao_1` (`id_proposta`,`id_item`),
  KEY `Index_2` (`numero_sequencia`) USING BTREE,
  KEY `FK_lista_funcao_2` (`Id_tipo_funcao`),
  CONSTRAINT `FK_lista_funcao_1` FOREIGN KEY (`id_proposta`, `id_item`) REFERENCES `proposta_item` (`id_proposta`, `id_item`),
  CONSTRAINT `FK_lista_funcao_2` FOREIGN KEY (`Id_tipo_funcao`) REFERENCES `tipo_funcao` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `lista_funcao`
--

/*!40000 ALTER TABLE `lista_funcao` DISABLE KEYS */;
SET AUTOCOMMIT=0;
COMMIT;
/*!40000 ALTER TABLE `lista_funcao` ENABLE KEYS */;


--
-- Definition of table `pergunta`
--

DROP TABLE IF EXISTS `pergunta`;
CREATE TABLE `pergunta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(255) DEFAULT NULL,
  `id_item` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `id_item` (`id_item`) USING BTREE,
  CONSTRAINT `FK_pergunta_1` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `pergunta`
--

/*!40000 ALTER TABLE `pergunta` DISABLE KEYS */;
SET AUTOCOMMIT=0;
INSERT INTO `pergunta` (`id`,`descricao`,`id_item`) VALUES 
 (1,'Apresentação e estilo (bem organizado, claro, correção gramatical e ortográfica), coesão e coerência textual?',6),
 (2,'Trabalho de acordo com os padrões de escrita definidos?',6),
 (3,'Justificativa clara, com texto bem organizado e, enfatizando a relevância e a  problemática que implica na necessidade do desenvolvimento do Sistema?',3),
 (4,'Missão do produto de acordo com a abrangência do sistema?',1),
 (5,'Lista de Funções bem definidas, demonstrando, no mínimo, 7 (sete) requisitos do sistema (entrada, processamento e saída). Sendo pelo menos 3 de processamento?',2),
 (6,'Metodologia coerente com os objetivos definidos e adequada abrangência do tema?',4),
 (7,'Sistema pertencente ao grupo de trabalhos aceitos?',6),
 (8,'As datas estão coesas?',5);
COMMIT;
/*!40000 ALTER TABLE `pergunta` ENABLE KEYS */;


--
-- Definition of table `proposta`
--

DROP TABLE IF EXISTS `proposta`;
CREATE TABLE `proposta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `id_status_proposta` int(10) unsigned NOT NULL DEFAULT '1',
  `data_criacao` date NOT NULL,
  `data_submissao` date DEFAULT NULL,
  `id_equipe` int(11) NOT NULL,
  `periodo` varchar(8) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Proposta` (`periodo`,`id_equipe`) USING BTREE,
  KEY `FK_proposta_2` (`id_equipe`),
  KEY `FK_proposta_1` (`id_status_proposta`) USING BTREE,
  CONSTRAINT `FK_proposta_1` FOREIGN KEY (`id_status_proposta`) REFERENCES `status` (`id`),
  CONSTRAINT `FK_proposta_2` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proposta`
--

/*!40000 ALTER TABLE `proposta` DISABLE KEYS */;
SET AUTOCOMMIT=0;
COMMIT;
/*!40000 ALTER TABLE `proposta` ENABLE KEYS */;


--
-- Definition of table `proposta_item`
--

DROP TABLE IF EXISTS `proposta_item`;
CREATE TABLE `proposta_item` (
  `id_proposta` int(11) NOT NULL AUTO_INCREMENT,
  `id_item` int(11) NOT NULL DEFAULT '0',
  `conteudo_item` text,
  `id_status_criacao` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id_proposta`,`id_item`),
  KEY `id_item` (`id_item`),
  KEY `Index_4` (`id_proposta`),
  KEY `FK_proposta_item_3` (`id_status_criacao`) USING BTREE,
  CONSTRAINT `FK_proposta_item_3` FOREIGN KEY (`id_status_criacao`) REFERENCES `status` (`id`),
  CONSTRAINT `proposta_item_ibfk_1` FOREIGN KEY (`id_proposta`) REFERENCES `proposta` (`id`),
  CONSTRAINT `proposta_item_ibfk_2` FOREIGN KEY (`id_item`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `proposta_item`
--

/*!40000 ALTER TABLE `proposta_item` DISABLE KEYS */;
SET AUTOCOMMIT=0;
COMMIT;
/*!40000 ALTER TABLE `proposta_item` ENABLE KEYS */;


--
-- Definition of table `resposta`
--

DROP TABLE IF EXISTS `resposta`;
CREATE TABLE `resposta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `resposta`
--

/*!40000 ALTER TABLE `resposta` DISABLE KEYS */;
SET AUTOCOMMIT=0;
INSERT INTO `resposta` (`id`,`descricao`) VALUES 
 (1,'SIM'),
 (2,'NÃO');
COMMIT;
/*!40000 ALTER TABLE `resposta` ENABLE KEYS */;


--
-- Definition of table `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE `status` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status`
--

/*!40000 ALTER TABLE `status` DISABLE KEYS */;
SET AUTOCOMMIT=0;
INSERT INTO `status` (`id`,`nome`) VALUES 
 (1,'Em construção'),
 (2,'Em correção'),
 (3,'Aprovado'),
 (4,'Aprovado com ressalvas'),
 (5,'Reprovado'),
 (6,'Concluído'),
 (7,'Corrigido');
COMMIT;
/*!40000 ALTER TABLE `status` ENABLE KEYS */;


--
-- Definition of table `tipo_funcao`
--

DROP TABLE IF EXISTS `tipo_funcao`;
CREATE TABLE `tipo_funcao` (
  `id` tinyint(4) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `abreviatura` char(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_funcao`
--

/*!40000 ALTER TABLE `tipo_funcao` DISABLE KEYS */;
SET AUTOCOMMIT=0;
INSERT INTO `tipo_funcao` (`id`,`nome`,`abreviatura`) VALUES 
 (1,'Manter','M'),
 (2,'Processamento','P'),
 (3,'Relatório','R');
COMMIT;
/*!40000 ALTER TABLE `tipo_funcao` ENABLE KEYS */;


--
-- Definition of table `tipo_usuario`
--

DROP TABLE IF EXISTS `tipo_usuario`;
CREATE TABLE `tipo_usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `Index_1` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tipo_usuario`
--

/*!40000 ALTER TABLE `tipo_usuario` DISABLE KEYS */;
SET AUTOCOMMIT=0;
INSERT INTO `tipo_usuario` (`id`,`nome`) VALUES 
 (1,'Aluno'),
 (2,'Professor'),
 (3,'Coordenador');
COMMIT;
/*!40000 ALTER TABLE `tipo_usuario` ENABLE KEYS */;


--
-- Definition of table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
CREATE TABLE `usuario` (
  `matricula` varchar(8) NOT NULL,
  `nome` varchar(80) NOT NULL,
  `id_equipe` int(11) DEFAULT NULL,
  `id_tipo` int(11) NOT NULL,
  `senha` varchar(33) NOT NULL DEFAULT '202CB962AC59075B964B07152D234B70',
  PRIMARY KEY (`matricula`) USING BTREE,
  KEY `FK_usuario_1` (`id_equipe`),
  KEY `FK_usuario_3` (`id_tipo`),
  CONSTRAINT `FK_usuario_1` FOREIGN KEY (`id_equipe`) REFERENCES `equipe` (`id`),
  CONSTRAINT `FK_usuario_3` FOREIGN KEY (`id_tipo`) REFERENCES `tipo_usuario` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usuario`
--

/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
SET AUTOCOMMIT=0;
INSERT INTO `usuario` (`matricula`,`nome`,`id_equipe`,`id_tipo`,`senha`) VALUES 
 ('1','admin',NULL,3,'21232F297A57A5A743894A0E4A801FC3');
COMMIT;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
