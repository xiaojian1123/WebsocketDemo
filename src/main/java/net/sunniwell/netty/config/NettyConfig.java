package net.sunniwell.netty.config;

import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

/**
 * 全局配置
 * @author:zhongxiaojian
 * @date:2018-04-08 15:43
 */
public class NettyConfig {

    /**
     * 存储每一个客户端接进来时的 channel对象
     */
    public static ChannelGroup group = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
}
