var mysql      = require('mysql');
 var connection = mysql.createConnection({
   host     : 'localhost',
   user     : 'root',
   database : 'employees'
 });

 connection.connect();

 connection.query('SELECT * from employees', function(err, rows, fields) {
   if (!err)
     console.log('The solution is: ', rows);
   else
     console.log('Error while performing Query:', err);
 });

 connection.end();

