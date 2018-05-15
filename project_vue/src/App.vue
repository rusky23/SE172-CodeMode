<template>
<div id="app">
    <b-navbar toggleable="md" type="dark" variant="info">

    <b-navbar-toggle target="nav_collapse"></b-navbar-toggle>

    <b-navbar-brand to="/">CodeMode</b-navbar-brand>

    <b-collapse is-nav id="nav_collapse">

      <b-navbar-nav>
        <b-nav-item to="/">Home</b-nav-item>
        <b-nav-item  to="/EmployeeInformation">Employee Information</b-nav-item>
      </b-navbar-nav>

      <!-- Right aligned nav items -->
      <b-navbar-nav class="ml-auto">

        



          <template slot="button-content">
            <em>User</em>
          </template>
          <b-nav-item href='#' @click.prevent='login' v-if='!authenticated'>Login</b-nav-item>
          <b-nav-item href='#' @click.prevent='logout' v-else>Logout</b-nav-item>
      </b-navbar-nav>

    </b-collapse>
  </b-navbar>
  <!-- routes will be rendered here -->
  <router-view />

</div>
</template>

<style>
  .navbar-brand{
    font-size: 30px;
    font-weight: bold;
  }
  .nav-link{
    margin-left: 40px;
    font-weight: bold;
  }
  .navbar_collapse{
    background-color: black;
    color: black;
  }
</style>


<script>

export default {
  name: 'app',
  data () {
    return {
      authenticated: false
    }
  },
  created () {
    this.isAuthenticated()
  },
  watch: {
    // everytime a route is changed refresh the activeUser
    '$route': 'isAuthenticated'
  },
  methods: {
    async isAuthenticated () {
      this.authenticated = await this.$auth.isAuthenticated()
    },
    async login () {
      this.$auth.loginRedirect()
    },
    async logout () {
      await this.$auth.logout()
      await this.isAuthenticated()
      this.$router.push('/')
    }
  }
}
</script>
