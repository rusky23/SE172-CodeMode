import Vue from 'vue'
import Vuex from 'vuex'
// Store Modules
import employee from './modules/employee'


Vue.use(Vuex)

export const store = new Vuex.Store({
  modules: {
    employee: employee
  }
})
