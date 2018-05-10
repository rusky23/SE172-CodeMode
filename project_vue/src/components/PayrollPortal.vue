<template>
    <div>
      <div style="text-align:center">
        <h1>Only authenticate user can see this page</h1>
        <h1>we can use filter in this page</h1>
      </div>
    <div>
      <h3 style="margin-top:20px; color:grey; font-weight:bold; text-align:center "> List of all Employees </h3>
    </div>
   <div>
     <b-table striped hover :items="items"></b-table>
   </div>
 </div>
</template>

<style>
  .table{
    margin-top: 30px;
    background-color: #f4faff;
  }
</style>

<script>
const items = [
  { first_name: 'Larsen', last_name: 'Shaw', isActive: false, age: 21, income: 20000, Tax: 8000 },
  { first_name: 'Larsen', last_name: 'Shaw', isActive: false, age: 21, income: 20000, Tax: 8000 },
  { first_name: 'Larsen', last_name: 'Shaw', isActive: false, age: 21, income: 20000, Tax: 8000 },
  { first_name: 'Larsen', last_name: 'Shaw', isActive: false, age: 21, income: 20000, Tax: 8000 }
]

export default {
  data () {
    return {
      items: items,
      text1: ''
    }
  }
}
</script>
