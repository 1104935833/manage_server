/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50710
 Source Host           : localhost:3306
 Source Schema         : vhr

 Target Server Type    : MySQL
 Target Server Version : 50710
 File Encoding         : 65001

 Date: 26/06/2020 17:10:17
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for audit
-- ----------------------------
DROP TABLE IF EXISTS `audit`;
CREATE TABLE `audit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `proposer_id` int(11) DEFAULT NULL COMMENT '申请人id',
  `proposer_type` varchar(255) DEFAULT NULL COMMENT '申请类型',
  `proposer_time` varchar(255) DEFAULT NULL COMMENT '申请时间',
  `auditor_research_id` int(11) DEFAULT NULL COMMENT '教研室审核人',
  `auditor_research_time` varchar(255) DEFAULT NULL COMMENT '教研室审核时间',
  `audit_status` int(11) DEFAULT NULL COMMENT '审核状态0:未审核1:教研室通过2:教研室未通过3:分院通过4:分院未通过',
  `table_id` int(11) DEFAULT NULL COMMENT '表id',
  `auditor_court_id` int(11) DEFAULT NULL COMMENT '分院审核人',
  `audtior_court_time` varchar(255) DEFAULT NULL COMMENT '分院审核时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of audit
-- ----------------------------
BEGIN;
INSERT INTO `audit` VALUES (31, 3, '22', '1593064613215', NULL, NULL, 3, 33, 3, '1593152938806');
INSERT INTO `audit` VALUES (32, 3, '23', '1593064628245', NULL, NULL, 0, 34, NULL, NULL);
INSERT INTO `audit` VALUES (33, 3, '7', '1593064646756', NULL, NULL, 0, 35, NULL, NULL);
INSERT INTO `audit` VALUES (34, 3, '8', '1593064668504', NULL, NULL, 0, 36, NULL, NULL);
INSERT INTO `audit` VALUES (35, 3, '9', '1593064677437', NULL, NULL, 0, 37, NULL, NULL);
INSERT INTO `audit` VALUES (36, 3, '10', '1593064694669', NULL, NULL, 0, 38, NULL, NULL);
INSERT INTO `audit` VALUES (39, 3, '11', '1593065606711', NULL, NULL, 0, 41, NULL, NULL);
INSERT INTO `audit` VALUES (40, 3, '17', '1593065650267', NULL, NULL, 0, 42, NULL, NULL);
INSERT INTO `audit` VALUES (41, 3, '18', '1593065679207', NULL, NULL, 0, 43, NULL, NULL);
INSERT INTO `audit` VALUES (42, 3, '19', '1593065748785', NULL, NULL, 0, 44, NULL, NULL);
INSERT INTO `audit` VALUES (43, 3, '20', '1593065768057', NULL, NULL, 0, 45, NULL, NULL);
INSERT INTO `audit` VALUES (44, 3, '21', '1593065783044', NULL, NULL, 0, 46, NULL, NULL);
INSERT INTO `audit` VALUES (45, 3, '24', '1593066129147', NULL, NULL, 0, 47, NULL, NULL);
INSERT INTO `audit` VALUES (46, 3, '25', '1593066146342', NULL, NULL, 0, 48, NULL, NULL);
INSERT INTO `audit` VALUES (47, 3, '26', '1593066173077', NULL, NULL, 0, 49, NULL, NULL);
INSERT INTO `audit` VALUES (48, 3, '27', '1593066184640', NULL, NULL, 0, 50, NULL, NULL);
INSERT INTO `audit` VALUES (51, 3, '28', '1593066272372', NULL, NULL, 0, 53, NULL, NULL);
INSERT INTO `audit` VALUES (52, 3, '29', '1593066280007', NULL, NULL, 0, 54, NULL, NULL);
INSERT INTO `audit` VALUES (53, 3, '30', '1593066290441', NULL, NULL, 0, 55, NULL, NULL);
INSERT INTO `audit` VALUES (54, 3, '30', '1593066315094', NULL, NULL, 0, 56, NULL, NULL);
INSERT INTO `audit` VALUES (55, 3, '31', '1593066327302', NULL, NULL, 0, 57, NULL, NULL);
INSERT INTO `audit` VALUES (56, 3, '32', '1593066340391', NULL, NULL, 0, 58, NULL, NULL);
INSERT INTO `audit` VALUES (57, 17, '22', '1593137670387', 13, '1593153634490', 4, 59, 3, '1593153734036');
INSERT INTO `audit` VALUES (58, 3, '22', '1593161254153', NULL, NULL, 0, 60, NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for file
-- ----------------------------
DROP TABLE IF EXISTS `file`;
CREATE TABLE `file` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `file_name` varchar(200) NOT NULL COMMENT '文件名',
  `file_path` varchar(200) DEFAULT NULL COMMENT '文件路径',
  `file_ext` varchar(10) NOT NULL COMMENT '文件后缀',
  `file_size` bigint(11) NOT NULL COMMENT '文件大小',
  `create_time` varchar(255) NOT NULL COMMENT '创建时间',
  `user_id` int(11) NOT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `table_id` int(10) DEFAULT NULL COMMENT '表类型id',
  `grade` int(10) DEFAULT NULL COMMENT '业绩点',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of grade
-- ----------------------------
BEGIN;
INSERT INTO `grade` VALUES (1, 1, NULL);
INSERT INTO `grade` VALUES (2, 2, NULL);
INSERT INTO `grade` VALUES (3, 3, NULL);
INSERT INTO `grade` VALUES (4, 4, NULL);
INSERT INTO `grade` VALUES (5, 5, NULL);
INSERT INTO `grade` VALUES (6, 6, NULL);
INSERT INTO `grade` VALUES (7, 7, 1);
INSERT INTO `grade` VALUES (8, 8, 1);
INSERT INTO `grade` VALUES (9, 9, 1);
INSERT INTO `grade` VALUES (10, 10, 1);
INSERT INTO `grade` VALUES (11, 11, 1);
INSERT INTO `grade` VALUES (12, 12, 1);
INSERT INTO `grade` VALUES (13, 13, 1);
INSERT INTO `grade` VALUES (14, 14, 1);
INSERT INTO `grade` VALUES (15, 15, 1);
INSERT INTO `grade` VALUES (16, 16, 1);
INSERT INTO `grade` VALUES (17, 17, 1);
INSERT INTO `grade` VALUES (18, 18, 1);
INSERT INTO `grade` VALUES (19, 19, 1);
INSERT INTO `grade` VALUES (20, 20, 1);
INSERT INTO `grade` VALUES (21, 21, 1);
INSERT INTO `grade` VALUES (22, 22, 1);
INSERT INTO `grade` VALUES (23, 23, 1);
INSERT INTO `grade` VALUES (24, 24, 1);
INSERT INTO `grade` VALUES (25, 25, 1);
INSERT INTO `grade` VALUES (26, 26, 1);
INSERT INTO `grade` VALUES (27, 27, 1);
INSERT INTO `grade` VALUES (28, 28, 1);
INSERT INTO `grade` VALUES (29, 29, 1);
INSERT INTO `grade` VALUES (30, 30, 1);
INSERT INTO `grade` VALUES (31, 31, 1);
INSERT INTO `grade` VALUES (32, 32, 1);
COMMIT;

-- ----------------------------
-- Table structure for honor
-- ----------------------------
DROP TABLE IF EXISTS `honor`;
CREATE TABLE `honor` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `personal_honor_type` int(11) DEFAULT NULL COMMENT '荣誉类型',
  `name` int(11) DEFAULT NULL COMMENT '荣誉名称',
  `personal_gain_time` varchar(255) DEFAULT NULL COMMENT '获得时间',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `organization_name` varchar(255) DEFAULT NULL COMMENT '组织名称',
  `organization_member` varchar(255) DEFAULT NULL COMMENT '组织成员',
  `type` int(255) DEFAULT NULL COMMENT '1个人 2集体',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of honor
-- ----------------------------
BEGIN;
INSERT INTO `honor` VALUES (22, 70, 85, '1592928000000', NULL, NULL, NULL, 1, '1593064613205', 33);
INSERT INTO `honor` VALUES (23, 95, 100, '1593446400000', NULL, 'yy', 'yy', 2, '1593064628239', 34);
INSERT INTO `honor` VALUES (24, 69, 75, '1591632000000', NULL, NULL, NULL, 1, '1593137670379', 59);
INSERT INTO `honor` VALUES (25, 69, 75, '1592323200000', NULL, NULL, NULL, 1, '1593161254132', 60);
COMMIT;

-- ----------------------------
-- Table structure for jt_academic_innovation
-- ----------------------------
DROP TABLE IF EXISTS `jt_academic_innovation`;
CREATE TABLE `jt_academic_innovation` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '创新团队名称',
  `team_personnel` varchar(255) DEFAULT NULL COMMENT '团队人员',
  `direction` varchar(255) DEFAULT NULL COMMENT '研究方向',
  `school_place` varchar(255) DEFAULT NULL COMMENT '所在学校',
  `address` varchar(255) DEFAULT NULL COMMENT '通讯地址',
  `head_phone` char(11) DEFAULT NULL COMMENT '负责人联系电话',
  `declare_time` varchar(255) DEFAULT NULL COMMENT '申报日期',
  `competent_department` varchar(255) DEFAULT NULL COMMENT '主管部门',
  `level` enum('0','1','2','3') DEFAULT NULL COMMENT '等级',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL COMMENT 'table表的id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jt_academic_innovation
-- ----------------------------
BEGIN;
INSERT INTO `jt_academic_innovation` VALUES (1, 'e', 'e', 'e', 'e', 'e', '17376513235', '1592755200000', 'e', '0', NULL, '1593065783039', 46);
COMMIT;

-- ----------------------------
-- Table structure for jt_first_subject
-- ----------------------------
DROP TABLE IF EXISTS `jt_first_subject`;
CREATE TABLE `jt_first_subject` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `support_school` varchar(255) DEFAULT NULL COMMENT '依托学校',
  `name` varchar(255) DEFAULT NULL COMMENT '学科名称',
  `contact` varchar(255) DEFAULT NULL COMMENT '联系人',
  `phone` char(11) DEFAULT NULL COMMENT '联系电话',
  `declare_subject_name` varchar(255) DEFAULT NULL COMMENT '申报学科名称',
  `subject_leader` varchar(255) DEFAULT NULL COMMENT '学科带头人',
  `incept_name` varchar(255) DEFAULT NULL COMMENT '获得学位授权情况(名称)',
  `incept_time` varchar(255) DEFAULT NULL COMMENT '获得学位授权情况(时间)',
  `subject_third_evaluation` varchar(255) DEFAULT NULL COMMENT '学科第三方评价情况',
  `approval_department` varchar(255) DEFAULT NULL COMMENT '批准部门',
  `approval_time` varchar(255) DEFAULT NULL COMMENT '批准时间',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jt_first_subject
-- ----------------------------
BEGIN;
INSERT INTO `jt_first_subject` VALUES (1, 'rtre', 'ret', 'ret', '17376513713', 'ertret', 'ret', 'ret', '1592150400000', 'ret', 'rghh', '1592755200000', NULL, '1593065650263', 42);
COMMIT;

-- ----------------------------
-- Table structure for jt_lab
-- ----------------------------
DROP TABLE IF EXISTS `jt_lab`;
CREATE TABLE `jt_lab` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '实验室名称',
  `lab_approval_time` varchar(255) DEFAULT NULL COMMENT '实验室批准建设时间',
  `support_subject` varchar(255) DEFAULT NULL COMMENT '依托学科',
  `declare_start_time` varchar(255) DEFAULT NULL COMMENT '拟申报建设起始时间',
  `declare_end_time` varchar(255) DEFAULT NULL COMMENT '拟申报建设结束时间',
  `total_person` int(9) DEFAULT NULL COMMENT '人员总数',
  `head` varchar(255) DEFAULT NULL COMMENT '负责人',
  `lab_address` varchar(255) DEFAULT NULL COMMENT '实验室地址',
  `direction_one` varchar(255) DEFAULT NULL COMMENT '研究方向1',
  `direction_two` varchar(255) DEFAULT NULL COMMENT '研究方向2',
  `direction_three` varchar(255) DEFAULT NULL COMMENT '研究方向3',
  `approval_department` varchar(255) DEFAULT NULL COMMENT '批准部门',
  `approval_time` varchar(255) DEFAULT NULL COMMENT '批准时间',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jt_lab
-- ----------------------------
BEGIN;
INSERT INTO `jt_lab` VALUES (1, '非让水分', '1591027200000', '根深蒂固', '1591113600000', '1591113600000', 13, 'refer', '2132', '123', '放入', '3确认', 'ewrwt', '1591027200000', NULL, '1593065679203', 43);
COMMIT;

-- ----------------------------
-- Table structure for jt_production_union
-- ----------------------------
DROP TABLE IF EXISTS `jt_production_union`;
CREATE TABLE `jt_production_union` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '联盟名称',
  `union_effect_time` varchar(255) DEFAULT NULL COMMENT '联盟协议生效时间',
  `technology_field` varchar(255) DEFAULT NULL COMMENT '技术领域',
  `union_director` varchar(255) DEFAULT NULL COMMENT '联盟理事长',
  `unit_place` varchar(255) DEFAULT NULL COMMENT '所在单位',
  `phone` char(11) DEFAULT NULL COMMENT '联系方式',
  `standing_body_name` varchar(255) DEFAULT NULL COMMENT '联盟常设机构的依托单位名称',
  `standing_body_address` varchar(255) DEFAULT NULL COMMENT '常设机构通讯地址',
  `approval_department` varchar(255) DEFAULT NULL COMMENT '批准部门',
  `approval_time` varchar(255) DEFAULT NULL COMMENT '批准时间',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jt_production_union
-- ----------------------------
BEGIN;
INSERT INTO `jt_production_union` VALUES (1, 'e', '1591718400000', 'e', 'e', 'e', '17376517312', 'e', 'e', 'e', '1592841600000', NULL, '1593065768051', 45);
COMMIT;

-- ----------------------------
-- Table structure for jt_technological_innovation
-- ----------------------------
DROP TABLE IF EXISTS `jt_technological_innovation`;
CREATE TABLE `jt_technological_innovation` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `declare_unit` varchar(255) DEFAULT NULL COMMENT '申报单位',
  `plan_category` varchar(255) DEFAULT NULL COMMENT '计划类别',
  `special_name` varchar(255) DEFAULT NULL COMMENT '专题名称',
  `support_unit` varchar(255) DEFAULT NULL COMMENT '支持单位',
  `declare_time` varchar(255) DEFAULT NULL COMMENT '申报时间',
  `organization_unit` varchar(255) DEFAULT NULL COMMENT '组织单位',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `declare_unit_name` varchar(255) DEFAULT NULL COMMENT '申报单位名称',
  `head` varchar(255) DEFAULT NULL COMMENT '负责人',
  `phone` char(11) DEFAULT NULL COMMENT '联系方式',
  `approval_department` varchar(255) DEFAULT NULL COMMENT '批准部门',
  `approval_time` varchar(255) DEFAULT NULL COMMENT '批准时间',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jt_technological_innovation
-- ----------------------------
BEGIN;
INSERT INTO `jt_technological_innovation` VALUES (1, 'q', 'qqq', 'q', 'q', 'q', '1591545600000', 'q', 'q', 'q', 'q', '17376517313', 'q', '1591718400000', NULL, '1593065748781', 44);
COMMIT;

-- ----------------------------
-- Table structure for jx_achievement_prize
-- ----------------------------
DROP TABLE IF EXISTS `jx_achievement_prize`;
CREATE TABLE `jx_achievement_prize` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '成果名称',
  `complete_person` varchar(255) DEFAULT NULL COMMENT '成果完成人',
  `complete_unit` varchar(255) DEFAULT NULL COMMENT '成果完成单位',
  `section_category` varchar(255) DEFAULT NULL COMMENT '成果科类',
  `declare_unit` varchar(255) DEFAULT NULL COMMENT '申报单位',
  `code` char(7) DEFAULT NULL COMMENT '代码',
  `apply_time` varchar(255) DEFAULT NULL COMMENT '申请时间',
  `grade` int(11) DEFAULT NULL COMMENT '等级 0:国家级 1:省部级 2:市厅级 3:校院级',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jx_achievement_prize
-- ----------------------------
BEGIN;
INSERT INTO `jx_achievement_prize` VALUES (1, 'fsdf', '3', '3', '3', '3', '3', '1591027200000', 5, NULL, '1593066272367', 53);
COMMIT;

-- ----------------------------
-- Table structure for jx_competition_direct
-- ----------------------------
DROP TABLE IF EXISTS `jx_competition_direct`;
CREATE TABLE `jx_competition_direct` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '竞赛名称',
  `organizer` varchar(255) DEFAULT NULL COMMENT '主办单位',
  `participating_number` int(9) DEFAULT NULL COMMENT '参赛人数',
  `competition_leader` varchar(255) DEFAULT NULL COMMENT '竞赛负责人',
  `responsible_teacher` varchar(255) DEFAULT NULL COMMENT '培训主要负责教师',
  `phone` char(11) DEFAULT NULL COMMENT '联系方式',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `agency_address` varchar(255) DEFAULT NULL COMMENT '常设机构通讯地址',
  `approval_department` varchar(255) DEFAULT NULL COMMENT '批准部门',
  `approval_time` varchar(255) DEFAULT NULL COMMENT '批准时间',
  `grade` enum('0','1','2','3','4') DEFAULT NULL COMMENT '等级0:国家级 1:省级 2:市级 3:校级 4:院级',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jx_competition_direct
-- ----------------------------
BEGIN;
INSERT INTO `jx_competition_direct` VALUES (1, 'w', 'w', 33, 'w', '3', '17376513232', 'w', 'w', 'w', '1592323200000', '2', NULL, '1593066173074', 49);
COMMIT;

-- ----------------------------
-- Table structure for jx_course_construction
-- ----------------------------
DROP TABLE IF EXISTS `jx_course_construction`;
CREATE TABLE `jx_course_construction` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '课程名字',
  `professional_place` varchar(255) DEFAULT NULL COMMENT '所属专业',
  `course_leader` varchar(255) DEFAULT NULL COMMENT '课程负责人',
  `teacher_main` varchar(255) DEFAULT NULL COMMENT '主讲教师',
  `teacher_professional` varchar(255) DEFAULT NULL COMMENT '主讲教师的专业领域',
  `teacher_certificate` varchar(255) DEFAULT NULL COMMENT '主讲教师的职业资格证书',
  `declare_time` varchar(255) DEFAULT NULL COMMENT '申报时间',
  `course_category` int(11) DEFAULT NULL COMMENT '课程类型 0:优质核心课程 1:一般教改课程',
  `grade` int(11) DEFAULT NULL COMMENT '等级 0:国家级 1:省部级 2:市厅级 3:校院级',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jx_course_construction
-- ----------------------------
BEGIN;
INSERT INTO `jx_course_construction` VALUES (1, 'q', 'q', 'q', 'q', 'q', 'q', '1593100800000', 0, 1, NULL, '1593066315091', 56);
COMMIT;

-- ----------------------------
-- Table structure for jx_educational_reform
-- ----------------------------
DROP TABLE IF EXISTS `jx_educational_reform`;
CREATE TABLE `jx_educational_reform` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `project_leader` varchar(255) DEFAULT NULL COMMENT '项目负责人',
  `unit_place` varchar(255) DEFAULT NULL COMMENT '所属单位',
  `professional_place` varchar(255) DEFAULT NULL COMMENT '项目所属专业',
  `course_name` varchar(255) DEFAULT NULL COMMENT '讲授的主要课程名称',
  `course_category` varchar(255) DEFAULT NULL COMMENT '讲授的主要课程类别',
  `subject_name` varchar(255) DEFAULT NULL COMMENT '主持的教学研究课题名称',
  `subject_source` varchar(255) DEFAULT NULL COMMENT '主持的教学研究课题来源',
  `declare_time` varchar(255) DEFAULT NULL COMMENT '申报时间',
  `project_category` enum('0','1','2') DEFAULT NULL COMMENT '项目类别 0:总体研究 1:专业大类 2:教学管理',
  `declare_category` enum('0','1') DEFAULT NULL COMMENT '申报项目类别 0:重点项目 1:一般项目',
  `grade` enum('0','1','2','3') DEFAULT NULL COMMENT '等级 0:国家级 1:省部级 2:市厅级 3:校院级',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jx_educational_reform
-- ----------------------------
BEGIN;
INSERT INTO `jx_educational_reform` VALUES (1, '3', '3', '3', '3', '3', '3', '3', '3', '1591804800000', '1', '1', '1', NULL, '1593066184636', 50);
COMMIT;

-- ----------------------------
-- Table structure for jx_professional_building
-- ----------------------------
DROP TABLE IF EXISTS `jx_professional_building`;
CREATE TABLE `jx_professional_building` (
  `id` int(13) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '新增专业名称',
  `department_place` varchar(255) DEFAULT NULL COMMENT '所在院系',
  `professional_leader` varchar(255) DEFAULT NULL COMMENT '专业负责人',
  `phone` char(11) DEFAULT NULL COMMENT '联系方式',
  `grade` enum('0','1','2','3','4') DEFAULT NULL COMMENT '等级 0:国家级 1:省级 2:市厅级 3:校院级 4:新专业',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jx_professional_building
-- ----------------------------
BEGIN;
INSERT INTO `jx_professional_building` VALUES (1, 'q', 'q', 'q', '17376513231', '3', NULL, '1593066340387', 58);
COMMIT;

-- ----------------------------
-- Table structure for jx_skill_competition
-- ----------------------------
DROP TABLE IF EXISTS `jx_skill_competition`;
CREATE TABLE `jx_skill_competition` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '竞赛名称',
  `professional_subject` varchar(255) DEFAULT NULL COMMENT '专业学科',
  `leader` varchar(255) DEFAULT NULL COMMENT '负责人',
  `phone` char(11) DEFAULT NULL COMMENT '联系方式',
  `winning_grade` enum('0','1','2') DEFAULT NULL COMMENT '获奖等级0:省级1:校级 2:院级',
  `prize` enum('0','1','2','3','4') DEFAULT NULL COMMENT '0:特等奖 1:一等奖 2:二等奖 3:三等奖 4:优胜奖',
  `file_id` int(11) DEFAULT NULL,
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jx_skill_competition
-- ----------------------------
BEGIN;
INSERT INTO `jx_skill_competition` VALUES (1, '电话', 'e', 'e', '17376513745', '1', '1', NULL, '1593066146336', 48);
COMMIT;

-- ----------------------------
-- Table structure for jx_student_research
-- ----------------------------
DROP TABLE IF EXISTS `jx_student_research`;
CREATE TABLE `jx_student_research` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `project_leader` varchar(255) DEFAULT NULL COMMENT '工程负责人',
  `tutor` varchar(255) DEFAULT NULL COMMENT '指导教师',
  `phone` char(11) DEFAULT NULL COMMENT '联系方式',
  `winning_grade` enum('0','1','2','3') DEFAULT NULL COMMENT '获奖等级0:国家级1:省级2:市厅级3:校院级',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jx_student_research
-- ----------------------------
BEGIN;
INSERT INTO `jx_student_research` VALUES (1, '通过', '还飞鸽的', '规范化', '17376513745', '2', NULL, '1593066129143', 47);
COMMIT;

-- ----------------------------
-- Table structure for jx_teaching_reform
-- ----------------------------
DROP TABLE IF EXISTS `jx_teaching_reform`;
CREATE TABLE `jx_teaching_reform` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '名称',
  `grade` enum('0','1','2','3') DEFAULT NULL COMMENT '等级 0:一级B与理工医一级 1:二级与EI期刊 2:三级与EI会议 3:论文集或增刊',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jx_teaching_reform
-- ----------------------------
BEGIN;
INSERT INTO `jx_teaching_reform` VALUES (1, 'q', '1', NULL, '1593066280003', 54);
COMMIT;

-- ----------------------------
-- Table structure for jx_textbook_compilation
-- ----------------------------
DROP TABLE IF EXISTS `jx_textbook_compilation`;
CREATE TABLE `jx_textbook_compilation` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '教材名称',
  `editor_chief` varchar(255) DEFAULT NULL COMMENT '主编姓名',
  `ginseng_name` varchar(255) DEFAULT NULL COMMENT '参编姓名',
  `course_status` varchar(255) DEFAULT NULL COMMENT '本课程在专业课程体系中的地位',
  `course_condition` varchar(255) DEFAULT NULL COMMENT '本课程现有教材状况分析',
  `course_feature` varchar(255) DEFAULT NULL COMMENT '本课程的主要特色与创新',
  `write_person` varchar(255) DEFAULT NULL COMMENT '教材目录及编写人员',
  `write_finish_time` varchar(255) DEFAULT NULL COMMENT '教材编写计划完成时间',
  `declare_time` varchar(255) DEFAULT NULL COMMENT '申报日期',
  `grade` enum('0','1','2','3','4','5') DEFAULT NULL COMMENT '等级 0:国家级 1:省部级 2:市厅级 3:校级 4:院级 5:未立项',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of jx_textbook_compilation
-- ----------------------------
BEGIN;
INSERT INTO `jx_textbook_compilation` VALUES (1, 'q', 'q', 'q', 'q', 'q', 'qq', 'q', '1590940800000', '1593014400000', '2', NULL, '1593066327299', 57);
COMMIT;

-- ----------------------------
-- Table structure for list
-- ----------------------------
DROP TABLE IF EXISTS `list`;
CREATE TABLE `list` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL COMMENT '哪一个类型的下拉框',
  `label` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `target` varchar(255) DEFAULT NULL COMMENT '哪一个页面的',
  `parentId` int(11) DEFAULT NULL COMMENT '上一级id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of list
-- ----------------------------
BEGIN;
INSERT INTO `list` VALUES (1, 'publication_type', '工会', '1', 'paper', NULL);
INSERT INTO `list` VALUES (2, 'publication_type', '专著', '2', 'paper', NULL);
INSERT INTO `list` VALUES (3, 'publication_type', '专利', '3', 'paper', NULL);
INSERT INTO `list` VALUES (4, 'publication_type', '纵向', '4', 'paper', NULL);
INSERT INTO `list` VALUES (5, 'publication_type', '横向', '5', 'paper', NULL);
INSERT INTO `list` VALUES (6, 'publication_type', '工具资料性期刊', '6', 'paper', NULL);
INSERT INTO `list` VALUES (7, 'publication_type', '行业性期刊', '7', 'paper', NULL);
INSERT INTO `list` VALUES (8, 'paperGrades', '省级期刊', '1', 'paper', NULL);
INSERT INTO `list` VALUES (9, 'paperGrades', '国家级期刊', '2', 'paper', NULL);
INSERT INTO `list` VALUES (10, 'paperGrades', '核心期刊', '3', 'paper', NULL);
INSERT INTO `list` VALUES (15, 'paperCompanys', '单位01', '1', 'paper', NULL);
INSERT INTO `list` VALUES (16, 'paperCompanys', '单位02', '2', 'paper', NULL);
INSERT INTO `list` VALUES (17, 'paperCompanys', '单位03', '3', 'paper', NULL);
INSERT INTO `list` VALUES (18, 'paperCompanys', '单位04', '4', 'paper', NULL);
INSERT INTO `list` VALUES (19, 'paperCompanys', '单位05', '5', 'paper', NULL);
INSERT INTO `list` VALUES (22, 'subjects', '学科1', '1', 'paper', NULL);
INSERT INTO `list` VALUES (23, 'subjects', '学科2', '2', 'paper', NULL);
INSERT INTO `list` VALUES (24, 'subjects', '学科3', '3', 'paper', NULL);
INSERT INTO `list` VALUES (25, 'subjects', '学科4', '4', 'paper', NULL);
INSERT INTO `list` VALUES (29, 'researchSelf', '论文', '1', 'scientific', NULL);
INSERT INTO `list` VALUES (30, 'researchSelf', '专著', '2', 'scientific', NULL);
INSERT INTO `list` VALUES (31, 'researchSelf', '专利', '3', 'scientific', NULL);
INSERT INTO `list` VALUES (32, 'researchSelf', '纵向科研项目', '4', 'scientific', NULL);
INSERT INTO `list` VALUES (33, 'researchSelf', '横向科研项目', '5', 'scientific', NULL);
INSERT INTO `list` VALUES (34, 'researchGroup', '重点(一流学科)', '1', 'scientific', NULL);
INSERT INTO `list` VALUES (35, 'researchGroup', '重点实验室', '2', 'scientific', NULL);
INSERT INTO `list` VALUES (36, 'researchGroup', '科技创新平台', '3', 'scientific', NULL);
INSERT INTO `list` VALUES (37, 'researchGroup', '产学科研联盟', '4', 'scientific', NULL);
INSERT INTO `list` VALUES (39, 'researchGroup', '学术创新团队', '5', 'scientific', NULL);
INSERT INTO `list` VALUES (40, 'researchSelfPatent', '发明', '1', 'scientific', 31);
INSERT INTO `list` VALUES (41, 'researchSelfPatent', '使用新型', '2', 'scientific', 31);
INSERT INTO `list` VALUES (42, 'researchSelfPatent', '外观设计专利', '3', 'scientific', 31);
INSERT INTO `list` VALUES (43, 'researchSelfPatent', '软件著作', '4', 'scientific', 31);
INSERT INTO `list` VALUES (44, 'researchSelfPatent', '专利转让', '5', 'scientific', 31);
INSERT INTO `list` VALUES (45, 'researchSelfHorizLevel', '国家级', '1', 'scientific', 33);
INSERT INTO `list` VALUES (46, 'researchSelfHorizLevel', '省部级', '2', 'scientific', 33);
INSERT INTO `list` VALUES (47, 'researchSelfHorizLevel', '市厅级', '3', 'scientific', 33);
INSERT INTO `list` VALUES (48, 'researchSelfHorizLevel', '校院级', '4', 'scientific', 33);
INSERT INTO `list` VALUES (49, 'researchGroupAcademicLevel', '国家级', '1', 'scientific', 39);
INSERT INTO `list` VALUES (50, 'researchGroupAcademicLevel', '省部级', '2', 'scientific', 39);
INSERT INTO `list` VALUES (51, 'researchGroupAcademicLevel', '市厅级', '3', 'scientific', 39);
INSERT INTO `list` VALUES (52, 'researchGroupAcademicLevel', '校院级', '4', 'scientific', 39);
INSERT INTO `list` VALUES (53, 'grade', '国家级--特等', '1', 'achiecement', NULL);
INSERT INTO `list` VALUES (54, 'grade', '国家级--一等', '2', 'achiecement', NULL);
INSERT INTO `list` VALUES (55, 'grade', '国家级--二等', '3', 'achiecement', NULL);
INSERT INTO `list` VALUES (56, 'grade', '省级--一等', '4', 'achiecement', NULL);
INSERT INTO `list` VALUES (57, 'grade', '省级--二等', '5', 'achiecement', NULL);
INSERT INTO `list` VALUES (58, 'grade', '市厅级--校级', '6', 'achiecement', NULL);
INSERT INTO `list` VALUES (59, 'grade', '市厅级--院级', '7', 'achiecement', NULL);
INSERT INTO `list` VALUES (60, 'grade', '市厅级--一等', '8', 'achiecement', NULL);
INSERT INTO `list` VALUES (61, 'grade', '市厅级--二等', '9', 'achiecement', NULL);
INSERT INTO `list` VALUES (62, 'grade', '市厅级--三等', '10', 'achiecement', NULL);
INSERT INTO `list` VALUES (63, 'grade', '国家级', '1', 'competition', NULL);
INSERT INTO `list` VALUES (64, 'grade', '省部级', '2', 'competition', NULL);
INSERT INTO `list` VALUES (65, 'grade', '市厅级', '3', 'competition', NULL);
INSERT INTO `list` VALUES (66, 'grade', '校院级--一类等', '4', 'competition', NULL);
INSERT INTO `list` VALUES (67, 'grade', '校院级--二类等', '5', 'competition', NULL);
INSERT INTO `list` VALUES (68, 'grade', '校院级--艺体类', '6', 'competition', NULL);
INSERT INTO `list` VALUES (69, 'honorSelefTitle', '工会', '1', 'honor', NULL);
INSERT INTO `list` VALUES (70, 'honorSelefTitle', '人事', '2', 'honor', NULL);
INSERT INTO `list` VALUES (71, 'honorSelefTitle', '组织', '3', 'honor', NULL);
INSERT INTO `list` VALUES (72, 'honorSelefTitle', '综保', '4', 'honor', NULL);
INSERT INTO `list` VALUES (73, 'honorSelefTitle', '科研', '5', 'honor', NULL);
INSERT INTO `list` VALUES (74, 'honorSelefTitle', '教务', '6', 'honor', NULL);
INSERT INTO `list` VALUES (75, 'honorSelefTitleSon', '巾帼文明示范岗先进个人', '1', 'honor', 69);
INSERT INTO `list` VALUES (76, 'honorSelefTitleSon', '事业家庭兼顾型先进个人', '2', 'honor', 69);
INSERT INTO `list` VALUES (77, 'honorSelefTitleSon', '师德标兵', '3', 'honor', 69);
INSERT INTO `list` VALUES (78, 'honorSelefTitleSon', '三育人先进个人', '4', 'honor', 69);
INSERT INTO `list` VALUES (79, 'honorSelefTitleSon', '“杭州教育工匠”暨“最美思政教师”', '5', 'honor', 69);
INSERT INTO `list` VALUES (80, 'honorSelefTitleSon', '最美班主任', '6', 'honor', 69);
INSERT INTO `list` VALUES (81, 'honorSelefTitleSon', '优秀共产党员', '7', 'honor', 69);
INSERT INTO `list` VALUES (82, 'honorSelefTitleSon', '工会活动积极分子', '8', 'honor', 69);
INSERT INTO `list` VALUES (83, 'honorSelefTitleSon', '优秀工会工作者', '9', 'honor', 69);
INSERT INTO `list` VALUES (84, 'honorSelefTitleSon', '年度考核优秀', '1', 'honor', 70);
INSERT INTO `list` VALUES (85, 'honorSelefTitleSon', '优秀教师', '2', 'honor', 70);
INSERT INTO `list` VALUES (86, 'honorSelefTitleSon', '优秀教育工作者', '3', 'honor', 70);
INSERT INTO `list` VALUES (87, 'honorSelefTitleSon', '优秀共产党员', '1', 'honor', 71);
INSERT INTO `list` VALUES (88, 'honorSelefTitleSon', '优秀党务工作者', '2', 'honor', 71);
INSERT INTO `list` VALUES (89, 'honorSelefTitleSon', '平安校园先进个人', '1', 'honor', 72);
INSERT INTO `list` VALUES (90, 'honorSelefTitleSon', '科研十佳', '1', 'honor', 73);
INSERT INTO `list` VALUES (91, 'honorSelefTitleSon', '我心目中的好老师', '1', 'honor', 74);
INSERT INTO `list` VALUES (92, 'honorSelefTitleSon', '教学考核优秀', '2', 'honor', 74);
INSERT INTO `list` VALUES (93, 'honorGroupTitle', '工会', '1', 'honor', NULL);
INSERT INTO `list` VALUES (94, 'honorGroupTitle', '人事', '2', 'honor', NULL);
INSERT INTO `list` VALUES (95, 'honorGroupTitle', '组织', '3', 'honor', NULL);
INSERT INTO `list` VALUES (96, 'honorGroupTitle', '综保', '4', 'honor', NULL);
INSERT INTO `list` VALUES (97, 'honorGroupTitleSon', '巾帼文明示范岗先进集体', '1', 'honor', 93);
INSERT INTO `list` VALUES (98, 'honorGroupTitleSon', '三育人先进集体', '2', 'honor', 93);
INSERT INTO `list` VALUES (99, 'honorGroupTitleSon', '优秀教研室', '1', 'honor', 94);
INSERT INTO `list` VALUES (100, 'honorGroupTitleSon', '优秀基层党组织', '1', 'honor', 95);
INSERT INTO `list` VALUES (101, 'honorGroupTitleSon', '平安校园先进集体', '1', 'honor', 96);
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(64) DEFAULT NULL COMMENT '请求路径',
  `path` varchar(64) DEFAULT NULL COMMENT '访问路劲',
  `component` varchar(64) DEFAULT NULL COMMENT '模块名称',
  `name` varchar(64) DEFAULT NULL COMMENT '标题',
  `iconCls` varchar(64) DEFAULT NULL COMMENT '图标',
  `keepAlive` tinyint(1) DEFAULT NULL COMMENT '是否保持连接',
  `requireAuth` tinyint(1) DEFAULT '1' COMMENT '要求授权',
  `parentId` int(11) DEFAULT NULL COMMENT '父ID',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '0：无效1有效',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `parentId` (`parentId`) USING BTREE,
  CONSTRAINT `menu_ibfk_1` FOREIGN KEY (`parentId`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, '/', '', '', '首页', '', NULL, NULL, NULL, 1);
INSERT INTO `menu` VALUES (2, '/', '/home', 'Home', '个人信息', 'Steve-Jobs', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (3, '/', '/home', 'Home', '业绩登记', 'error', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (4, '/', '/home', 'Home', '业绩审核', 'redis', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (5, '/', '/home', 'Home', '业绩汇总', 'chart', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (6, '/', '/home', 'Home', '系统管理', 'system', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (7, '/employee/basic/**', '/personalinf/basic', 'EmpBasic', '基本信息', NULL, NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (8, '/employee/advanced/**', '/personalinf/adv', 'EmpAdv', '业绩信息', NULL, NULL, 1, 2, 1);
INSERT INTO `menu` VALUES (9, '/employee/advanced/**', '/personalinf/adv', 'EmpAdv', '业绩模块', 'fwb', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (10, '/personnel/train/**', '/achievementInput/Perhonor', 'Perhonor', '荣誉录入界面', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (11, '/personnel/ec/**', '/achievementInput/Perscientific', 'Perscientific', '科研业绩录入', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (13, '/personnel/remove/**', '/achievementInput/Perteacher', 'Perteacher', '教学业绩录入', NULL, NULL, 1, 3, 1);
INSERT INTO `menu` VALUES (14, '/audit/sob/**', '/audit/ResearchAudit', 'AuditResearch', '教研室/院级审核', NULL, NULL, 1, 4, 1);
INSERT INTO `menu` VALUES (19, '/statistics/all/**', '/sta/all', 'StaAll', '业绩汇总', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (21, '/statistics/personnel/**', '/sta/pers', 'StaPers', '个人业绩', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (22, '/statistics/recored/**', '/sta/StaGroup', 'StaGroup', '集体业绩', NULL, NULL, 1, 5, 1);
INSERT INTO `menu` VALUES (24, '/system/peo/**', '/sys/peo', 'SysPeoPle', '人员管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (25, '/system/menu/**', '/sys/menu', 'SysMenu', '菜单管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (26, '/system/user/**', '/sys/user', 'SysUser', '角色管理', NULL, NULL, 1, 6, 1);
INSERT INTO `menu` VALUES (32, '/', '/home', 'Home', '首页', 'fa fa-windows', NULL, 1, 1, 1);
INSERT INTO `menu` VALUES (56, '/system/pedding/**', '/sys/peddingList', 'peddingList', '待办列表', NULL, NULL, 1, 57, 0);
INSERT INTO `menu` VALUES (57, '/', '/home', 'Home', '待办管理', 'email', NULL, 1, 1, 0);
INSERT INTO `menu` VALUES (59, '/Grade/Grade/**', '/Grade/GradeSetting', 'GradeSetting', '业绩配置', '', NULL, 1, 9, 1);
INSERT INTO `menu` VALUES (60, '/Grade/Grade/**', '/Grade/GradeCollect', 'GradeCollect', '业绩汇总', '', NULL, 1, 9, 1);
INSERT INTO `menu` VALUES (61, '/', '/home', 'Home', '首页', NULL, NULL, 1, 32, 1);
COMMIT;

-- ----------------------------
-- Table structure for menu_role
-- ----------------------------
DROP TABLE IF EXISTS `menu_role`;
CREATE TABLE `menu_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `mid` (`mid`) USING BTREE,
  KEY `rid` (`rid`) USING BTREE,
  CONSTRAINT `menu_role_ibfk_1` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`) ON DELETE CASCADE,
  CONSTRAINT `menu_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1185 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of menu_role
