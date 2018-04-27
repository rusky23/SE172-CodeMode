import Vue from 'vue'
import Router from 'vue-router'
import Home from '@/components/Home'
import Payrollhome from '@/components/Payrollhome'
import Auth from '@okta/okta-vue'
import Search from '@/components/Search'

Vue.use(Auth, {
  issuer: 'https://dev-153969.oktapreview.com/oauth2/default',
  client_id: '0oaes4wjgjD05WcWH0h7',
  redirect_uri: 'http://localhost:8080/implicit/callback',
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
      path: '/Payrollhome',
      name: 'Payrollhome',
      component: Payrollhome,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: '/Search',
      name: 'Search',
      component: Search,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

router.beforeEach(Vue.prototype.$auth.authRedirectGuard())

export default router
