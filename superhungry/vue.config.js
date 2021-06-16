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
    devServer: {
        //     host: '192.168.43.105', // ip
        port: 8081, // 设置端口号
        //     https: false, // https:{type:Boolean}
        //     open: false, //配置自动启动浏览器
        //     proxy:null  //设置代理
        proxy: {
            "/api": {
                target: "http://123.60.33.16:8080/Hungry",// 要访问的接口域名
                ws: true,// 是否启用websockets
                changeOrigin: true, //开启代理：在本地会创建一个虚拟服务端，然后发送请求的数据，并同时接收请求的数据，这样服务端和服务端进行数据的交互就不会有跨域问题
                pathRewrite: {
                    '^/api': '' //这里理解成用'/api'代替target里面的地址,比如我要调用'http://40.00.100.100:3002/user/add'，直接写'/api/user/add'即可
                }
            }
        },
    }
}