-- ----------------------------
BEGIN;
INSERT INTO `menu_role` VALUES (1138, 2, 6);
INSERT INTO `menu_role` VALUES (1139, 3, 6);
INSERT INTO `menu_role` VALUES (1140, 4, 6);
INSERT INTO `menu_role` VALUES (1141, 5, 6);
INSERT INTO `menu_role` VALUES (1142, 6, 6);
INSERT INTO `menu_role` VALUES (1143, 7, 6);
INSERT INTO `menu_role` VALUES (1144, 8, 6);
INSERT INTO `menu_role` VALUES (1145, 10, 6);
INSERT INTO `menu_role` VALUES (1146, 11, 6);
INSERT INTO `menu_role` VALUES (1147, 13, 6);
INSERT INTO `menu_role` VALUES (1148, 14, 6);
INSERT INTO `menu_role` VALUES (1149, 19, 6);
INSERT INTO `menu_role` VALUES (1150, 21, 6);
INSERT INTO `menu_role` VALUES (1151, 22, 6);
INSERT INTO `menu_role` VALUES (1152, 24, 6);
INSERT INTO `menu_role` VALUES (1153, 25, 6);
INSERT INTO `menu_role` VALUES (1154, 26, 6);
INSERT INTO `menu_role` VALUES (1155, 32, 6);
INSERT INTO `menu_role` VALUES (1159, 59, 6);
INSERT INTO `menu_role` VALUES (1160, 60, 6);
INSERT INTO `menu_role` VALUES (1161, 61, 6);
INSERT INTO `menu_role` VALUES (1162, 9, 6);
INSERT INTO `menu_role` VALUES (1163, 59, 3);
INSERT INTO `menu_role` VALUES (1164, 60, 3);
INSERT INTO `menu_role` VALUES (1165, 9, 3);
INSERT INTO `menu_role` VALUES (1170, 7, 1);
INSERT INTO `menu_role` VALUES (1171, 8, 1);
INSERT INTO `menu_role` VALUES (1172, 10, 1);
INSERT INTO `menu_role` VALUES (1173, 11, 1);
INSERT INTO `menu_role` VALUES (1174, 13, 1);
INSERT INTO `menu_role` VALUES (1175, 14, 1);
INSERT INTO `menu_role` VALUES (1176, 19, 1);
INSERT INTO `menu_role` VALUES (1177, 21, 1);
INSERT INTO `menu_role` VALUES (1178, 22, 1);
INSERT INTO `menu_role` VALUES (1179, 61, 1);
INSERT INTO `menu_role` VALUES (1180, 2, 1);
INSERT INTO `menu_role` VALUES (1181, 3, 1);
INSERT INTO `menu_role` VALUES (1182, 4, 1);
INSERT INTO `menu_role` VALUES (1183, 5, 1);
INSERT INTO `menu_role` VALUES (1184, 32, 1);
COMMIT;

