/*
 Navicat Premium Data Transfer

 Source Server         : aliyuu
 Source Server Type    : MySQL
 Source Server Version : 50728
 Source Host           : 39.98.93.238:3306
 Source Schema         : vhr

 Target Server Type    : MySQL
 Target Server Version : 50728
 File Encoding         : 65001

 Date: 04/02/2020 12:17:46
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

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
) ENGINE = InnoDB AUTO_INCREMENT = 58 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES (1, '/', '', '', '首页', '', NULL, NULL, NULL, 1);
INSERT INTO `menu` VALUES (2, '/', '/home', 'Home', '员工管理', 'Steve-Jobs', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (3, '/', '/home', 'Home', '人事管理', 'error', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (4, '/', '/home', 'Home', '薪资管理', 'redis', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (5, '/', '/home', 'Home', '统计管理', 'chart', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (6, '/', '/home', 'Home', '系统管理', 'system', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (7, '/employee/basic/**', '/emp/basic', 'EmpBasic', '基本资料', NULL, NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (8, '/employee/advanced/**', '/emp/adv', 'EmpAdv', '高级资料', NULL, NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (9, '/personnel/emp/**', '/per/emp', 'PerEmp', '员工资料', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (10, '/personnel/ec/**', '/per/ec', 'PerEc', '员工奖惩', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (11, '/personnel/train/**', '/per/train', 'PerTrain', '员工培训', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (12, '/personnel/salary/**', '/per/salary', 'PerSalary', '员工调薪', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (13, '/personnel/remove/**', '/per/mv', 'PerMv', '员工调动', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (14, '/salary/sob/**', '/sal/sob', 'SalSob', '工资账套管理', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (15, '/salary/sobcfg/**', '/sal/sobcfg', 'SalSobCfg', '员工账套设置', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (16, '/salary/table/**', '/sal/table', 'SalTable', '工资表管理', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (17, '/salary/month/**', '/sal/month', 'SalMonth', '月末处理', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (18, '/salary/search/**', '/sal/search', 'SalSearch', '工资表查询', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (19, '/statistics/all/**', '/sta/all', 'StaAll', '综合信息统计', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (20, '/statistics/score/**', '/sta/score', 'StaScore', '员工积分统计', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (21, '/statistics/personnel/**', '/sta/pers', 'StaPers', '人事信息统计', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (22, '/statistics/recored/**', '/sta/record', 'StaRecord', '人事记录统计', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (23, '/system/role/**', '/sys/role', 'SysRole', '权限设置', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (24, '/system/peo/**', '/sys/peo', 'SysPeoPle', '人员管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (25, '/system/menu/**', '/sys/menu', 'SysMenu', '菜单管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (26, '/system/user/**', '/sys/user', 'SysUser', '角色管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (28, '/system/init/**', '/sys/icon', 'index', '初始化数据库', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (29, '/', '/home', 'Home', '测试gl', 'date', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (32, '/', '/home', 'Home', '首页', 'fa fa-windows', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (56, '/system/pedding/**', '/sys/peddingList', 'peddingList', '待办列表', NULL, NULL, 1, 57, 1);
INSERT INTO `menu` VALUES (57, '/', '/home', 'Home', '待办管理', 'email', NULL, 1, 1, 1);

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
) ENGINE = InnoDB AUTO_INCREMENT = 826 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
INSERT INTO `menu_role` VALUES (161, 7, 3);
INSERT INTO `menu_role` VALUES (247, 7, 4);
INSERT INTO `menu_role` VALUES (248, 8, 4);
INSERT INTO `menu_role` VALUES (249, 11, 4);
INSERT INTO `menu_role` VALUES (250, 7, 2);
INSERT INTO `menu_role` VALUES (251, 8, 2);
INSERT INTO `menu_role` VALUES (252, 9, 2);
INSERT INTO `menu_role` VALUES (253, 10, 2);
INSERT INTO `menu_role` VALUES (254, 12, 2);
INSERT INTO `menu_role` VALUES (255, 13, 2);
INSERT INTO `menu_role` VALUES (256, 7, 1);
INSERT INTO `menu_role` VALUES (257, 8, 1);
INSERT INTO `menu_role` VALUES (258, 9, 1);
INSERT INTO `menu_role` VALUES (259, 10, 1);
INSERT INTO `menu_role` VALUES (260, 11, 1);
INSERT INTO `menu_role` VALUES (261, 12, 1);
INSERT INTO `menu_role` VALUES (262, 13, 1);
INSERT INTO `menu_role` VALUES (263, 14, 1);
INSERT INTO `menu_role` VALUES (264, 15, 1);
INSERT INTO `menu_role` VALUES (265, 16, 1);
INSERT INTO `menu_role` VALUES (266, 17, 1);
INSERT INTO `menu_role` VALUES (267, 18, 1);
INSERT INTO `menu_role` VALUES (268, 19, 1);
INSERT INTO `menu_role` VALUES (269, 20, 1);
INSERT INTO `menu_role` VALUES (270, 21, 1);
INSERT INTO `menu_role` VALUES (271, 22, 1);
INSERT INTO `menu_role` VALUES (272, 23, 1);
INSERT INTO `menu_role` VALUES (273, 24, 1);
INSERT INTO `menu_role` VALUES (274, 25, 1);
INSERT INTO `menu_role` VALUES (275, 26, 1);
INSERT INTO `menu_role` VALUES (277, 28, 1);
INSERT INTO `menu_role` VALUES (795, 7, 6);
INSERT INTO `menu_role` VALUES (796, 8, 6);
INSERT INTO `menu_role` VALUES (797, 9, 6);
INSERT INTO `menu_role` VALUES (798, 10, 6);
INSERT INTO `menu_role` VALUES (799, 11, 6);
INSERT INTO `menu_role` VALUES (800, 12, 6);
INSERT INTO `menu_role` VALUES (801, 13, 6);
INSERT INTO `menu_role` VALUES (802, 14, 6);
INSERT INTO `menu_role` VALUES (803, 15, 6);
INSERT INTO `menu_role` VALUES (804, 16, 6);
INSERT INTO `menu_role` VALUES (805, 17, 6);
INSERT INTO `menu_role` VALUES (806, 18, 6);
INSERT INTO `menu_role` VALUES (807, 19, 6);
INSERT INTO `menu_role` VALUES (808, 20, 6);
INSERT INTO `menu_role` VALUES (809, 21, 6);
INSERT INTO `menu_role` VALUES (810, 22, 6);
INSERT INTO `menu_role` VALUES (811, 23, 6);
INSERT INTO `menu_role` VALUES (812, 24, 6);
INSERT INTO `menu_role` VALUES (813, 25, 6);
INSERT INTO `menu_role` VALUES (814, 26, 6);
INSERT INTO `menu_role` VALUES (815, 28, 6);
INSERT INTO `menu_role` VALUES (817, 32, 6);
INSERT INTO `menu_role` VALUES (818, 10, 27);
INSERT INTO `menu_role` VALUES (819, 11, 27);
INSERT INTO `menu_role` VALUES (820, 14, 27);
INSERT INTO `menu_role` VALUES (821, 15, 27);
INSERT INTO `menu_role` VALUES (822, 16, 27);
INSERT INTO `menu_role` VALUES (823, 17, 27);
INSERT INTO `menu_role` VALUES (824, 18, 27);
INSERT INTO `menu_role` VALUES (825, 56, 6);

-- ----------------------------
-- Table structure for paper
-- ----------------------------
DROP TABLE IF EXISTS `paper`;
CREATE TABLE `paper`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '工号',
  `paper_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '论文类型',
  `paper_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '论文标题',
  `first_author_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第一作者类型',
  `first_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '第一作者',
  `correspondence_author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通讯作者',
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发表/出版时间',
  `publication` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发表刊物/论文集',
  `publication_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '刊物类型',
  `paper_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '论文学科门类',
  `paper_company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属单位',
  `paper_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '项目来源',
  `paper_volume` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '卷号',
  `paper_page` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '页码范围',
  `paper_school` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '学校署名',
  `paper_translation` tinyint(255) NULL DEFAULT NULL COMMENT '是否译文',
  `paper_cn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'CN号',
  `paper_local` tinyint(255) NULL DEFAULT NULL COMMENT '是否与地方联合发表',
  `paper_enterprise` tinyint(255) NULL DEFAULT NULL COMMENT '是否与企业共同发表',
  `paper_high` tinyint(255) NULL DEFAULT NULL COMMENT '是否被高引用',
  `science` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '自然科学研究类别',
  `paper_grade` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期刊等级',
  `paper_a` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '一级学科',
  `publication_scope` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '发表范围',
  `paper_issue` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '期号',
  `paper_word` int(255) NULL DEFAULT NULL COMMENT '字数',
  `page` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '版面',
  `paper_issn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ISSN号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of paper
-- ----------------------------
INSERT INTO `paper` VALUES (11, '0', '', NULL, '', NULL, '', '', NULL, NULL, '', NULL, NULL, '', '', NULL, '', NULL, NULL, NULL, NULL, '', '', '', '', NULL, NULL, '');

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
INSERT INTO `pedding` VALUES (14, '1', '6', '论文', '审核', '2', '0', '/sys/peddingList', '13', '1234', NULL);

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
) ENGINE = InnoDB AUTO_INCREMENT = 210 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (3, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (5, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (10, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (11, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (12, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
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
INSERT INTO `user` VALUES (67, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (68, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (69, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (70, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (71, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (72, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (73, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (74, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (75, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (76, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (77, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (78, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (79, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (80, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (81, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (82, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (83, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (84, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (85, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (86, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (87, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (88, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (89, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (90, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (91, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (92, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (93, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (94, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (95, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (96, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (97, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (98, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (99, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (100, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (101, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (102, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (103, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (104, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0102');
INSERT INTO `user` VALUES (105, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (106, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (107, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (108, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (109, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (110, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (111, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (112, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (113, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (114, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (115, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (116, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (117, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (118, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (119, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (120, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (121, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (122, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (123, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (124, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (125, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (126, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (127, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (128, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (129, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (130, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (131, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (132, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (133, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (134, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (135, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (136, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (137, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (138, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (139, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (140, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (141, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (142, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (143, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (144, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (145, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (146, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (147, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (148, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (149, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (150, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (151, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (152, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (153, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (154, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (155, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (156, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (157, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (158, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (159, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (160, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (161, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (162, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (163, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (164, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (165, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (166, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (167, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (168, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (169, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (170, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (171, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (172, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (173, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (174, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (175, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (176, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (177, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0106');
INSERT INTO `user` VALUES (178, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (179, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (180, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (181, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (182, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (183, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (184, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (185, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (186, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (187, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (188, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (189, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (190, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (191, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (192, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (193, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (194, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (195, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (196, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (197, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (198, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (199, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (200, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (201, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (202, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (203, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (204, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (205, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (206, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (208, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');

-- ----------------------------
-- Table structure for user_details
-- ----------------------------
DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `workID` char(8) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '工号',
  `name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '员工姓名',
  `gender` char(4) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '性别',
  `birthday` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '出生日期',
  `idCard` char(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '身份证号',
  `nation` varchar(8) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '民族',
  `email` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电话号码',
  `address` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系地址',
  `department` varchar(11) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '所属部门',
  `user_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`, `workID`) USING BTREE,
  INDEX `departmentId`(`department`) USING BTREE,
  INDEX `nationId`(`nation`) USING BTREE,
  INDEX `workID_key`(`workID`) USING BTREE,
  INDEX `id`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1525 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_details
-- ----------------------------
INSERT INTO `user_details` VALUES (1, '00000001', '江南一点雨', '男', '2018-01-01', '610122199909091234', '3', '584991843@qq.com', '1', '1', '85', 13);
INSERT INTO `user_details` VALUES (2, '00000002', '陈静', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 14);
INSERT INTO `user_details` VALUES (3, '00000003', '赵琳浩', '男', '2018-01-01', '01221999090912342', '1', '584991843@qq.com', '1', '1', '91', 15);
INSERT INTO `user_details` VALUES (4, '00000004', '鹿存亮', '男', '2018-01-01', '6102199909091234', '1', '584991843@qq.com', '1', '1', '92', 16);
INSERT INTO `user_details` VALUES (5, '00000005', '姚森', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 17);
INSERT INTO `user_details` VALUES (6, '00000006', '云星', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 18);
INSERT INTO `user_details` VALUES (7, '00000007', '贾旭明', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 19);
INSERT INTO `user_details` VALUES (8, '00000008', '张黎明', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 20);
INSERT INTO `user_details` VALUES (9, '00000009', '薛磊', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 21);
INSERT INTO `user_details` VALUES (10, '00000010', '张洁', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 22);
INSERT INTO `user_details` VALUES (11, '00000011', '江南一点雨2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 23);
INSERT INTO `user_details` VALUES (12, '00000012', '陈静2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 24);
INSERT INTO `user_details` VALUES (13, '00000013', '江南一点雨', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 25);
INSERT INTO `user_details` VALUES (14, '00000014', '鹿存亮2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 26);
INSERT INTO `user_details` VALUES (15, '00000015', '姚森2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 27);
INSERT INTO `user_details` VALUES (16, '00000016', '鹿存亮', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 28);
INSERT INTO `user_details` VALUES (17, '00000017', '贾旭明2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 29);
INSERT INTO `user_details` VALUES (18, '00000018', '王一亭', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 30);
INSERT INTO `user_details` VALUES (19, '00000019', '薛磊2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 31);
INSERT INTO `user_details` VALUES (20, '00000020', '张洁2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 32);
INSERT INTO `user_details` VALUES (21, '00000021', '江南一点雨3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 33);
INSERT INTO `user_details` VALUES (22, '00000022', '陈静3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 34);
INSERT INTO `user_details` VALUES (24, '00000024', '鹿存亮3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 35);
INSERT INTO `user_details` VALUES (25, '00000025', '江南一点雨', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 36);
INSERT INTO `user_details` VALUES (26, '00000026', '云星3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 37);
INSERT INTO `user_details` VALUES (27, '00000027', '贾旭明3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 38);
INSERT INTO `user_details` VALUES (28, '00000028', '张黎明3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 39);
INSERT INTO `user_details` VALUES (29, '00000029', '薛磊3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 40);
INSERT INTO `user_details` VALUES (31, '00000031', '江南一点雨4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 41);
INSERT INTO `user_details` VALUES (32, '00000032', '陈静4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 42);
INSERT INTO `user_details` VALUES (33, '00000033', '赵琳浩4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 43);
INSERT INTO `user_details` VALUES (34, '00000034', '鹿存亮4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 44);
INSERT INTO `user_details` VALUES (35, '00000035', '姚森4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 45);
INSERT INTO `user_details` VALUES (36, '00000036', '云星4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 46);
INSERT INTO `user_details` VALUES (37, '00000037', '贾旭明4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 47);
INSERT INTO `user_details` VALUES (38, '00000038', '张黎明2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 48);
INSERT INTO `user_details` VALUES (39, '00000039', '薛磊4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 49);
INSERT INTO `user_details` VALUES (40, '00000040', '张洁4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 50);
INSERT INTO `user_details` VALUES (41, '00000041', '江南一点雨5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 51);
INSERT INTO `user_details` VALUES (42, '00000042', '陈静5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 52);
INSERT INTO `user_details` VALUES (43, '00000043', '赵琳浩5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 53);
INSERT INTO `user_details` VALUES (44, '00000044', '鹿存亮5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 54);
INSERT INTO `user_details` VALUES (45, '00000045', '姚森5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 55);
INSERT INTO `user_details` VALUES (46, '00000046', '云星5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 56);
INSERT INTO `user_details` VALUES (47, '00000047', '贾旭明5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 57);
INSERT INTO `user_details` VALUES (48, '00000048', '张黎明5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 58);
INSERT INTO `user_details` VALUES (49, '00000049', '薛磊5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 59);
INSERT INTO `user_details` VALUES (50, '00000050', '张洁5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 60);
INSERT INTO `user_details` VALUES (51, '00000051', '江南一点雨6', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 61);
INSERT INTO `user_details` VALUES (52, '00000052', '陈静6', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 62);
INSERT INTO `user_details` VALUES (53, '00000053', '赵琳浩6', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 63);
INSERT INTO `user_details` VALUES (54, '00000054', '鹿存亮6', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 64);
INSERT INTO `user_details` VALUES (55, '00000055', '姚森6', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 65);
INSERT INTO `user_details` VALUES (56, '00000056', '云星6', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 66);
INSERT INTO `user_details` VALUES (1352, '00000002', '陈静', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 68);
INSERT INTO `user_details` VALUES (1353, '00000003', '赵琳浩', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 69);
INSERT INTO `user_details` VALUES (1354, '00000004', '鹿存亮', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 70);
INSERT INTO `user_details` VALUES (1355, '00000005', '姚森', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 71);
INSERT INTO `user_details` VALUES (1357, '00000007', '贾旭明', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 72);
INSERT INTO `user_details` VALUES (1358, '00000008', '张黎明', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 73);
INSERT INTO `user_details` VALUES (1359, '00000009', '薛磊', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 74);
INSERT INTO `user_details` VALUES (1360, '00000010', '张洁', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 75);
INSERT INTO `user_details` VALUES (1361, '00000011', '江南一点雨2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 76);
INSERT INTO `user_details` VALUES (1362, '00000012', '陈静2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 77);
INSERT INTO `user_details` VALUES (1363, '00000013', '赵琳浩2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 78);
INSERT INTO `user_details` VALUES (1364, '00000014', '鹿存亮2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 79);
INSERT INTO `user_details` VALUES (1365, '00000015', '姚森2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 80);
INSERT INTO `user_details` VALUES (1366, '00000016', '云星2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 81);
INSERT INTO `user_details` VALUES (1367, '00000017', '贾旭明2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 82);
INSERT INTO `user_details` VALUES (1368, '00000018', '王一亭', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 83);
INSERT INTO `user_details` VALUES (1369, '00000019', '薛磊2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 84);
INSERT INTO `user_details` VALUES (1370, '00000020', '张洁2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 85);
INSERT INTO `user_details` VALUES (1371, '00000021', '江南一点雨3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 86);
INSERT INTO `user_details` VALUES (1372, '00000022', '陈静3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 87);
INSERT INTO `user_details` VALUES (1373, '00000024', '鹿存亮3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 88);
INSERT INTO `user_details` VALUES (1374, '00000025', '姚森3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 89);
INSERT INTO `user_details` VALUES (1375, '00000026', '云星3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 90);
INSERT INTO `user_details` VALUES (1376, '00000027', '贾旭明3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 91);
INSERT INTO `user_details` VALUES (1377, '00000028', '张黎明3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 92);
INSERT INTO `user_details` VALUES (1378, '00000029', '薛磊3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 93);
INSERT INTO `user_details` VALUES (1379, '00000031', '江南一点雨4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 94);
INSERT INTO `user_details` VALUES (1380, '00000032', '陈静4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 95);
INSERT INTO `user_details` VALUES (1381, '00000033', '赵琳浩4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 96);
INSERT INTO `user_details` VALUES (1382, '00000034', '鹿存亮4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 97);
INSERT INTO `user_details` VALUES (1383, '00000035', '姚森4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 98);
INSERT INTO `user_details` VALUES (1384, '00000036', '云星4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 99);
INSERT INTO `user_details` VALUES (1385, '00000037', '贾旭明4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 100);
INSERT INTO `user_details` VALUES (1411, '00000038', '谢工', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 101);
INSERT INTO `user_details` VALUES (1412, '00000039', '林昭亮', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 102);
INSERT INTO `user_details` VALUES (1413, '00000040', '11', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '89', 103);
INSERT INTO `user_details` VALUES (1414, '00000041', '1', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '89', 104);
INSERT INTO `user_details` VALUES (1415, '00000042', '1', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 105);
INSERT INTO `user_details` VALUES (1416, '00000043', '1', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '81', 106);
INSERT INTO `user_details` VALUES (1417, '00000044', '1', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '87', 107);
INSERT INTO `user_details` VALUES (1418, '00000045', '1', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 108);
INSERT INTO `user_details` VALUES (1419, '00000046', '林伯渠', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 109);
INSERT INTO `user_details` VALUES (1420, '00000047', '1', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 110);
INSERT INTO `user_details` VALUES (1422, '00000002', '陈静', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 112);
INSERT INTO `user_details` VALUES (1423, '00000003', '赵琳浩', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 113);
INSERT INTO `user_details` VALUES (1424, '00000004', '鹿存亮', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 114);
INSERT INTO `user_details` VALUES (1425, '00000005', '姚森', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 115);
INSERT INTO `user_details` VALUES (1426, '00000006', '云星', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 116);
INSERT INTO `user_details` VALUES (1427, '00000007', '贾旭明', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 117);
INSERT INTO `user_details` VALUES (1428, '00000008', '张黎明', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 118);
INSERT INTO `user_details` VALUES (1429, '00000009', '薛磊', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 119);
INSERT INTO `user_details` VALUES (1430, '00000010', '张洁', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 120);
INSERT INTO `user_details` VALUES (1431, '00000011', '江南一点雨2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 121);
INSERT INTO `user_details` VALUES (1432, '00000012', '陈静2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 122);
INSERT INTO `user_details` VALUES (1433, '00000013', '赵琳浩2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 123);
INSERT INTO `user_details` VALUES (1434, '00000014', '鹿存亮2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 124);
INSERT INTO `user_details` VALUES (1435, '00000015', '姚森2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 125);
INSERT INTO `user_details` VALUES (1436, '00000016', '云星2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 126);
INSERT INTO `user_details` VALUES (1437, '00000017', '贾旭明2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 127);
INSERT INTO `user_details` VALUES (1438, '00000018', '王一亭', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 128);
INSERT INTO `user_details` VALUES (1439, '00000019', '薛磊2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 129);
INSERT INTO `user_details` VALUES (1440, '00000020', '张洁2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 130);
INSERT INTO `user_details` VALUES (1441, '00000021', '江南一点雨3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 131);
INSERT INTO `user_details` VALUES (1442, '00000022', '陈静3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 132);
INSERT INTO `user_details` VALUES (1443, '00000024', '鹿存亮3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 133);
INSERT INTO `user_details` VALUES (1444, '00000025', '姚森3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 134);
INSERT INTO `user_details` VALUES (1445, '00000026', '云星3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 135);
INSERT INTO `user_details` VALUES (1446, '00000027', '贾旭明3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 136);
INSERT INTO `user_details` VALUES (1447, '00000028', '张黎明3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 137);
INSERT INTO `user_details` VALUES (1448, '00000029', '薛磊3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 138);
INSERT INTO `user_details` VALUES (1449, '00000031', '江南一点雨4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 139);
INSERT INTO `user_details` VALUES (1450, '00000032', '陈静4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 140);
INSERT INTO `user_details` VALUES (1451, '00000033', '赵琳浩4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 141);
INSERT INTO `user_details` VALUES (1452, '00000034', '鹿存亮4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 142);
INSERT INTO `user_details` VALUES (1453, '00000035', '姚森4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 143);
INSERT INTO `user_details` VALUES (1454, '00000036', '云星4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 144);
INSERT INTO `user_details` VALUES (1455, '00000037', '贾旭明4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 145);
INSERT INTO `user_details` VALUES (1456, '00000038', '张黎明2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 146);
INSERT INTO `user_details` VALUES (1457, '00000039', '薛磊4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 147);
INSERT INTO `user_details` VALUES (1458, '00000040', '张洁4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 148);
INSERT INTO `user_details` VALUES (1459, '00000041', '江南一点雨5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 149);
INSERT INTO `user_details` VALUES (1460, '00000042', '陈静5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 150);
INSERT INTO `user_details` VALUES (1461, '00000043', '赵琳浩5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 151);
INSERT INTO `user_details` VALUES (1462, '00000044', '鹿存亮5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 152);
INSERT INTO `user_details` VALUES (1463, '00000045', '姚森5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 153);
INSERT INTO `user_details` VALUES (1464, '00000046', '云星5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 154);
INSERT INTO `user_details` VALUES (1465, '00000047', '贾旭明5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 155);
INSERT INTO `user_details` VALUES (1466, '00000048', '张黎明5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 156);
INSERT INTO `user_details` VALUES (1467, '00000049', '薛磊5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 157);
INSERT INTO `user_details` VALUES (1468, '00000050', '张洁5', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 158);
INSERT INTO `user_details` VALUES (1469, '00000051', '江南一点雨6', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 159);
INSERT INTO `user_details` VALUES (1470, '00000052', '陈静6', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 160);
INSERT INTO `user_details` VALUES (1471, '00000053', '赵琳浩6', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 161);
INSERT INTO `user_details` VALUES (1472, '00000054', '鹿存亮6', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 162);
INSERT INTO `user_details` VALUES (1473, '00000055', '姚森6', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 163);
INSERT INTO `user_details` VALUES (1474, '00000056', '云星6', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 164);
INSERT INTO `user_details` VALUES (1476, '00000002', '陈静', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 166);
INSERT INTO `user_details` VALUES (1477, '00000003', '赵琳浩', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 167);
INSERT INTO `user_details` VALUES (1478, '00000004', '鹿存亮', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 168);
INSERT INTO `user_details` VALUES (1479, '00000005', '姚森', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 169);
INSERT INTO `user_details` VALUES (1480, '00000007', '贾旭明', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 170);
INSERT INTO `user_details` VALUES (1481, '00000008', '张黎明', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 171);
INSERT INTO `user_details` VALUES (1482, '00000009', '薛磊', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 172);
INSERT INTO `user_details` VALUES (1483, '00000010', '张洁', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 173);
INSERT INTO `user_details` VALUES (1484, '00000011', '江南一点雨2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 174);
INSERT INTO `user_details` VALUES (1485, '00000012', '陈静2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 175);
INSERT INTO `user_details` VALUES (1486, '00000013', '赵琳浩2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 176);
INSERT INTO `user_details` VALUES (1487, '00000014', '鹿存亮2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 177);
INSERT INTO `user_details` VALUES (1488, '00000015', '姚森2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 178);
INSERT INTO `user_details` VALUES (1489, '00000016', '云星2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 179);
INSERT INTO `user_details` VALUES (1490, '00000017', '贾旭明2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 180);
INSERT INTO `user_details` VALUES (1491, '00000018', '王一亭', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 181);
INSERT INTO `user_details` VALUES (1492, '00000019', '薛磊2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 182);
INSERT INTO `user_details` VALUES (1493, '00000020', '张洁2', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 183);
INSERT INTO `user_details` VALUES (1494, '00000021', '江南一点雨3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 184);
INSERT INTO `user_details` VALUES (1495, '00000022', '陈静3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 185);
INSERT INTO `user_details` VALUES (1496, '00000024', '鹿存亮3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 186);
INSERT INTO `user_details` VALUES (1497, '00000025', '姚森3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 187);
INSERT INTO `user_details` VALUES (1498, '00000026', '云星3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 188);
INSERT INTO `user_details` VALUES (1499, '00000027', '贾旭明3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 189);
INSERT INTO `user_details` VALUES (1500, '00000028', '张黎明3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 190);
INSERT INTO `user_details` VALUES (1501, '00000029', '薛磊3', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 191);
INSERT INTO `user_details` VALUES (1502, '00000031', '江南一点雨4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 192);
INSERT INTO `user_details` VALUES (1503, '00000032', '陈静4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '82', 193);
INSERT INTO `user_details` VALUES (1504, '00000033', '赵琳浩4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 194);
INSERT INTO `user_details` VALUES (1505, '00000034', '鹿存亮4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 195);
INSERT INTO `user_details` VALUES (1506, '00000035', '姚森4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 196);
INSERT INTO `user_details` VALUES (1507, '00000036', '云星4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '92', 197);
INSERT INTO `user_details` VALUES (1508, '00000037', '贾旭明4', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 198);
INSERT INTO `user_details` VALUES (1509, '00000038', '谢工', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 199);
INSERT INTO `user_details` VALUES (1510, '00000039', '林昭亮', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '91', 200);
INSERT INTO `user_details` VALUES (1511, '00000040', '11', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '89', 201);
INSERT INTO `user_details` VALUES (1512, '00000041', '1', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '89', 202);
INSERT INTO `user_details` VALUES (1513, '00000042', '1', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 203);
INSERT INTO `user_details` VALUES (1514, '00000043', '1', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '81', 204);
INSERT INTO `user_details` VALUES (1515, '00000044', '1', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '87', 205);
INSERT INTO `user_details` VALUES (1516, '00000045', '1', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '78', 206);
INSERT INTO `user_details` VALUES (1517, '00000046', '林伯渠', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 207);
INSERT INTO `user_details` VALUES (1518, '00000047', '1', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 208);
INSERT INTO `user_details` VALUES (1519, 'admin', '系统管理员', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 3);
INSERT INTO `user_details` VALUES (1520, '00000049', '李白', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 5);
INSERT INTO `user_details` VALUES (1521, '00000050', '韩愈', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 10);
INSERT INTO `user_details` VALUES (1522, '00000051', '柳宗元', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 11);
INSERT INTO `user_details` VALUES (1523, '00000052', '曾巩', '男', '2018-01-01', '610122199909091234', '1', '584991843@qq.com', '1', '1', '8', 12);
INSERT INTO `user_details` VALUES (1524, '00000057', 'q', '1', '2020-01-21', '213123123', NULL, 'q', '1321321', 'q', NULL, 209);

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NULL DEFAULT NULL,
  `rid` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  INDEX `user_role_ibfk_1`(`userid`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (9, 5, 1);
INSERT INTO `user_role` VALUES (10, 5, 4);
INSERT INTO `user_role` VALUES (35, 12, 4);
INSERT INTO `user_role` VALUES (36, 12, 3);
INSERT INTO `user_role` VALUES (37, 12, 2);
INSERT INTO `user_role` VALUES (43, 11, 3);
INSERT INTO `user_role` VALUES (44, 11, 2);
INSERT INTO `user_role` VALUES (45, 11, 4);
INSERT INTO `user_role` VALUES (46, 11, 5);
INSERT INTO `user_role` VALUES (50, 13, 4);
INSERT INTO `user_role` VALUES (57, 3, 6);
INSERT INTO `user_role` VALUES (59, 13, 27);
INSERT INTO `user_role` VALUES (60, 16, 27);

-- ----------------------------
-- Procedure structure for addDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `addDep`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `addDep`(in depName varchar(32),in parentId int,in enabled boolean,out result int,out result2 int)
begin
  declare did int;
  declare pDepPath varchar(64);
  insert into department set name=depName,parentId=parentId,enabled=enabled;
  select row_count() into result;
  select last_insert_id() into did;
  set result2=did;
  select depPath into pDepPath from department where id=parentId;
  update department set depPath=concat(pDepPath,'.',did) where id=did;
  update department set isParent=true where id=parentId;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for deleteDep
-- ----------------------------
DROP PROCEDURE IF EXISTS `deleteDep`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteDep`(in did int,out result int)
begin
  declare ecount int;
  declare pid int;
  declare pcount int;
  select count(*) into ecount from employee where departmentId=did;
  if ecount>0 then set result=-1;
  else 
  select parentId into pid from department where id=did;
  delete from department where id=did and isParent=false;
  select row_count() into result;
  select count(*) into pcount from department where parentId=pid;
  if pcount=0 then update department set isParent=false where id=pid;
  end if;
  end if;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
