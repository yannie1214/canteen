module.exports = {
    configureWebpack: {
        resolve: {
            // 配置别名
            alias: {
                'assets': '@/assets',
                'common': '@/common',
                'components': '@/components',
                'network': '@/network',
                'views': '@/views',
            }
        }
    },
    publicPath: './',
    // publicPath: process.env.NODE_ENV === "production" ? "/backstage/" : "/",
    devServer: {
        host: 'localhost',
        port: 8080,
        proxy: {
            "/": {
                // target: "http://123.60.33.16:8080/Hungry",// 要访问的接口域名
                target: "http://124.71.155.172:8080/Hungry",// 要访问的接口域名
                ws: false,// 是否启用websockets
                changeOrigin: true, //开启代理：在本地会创建一个虚拟服务端，然后发送请求的数据，并同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题
                pathRewrite: {
                    '^/': '' //这里理解成用'/api'代替target里面的地址,比如我要调用'http://40.00.100.100:3002/user/add'，直接写'/api/user/add'即可
                }
            }
        },
    },

}