-- ----------------------------
-- Table structure for office
-- ----------------------------
DROP TABLE IF EXISTS `office`;
CREATE TABLE `office` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `office` enum('A-101','B-203','C-404','D-502','B-304','C-405','C-203','D-503') DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of office
-- ----------------------------
BEGIN;
INSERT INTO `office` VALUES (1, 'A-101');
INSERT INTO `office` VALUES (2, 'B-203');
INSERT INTO `office` VALUES (3, 'C-404');
INSERT INTO `office` VALUES (4, 'D-502');
INSERT INTO `office` VALUES (5, 'B-304');
INSERT INTO `office` VALUES (6, 'C-405');
INSERT INTO `office` VALUES (7, 'C-203');
INSERT INTO `office` VALUES (8, 'D-503');
COMMIT;

-- ----------------------------
-- Table structure for pedding
-- ----------------------------
DROP TABLE IF EXISTS `pedding`;
CREATE TABLE `pedding` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(2) DEFAULT NULL COMMENT '消息类型：1,个人;2,集体',
  `role` varchar(20) DEFAULT NULL COMMENT '消息角色:发送给哪个角色',
  `main` varchar(255) DEFAULT NULL COMMENT '消息主体',
  `name` varchar(255) DEFAULT NULL COMMENT '消息名称',
  `tableId` varchar(11) DEFAULT NULL COMMENT '表格id',
  `state` enum('0','1','2','3','4') DEFAULT NULL COMMENT '消息状态：0待审核;1教研室通过;2教研室未通过;3分院通过;4分院未通过',
  `url` varchar(255) DEFAULT NULL COMMENT '消息地址',
  `operator` varchar(20) DEFAULT NULL COMMENT '发起人',
  `createTime` varchar(255) DEFAULT NULL COMMENT '发起时间',
  `updateTime` varchar(255) DEFAULT NULL COMMENT '处理时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of pedding
