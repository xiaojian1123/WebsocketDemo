package net.sunniwell.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.sctp.nio.NioSctpServerChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import net.sunniwell.netty.websocket.MyWebSocketChannelHandler;
import net.sunniwell.netty.websocket.MyWebSocketHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *启动应用
 * @author xiaojian
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		EventLoopGroup bossGroup = new NioEventLoopGroup();
		EventLoopGroup workGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup,workGroup);
			b.channel(NioServerSocketChannel.class);
			b.childHandler(new MyWebSocketChannelHandler());
			System.out.println("服务端开启等待客户端连接...");
			Channel ch = b.bind(8888).sync().channel();
			ch.closeFuture().sync();
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			//退出程序
			bossGroup.shutdownGracefully();
			workGroup.shutdownGracefully();
		}
//		SpringApplication.run(DemoApplication.class, args);
	}
}
