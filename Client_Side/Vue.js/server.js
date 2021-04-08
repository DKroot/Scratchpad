const http = require("http");
const nStatic = require("node-static");
const PORT = 4292;

const fileServer = new nStatic.Server('./',
    {
      // set the Cache-Control header
      cache: false
    }
);
http.createServer((request, response) =>
    request.addListener('end', () => {
      fileServer.serve(request, response);
    }).resume()).listen(PORT);