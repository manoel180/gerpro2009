DROP TABLE IF EXISTS `gerprodb`.`cronograma`;
CREATE TABLE  `gerprodb`.`cronograma` (
  `id_proposta` int(11) NOT NULL,
  `id_item` int(11) NOT NULL,
  `data_inicial` date DEFAULT NULL,
  `data_final` date DEFAULT NULL,
  `numero_sequencia` int(11) NOT NULL AUTO_INCREMENT,
  `id_artefatos` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id_proposta`,`id_item`,`numero_sequencia`) USING BTREE,
  KEY `Index_2` (`numero_sequencia`),
  KEY `FK_cronograma_2` (`id_artefatos`),
  CONSTRAINT `FK_cronograma_2` FOREIGN KEY (`id_artefatos`) REFERENCES `artefatos` (`id`),
  CONSTRAINT `FK_cronograma_1` FOREIGN KEY (`id_proposta`, `id_item`) REFERENCES `proposta_item` (`id_proposta`, `id_item`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `gerprodb`.`artefatos`;
CREATE TABLE  `gerprodb`.`artefatos` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;