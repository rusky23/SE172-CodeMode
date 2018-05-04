<template>
  <div>
    <h1>we can use filter in this page</h1>
    <div>
      <h3 style=" margin-top:20px; color:grey; font-weight:bold; text-align:center ">List of all Employees</h3>
    </div>

   <div>
     <b-table striped hover :items="items"></b-table>
   </div>

 </div>


</template>

<style>
  .table{
    margin-top: 30px;
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
