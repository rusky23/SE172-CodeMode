<template>
  <div class="div">
    <div class="container-fluid mt-4">
      <h1 class="headline">Employee Information</h1>
      <h3>Welcome to Your page "Employee name"</h3>
      <h1>Only Authenticate User can see This page--</h1>
      <v-btn color="brown darken-2" flat @click="updateUserInfo"> Test</v-btn>
    </div>
  </div>
</template>

<style>
.div {
  height: 90vh;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
  background-color: #f7f9f9;
}
</style>

<script>
  export default {
    data: () => ({
      
    }),
    computed: {

    },
    methods: {
      testDatabase () {
        var testData = {firstName: 'Charlene'}
        this.$store.dispatch('testDatabase', testData)
      }
    }
  }
</script>
