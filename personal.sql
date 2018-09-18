/*
Navicat MySQL Data Transfer

Source Server         : IP
Source Server Version : 50095
Source Host           : almacen-nortfarma.no-ip.org:3306
Source Database       : almacennortfarma

Target Server Type    : MYSQL
Target Server Version : 50095
File Encoding         : 65001

Date: 2013-10-21 18:03:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `personal`
-- ----------------------------
DROP TABLE IF EXISTS `personal`;
CREATE TABLE `personal` (
  `Id_Personal` int(8) NOT NULL,
  `Nombre` varchar(20) default NULL,
  `Apellido` varchar(50) default NULL,
  `Direccion` text,
  `Contrasena` varchar(40) default NULL,
  `DNI` char(8) default NULL,
  `Personal_Cesado` int(1) unsigned default '0',
  `Cambio` int(1) default '0',
  `Codigo_Administrativo` varchar(6) default NULL,
  `Cargo_Almacen` int(5) default NULL,
  PRIMARY KEY  (`Id_Personal`),
  UNIQUE KEY `Id_Personal` (`Id_Personal`),
  UNIQUE KEY `DNI` (`DNI`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personal
-- ----------------------------
INSERT INTO `personal` VALUES ('1', 'ANA DEL ROSARIO', 'TRELLES ATO', '', '852d7b5d37661fe1a97747a31a88870f30bdaa11', '02645894', '0', '0', '0001P', null);
INSERT INTO `personal` VALUES ('2', 'GELIMER', 'RAYGADA CESPEDES', '', 'b39ea492ef9e3146ca1898d0a285a31733b1c2e7', '02771541', '0', '0', '0005P', null);
INSERT INTO `personal` VALUES ('3', 'DAISY CECILIA', 'ANTON ESPINOZA', '', 'e263ff120143c457d3be96690d3d69e1c6bf7882', '02854946', '0', '0', '0008P', null);
INSERT INTO `personal` VALUES ('4', 'MARIA ISABEL', 'CHUYES GUEVARA', '', 'f7583d1c85336c851486defa06745edb8da87de2', '02800810', '0', '0', '0014P', null);
INSERT INTO `personal` VALUES ('5', 'WALFO ANTONIO', 'GALLARDO RODRIGUEZ', '', '910324d6e665572248c4885a01660cd1cab1ab63', '02653168', '0', '0', '0069P', null);
INSERT INTO `personal` VALUES ('6', 'AGUSTIN', 'CAMPOS GONZALES', '', '11c3bb35707bc56d89a5d2178c381e3c6574fc6d', '03233412', '0', '0', '0087P', null);
INSERT INTO `personal` VALUES ('7', 'HERNAN', 'CANO GERALDO', '', 'af5220686ff67f282d799b2dfab22553feac63f0', '10367165', '0', '0', '0570P', null);
INSERT INTO `personal` VALUES ('8', 'MILTON CESAR', 'BAYONA LAZO', '', 'dec44502da1f8e4b5fedcadc9d3b4f967e4e7a50', '05643842', '0', '0', '0689P', null);
INSERT INTO `personal` VALUES ('9', 'HOOVER IVAN', 'MINAN MOGOLLON', '', 'd2ccca0ba40cb0335d8c33831e65349e3a53d8bd', '41113745', '0', '0', '0736P', null);
INSERT INTO `personal` VALUES ('10', 'FLOR DE MARIA', 'YARLEQUE CHANDUVI', '', '7ef9f725fdb2ce6895940faf3799d6183c7fe142', '45473103', '0', '0', '0872P', null);
INSERT INTO `personal` VALUES ('11', 'SILVIA KARE', 'GRANADINO BAYONA', '', '64183c32b39e953299a3a46c9f5ebceb565bd089', '43191485', '0', '0', '0901P', null);
INSERT INTO `personal` VALUES ('12', 'NELZON LEODAN', 'CHUMACERO CRUZ', '', 'a9a1ef5f76be49155de6f3e31c07aa7386e298d9', '43965317', '0', '0', '0906P', null);
INSERT INTO `personal` VALUES ('13', 'JIMY PAUL', 'TEZEN CHERO', '', 'ce346c940185e70760329dd9537e20d51f01e885', '42505341', '0', '0', '0959P', null);
INSERT INTO `personal` VALUES ('14', 'ALEX ENRIQUE', 'OCANA VALENCIA', '', 'a9ddb471d6cd77facfae20c6c90521972a9c9f33', '43836946', '0', '0', '0960P', null);
INSERT INTO `personal` VALUES ('15', 'OSCAR EDUARDO', 'PAUCAR JIMENEZ', '', 'a34fc35b985d06c4d6622f733ae7a98c0847e955', '43859147', '0', '0', '0961P', null);
INSERT INTO `personal` VALUES ('16', 'RUBEN JUNIOR', 'PAUCAR LLAPAPASCA', '', '2502b039312e1a6ef101a6fbb2c5fc4a70039969', '44632328', '0', '0', '1207P', null);
INSERT INTO `personal` VALUES ('17', 'NORLY GUISELA', 'ESTRADA LLENQUE', '', '06c4fcd6d940cc741d15fb13d0ca7d5196d6eb45', '45400969', '0', '0', '1440P', null);
INSERT INTO `personal` VALUES ('18', 'CAROLINA LIZBETH', 'CELI ALAMA', '', 'e2b9c1ca6c160eef7c005bc44942885deedaa3b7', '46705811', '0', '0', '1461P', null);
INSERT INTO `personal` VALUES ('19', 'CESAR AUGUSTO', 'CORNEJO CALDERON', '', '537e89822006bd80e58415c31fffba4d7aa92d04', '40978531', '0', '0', '1462P', null);
INSERT INTO `personal` VALUES ('20', 'BETTY', 'NEIRA GUERRERO', '', '1e79add2e082c6e8e150bc993299ae9c013be002', '46038820', '0', '0', '1464P', null);
INSERT INTO `personal` VALUES ('21', 'IRIS JAZMILE', 'ORDINOLA SEMINARIO', '', '2ac2973d90a219b93feb355431e7b9a4dbbe12d2', '45923518', '0', '0', '1498P', null);
INSERT INTO `personal` VALUES ('22', 'CESAR AUGUSTO', 'CORDOVA CASTRO', '', '7ccdd95ed5a3c8c8129ee38b52ae2908a653a372', '42827061', '0', '0', '1510P', null);
INSERT INTO `personal` VALUES ('23', 'CRUZ MARIA', 'GALAN QUIROGA', '', '25dac6719827a63f40c077e4db201ab661bd7cff', '47471749', '0', '0', '1513P', null);
INSERT INTO `personal` VALUES ('24', 'INGRID RAQUEL', 'INFANTE UBILLUS', '', '455cadef6492ac991a8e0dc5e93eec3005fa7b64', '46286200', '0', '0', '1516P', null);
INSERT INTO `personal` VALUES ('25', 'SANDRA NOELIA', 'MENDOZA CHERO', '', 'cc07bdd3fc744fcc1e0a096df9bfeeb7644ec9c4', '47416364', '0', '0', '1521P', null);
INSERT INTO `personal` VALUES ('26', 'LUCIEL', 'SANTOS GARCIA', '', '5d327e4a2ae5097cf8bb2c87b3a9adc225755d02', '47093829', '0', '0', '1527P', null);
INSERT INTO `personal` VALUES ('27', 'KARINA YANET', 'CAMPOS GALLO', '', 'd073fee5bca4b19280c9c0344805fbf47e9914f6', '03691123', '0', '0', '1531P', null);
INSERT INTO `personal` VALUES ('28', 'MIRYAN ISABEL', 'MECHATO GUERRERO', '', '3de6aabb7aa986f56d5b433bc3bd98a062795ade', '46144103', '0', '0', '1533P', null);
INSERT INTO `personal` VALUES ('29', 'PAMELA', 'GARCES DEZA', '', '249a05ed39eb97ffefdb4e67603e68a471096d0b', '46994624', '0', '0', '1564P', null);
INSERT INTO `personal` VALUES ('30', 'MARIBEL', 'HUACCHILLO CAGALLAZA', '', 'abb8d71d0449fb2b1a7793ad0dc73025242a713a', '45394899', '0', '0', '1565P', null);
INSERT INTO `personal` VALUES ('31', 'LESLI', 'PUSMA CRUZ', '', '8c5a6fed46e881bf503360484e8af130bbcbfacb', '46648759', '0', '0', '1567P', null);
INSERT INTO `personal` VALUES ('32', 'YULIANA MERCEDES', 'VICENTE JUAREZ', '', '39c4fb08563892d10fab4b95bd0e7168d3872ad0', '46709957', '0', '0', '1569P', null);
INSERT INTO `personal` VALUES ('33', 'LIZBETH GERALDINE', 'MACALUPU MENDOZA', '', '8666e68e932644b86f0b3fe6d621c48d876f2234', '46473147', '0', '0', '1570P', null);
INSERT INTO `personal` VALUES ('34', 'YEESBY LIIZZETY', 'GUTIERREZ ROA', '', '3c71bd13ec8fe64f420412a5e167f612ae177af6', '48093552', '0', '0', '1615P', null);
INSERT INTO `personal` VALUES ('35', 'MAIRA FABIOLA', 'ZAPATA AREVALO', '', '8380af15885b8f6869b2868ec33616d0613ff857', '45948706', '0', '0', '1624P', null);
INSERT INTO `personal` VALUES ('36', 'DIANA CAROLINA', 'ZAPATA PACHERRE', '', 'cce8514f0d73c1bfe2877749654efe3609256379', '44442226', '0', '0', '1625P', null);
INSERT INTO `personal` VALUES ('37', 'RENSON MAURICIO', 'GUTIERREZ ROSALES', '', '9dc17ca1f1f44851f8ac911191905349ae86093f', '48201413', '0', '0', '1676P', null);
INSERT INTO `personal` VALUES ('38', ' JOSE LEYDER', 'PEA AZNARAN', '', '85987638dc914d9599765ce876161a41134a5a06', '72537515', '0', '0', '1678P', null);
INSERT INTO `personal` VALUES ('39', 'ERIKA YOVANY', 'ABAD VELASQUEZ', '', '6473d43944cd2bf1541d33774692d17075e0ecb9', '42849256', '0', '0', '1775P', null);
INSERT INTO `personal` VALUES ('40', 'LUIS ALBERTO', 'MORE CHERRES', '', '4ac64505f0bb79efcb976f3241bea31e16feea67', '71112996', '0', '0', '1778P', null);
INSERT INTO `personal` VALUES ('41', 'ISAIAS', 'SILUPU VILLEGAS', '', 'c7b20f0e06e8182479d3982dc372fa9f78f0bf26', '47321384', '0', '0', '1785P', null);
INSERT INTO `personal` VALUES ('42', 'JULIO', 'DOMINGUEZ PAZ', '', 'a88c6aad5604b5d17bb55c07fc5268e7a47c1e86', '46672392', '0', '0', '1809P', null);
INSERT INTO `personal` VALUES ('43', 'CARLOS EDUARDO', 'CERVERA AYOSA', '', 'c380f446fa37eb4c0210f86b2f19484e653e3092', '44832784', '0', '0', '1911P', null);
INSERT INTO `personal` VALUES ('44', 'JULY GISELA', 'CESPEDES RAMOS', '', '984c0e11d2573d18242ca00e8349c47155d9595b', '47212426', '0', '0', '1912P', null);
INSERT INTO `personal` VALUES ('45', 'YOANY', 'ROMERO NEYRA', '', '5755951efd253d8ed42ed9c3026f5e62e1ab9574', '47626375', '0', '0', '1918P', null);
INSERT INTO `personal` VALUES ('46', 'GIOVANNA CRISTINA', 'COLONA SAAVEDRA', '', 'fcc498e475770f67acd6c766ea9e4e4bf6099d82', '45639311', '0', '0', '2136R', null);
INSERT INTO `personal` VALUES ('47', 'ELIZABETH', 'GARCIA LIZANA', '', '84b50e1db03fe168f67a7cf1ea971611e74f23d9', '47346187', '0', '0', '2217R', null);
INSERT INTO `personal` VALUES ('48', 'PIERINA', 'SANDOVAL CHUNGA', '', 'c66d84b53f5c6afa0ff6e9d7208aad7872d16c5d', '47401674', '0', '0', '2218R', null);
INSERT INTO `personal` VALUES ('49', 'MIRIAM', 'ANASTACIO VILCHEZ', '', '99f259ffe4291f8a4cc75109c4aa42584ffeb238', '48498094', '0', '0', '2219R', null);
INSERT INTO `personal` VALUES ('50', 'FIORELLA', 'VILCHEZ VILCHEZ', '', '50e87f0d75f6e7f5ab5210bbe88098de4fbc998f', '46410355', '0', '0', '2220R', null);
INSERT INTO `personal` VALUES ('51', 'ROSS MERY', 'SILVA FLORES', '', 'd0d728bce484176ca4c91db3a36493eaaafb318b', '70315635', '0', '0', '2221R', null);
INSERT INTO `personal` VALUES ('52', 'RASAURA', 'SILVA CHERO', '', 'a101fc57242af9498bf254dbd8b7eca5ce02e2b3', '46718677', '0', '0', '2222R', null);
INSERT INTO `personal` VALUES ('53', 'JOSE ANTONIO', 'PRADO GARCIA', '', '0b56520d9f43365093e68ff49aa331f252ff0883', '47716041', '0', '0', '2223R', null);
INSERT INTO `personal` VALUES ('54', 'ALDO MERCEDES', 'MORALES VILCHEZ', '', '49adde1fce120b2542ca705611f2bb51dd61783a', '71081703', '0', '0', '2224R', null);
INSERT INTO `personal` VALUES ('55', 'NESTOR ALONSO', 'JARAMILLO GIRON', '', 'eedb0eb05926963dd8b1c55e87b23e999efd6dfd', '47173001', '0', '0', '2225R', null);
INSERT INTO `personal` VALUES ('56', 'JORGE MARCOS', 'YOVERA PRADO', '', '4685be3aa6d5464bd7716b453c5e80e7ad084da0', '46453245', '0', '0', '2226R', null);
INSERT INTO `personal` VALUES ('57', 'PATRICIA MARIBEL', 'SILVA TIMANA', '', '7ab2b1201c5670bd556548be64af6960a34d2f81', '47388098', '0', '0', '2227R', null);
INSERT INTO `personal` VALUES ('58', 'MERLY', 'RIVERA ABAD', '', '4e8f7d6ee159c1040729ae35b2ba38ff0320b586', '47400462', '0', '0', '2228R', null);
INSERT INTO `personal` VALUES ('59', 'CINTHIA CAROLINA', 'YOVERA OJEDA', '', '52b6656e8f493764de9a9e7f7f58431c24890529', '47654350', '0', '0', '2229R', null);
INSERT INTO `personal` VALUES ('60', 'BRENDA LIZET', 'CHAVEZ VILLAVICENCIO', '', '4a71e88a21859974b07a8fa65740022ebbf6a4b9', '47607354', '0', '0', '2230R', null);
INSERT INTO `personal` VALUES ('61', 'KAROL IBET', 'DE LA CRUZ COORIAUP', '', '95870a8881271a101dc52ec7aff6232f9aea1ab8', '47834056', '0', '0', '1514S', null);
INSERT INTO `personal` VALUES ('62', 'LILIANA', 'SARANGO HERMOSA', '', '7d7e4e20752c48ddc89215d5bdf9355e10f6132e', '46317762', '0', '0', '1515S', null);
INSERT INTO `personal` VALUES ('63', 'ELIZABETH', 'SERNAQUE DOMINGUEZ', '', '6b86eb45979d8ba8b3ae4dcfc2dbca9d5b17edf8', '71108954', '0', '0', '1516S', null);
INSERT INTO `personal` VALUES ('64', 'EGLE ELIZABETH', 'TOCTO TOCTO', '', '8ee0211a3454a0837b23aa2e335c9b74845731ca', '46818357', '0', '0', '1517S', null);
