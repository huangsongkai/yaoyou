var rootPath = "/Users/song/work/Idea_space/yaoyou/WebRoot/WEB-INF/js";
// var rootPath = "/root/.jenkins/jobs/focus_sat/workspace/WebRoot";

var webpack = require('webpack');
var path = require("path"); 
var uglifyJsPlugin = webpack.optimize.UglifyJsPlugin;
var AssetsPlugin = require('assets-webpack-plugin');
var assetsPluginInstance = new AssetsPlugin({filename: 'assets.json', prettyPrint:true});

module.exports = {
        entry: {
            top: rootPath+"/entry/top.js"//"./topV3.js",//
        },
        output: {
            publicPath: "http://127.0.0.1:8080/static/",//"http://test.static.360class.cn/", //"http://static.360class.cn/",//
            path: path.join(__dirname, "static"),
            filename: "[name]-bundle.js",
            chunkFilename: "[id]-chunk.js"
        },
        //require.resolve,解决了所在资源父文件夹内没有node_modules的问题，从webpack.config.js中所在目录返回绝对路径
        module: {
            loaders: [
                { test: /\.css$/, loader: require.resolve("style-loader") + "!"+require.resolve("css-loader")},
                { test: /\.jpe?g$|\.gif$|\.png$|\.svg$|\.woff$|\.ttf$|\.wav$|\.mp3$/, loader:require.resolve("file-loader") + "?name=images/[hash:8].[ext]"},
                { test: /\.txt$|\.tp$/, loader: require.resolve("raw-loader") + "?name=[hash:8].[ext]"},
                //将$暴露为全局（window）下可见，正则表达式匹配jquery和jquery-x.x.js
                { test: /jquery$|jquery(-|\d|\.|min)*.js$/, loader: 'expose?jQuery!expose?$' },
            ]
        },
        resolve: { 

             alias: {
                //jquery: "/Users/song/work/nodejs/webpackTest/6th/js/common/jquery-1.11.3.js",
                //path join 解决相对路径问题 
                //sem: rootPath+"/js/modules/sem_module.js",
                jquery: rootPath+"/jquery-2.2.1.min.js",
                underscore: rootPath+"/underscore-min.js",
             }
        },

        plugins: [
            new webpack.ProvidePlugin({
                $: "jquery",
                jQuery: "jquery",
                _:"underscore"
            }),
            new webpack.optimize.DedupePlugin(),
            new webpack.optimize.OccurenceOrderPlugin(),
            //限制整体chunk的数量，如果chunk数量大于num，则不会有splitting
            new webpack.optimize.LimitChunkCountPlugin({maxChunks: 15}),
            //会合并大小小于\d b的chunk，但至少会有一个 不会合并到parent中
            new webpack.optimize.MinChunkSizePlugin({minChunkSize: 1000}),
            new webpack.optimize.CommonsChunkPlugin("commonV3.js"),
            assetsPluginInstance
        ]
    };
