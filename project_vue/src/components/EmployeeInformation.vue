<template>
<b-container fluid>
<br>
<b-alert show variant="primary">Employees Information</b-alert>
  <div>
    <vue-good-table
      :columns="columns"
      :rows="rows"
      :search-options="{
        enabled: true,
        placeholder: 'Search Employees by Name or Number ...'
      }"
      :pagination-options="{
        enabled: true,
        perPage: 10,
      }"
      :lineNumbers="true"
      @on-cell-click="onCellClick"
      styleClass="vgt-table striped bordered"/>
  </div>
    <b-modal v-model="ShowModal" id="modal-center" centered title="Selected Employee" ok-only>
    <p class="my-4">{{SelectedText}}</p>
  </b-modal>
</b-container>
</template>

<style>
</style>

<script>
  export default {
    data: () => ({
      SelectedText: '',
      ShowModal: false,
      columns: [
        {
          label: 'Employee Number',
          field: 'Emp_no',
          filterOptions: { enabled: true
          },
          type: 'number',
          thClass: 'vgt-left-align',
          tdClass: 'vgt-left-align'
        },
        {
          label: 'Full Name',
          field: 'FullName',
          filterOptions: { enabled: true
          },
          thClass: 'vgt-left-align',
          tdClass: 'vgt-left-align'
        },
        {
          label: 'Gender',
          field: 'Gender',
          thClass: 'vgt-left-align',
          tdClass: 'vgt-left-align'
        },
        {
          label: 'Birth Date',
          field: 'BirthDate',
          type: 'date',
          dateInputFormat: 'YYYY-MM-DD',
          dateOutputFormat: 'Do MMM YYYY',
          thClass: 'vgt-left-align',
          tdClass: 'vgt-left-align'
        },
        {
          label: 'Action',
          field: 'action',
          html: true,
          thClass: 'vgt-center-align',
          tdClass: 'vgt-center-align'}],
      rows: []
    }),
    computed: {
    },
    mounted () {
      this.axios.get('http://www.topcutbarbers.co.uk/service/service.php').then((response) => { console.log(response); this.rows = response.data })
    },
    methods: {
      onCellClick (params) {
        if (params.column.field === 'action') {
          this.ShowModal = true
          this.SelectedText = params.row.FullName + ' ' + ', Employee ID : ' + params.row.Emp_no + ', Birth Date : ' + params.row.BirthDate
        }
      }
    }
  }
</script>
