-- ----------------------------
-- Table structure for collect_config
-- ----------------------------
DROP TABLE IF EXISTS `collect_config`;
CREATE TABLE `collect_config`  (
                                   `collect_config_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '�ɼ�����id',
                                   `collect_id` int(11) NOT NULL COMMENT '�ɼ�id',
                                   `config_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '������',
                                   `collect_param` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ɼ�����',
                                   `config_version` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '�汾��',
                                   `request_config` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '��������',
                                   `record_data` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�Ƿ��¼ԭʼ����',
                                   `max_count` int(11) NULL DEFAULT NULL COMMENT '���μ�¼�������',
                                   `effect` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '�Ƿ���Ч',
                                   `cron` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ɼ�����corn���ʽ',
                                   `collect_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ɼ����ʽ',
                                   `charset` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ɼ�����',
                                   `create_time` datetime NULL DEFAULT NULL COMMENT '����ʱ��',
                                   `update_time` datetime NULL DEFAULT NULL COMMENT '����ʱ��',
                                   `creater` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '������',
                                   `updater` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '������',
                                   PRIMARY KEY (`collect_config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '�ɼ�����' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collect_config
-- ----------------------------
INSERT INTO `collect_config` VALUES (1, 1, '�ٶ�����-ʵʱ����', 'realtime', '1', NULL, '1', 5, '1', '0 0 23 * * ?', '$.data.cards[0].content', 'utf-8', '2023-12-12 22:23:50', '2023-12-12 22:23:53', NULL, NULL);
INSERT INTO `collect_config` VALUES (2, 1, '�ٶ�����-С˵��', 'novel', '1', NULL, '1', 5, '1', '0 0 23 * * ?', '$.data.cards[0].content', 'utf-8', '2023-12-12 22:23:50', '2023-12-12 22:23:53', NULL, NULL);
INSERT INTO `collect_config` VALUES (3, 1, '�ٶ�����-��Ӱ��', 'movie', '1', NULL, '1', 5, '1', '0 0 23 * * ?', '$.data.cards[0].content', 'utf-8', '2023-12-12 22:23:50', '2023-12-12 22:23:53', NULL, NULL);
INSERT INTO `collect_config` VALUES (4, 1, '�ٶ�����-������', 'car', '1', NULL, '1', 5, '1', '0 0 23 * * ?', '$.data.cards[0].content', 'utf-8', '2023-12-12 22:23:50', '2023-12-12 22:23:53', NULL, NULL);
INSERT INTO `collect_config` VALUES (5, 1, '�ٶ�����-��Ϸ��', 'game', '1', NULL, '1', 5, '1', '0 0 23 * * ?', '$.data.cards[0].content', 'utf-8', '2023-12-12 22:23:50', '2023-12-12 22:23:53', NULL, NULL);
INSERT INTO `collect_config` VALUES (6, 2, '��������-��ս��', 'hotspot_challenge,2,170400', '1', '{\r\n    \"cookies\": {\r\n        \"passport_csrf_token_default\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"passport_csrf_token\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"csrf_session_id\":\"c480e18d09ba790dec05983e171464c5\"\r\n    },\r\n    \"headers\": {},\r\n    \"requestBody\": \"\"\r\n}', NULL, 5, '1', '0 0 23 * * ?', '$.data.word_list', 'utf-8', '2023-12-13 14:23:20', '2023-12-13 14:23:24', NULL, NULL);
INSERT INTO `collect_config` VALUES (7, 2, '��������-ʵʱ�Ȱ�', '0,2,170400', '1', '{\r\n    \"cookies\": {\r\n        \"passport_csrf_token_default\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"passport_csrf_token\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"csrf_session_id\":\"c480e18d09ba790dec05983e171464c5\"\r\n    },\r\n    \"headers\": {},\r\n    \"requestBody\": \"\"\r\n}', NULL, 5, '1', '0 0 23 * * ?', '$.data.word_list', 'utf-8', '2023-12-13 16:15:02', '2023-12-13 16:15:07', NULL, NULL);
INSERT INTO `collect_config` VALUES (8, 2, '��������-���ְ�', '2,2,170400', '1', '{\r\n    \"cookies\": {\r\n        \"passport_csrf_token_default\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"passport_csrf_token\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"csrf_session_id\":\"c480e18d09ba790dec05983e171464c5\"\r\n    },\r\n    \"headers\": {},\r\n    \"requestBody\": \"\"\r\n}', NULL, 5, '1', '0 0 23 * * ?', '$.data.word_list', 'utf-8', '2023-12-13 16:15:02', '2023-12-13 16:15:07', NULL, NULL);
INSERT INTO `collect_config` VALUES (9, 2, '��������-����', '4,2,170400', '1', '{\r\n    \"cookies\": {\r\n        \"passport_csrf_token_default\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"passport_csrf_token\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"csrf_session_id\":\"c480e18d09ba790dec05983e171464c5\"\r\n    },\r\n    \"headers\": {},\r\n    \"requestBody\": \"\"\r\n}', NULL, 5, '1', '0 0 23 * * ?', '$.data.word_list', 'utf-8', '2023-12-13 16:15:02', '2023-12-13 16:15:07', NULL, NULL);
INSERT INTO `collect_config` VALUES (10, 3, '΢������-ʵʱ����', NULL, '1', NULL, NULL, 5, '1', '0 0 23 * * ?', '$.data.realtime', 'utf-8', '2023-12-13 19:14:24', '2023-12-13 19:13:25', NULL, NULL);
INSERT INTO `collect_config` VALUES (11, 4, '֪������-ʵʱ����', NULL, '1', NULL, NULL, 10, '1', '0 0 23 * * ?', '$.initialState.topstory.hotList', 'utf-8', '2023-12-13 20:59:44', '2023-12-13 20:59:47', NULL, NULL);


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collect_content
-- ----------------------------
DROP TABLE IF EXISTS `collect_content`;
CREATE TABLE `collect_content`  (
                                    `collect_content_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '�ɼ�����id',
                                    `title` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '����',
                                    `url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '·��',
                                    `img` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ͼƬ·��',
                                    `config_id` int(11) NULL DEFAULT NULL COMMENT '��������',
                                    `collect_id` int(11) NULL DEFAULT NULL COMMENT '�����ռ�',
                                    `hot_order` int(11) NULL DEFAULT NULL COMMENT '����',
                                    `hot_metric` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ȶ�',
                                    `datastr` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ԭʼ����',
                                    `create_time` datetime NULL DEFAULT NULL COMMENT '����ʱ��',
                                    `creater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '������',
                                    `param` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ɼ�����',
                                    `config_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�����h��',
                                    PRIMARY KEY (`collect_content_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '�ɼ����' ROW_FORMAT = DYNAMIC;



SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collect_web
-- ----------------------------
DROP TABLE IF EXISTS `collect_web`;
CREATE TABLE `collect_web`  (
                                `collect_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '�ɼ�id',
                                `collect_endpoint` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ɼ��ӿ�(ģ��)',
                                `collect_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�ɼ�����',
                                `collect_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '����',
                                `collect_type` int(1) NULL DEFAULT NULL COMMENT '�ɼ�����',
                                `effecct` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '�Ƿ���Ч',
                                `create_time` datetime NULL DEFAULT NULL COMMENT '����ʱ��',
                                `update_time` datetime NULL DEFAULT NULL COMMENT '����ʱ��',
                                `creater` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '������',
                                `updater` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '������',
                                `collect_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '˵��',
                                PRIMARY KEY (`collect_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '�ɼ�����' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collect_web
-- ----------------------------
INSERT INTO `collect_web` VALUES (1, 'https://top.baidu.com/api/board?tab={0}', '�ٶ�����', 'baiduHot', 1, '1', '2023-12-12 22:20:29', '2023-12-12 22:20:33', NULL, NULL, '�ٶ�����');
INSERT INTO `collect_web` VALUES (2, 'https://www.douyin.com/aweme/v1/web/hot/search/list?board_sub_type={0}&board_type={1}&version_code={2}', '��������', 'douyinHot', 1, '1', '2023-12-13 14:21:33', '2023-12-13 14:21:35', NULL, NULL, '��������');
INSERT INTO `collect_web` VALUES (3, 'https://weibo.com/ajax/side/hotSearch', '΢������', 'weboHot', 1, '1', '2023-12-13 19:12:35', '2023-12-13 19:12:39', NULL, NULL, '΢������');
INSERT INTO `collect_web` VALUES (4, 'https://www.zhihu.com/billboard', '֪������', 'zhihuHot', 2, '1', '2023-12-13 20:58:27', '2023-12-13 20:58:32', NULL, NULL, '֪������');

SET FOREIGN_KEY_CHECKS = 1;