-- ----------------------------
BEGIN;
INSERT INTO `pedding` VALUES (31, '1', NULL, '有一条申请需要审核', '审核', '33', '3', '/audit/ResearchAudit', '3', '1593064613209', '1593152942358');
INSERT INTO `pedding` VALUES (32, '1', '6', '有一条申请需要审核', '审核', '34', '0', '/audit/ResearchAudit', '3', '1593064628242', NULL);
INSERT INTO `pedding` VALUES (33, '1', '6', '有一条申请需要审核', '审核', '35', '0', '/audit/ResearchAudit', '3', '1593064646753', NULL);
INSERT INTO `pedding` VALUES (34, '1', '6', '有一条申请需要审核', '审核', '36', '0', '/audit/ResearchAudit', '3', '1593064668502', NULL);
INSERT INTO `pedding` VALUES (35, '1', '6', '有一条申请需要审核', '审核', '37', '0', '/audit/ResearchAudit', '3', '1593064677434', NULL);
INSERT INTO `pedding` VALUES (36, '1', '6', '有一条申请需要审核', '审核', '38', '0', '/audit/ResearchAudit', '3', '1593064694666', NULL);
INSERT INTO `pedding` VALUES (39, '1', '6', '有一条申请需要审核', '审核', '41', '0', '/audit/ResearchAudit', '3', '1593065606709', NULL);
INSERT INTO `pedding` VALUES (40, '1', '6', '有一条申请需要审核', '审核', '42', '0', '/audit/ResearchAudit', '3', '1593065650265', NULL);
INSERT INTO `pedding` VALUES (41, '1', '6', '有一条申请需要审核', '审核', '43', '0', '/audit/ResearchAudit', '3', '1593065679205', NULL);
INSERT INTO `pedding` VALUES (42, '1', '6', '有一条申请需要审核', '审核', '44', '0', '/audit/ResearchAudit', '3', '1593065748783', NULL);
INSERT INTO `pedding` VALUES (43, '1', '6', '有一条申请需要审核', '审核', '45', '0', '/audit/ResearchAudit', '3', '1593065768054', NULL);
INSERT INTO `pedding` VALUES (44, '1', '6', '有一条申请需要审核', '审核', '46', '0', '/audit/ResearchAudit', '3', '1593065783041', NULL);
INSERT INTO `pedding` VALUES (45, '1', '6', '有一条申请需要审核', '审核', '47', '0', '/audit/ResearchAudit', '3', '1593066129145', NULL);
INSERT INTO `pedding` VALUES (46, '1', '6', '有一条申请需要审核', '审核', '48', '0', '/audit/ResearchAudit', '3', '1593066146339', NULL);
INSERT INTO `pedding` VALUES (47, '1', '6', '有一条申请需要审核', '审核', '49', '0', '/audit/ResearchAudit', '3', '1593066173076', NULL);
INSERT INTO `pedding` VALUES (48, '1', '6', '有一条申请需要审核', '审核', '50', '0', '/audit/ResearchAudit', '3', '1593066184638', NULL);
INSERT INTO `pedding` VALUES (49, '1', '6', '有一条申请需要审核', '审核', '51', '0', '/audit/ResearchAudit', '3', '1593066197605', NULL);
INSERT INTO `pedding` VALUES (50, '1', '6', '有一条申请需要审核', '审核', '52', '0', '/audit/ResearchAudit', '3', '1593066228688', NULL);
INSERT INTO `pedding` VALUES (51, '1', '6', '有一条申请需要审核', '审核', '53', '0', '/audit/ResearchAudit', '3', '1593066272369', NULL);
INSERT INTO `pedding` VALUES (52, '1', '6', '有一条申请需要审核', '审核', '54', '0', '/audit/ResearchAudit', '3', '1593066280005', NULL);
INSERT INTO `pedding` VALUES (53, '1', '6', '有一条申请需要审核', '审核', '55', '0', '/audit/ResearchAudit', '3', '1593066290440', NULL);
INSERT INTO `pedding` VALUES (54, '1', '6', '有一条申请需要审核', '审核', '56', '0', '/audit/ResearchAudit', '3', '1593066315093', NULL);
INSERT INTO `pedding` VALUES (55, '1', '6', '有一条申请需要审核', '审核', '57', '0', '/audit/ResearchAudit', '3', '1593066327301', NULL);
INSERT INTO `pedding` VALUES (56, '1', '6', '有一条申请需要审核', '审核', '58', '0', '/audit/ResearchAudit', '3', '1593066340389', NULL);
INSERT INTO `pedding` VALUES (57, '1', NULL, '有一条申请需要审核', '审核', '59', '4', '/audit/ResearchAudit', '17', '1593137670382', '1593153734060');
INSERT INTO `pedding` VALUES (58, '1', '6', '有一条申请需要审核', '审核', '60', '0', '/audit/ResearchAudit', '3', '1593161254144', NULL);
COMMIT;

