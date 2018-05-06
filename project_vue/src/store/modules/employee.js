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
  testDatabase ({commit}, payload) {
    // code to test database
    /*
    Connection info:

    var connection = mysql.createConnection({
      host     : 'localhost',
      user     : 'root',
      database : 'employees'
    });
    */
  }
}

export default {
  state,
  getters,
  actions,
  mutations
}
