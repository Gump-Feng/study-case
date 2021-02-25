package com.tutu.reading.design_pattern.factory;

/**
 * @Description: java类作用描述
 * @Author: hxf
 * @CreateDate: 2020/9/12$ 10:24$
 * @Version: 1.0
 */
public class HighMaskFactory implements IMaskFactory {
    @Override
    public IMask createMask() {
        IMask highFactory = new HighMask();
        highFactory.show();
        return highFactory;
    }
}