-- ----------------------------
-- Table structure for performance
-- ----------------------------
DROP TABLE IF EXISTS `performance`;
CREATE TABLE `performance` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `table_son_id` int(255) DEFAULT NULL COMMENT '业绩名称',
  `table_id` int(255) DEFAULT NULL COMMENT '业绩类别',
  `time` varchar(255) DEFAULT NULL COMMENT '时间',
  `first_author` tinyint(1) DEFAULT NULL COMMENT '是否是第一作者',
  `complete_author` varchar(255) DEFAULT NULL COMMENT '完成者',
  `grade` varchar(255) DEFAULT NULL COMMENT '级别',
  `performance_point` double(14,0) DEFAULT NULL COMMENT '业绩点',
  `audit_condition` int(11) DEFAULT NULL COMMENT '审核情况1:通过 2:审核中 3:未通过',
  `material_condition` int(11) DEFAULT NULL COMMENT '佐证材料上交情况1:通过 2:审核中 3:未通过',
  `note` text COMMENT '备注',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) DEFAULT NULL,
  `nameZh` varchar(64) DEFAULT NULL COMMENT '角色名称',
  `state` int(1) DEFAULT '1' COMMENT '是否有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'ROLE_manager', '计算机教研室', 1);
INSERT INTO `role` VALUES (2, 'ROLE_personnel', '机械教研室', 1);
INSERT INTO `role` VALUES (3, 'ROLE_recruiterd', '工业教研室', 1);
INSERT INTO `role` VALUES (4, 'ROLE_train', '电子教研室', 1);
INSERT INTO `role` VALUES (5, 'ROLE_performance', '高分子教研室', 1);
INSERT INTO `role` VALUES (6, 'ROLE_admin', '分院管理员', 1);
INSERT INTO `role` VALUES (13, 'ROLE_test2', '数学教研室', 1);
INSERT INTO `role` VALUES (14, 'ROLE_test1', '应化教研室', 1);
INSERT INTO `role` VALUES (27, 'ROLE_yiban', '普通用户', 1);
COMMIT;

