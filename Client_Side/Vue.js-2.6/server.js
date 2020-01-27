const http = require("http");
const nStatic = require("node-static");
const PORT = 4292;

const fileServer = new nStatic.Server('./');
http.createServer(function (req, res) {
  fileServer.serve(req, res);
}).listen(PORT);