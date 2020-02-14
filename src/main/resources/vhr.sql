/*
 Navicat Premium Data Transfer

 Source Server         : 39.98.93.238_3306
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : 39.98.93.238:3306
 Source Schema         : vhr

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 14/02/2020 02:31:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for audit
-- ----------------------------
DROP TABLE IF EXISTS `audit`;
CREATE TABLE `audit`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proposer_id` int(11) NULL DEFAULT NULL COMMENT '申请人id',
  `proposer_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '申请类型',
  `proposer_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '申请时间',
  `auditor_research_id` int(11) NULL DEFAULT NULL COMMENT '教研室审核人',
  `auditor_research_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '教研室审核时间',
  `audit_status` int(11) NULL DEFAULT NULL COMMENT '审核状态0:未审核1:教研室通过2:教研室未通过3:分院通过4:分院未通过',
  `table_id` int(11) NULL DEFAULT NULL COMMENT '表id',
  `auditor_court_id` int(11) NULL DEFAULT NULL COMMENT '分院审核人',
  `audtior_court_time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '分院审核时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of audit
-- ----------------------------
INSERT INTO `audit` VALUES (1, 3, '1', '1581436800000', 3, '1581523200000', 1, 1, 3, '1581612128770');

-- ----------------------------
-- Table structure for list
-- ----------------------------
DROP TABLE IF EXISTS `list`;
CREATE TABLE `list`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `label` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `target` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of list
-- ----------------------------
INSERT INTO `list` VALUES (1, 'publication_type', '学术性期刊', '1', 'paper');
INSERT INTO `list` VALUES (2, 'publication_type', '科普性期刊', '2', 'paper');
INSERT INTO `list` VALUES (3, 'publication_type', '技术性期刊', '3', 'paper');
INSERT INTO `list` VALUES (4, 'publication_type', '情报性期刊', '4', 'paper');
INSERT INTO `list` VALUES (5, 'publication_type', '检索性期刊', '5', 'paper');
INSERT INTO `list` VALUES (6, 'publication_type', '工具资料性期刊', '6', 'paper');
INSERT INTO `list` VALUES (7, 'publication_type', '行业性期刊', '7', 'paper');
INSERT INTO `list` VALUES (8, 'paperGrades', '省级期刊', '1', 'paper');
INSERT INTO `list` VALUES (9, 'paperGrades', '国家级期刊', '2', 'paper');
INSERT INTO `list` VALUES (10, 'paperGrades', '核心期刊', '3', 'paper');
INSERT INTO `list` VALUES (15, 'paperCompanys', '单位01', '1', 'paper');
INSERT INTO `list` VALUES (16, 'paperCompanys', '单位02', '2', 'paper');
INSERT INTO `list` VALUES (17, 'paperCompanys', '单位03', '3', 'paper');
INSERT INTO `list` VALUES (18, 'paperCompanys', '单位04', '4', 'paper');
INSERT INTO `list` VALUES (19, 'paperCompanys', '单位05', '5', 'paper');
INSERT INTO `list` VALUES (22, 'subjects', '学科1', '1', 'paper');
INSERT INTO `list` VALUES (23, 'subjects', '学科2', '2', 'paper');
INSERT INTO `list` VALUES (24, 'subjects', '学科3', '3', 'paper');
INSERT INTO `list` VALUES (25, 'subjects', '学科4', '4', 'paper');
INSERT INTO `list` VALUES (29, 'sources', 's1', '1', 'paper');
INSERT INTO `list` VALUES (30, 'sources', 's2', '2', 'paper');
INSERT INTO `list` VALUES (31, 'sources', 's3', '3', 'paper');
INSERT INTO `list` VALUES (32, 'sources', 's4', '4', 'paper');
INSERT INTO `list` VALUES (33, 'sources', 's5', '5', 'paper');
INSERT INTO `list` VALUES (34, 'scopes', '省', '1', 'paper');
INSERT INTO `list` VALUES (35, 'scopes', '市', '2', 'paper');
INSERT INTO `list` VALUES (36, 'scopes', '区', '3', 'paper');
INSERT INTO `list` VALUES (37, 'scopes', '县', '4', 'paper');
INSERT INTO `list` VALUES (39, 'scopes', '镇', '5', 'paper');

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求路径',
  `path` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问路劲',
  `component` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '模块名称',
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '标题',
  `iconCls` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `keepAlive` tinyint(1) NULL DEFAULT NULL,
  `requireAuth` tinyint(1) NULL DEFAULT 1 COMMENT '要求授权',
  `parentId` int(11) NULL DEFAULT NULL COMMENT '父ID',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '0：无效1有效',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `parentId`(`parentId`) USING BTREE,
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `menu` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 59 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '/', '', '', '首页', '', NULL, NULL, NULL, 1);
INSERT INTO `menu` VALUES (2, '/', '/home', 'Home', '个人信息', 'Steve-Jobs', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (3, '/', '/home', 'Home', '业绩登记', 'error', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (4, '/', '/home', 'Home', '业绩审核', 'redis', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (5, '/', '/home', 'Home', '业绩计算', 'chart', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (6, '/', '/home', 'Home', '系统管理', 'system', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (7, '/employee/basic/**', '/personalinf/basic', 'EmpBasic', '基本信息', NULL, NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (8, '/employee/advanced/**', '/personalinf/adv', 'EmpAdv', '业绩信息', NULL, NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (10, '/personnel/ec/**', '/achievementInput/Perscientific', 'Perscientific', '科研业绩录入界面', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (11, '/personnel/train/**', '/Perhonor/Perhonor', 'Perhonor', '荣誉录入界面', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (13, '/personnel/remove/**', '/achievementInput/Perhonor', 'Perteacher', '教学业绩录入', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (14, '/audit/sob/**', '/audit/ResearchAudit', 'AuditResearch', '教研室/院级审核', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (19, '/statistics/all/**', '/sta/all', 'StaAll', '业绩汇总', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (20, '/statistics/score/**', '/sta/score', 'StaScore', '员工积分统计', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (21, '/statistics/personnel/**', '/sta/pers', 'StaPers', '个人业绩', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (22, '/statistics/recored/**', '/sta/StaGroup', 'StaGroup', '集体业绩', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (24, '/system/peo/**', '/sys/peo', 'SysPeoPle', '人员管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (25, '/system/menu/**', '/sys/menu', 'SysMenu', '菜单管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (26, '/system/user/**', '/sys/user', 'SysUser', '角色管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (29, '/', '/home', 'Home', '测试gl', 'date', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (32, '/', '/home', 'Home', '首页', 'fa fa-windows', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (56, '/system/pedding/**', '/sys/peddingList', 'peddingList', '待办列表', NULL, NULL, 1, 57, 1);
INSERT INTO `menu` VALUES (57, '/', '/home', 'Home', '待办管理', 'email', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (58, '/personnel/remove/**', '/achievementInput/Perscientific', 'Perscientific', '科研业绩录入', '', NULL, 1, 3, 1);

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `mid`(`mid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 829 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES (161, 7, 3);
INSERT INTO `menu_role` VALUES (247, 7, 4);
INSERT INTO `menu_role` VALUES (248, 8, 4);
INSERT INTO `menu_role` VALUES (249, 11, 4);
INSERT INTO `menu_role` VALUES (250, 7, 2);
INSERT INTO `menu_role` VALUES (251, 8, 2);
INSERT INTO `menu_role` VALUES (255, 13, 2);
INSERT INTO `menu_role` VALUES (256, 7, 1);
INSERT INTO `menu_role` VALUES (257, 8, 1);
INSERT INTO `menu_role` VALUES (260, 11, 1);
INSERT INTO `menu_role` VALUES (262, 13, 1);
INSERT INTO `menu_role` VALUES (263, 14, 1);
INSERT INTO `menu_role` VALUES (268, 19, 1);
INSERT INTO `menu_role` VALUES (269, 20, 1);
INSERT INTO `menu_role` VALUES (270, 21, 1);
INSERT INTO `menu_role` VALUES (271, 22, 1);
INSERT INTO `menu_role` VALUES (274, 25, 1);
INSERT INTO `menu_role` VALUES (795, 7, 6);
INSERT INTO `menu_role` VALUES (796, 8, 6);
INSERT INTO `menu_role` VALUES (799, 11, 6);
INSERT INTO `menu_role` VALUES (801, 13, 6);
INSERT INTO `menu_role` VALUES (802, 14, 6);
INSERT INTO `menu_role` VALUES (807, 19, 6);
INSERT INTO `menu_role` VALUES (808, 20, 6);
INSERT INTO `menu_role` VALUES (809, 21, 6);
INSERT INTO `menu_role` VALUES (810, 22, 6);
INSERT INTO `menu_role` VALUES (813, 25, 6);
INSERT INTO `menu_role` VALUES (817, 32, 6);
INSERT INTO `menu_role` VALUES (819, 11, 27);
INSERT INTO `menu_role` VALUES (820, 14, 27);
INSERT INTO `menu_role` VALUES (825, 56, 6);
INSERT INTO `menu_role` VALUES (826, 26, 6);
INSERT INTO `menu_role` VALUES (827, 24, 6);
INSERT INTO `menu_role` VALUES (828, 10, 6);

-- ----------------------------
-- Table structure for office
-- ----------------------------
DROP TABLE IF EXISTS `office`;
CREATE TABLE `office`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `office` enum('A-101','B-203','C-404','D-502','B-304','C-405','C-203','D-503') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of office
-- ----------------------------
INSERT INTO `office` VALUES (1, 'A-101');
INSERT INTO `office` VALUES (2, 'B-203');
INSERT INTO `office` VALUES (3, 'C-404');
INSERT INTO `office` VALUES (4, 'D-502');
INSERT INTO `office` VALUES (5, 'B-304');
INSERT INTO `office` VALUES (6, 'C-405');
INSERT INTO `office` VALUES (7, 'C-203');
INSERT INTO `office` VALUES (8, 'D-503');

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `id` int(13) NOT NULL AUTO_INCREMENT COMMENT '工号',
  `paper_type` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '论文类型1:2:',
  `paper_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '论文标题',
  `first_author_type` enum('1','2','3') CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '第一作者类型1:2:',
  `first_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '第一作者',
  `correspondence_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通讯作者',
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '发表/出版时间',
  `publication` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发表刊物/论文集',
  `publication_type` enum('0','1') CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '刊物类型1:2:',
  `paper_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '论文学科门类',
  `paper_company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '所属单位',
  `paper_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目来源',
  `paper_volume` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '卷号',
  `paper_page` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '页码范围',
  `paper_school` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校署名',
  `paper_translation` tinyint(1) NULL DEFAULT NULL COMMENT '是否译文',
  `paper_cn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'CN号',
  `paper_local` tinyint(1) NULL DEFAULT NULL COMMENT '是否与地方联合发表',
  `paper_enterprise` tinyint(1) NULL DEFAULT NULL COMMENT '是否与企业共同发表',
  `paper_high` tinyint(1) NULL DEFAULT NULL COMMENT '是否被高引用',
  `science` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自然科学研究类别',
  `paper_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期刊等级',
  `paper_a` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '一级学科',
  `publication_scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发表范围',
  `paper_issue` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '期号',
  `paper_word` int(4) NOT NULL COMMENT '字数',
  `page` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版面',
  `paper_issn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ISSN号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for pedding
-- ----------------------------
DROP TABLE IF EXISTS `pedding`;
CREATE TABLE `pedding`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息类型：1,个人;2,集体',
  `role` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息角色:发送给哪个角色',
  `main` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息主体',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息名称',
  `tableId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '表格id',
  `state` enum('0','1','2','3','4') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息状态：0待审核;1教研室通过;2教研室未通过;3分院通过;4分院未通过',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息地址',
  `operator` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发起人',
  `createTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发起时间',
  `updateTime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '处理时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of pedding
-- ----------------------------
INSERT INTO `pedding` VALUES (14, '1', '6', '论文', '审核', '2', '0', '/audit/ResearchAudit', '13', '1234', NULL);

-- ----------------------------
-- Table structure for performance
-- ----------------------------
DROP TABLE IF EXISTS `performance`;
CREATE TABLE `performance`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `performance_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '业绩名称',
  `performance_class` int(255) NULL DEFAULT NULL COMMENT '业绩类别',
  `time` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '时间',
  `first_author` tinyint(1) NULL DEFAULT NULL COMMENT '是否是第一作者',
  `complete_author` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '完成者',
  `grade` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '级别',
  `performance_point` double(14, 0) NULL DEFAULT NULL COMMENT '业绩点',
  `audit_condition` int(11) NULL DEFAULT NULL COMMENT '审核情况1:通过 2:审核中 3:未通过',
  `material_condition` int(11) NULL DEFAULT NULL COMMENT '佐证材料上交情况1:通过 2:审核中 3:未通过',
  `note` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT '备注',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of performance
-- ----------------------------
INSERT INTO `performance` VALUES (1, '1', 1, '1580486400000', 1, '1', '1', 1, 1, 1, '1', 3);
INSERT INTO `performance` VALUES (2, '2', 2, '1580486400000', 2, '2', '2', 2, 2, 2, '2', 3);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `nameZh` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色名称',
  `state` int(1) NULL DEFAULT 1 COMMENT '是否有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, 'ROLE_manager', '计算机教研室', 1);
INSERT INTO `role` VALUES (2, 'ROLE_personnel', '机械教研室', 1);
INSERT INTO `role` VALUES (3, 'ROLE_recruiterd', '工业教研室', 1);
INSERT INTO `role` VALUES (4, 'ROLE_train', '电子教研室', 1);
INSERT INTO `role` VALUES (5, 'ROLE_performance', '高分子教研室', 1);
INSERT INTO `role` VALUES (6, 'ROLE_admin', '分院管理员', 1);
INSERT INTO `role` VALUES (13, 'ROLE_test2', '数学教研室', 1);
INSERT INTO `role` VALUES (14, 'ROLE_test1', '应化教研室', 1);
INSERT INTO `role` VALUES (27, 'ROLE_yiban', '普通用户', 1);

-- ----------------------------
-- Table structure for table
-- ----------------------------
DROP TABLE IF EXISTS `table`;
CREATE TABLE `table`  (
  `id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `userId` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '发起人id',
  `content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `state` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of table
-- ----------------------------
INSERT INTO `table` VALUES ('1', '14', NULL, NULL);
INSERT INTO `table` VALUES ('2', '13', NULL, NULL);

-- ----------------------------
-- Table structure for tree_people
-- ----------------------------
DROP TABLE IF EXISTS `tree_people`;
CREATE TABLE `tree_people`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tree_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `parent_id` int(11) NOT NULL COMMENT '上级id',
  `state` tinyint(255) NOT NULL COMMENT '1:有效；0：无效；',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of tree_people
-- ----------------------------
INSERT INTO `tree_people` VALUES (1, '01', '理工分院', 0, 1);
INSERT INTO `tree_people` VALUES (2, '0101', '计算机教研室', 1, 1);
INSERT INTO `tree_people` VALUES (3, '0102', '机械教研室', 1, 1);
INSERT INTO `tree_people` VALUES (4, '0103', '工业教研室', 1, 1);
INSERT INTO `tree_people` VALUES (5, '0104', '电子教研室', 1, 1);
INSERT INTO `tree_people` VALUES (6, '0105', '高分子教研室', 1, 1);
INSERT INTO `tree_people` VALUES (7, '0106', '数学教研室', 1, 1);
INSERT INTO `tree_people` VALUES (8, '0107', '应化教研室', 1, 1);

-- ----------------------------
-- Table structure for tree_role
-- ----------------------------
DROP TABLE IF EXISTS `tree_role`;
CREATE TABLE `tree_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `treeid` int(11) NULL DEFAULT NULL,
  `roleid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tree_role
-- ----------------------------
INSERT INTO `tree_role` VALUES (1, 2, 1);
INSERT INTO `tree_role` VALUES (2, 3, 2);
INSERT INTO `tree_role` VALUES (3, 4, 3);
INSERT INTO `tree_role` VALUES (4, 5, 4);
INSERT INTO `tree_role` VALUES (5, 6, 5);
INSERT INTO `tree_role` VALUES (6, 7, 13);
INSERT INTO `tree_role` VALUES (7, 8, 14);
INSERT INTO `tree_role` VALUES (8, 1, 6);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hrID',
  `enabled` tinyint(1) NULL DEFAULT 1 COMMENT '是否有效0：无效1：有效',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `tree` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '教研室',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 67 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 1, '$2a$10$dE7SjUUZamZPLWh5/8o/uOeshzWzXihRAnPkY.xqmUO1779kR7vke', '0101');
INSERT INTO `user` VALUES (13, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (14, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (15, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (16, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (17, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (18, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (19, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (20, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (21, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (22, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (23, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (24, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (25, 0, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (26, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (27, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (28, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (29, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (30, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (31, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (32, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (33, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (34, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (35, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (36, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (37, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (38, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (39, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (40, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (41, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (42, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (43, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (44, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (45, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (46, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (47, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (48, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (49, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (50, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (51, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (52, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (53, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (54, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (55, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (56, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (57, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (58, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (59, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (60, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (61, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (62, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (63, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (64, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (65, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (66, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');

-- ----------------------------
-- Table structure for user_details
-- ----------------------------
DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details`  (
  `id` int(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `workID` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工号',
  `name` varchar(12) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `gender` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `office_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '办公室',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `note` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '备注',
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `workID`) USING BTREE,
  INDEX `workID_key`(`workID`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1520 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_details
-- ----------------------------
INSERT INTO `user_details` VALUES (1, '00000001', '江南一点雨', '1', '1', '1', '584991843@qq.com', NULL, 66);
INSERT INTO `user_details` VALUES (2, '00000002', '陈静', '1', '2', '1', '584991843@qq.com', NULL, 13);
INSERT INTO `user_details` VALUES (3, '00000003', '赵琳浩', '1', '3', '1', '584991843@qq.com', NULL, 14);
INSERT INTO `user_details` VALUES (4, '00000004', '鹿存亮', '1', '4', '1', '584991843@qq.com', NULL, 15);
INSERT INTO `user_details` VALUES (5, '00000005', '姚森', '0', '5', '1', '584991843@qq.com', NULL, 16);
INSERT INTO `user_details` VALUES (6, '00000006', '云星', '0', '6', '1', '584991843@qq.com', NULL, 17);
INSERT INTO `user_details` VALUES (7, '00000007', '贾旭明', '0', '7', '1', '584991843@qq.com', NULL, 18);
INSERT INTO `user_details` VALUES (8, '00000008', '张黎明', '0', '8', '1', '584991843@qq.com', NULL, 19);
INSERT INTO `user_details` VALUES (9, '00000009', '薛磊', '0', '1', '1', '584991843@qq.com', NULL, 20);
INSERT INTO `user_details` VALUES (10, '00000010', '张洁', '0', '2', '1', '584991843@qq.com', NULL, 21);
INSERT INTO `user_details` VALUES (11, '00000011', '江南一点雨2', '0', '3', '1', '584991843@qq.com', NULL, 22);
INSERT INTO `user_details` VALUES (12, '00000012', '陈静2', '1', '4', '1', '584991843@qq.com', NULL, 23);
INSERT INTO `user_details` VALUES (13, '00000013', '江南一点雨', '1', '5', '1', '584991843@qq.com', NULL, 24);
INSERT INTO `user_details` VALUES (14, '00000014', '鹿存亮2', '1', '6', '1', '584991843@qq.com', NULL, 25);
INSERT INTO `user_details` VALUES (15, '00000015', '姚森2', '1', '7', '1', '584991843@qq.com', NULL, 26);
INSERT INTO `user_details` VALUES (16, '00000016', '鹿存亮', '1', '8', '1', '584991843@qq.com', NULL, 27);
INSERT INTO `user_details` VALUES (17, '00000017', '贾旭明2', '1', '1', '1', '584991843@qq.com', NULL, 28);
INSERT INTO `user_details` VALUES (18, '00000018', '王一亭', '1', '2', '1', '584991843@qq.com', NULL, 29);
INSERT INTO `user_details` VALUES (19, '00000019', '薛磊2', '1', '3', '1', '584991843@qq.com', NULL, 30);
INSERT INTO `user_details` VALUES (20, '00000020', '张洁2', '1', '4', '1', '584991843@qq.com', NULL, 31);
INSERT INTO `user_details` VALUES (21, '00000021', '江南一点雨3', '1', '5', '1', '584991843@qq.com', NULL, 32);
INSERT INTO `user_details` VALUES (22, '00000022', '陈静3', '1', '6', '1', '584991843@qq.com', NULL, 33);
INSERT INTO `user_details` VALUES (24, '00000024', '鹿存亮3', '1', '7', '1', '584991843@qq.com', NULL, 34);
INSERT INTO `user_details` VALUES (25, '00000025', '江南一点雨', '1', '8', '1', '584991843@qq.com', NULL, 35);
INSERT INTO `user_details` VALUES (26, '00000026', '云星3', '1', '1', '1', '584991843@qq.com', NULL, 36);
INSERT INTO `user_details` VALUES (27, '00000027', '贾旭明3', '1', '2', '1', '584991843@qq.com', NULL, 37);
INSERT INTO `user_details` VALUES (28, '00000028', '张黎明3', '1', '3', '1', '584991843@qq.com', NULL, 38);
INSERT INTO `user_details` VALUES (29, '00000029', '薛磊3', '1', '4', '1', '584991843@qq.com', NULL, 39);
INSERT INTO `user_details` VALUES (31, '00000031', '江南一点雨4', '1', '5', '1', '584991843@qq.com', NULL, 40);
INSERT INTO `user_details` VALUES (32, '00000032', '陈静4', '1', '6', '1', '584991843@qq.com', NULL, 41);
INSERT INTO `user_details` VALUES (33, '00000033', '赵琳浩4', '0', '7', '1', '584991843@qq.com', NULL, 42);
INSERT INTO `user_details` VALUES (34, '00000034', '鹿存亮4', '0', '8', '1', '584991843@qq.com', NULL, 43);
INSERT INTO `user_details` VALUES (35, '00000035', '姚森4', '0', '1', '1', '584991843@qq.com', NULL, 44);
INSERT INTO `user_details` VALUES (36, '00000036', '云星4', '0', '2', '1', '584991843@qq.com', NULL, 45);
INSERT INTO `user_details` VALUES (37, '00000037', '贾旭明4', '0', '3', '1', '584991843@qq.com', NULL, 46);
INSERT INTO `user_details` VALUES (38, '00000038', '张黎明2', '0', '4', '1', '584991843@qq.com', NULL, 47);
INSERT INTO `user_details` VALUES (39, '00000039', '薛磊4', '0', '5', '1', '584991843@qq.com', NULL, 48);
INSERT INTO `user_details` VALUES (40, '00000040', '张洁4', '1', '6', '1', '584991843@qq.com', NULL, 49);
INSERT INTO `user_details` VALUES (41, '00000041', '江南一点雨5', '1', '7', '1', '584991843@qq.com', NULL, 50);
INSERT INTO `user_details` VALUES (42, '00000042', '陈静5', '1', '8', '1', '584991843@qq.com', NULL, 51);
INSERT INTO `user_details` VALUES (43, '00000043', '赵琳浩5', '1', '1', '1', '584991843@qq.com', NULL, 52);
INSERT INTO `user_details` VALUES (44, '00000044', '鹿存亮5', '1', '2', '1', '584991843@qq.com', NULL, 53);
INSERT INTO `user_details` VALUES (45, '00000045', '姚森5', '1', '3', '1', '584991843@qq.com', NULL, 54);
INSERT INTO `user_details` VALUES (46, '00000046', '云星5', '1', '4', '1', '584991843@qq.com', NULL, 55);
INSERT INTO `user_details` VALUES (47, '00000047', '贾旭明5', '1', '5', '1', '584991843@qq.com', NULL, 56);
INSERT INTO `user_details` VALUES (48, '00000048', '张黎明5', '0', '6', '1', '584991843@qq.com', NULL, 57);
INSERT INTO `user_details` VALUES (49, '00000049', '薛磊5', '0', '7', '1', '584991843@qq.com', NULL, 58);
INSERT INTO `user_details` VALUES (50, '00000050', '张洁5', '0', '8', '1', '584991843@qq.com', NULL, 59);
INSERT INTO `user_details` VALUES (51, '00000051', '江南一点雨6', '0', '1', '1', '584991843@qq.com', NULL, 60);
INSERT INTO `user_details` VALUES (52, '00000052', '陈静6', '0', '2', '1', '584991843@qq.com', NULL, 61);
INSERT INTO `user_details` VALUES (53, '00000053', '赵琳浩6', '0', '3', '1', '584991843@qq.com', NULL, 62);
INSERT INTO `user_details` VALUES (54, '00000054', '鹿存亮6', '0', '4', '1', '584991843@qq.com', NULL, 63);
INSERT INTO `user_details` VALUES (55, '00000055', '姚森6', '0', '5', '1', '584991843@qq.com', NULL, 64);
INSERT INTO `user_details` VALUES (56, '00000056', '云星6', '0', '6', '1', '584991843@qq.com', NULL, 65);
INSERT INTO `user_details` VALUES (1519, 'admin', '系统管理员', '0', '4', '123', '584991843@qq.com', '', 3);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  `isManager` int(1) NULL DEFAULT 0 COMMENT '是否管理员0：不是1是',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  INDEX `user_role_ibfk_1`(`userid`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 171 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (57, 3, 6, 1);
INSERT INTO `user_role` VALUES (59, 13, 27, 1);
INSERT INTO `user_role` VALUES (60, 16, 27, 0);
INSERT INTO `user_role` VALUES (67, 13, 4, 1);
INSERT INTO `user_role` VALUES (68, 14, 4, 0);
INSERT INTO `user_role` VALUES (69, 15, 4, 0);
INSERT INTO `user_role` VALUES (75, 14, 2, 0);
INSERT INTO `user_role` VALUES (76, 15, 2, 0);
INSERT INTO `user_role` VALUES (164, 15, 5, 1);
INSERT INTO `user_role` VALUES (168, 15, 5, 0);
INSERT INTO `user_role` VALUES (169, 14, 5, 0);
INSERT INTO `user_role` VALUES (170, 16, 5, 0);

SET FOREIGN_KEY_CHECKS = 1;