-- ----------------------------
-- Table structure for table
-- ----------------------------
DROP TABLE IF EXISTS `table`;
CREATE TABLE `table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(11) DEFAULT NULL COMMENT '发起人id',
  `table_name` varchar(255) DEFAULT NULL COMMENT '表格名称',
  `state` varchar(11) DEFAULT NULL COMMENT '业绩类型',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of table
-- ----------------------------
BEGIN;
INSERT INTO `table` VALUES (33, '3', 'honor', '22');
INSERT INTO `table` VALUES (34, '3', 'honor', '23');
INSERT INTO `table` VALUES (35, '3', 'tb_paper', '7');
INSERT INTO `table` VALUES (36, '3', 'tb_Monographs', '8');
INSERT INTO `table` VALUES (37, '3', 'tb_patent', '9');
INSERT INTO `table` VALUES (38, '3', 'tb_portrait', '10');
INSERT INTO `table` VALUES (41, '3', 'tb_transverse', '11');
INSERT INTO `table` VALUES (42, '3', 'jt_first_subject', '17');
INSERT INTO `table` VALUES (43, '3', 'jt_lab', '18');
INSERT INTO `table` VALUES (44, '3', 'jt_technological_innovation', '19');
INSERT INTO `table` VALUES (45, '3', 'jt_production_union', '20');
INSERT INTO `table` VALUES (46, '3', 'jt_academic_innovation', '21');
INSERT INTO `table` VALUES (47, '3', 'jx_student_research', '24');
INSERT INTO `table` VALUES (48, '3', 'jx_skill_competition', '25');
INSERT INTO `table` VALUES (49, '3', 'jx_competition_direct', '26');
INSERT INTO `table` VALUES (50, '3', 'jx_educational_reform', '27');
INSERT INTO `table` VALUES (53, '3', 'jx_achievement_prize', '28');
INSERT INTO `table` VALUES (54, '3', 'jx_teaching_reform', '29');
INSERT INTO `table` VALUES (55, '3', 'jx_course_construction', '30');
INSERT INTO `table` VALUES (56, '3', 'jx_course_construction', '30');
INSERT INTO `table` VALUES (57, '3', 'jx_textbook_compilation', '31');
INSERT INTO `table` VALUES (58, '3', 'jx_professional_building', '32');
INSERT INTO `table` VALUES (59, '17', 'honor', '22');
INSERT INTO `table` VALUES (60, '3', 'honor', '22');
COMMIT;

-- ----------------------------
-- Table structure for table_state
-- ----------------------------
DROP TABLE IF EXISTS `table_state`;
CREATE TABLE `table_state` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `table_name` varchar(50) DEFAULT NULL COMMENT '业绩类型名称',
  `state` varchar(11) DEFAULT NULL COMMENT '表格类型',
  `name` varchar(50) DEFAULT NULL COMMENT '数据库表名',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of table_state
-- ----------------------------
BEGIN;
INSERT INTO `table_state` VALUES (1, '个人科研', '0', NULL);
INSERT INTO `table_state` VALUES (2, '集体科研', '0', NULL);
INSERT INTO `table_state` VALUES (3, '个人荣誉', '0', '');
INSERT INTO `table_state` VALUES (4, '集体荣誉', '0', '');
INSERT INTO `table_state` VALUES (5, '个人教学业绩', '0', NULL);
INSERT INTO `table_state` VALUES (6, '集体教学业绩', '0', NULL);
INSERT INTO `table_state` VALUES (7, '论文', '1', 'tb_paper');
INSERT INTO `table_state` VALUES (8, '专著', '1', 'tb_monographs');
INSERT INTO `table_state` VALUES (9, '专利', '1', 'tb_patent');
INSERT INTO `table_state` VALUES (10, '纵向科研项目', '1', 'tb_portrait');
INSERT INTO `table_state` VALUES (11, '外向科研项目', '1', 'tb_transverse');
INSERT INTO `table_state` VALUES (17, '重点(一流学科)', '2', 'jt_first_subject');
INSERT INTO `table_state` VALUES (18, '重点实验室', '2', 'jt_lab');
INSERT INTO `table_state` VALUES (19, '科技创新平台', '2', 'jt_technological_innovation');
INSERT INTO `table_state` VALUES (20, '产学科研联盟', '2', 'jt_production_union');
INSERT INTO `table_state` VALUES (21, '学术创新团队', '2', 'jt_academic_innovation');
INSERT INTO `table_state` VALUES (22, '个人荣誉', '3', 'honor');
INSERT INTO `table_state` VALUES (23, '集体荣誉', '4', 'honor');
INSERT INTO `table_state` VALUES (24, '学生科研指导', '5', 'jx_student_research');
INSERT INTO `table_state` VALUES (25, '教学技能竞赛', '5', 'jx_skill_competition');
INSERT INTO `table_state` VALUES (26, '学科竞赛指导', '5', 'jx_competition_direct');
INSERT INTO `table_state` VALUES (27, '教改项目', '5', 'jx_educational_reform');
INSERT INTO `table_state` VALUES (28, '教学成果奖', '5', 'jx_achievement_prize');
INSERT INTO `table_state` VALUES (29, '教研教改', '5', 'jx_teaching_reform');
INSERT INTO `table_state` VALUES (30, '课程建设与课程改革', '5', 'jx_course_construction');
INSERT INTO `table_state` VALUES (31, '教材编写', '5', 'jx_textbook_compilation');
INSERT INTO `table_state` VALUES (32, '专业建设', '6', 'jx_professional_building');
COMMIT;

-- ----------------------------
-- Table structure for tb_monographs
-- ----------------------------
DROP TABLE IF EXISTS `tb_monographs`;
CREATE TABLE `tb_monographs` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '著作名称',
  `theme_word` varchar(255) DEFAULT NULL COMMENT '主题词',
  `author_name` varchar(255) DEFAULT NULL COMMENT '作者名称',
  `finish_time` varchar(255) DEFAULT NULL COMMENT '著作完成时间',
  `subordinate_subject` varchar(255) DEFAULT NULL COMMENT '所属学科',
  `phone` char(11) DEFAULT NULL COMMENT '联系电话',
  `word_number` int(10) DEFAULT NULL COMMENT '总字数',
  `published_number` int(10) DEFAULT NULL COMMENT '出版册数',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_monographs
-- ----------------------------
BEGIN;
INSERT INTO `tb_monographs` VALUES (2, '7', '7', '7', '1593360000000', '7', '17376513713', 77, 77, NULL, '1593064668500', 36);
COMMIT;

-- ----------------------------
-- Table structure for tb_paper
-- ----------------------------
DROP TABLE IF EXISTS `tb_paper`;
CREATE TABLE `tb_paper` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '论文标题',
  `first_author` varchar(255) DEFAULT NULL COMMENT '第一作者',
  `correspondence_author` varchar(255) DEFAULT NULL COMMENT '通讯作者',
  `first_author_type` int(11) DEFAULT NULL COMMENT '第一作者类型0:本校老师1：本校学生2：校外人员',
  `publication` varchar(255) DEFAULT NULL COMMENT '发表刊物/论文集',
  `time` varchar(255) DEFAULT NULL COMMENT '发表/出版时间',
  `paper_school` int(11) DEFAULT NULL COMMENT '学校署名0:第一单位1:非第一单位',
  `paper_volume` varchar(255) DEFAULT NULL COMMENT '卷号',
  `paper_page` varchar(255) DEFAULT NULL COMMENT '页码范围',
  `paper_grade` int(11) DEFAULT NULL COMMENT '期刊等级0：一级1:二级2：三级3：EI4：SCI5：CSSCI',
  `create_time` varchar(255) DEFAULT NULL,
  `file_id` int(11) DEFAULT NULL,
  `table_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tb_paper
