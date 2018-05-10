import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import EmployeeInformation from '@/components/EmployeeInformation'
import Auth from '@okta/okta-vue'
import PayrollPortal from '@/components/PayrollPortal'

Vue.use(Auth, {
  issuer: 'https://sjsu-payam.okta.com',
  client_id: '0oa13uduyfAK6GQ4e2p7',
  redirect_uri: 'http://73.231.113.29:8080/implicit/callback',
  scope: 'openid profile email'
})

Vue.use(Router)

let router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Home',
      component: Home
    },
    {
      path: '/implicit/callback',
      component: Auth.handleCallback()
    },
    {
      path: '/EmployeeInformation',
      name: 'EmployeeInformation',
      component: EmployeeInformation,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: '/PayrollPortal',
      name: 'PayrollPortal',
      component: PayrollPortal,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

router.beforeEach(Vue.prototype.$auth.authRedirectGuard())

export default router
