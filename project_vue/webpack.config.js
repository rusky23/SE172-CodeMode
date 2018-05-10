// webpack.config.js

module.exports = {
   module: {
      node: {
        fs: "empty"
      },
      rules: [
        {
          test: /\.js$/,
          exclude: /node_modules/,
          use: {
            loader: "babel-loader"
          }
        }
      ]
   }
}
