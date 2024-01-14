package org.zzb.hot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.zzb.base.BaseResponse;
import org.zzb.hot.domain.CollectConfig;
import org.zzb.hot.service.ICollectContentService;
import org.zzb.hot.strategy.BaiduHotProcessor;

@RestController
@RequestMapping("/api/admin")
public class HotController {

    @Autowired
    private BaiduHotProcessor baiduHotProcessor;

    @Autowired
    private ICollectContentService contentService;

    @PostMapping("process")
    public BaseResponse<?> process() {
        CollectConfig config = new CollectConfig();
        config.setCollectParam("realtime");
        config.setCollectExpression("$.data.cards[0].content");
        return BaseResponse.ok(baiduHotProcessor.getObj(config));
    }

    @GetMapping ("queryRealTime")
    public BaseResponse<?> queryRealTime() {
        return BaseResponse.ok(contentService.queryRealTime());
    }


}
