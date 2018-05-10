'use strict';
module.exports = (sequelize, DataTypes) => {
  var employee = sequelize.define('employee', {
    emp_no: Sequelize.INTEGER,
    birth_date: Sequelize.DATE,
    first_name: Sequelize.STRING,
    last_name: Sequelize.STRING,
    gender: {
      type: Sequelize.ENUM,
      values: ['M', 'F']
    },
    hire_date: Sequelize.DATE
  }, {});
  employee.associate = function(models) {
    // associations can be defined here
  };
  return employee;
};