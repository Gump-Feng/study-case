package com.tutu.reading.design_pattern.factory;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/9/12$ 10:24$
 * @Version: 1.0
 */
public class LowerMaskFactory implements IMaskFactory {
    @Override
    public IMask createMask() {
        IMask lowerMask = new LowerMask();
        //初始化方法
        lowerMask.show();
        return lowerMask;
    }
}
