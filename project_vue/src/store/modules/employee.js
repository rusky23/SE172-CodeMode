const state = {
  firstName: null
}

const getters = {
  firstName (state) {
    return state.firstName
  }
}

const mutations = {
  setFirstName (state, payload) {
    state.firstName = payload
  }
}

const actions = {
  updateUserInfo ({commit}, payload) {
    var mysql = require('mysql')
    var connection = mysql.createConnection({
      host: 'localhost',
      user: 'root',
      database: 'employees'
    })

    connection.connect()

    connection.query('SELECT * FROM employees WHERE firstName = ' + payload.firstName, function (err, rows, fields) {
      if (!err) {
        console.log('The solution is: ', rows)
      } else {
        console.log('Error while performing Query:', err)
      }
    })

    connection.end()
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}
