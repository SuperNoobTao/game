package com.bxm.game.service;

import com.bxm.newidea.component.vo.Message;

/**
 * @author zhaoyadong 2018/11/29 21:42
 * @desc
 */
public interface DataAcceptService {

    /**
     * 接收数据
     * @param id
     * @param value
     * @return
     */
    Message acceptData(String id, Long value);
}