-- ----------------------------
BEGIN;
INSERT INTO `tb_paper` VALUES (2, '7', '7', '7', 2, '7', '1593446400000', 2, '7', '7', 4, '1593064646751', NULL, '35');
COMMIT;

-- ----------------------------
-- Table structure for tb_patent
-- ----------------------------
DROP TABLE IF EXISTS `tb_patent`;
CREATE TABLE `tb_patent` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '专利名称',
  `patent_category` enum('0','1') DEFAULT NULL COMMENT '类别 0:发明专利 1:实用新型专利',
  `completer` varchar(255) DEFAULT NULL COMMENT '完成者',
  `patent_number` char(16) DEFAULT NULL COMMENT '专利号',
  `sign_order` varchar(255) DEFAULT NULL COMMENT '署名次序',
  `unit_name` varchar(255) DEFAULT NULL COMMENT '完成者单位名称',
  `unit_address` varchar(255) DEFAULT NULL COMMENT '完成者单位地址',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_patent
-- ----------------------------
BEGIN;
INSERT INTO `tb_patent` VALUES (1, '7', '0', '7', '7', '7', '7', '7', NULL, '1593064677432', 37);
COMMIT;

-- ----------------------------
-- Table structure for tb_portrait
-- ----------------------------
DROP TABLE IF EXISTS `tb_portrait`;
CREATE TABLE `tb_portrait` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `project_leader` varchar(255) DEFAULT NULL COMMENT '项目负责人',
  `title` varchar(255) DEFAULT NULL COMMENT '职称',
  `department` varchar(255) DEFAULT NULL COMMENT '所在部门',
  `date` varchar(255) DEFAULT NULL COMMENT '日期',
  `phone` char(11) DEFAULT NULL COMMENT '联系电话',
  `apply_rental` decimal(8,0) DEFAULT NULL COMMENT '申请总额',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `project_unit` varchar(255) DEFAULT NULL COMMENT '项目依托单位',
  `type` int(11) DEFAULT NULL COMMENT '项目类型0:国家级1:省部级2:市厅级3:校园级',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_portrait
