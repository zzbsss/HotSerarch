-- ----------------------------
-- Table structure for collect_config
-- ----------------------------
DROP TABLE IF EXISTS `collect_config`;
CREATE TABLE `collect_config`  (
                                   `collect_config_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采集配置id',
                                   `collect_id` int(11) NOT NULL COMMENT '采集id',
                                   `config_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '配置名',
                                   `collect_param` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采集参数',
                                   `config_version` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '版本号',
                                   `request_config` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '请求配置',
                                   `record_data` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否记录原始数据',
                                   `max_count` int(11) NULL DEFAULT NULL COMMENT '单次记录最大条数',
                                   `effect` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '是否有效',
                                   `cron` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采集任务corn表达式',
                                   `collect_expression` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采集表达式',
                                   `charset` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采集编码',
                                   `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                   `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                   `creater` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                   `updater` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
                                   PRIMARY KEY (`collect_config_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '采集配置' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collect_config
-- ----------------------------
INSERT INTO `collect_config` VALUES (1, 1, '百度热搜-实时热搜', 'realtime', '1', NULL, '1', 5, '1', '0 0 23 * * ?', '$.data.cards[0].content', 'utf-8', '2023-12-12 22:23:50', '2023-12-12 22:23:53', NULL, NULL);
INSERT INTO `collect_config` VALUES (2, 1, '百度热搜-小说榜', 'novel', '1', NULL, '1', 5, '1', '0 0 23 * * ?', '$.data.cards[0].content', 'utf-8', '2023-12-12 22:23:50', '2023-12-12 22:23:53', NULL, NULL);
INSERT INTO `collect_config` VALUES (3, 1, '百度热搜-电影榜', 'movie', '1', NULL, '1', 5, '1', '0 0 23 * * ?', '$.data.cards[0].content', 'utf-8', '2023-12-12 22:23:50', '2023-12-12 22:23:53', NULL, NULL);
INSERT INTO `collect_config` VALUES (4, 1, '百度热搜-汽车榜', 'car', '1', NULL, '1', 5, '1', '0 0 23 * * ?', '$.data.cards[0].content', 'utf-8', '2023-12-12 22:23:50', '2023-12-12 22:23:53', NULL, NULL);
INSERT INTO `collect_config` VALUES (5, 1, '百度热搜-游戏榜', 'game', '1', NULL, '1', 5, '1', '0 0 23 * * ?', '$.data.cards[0].content', 'utf-8', '2023-12-12 22:23:50', '2023-12-12 22:23:53', NULL, NULL);
INSERT INTO `collect_config` VALUES (6, 2, '抖音热搜-挑战榜', 'hotspot_challenge,2,170400', '1', '{\r\n    \"cookies\": {\r\n        \"passport_csrf_token_default\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"passport_csrf_token\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"csrf_session_id\":\"c480e18d09ba790dec05983e171464c5\"\r\n    },\r\n    \"headers\": {},\r\n    \"requestBody\": \"\"\r\n}', NULL, 5, '1', '0 0 23 * * ?', '$.data.word_list', 'utf-8', '2023-12-13 14:23:20', '2023-12-13 14:23:24', NULL, NULL);
INSERT INTO `collect_config` VALUES (7, 2, '抖音热搜-实时热榜', '0,2,170400', '1', '{\r\n    \"cookies\": {\r\n        \"passport_csrf_token_default\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"passport_csrf_token\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"csrf_session_id\":\"c480e18d09ba790dec05983e171464c5\"\r\n    },\r\n    \"headers\": {},\r\n    \"requestBody\": \"\"\r\n}', NULL, 5, '1', '0 0 23 * * ?', '$.data.word_list', 'utf-8', '2023-12-13 16:15:02', '2023-12-13 16:15:07', NULL, NULL);
INSERT INTO `collect_config` VALUES (8, 2, '抖音热搜-娱乐榜', '2,2,170400', '1', '{\r\n    \"cookies\": {\r\n        \"passport_csrf_token_default\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"passport_csrf_token\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"csrf_session_id\":\"c480e18d09ba790dec05983e171464c5\"\r\n    },\r\n    \"headers\": {},\r\n    \"requestBody\": \"\"\r\n}', NULL, 5, '1', '0 0 23 * * ?', '$.data.word_list', 'utf-8', '2023-12-13 16:15:02', '2023-12-13 16:15:07', NULL, NULL);
INSERT INTO `collect_config` VALUES (9, 2, '抖音热搜-社会榜', '4,2,170400', '1', '{\r\n    \"cookies\": {\r\n        \"passport_csrf_token_default\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"passport_csrf_token\":\"5a39cc7202731246f91bbac98c90a754\",\r\n        \"csrf_session_id\":\"c480e18d09ba790dec05983e171464c5\"\r\n    },\r\n    \"headers\": {},\r\n    \"requestBody\": \"\"\r\n}', NULL, 5, '1', '0 0 23 * * ?', '$.data.word_list', 'utf-8', '2023-12-13 16:15:02', '2023-12-13 16:15:07', NULL, NULL);
INSERT INTO `collect_config` VALUES (10, 3, '微博热搜-实时热搜', NULL, '1', NULL, NULL, 5, '1', '0 0 23 * * ?', '$.data.realtime', 'utf-8', '2023-12-13 19:14:24', '2023-12-13 19:13:25', NULL, NULL);
INSERT INTO `collect_config` VALUES (11, 4, '知乎热搜-实时热搜', NULL, '1', NULL, NULL, 10, '1', '0 0 23 * * ?', '$.initialState.topstory.hotList', 'utf-8', '2023-12-13 20:59:44', '2023-12-13 20:59:47', NULL, NULL);


SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collect_content
-- ----------------------------
DROP TABLE IF EXISTS `collect_content`;
CREATE TABLE `collect_content`  (
                                    `collect_content_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采集内容id',
                                    `title` varchar(500) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '主题',
                                    `url` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '路径',
                                    `img` varchar(2000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '图片路径',
                                    `config_id` int(11) NULL DEFAULT NULL COMMENT '关联配置',
                                    `collect_id` int(11) NULL DEFAULT NULL COMMENT '关联收集',
                                    `hot_order` int(11) NULL DEFAULT NULL COMMENT '排行',
                                    `hot_metric` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '热度',
                                    `datastr` varchar(4000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '原始数据',
                                    `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                    `creater` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                    `param` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采集參數',
                                    `config_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '配置説明',
                                    PRIMARY KEY (`collect_content_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '采集结果' ROW_FORMAT = DYNAMIC;



SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for collect_web
-- ----------------------------
DROP TABLE IF EXISTS `collect_web`;
CREATE TABLE `collect_web`  (
                                `collect_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采集id',
                                `collect_endpoint` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采集接口(模版)',
                                `collect_title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '采集主题',
                                `collect_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '编码',
                                `collect_type` int(1) NULL DEFAULT NULL COMMENT '采集类型',
                                `effecct` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '是否有效',
                                `create_time` datetime NULL DEFAULT NULL COMMENT '创建时间',
                                `update_time` datetime NULL DEFAULT NULL COMMENT '更新时间',
                                `creater` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '创建人',
                                `updater` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '更新人',
                                `collect_desc` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '说明',
                                PRIMARY KEY (`collect_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '采集主体' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of collect_web
-- ----------------------------
INSERT INTO `collect_web` VALUES (1, 'https://top.baidu.com/api/board?tab={0}', '百度热搜', 'baiduHot', 1, '1', '2023-12-12 22:20:29', '2023-12-12 22:20:33', NULL, NULL, '百度热搜');
INSERT INTO `collect_web` VALUES (2, 'https://www.douyin.com/aweme/v1/web/hot/search/list?board_sub_type={0}&board_type={1}&version_code={2}', '抖音热搜', 'douyinHot', 1, '1', '2023-12-13 14:21:33', '2023-12-13 14:21:35', NULL, NULL, '抖音热搜');
INSERT INTO `collect_web` VALUES (3, 'https://weibo.com/ajax/side/hotSearch', '微博热搜', 'weboHot', 1, '1', '2023-12-13 19:12:35', '2023-12-13 19:12:39', NULL, NULL, '微博热搜');
INSERT INTO `collect_web` VALUES (4, 'https://www.zhihu.com/billboard', '知乎热搜', 'zhihuHot', 2, '1', '2023-12-13 20:58:27', '2023-12-13 20:58:32', NULL, NULL, '知乎热搜');

SET FOREIGN_KEY_CHECKS = 1;
