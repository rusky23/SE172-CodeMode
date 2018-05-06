var nosql = require('mysql'); 

var Employee = function(emp_no, birth_date, first_name, last_name, gender, hire_date) {
    if (emp_no) this.emp_no = emp_no
    if (birth_date) this.birth_date = birth_date
    if (first_name) this.first_name = first_name
    if (last_name) this.last_name = last_name
    if (gender) this.gender = gender
    if (hire_date) this.hire_date = hire_date
}

// create basic object<->table mapping
var annotations = new nosql.TableMapping('employees').applyToClass(Employee);

//check results of find
var onFind = function(err, result) {
    console.log('onFind.');
    if (err) {
        console.log(err);
    } else {
        console.log('Found: ' + JSON.stringify(result));
    }
    process.exit(0);
};

//check results of insert
var onInsert = function(err, object, session) {
    console.log('onInsert.');
    if (err) {
        console.log(err);
    } else {
        console.log('Inserted: ' + JSON.stringify(object));

        // Now read the data back out from the database
        session.find(Employee, 'Maidenhead', onFind);
    }
};

// insert an object
var onSession = function(err, session) {
    console.log('onSession.');
    if (err) {
    console.log('Error onSession.');
        console.log(err);
        process.exit(0);
    } else {
        var data = new Employee('Maidenhead', 'Berkshire');
        session.persist(data, onInsert, data, session);
    }
};

var dbProperties = nosql.ConnectionProperties('ndb');

console.log('Openning session');

// connect to the database
nosql.openSession(dbProperties, Employee, onSession);

console.log('Openned session');