-- ----------------------------
BEGIN;
INSERT INTO `tb_portrait` VALUES (1, '7', '7', '7', '2020-06-15T16:00:00.000Z', '17376513713', 7, '7', '7', 7, NULL, '1593065224865', 38);
COMMIT;

-- ----------------------------
-- Table structure for tb_transverse
-- ----------------------------
DROP TABLE IF EXISTS `tb_transverse`;
CREATE TABLE `tb_transverse` (
  `id` int(13) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT '项目名称',
  `first_level` varchar(255) DEFAULT NULL COMMENT '所属一级学科',
  `research_category` enum('0','1','2') DEFAULT NULL COMMENT '研究类别0:基础研究1:应用研究2:实验与发展',
  `start_time` varchar(255) DEFAULT NULL COMMENT '项目发起时间',
  `client_name` varchar(255) DEFAULT NULL COMMENT '委托单位全称',
  `client_address` varchar(255) DEFAULT NULL COMMENT '委托单位所在地',
  `contract_nature` enum('0','1','2','3','4') DEFAULT NULL COMMENT '合同性质0:技术开发1:技术转让2:技术咨询3:技术服务4:其他',
  `project_leader` varchar(255) DEFAULT NULL COMMENT '项目负责人',
  `level` enum('0','1','2','3') DEFAULT NULL COMMENT '等级0:国家级1:省部级2:市厅级3:校园级',
  `file_id` int(11) DEFAULT NULL COMMENT 'fileID',
  `create_time` varchar(255) DEFAULT NULL,
  `table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tb_transverse
-- ----------------------------
BEGIN;
INSERT INTO `tb_transverse` VALUES (1, 'rgr', 'ret', '1', '1593532800000', 'retre', 'gsbhsgh', '0', 'ndthn', '1', NULL, '1593065606706', 41);
COMMIT;

-- ----------------------------
-- Table structure for tree_people
-- ----------------------------
DROP TABLE IF EXISTS `tree_people`;
CREATE TABLE `tree_people` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tree_code` varchar(255) NOT NULL COMMENT '部门编号',
  `name` varchar(255) NOT NULL COMMENT '部门名称',
  `parent_id` int(11) NOT NULL COMMENT '上级id',
  `state` tinyint(255) NOT NULL COMMENT '1:有效；0：无效；',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of tree_people
-- ----------------------------
BEGIN;
INSERT INTO `tree_people` VALUES (1, '01', '理工分院', 0, 1);
INSERT INTO `tree_people` VALUES (2, '0101', '计算机教研室', 1, 1);
INSERT INTO `tree_people` VALUES (3, '0102', '机械教研室', 1, 1);
INSERT INTO `tree_people` VALUES (4, '0103', '工业教研室', 1, 1);
INSERT INTO `tree_people` VALUES (5, '0104', '电子教研室', 1, 1);
INSERT INTO `tree_people` VALUES (6, '0105', '高分子教研室', 1, 1);
INSERT INTO `tree_people` VALUES (7, '0106', '数学教研室', 1, 1);
INSERT INTO `tree_people` VALUES (8, '0107', '应化教研室', 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for tree_role
-- ----------------------------
DROP TABLE IF EXISTS `tree_role`;
CREATE TABLE `tree_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `treeid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of tree_role
-- ----------------------------
BEGIN;
INSERT INTO `tree_role` VALUES (1, 2, 1);
INSERT INTO `tree_role` VALUES (2, 3, 2);
INSERT INTO `tree_role` VALUES (3, 4, 3);
INSERT INTO `tree_role` VALUES (4, 5, 4);
INSERT INTO `tree_role` VALUES (5, 6, 5);
INSERT INTO `tree_role` VALUES (6, 7, 13);
INSERT INTO `tree_role` VALUES (7, 8, 14);
INSERT INTO `tree_role` VALUES (8, 1, 6);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'hrID',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否有效0：无效1：有效',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `tree` varchar(255) DEFAULT NULL COMMENT '教研室',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=67 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (3, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (13, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (14, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (15, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (16, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0101');
INSERT INTO `user` VALUES (17, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (18, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0105');
INSERT INTO `user` VALUES (20, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0103');
INSERT INTO `user` VALUES (21, 1, '$2a$10$YdclEyV6KVCXgzOlzJ2ah.A.tCd0K7G8C3fmKWHVVl5zrXl1GgrCK', '0104');
INSERT INTO `user` VALUES (66, 1, '$2a$10$jXW53Lb8Wtz0Wz7poouyBuIs.RWpEIZrZOSV4g532tgb4Tz.1VqE6', '0102');
COMMIT;

-- ----------------------------
-- Table structure for user_details
-- ----------------------------
DROP TABLE IF EXISTS `user_details`;
CREATE TABLE `user_details` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `workID` char(8) NOT NULL COMMENT '工号',
  `name` varchar(12) DEFAULT NULL COMMENT '姓名',
  `gender` char(1) DEFAULT NULL COMMENT '性别',
  `office_id` varchar(10) DEFAULT '' COMMENT '办公室',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(20) DEFAULT NULL COMMENT '邮箱',
  `note` text COMMENT '备注',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`,`workID`) USING BTREE,
  KEY `workID_key` (`workID`) USING BTREE,
  KEY `id` (`id`) USING BTREE,
  KEY `user_id` (`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1520 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user_details
-- ----------------------------
BEGIN;
INSERT INTO `user_details` VALUES (1, '00000001', '江南一点雨', '1', '1', '17376513713', '1104935833@qq.com', NULL, 66);
INSERT INTO `user_details` VALUES (2, '00000002', '陈静', '1', '2', '17376513713', '1104935833@qq.com', NULL, 13);
INSERT INTO `user_details` VALUES (3, '00000003', '系统管理员', '0', '4', '17376513713', '1104935833@qq.com', NULL, 14);
INSERT INTO `user_details` VALUES (4, '00000004', '鹿存亮', '1', '4', '17376513713', '1104935833@qq.com', NULL, 15);
INSERT INTO `user_details` VALUES (5, '00000005', '姚森', '0', '5', '17376513713', '1104935833@qq.com', NULL, 16);
INSERT INTO `user_details` VALUES (6, '00000006', '云星', '0', '6', '17376513713', '1104935833@qq.com', NULL, 17);
INSERT INTO `user_details` VALUES (7, '00000007', '贾旭明', '0', '7', '17376513713', '1104935833@qq.com', NULL, 18);
INSERT INTO `user_details` VALUES (9, '00000009', '薛磊', '0', '1', '17376513713', '1104935833@qq.com', NULL, 20);
INSERT INTO `user_details` VALUES (10, '00000010', '张洁', '0', '2', '17376513713', '1104935833@qq.com', NULL, 21);
INSERT INTO `user_details` VALUES (1519, '00000000', 'dd', '0', NULL, '17376513713', '1104935833@qq.com', NULL, 3);
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `rid` int(11) DEFAULT NULL,
  `isManager` int(1) DEFAULT '0' COMMENT '是否管理员0：不是1是',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `rid` (`rid`) USING BTREE,
  KEY `user_role_ibfk_1` (`userid`) USING BTREE,
  CONSTRAINT `user_role_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  CONSTRAINT `user_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=238 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES (57, 3, 6, 1);
INSERT INTO `user_role` VALUES (173, 13, 1, 1);
INSERT INTO `user_role` VALUES (207, 3, 6, 0);
INSERT INTO `user_role` VALUES (214, 13, 1, 0);
INSERT INTO `user_role` VALUES (215, 13, 1, 0);
INSERT INTO `user_role` VALUES (216, 13, 1, 0);
INSERT INTO `user_role` VALUES (217, 13, 1, 0);
INSERT INTO `user_role` VALUES (218, 13, 1, 0);
INSERT INTO `user_role` VALUES (219, 14, 1, 0);
INSERT INTO `user_role` VALUES (220, 16, 1, 0);
INSERT INTO `user_role` VALUES (221, 17, 1, 0);
INSERT INTO `user_role` VALUES (225, 66, 27, 0);
INSERT INTO `user_role` VALUES (229, 20, 4, 0);
INSERT INTO `user_role` VALUES (230, 21, 4, 0);
INSERT INTO `user_role` VALUES (231, 20, 4, 1);
INSERT INTO `user_role` VALUES (236, 15, 3, 0);
INSERT INTO `user_role` VALUES (237, 21, 2, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
